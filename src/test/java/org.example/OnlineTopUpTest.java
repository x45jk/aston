package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class OnlineTopUpTest {
    private WebDriver driver;
    private MainPage mainPage;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        // driver initialization; launching a new browser instance
        driver = new ChromeDriver();
        // maximize window to avoid elements being outside the viewport
        driver.manage().window().maximize();
        // set explicit wait timeout (10 seconds)
           // open the 'МТС' main page
           // and accept cookies if the banner appears
        mainPage = new MainPage(driver)
                   .open("https://www.mts.by/")
                   .acceptCookiesIfPresent();
    }

    @AfterEach
    void teardown() {
        // close the browser and end the WebDriver session
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    @DisplayName("Checking the block name 'Онлайн пополнение без комиссии'")
    void checkNameOfSpecifiedBlock() {
        // expected text is uppercase due to CSS 'text-transform: uppercase;'
        //  '<br>' in HTML becomes '\n' in getText()
        String expectedName = "ОНЛАЙН ПОПОЛНЕНИЕ\nБЕЗ КОМИССИИ";
        String actualName = mainPage.getBlockName();

        assertEquals(expectedName, actualName);
    }

    @Test
    @DisplayName("Check for the presence of payment system logos")
    void checkPresenceOfPaymentLogos() {
        // wait for all payment system logos to become visible inside the '.pay__partners' block
        List<WebElement> logosImg = mainPage.getPartnerLogos();

        // there must be exactly 5 logos
        assertEquals(5, logosImg.size(), "There must be 5 payment system logos");

        // iterate through each logo and verify its loaded state
        for (WebElement logo : logosImg) {
            String srcAttribute = logo.getAttribute("src");
            String altAttribute = logo.getAttribute("alt");

            // verify 'src' attribute is present and not empty
            assertNotNull(srcAttribute, "The 'src' attribute is missing for one of the logos");
            assertFalse(srcAttribute.isEmpty(), "The 'src' attribute is empty for one of the logos");

            // verify 'alt' attribute is present and not empty
            assertNotNull(altAttribute, "The 'alt' attribute is missing for logo with src: " + srcAttribute);
            assertFalse(altAttribute.isEmpty(), "The 'alt' attribute is empty for logo with src: " + srcAttribute);

            // verify logo is visible on the page
            assertTrue(logo.isDisplayed(), "The logo '" + altAttribute + "' is not displayed");

            // verify image is actually loaded via JS
            assertTrue(mainPage.isLoadedImg(logo), "The logo '" + altAttribute + "' is broken");
        }
    }

    @Test
    @DisplayName("Check the functionality of the «Подробнее о сервисе» link")
    void checkFunctionalityOfLink() {
        // get the clickable link
        WebElement linkAboutService = mainPage.getElementMoreAboutServiceLink();

        // the link must be visible and enabled before clicking
        assertTrue(linkAboutService.isDisplayed(), "The link «Подробнее о сервисе» must be visible");
        assertTrue(linkAboutService.isEnabled(),   "The link «Подробнее о сервисе» must be clickable");

        // get the href attribute and convert relative URL to absolute
        String actualHref = linkAboutService.getAttribute("href");
        String expectedHref = mainPage.getAbsolutePath(actualHref);

        mainPage.clickLinkAndWait(linkAboutService);

        // verify the final URL matches the expected one
        String actualUrl = driver.getCurrentUrl();
        assertTrue(actualUrl.contains(expectedHref), "The browser navigated to an invalid URL: " + actualUrl);

        // verify the page title contains the expected text
        String pageTitle = driver.getTitle();
        assertTrue(pageTitle.contains("Порядок оплаты и безопасность интернет платежей"),
                "Expected page title not found! Current text: " + pageTitle);
    }

    @Test
    @DisplayName("Fill in the fields and check the «Продолжить» button")
    void fillInFieldsAndCheckButton() {
        String expectedItemText = "Услуги связи";           // check dropdown value

        // select dropdown option (if not already selected)
        mainPage.selectDropdownOption(expectedItemText);

        // verify the dropdown displays the expected value
        assertEquals(expectedItemText, mainPage.getSelectedDropdownValue(),
                "Expected dropdown value: '" + expectedItemText + "'");

       // enter phone number
        mainPage.enterPhone("297777777");
        assertEquals("(29)777-77-77", mainPage.getPhoneValue(), "Phone field should be filled");

        // enter sum
        mainPage.enterSum("100");
        assertEquals("100", mainPage.getSumValue(), "Sum field should be filled");

        // enter email
        mainPage.enterEmail("1@1.com");
        assertEquals("1@1.com", mainPage.getEmailValue(), "Email field should be filled");

        // verify button is visible and enabled
        assertTrue(mainPage.isSubmitButtonVisible(), "The button «Продолжить» must be visible");
        assertTrue(mainPage.isSubmitButtonEnabled(), "The button «Продолжить» must be clickable");

        // click button
        mainPage.clickSubmit();

        // wait for the payment widget iframe to appear after clicking the button
        assertTrue(mainPage.isPaymentIframeVisible(), "Payment widget iframe should appear");
    }

    @Test
    @DisplayName("Check the placeholders in the blank fields for each payment option")
    void checkPlaceholdersOfEachPaymentOption() {
        Map<String, Map<By, String>> placeholder = mainPage.getPlaceholderMapLocator();

        for (Map.Entry<String, Map<By, String>> serviceEntry : placeholder.entrySet()) {
            String serviceName = serviceEntry.getKey();
            Map<By, String> fieldsMap = serviceEntry.getValue();

            mainPage.selectDropdownOption(serviceName);

            for (Map.Entry<By, String> field : fieldsMap.entrySet()) {
                By fieldLocator = field.getKey();
                String expectedPlaceholder = field.getValue();

                String actualPlaceholder = mainPage.getPlaceholderById(fieldLocator);
                assertEquals(actualPlaceholder, expectedPlaceholder,
                        "Each placeholder must have valid value. Expected: " + expectedPlaceholder +
                                                                      ", actual: " + actualPlaceholder);
            }
        }
    }

    @Test
    @DisplayName("Check payment iframe elements are displayed correctly")
    void checkPaymentIframeElementsDisplayedCorrectly() {
        String expectedItemText = "Услуги связи";           // check dropdown value

        // select dropdown option (if not already selected)
        mainPage.selectDropdownOption(expectedItemText);

        // verify the dropdown displays the expected value
        assertEquals(expectedItemText, mainPage.getSelectedDropdownValue(),
                "Expected dropdown value: '" + expectedItemText + "'");

        // enter phone number
        mainPage.enterPhone("297777777");
        assertEquals("(29)777-77-77", mainPage.getPhoneValue(), "Phone field should be filled");

        // enter sum
        mainPage.enterSum("100");
        assertEquals("100", mainPage.getSumValue(), "Sum field should be filled");

        // enter email
        mainPage.enterEmail("1@1.com");
        assertEquals("1@1.com", mainPage.getEmailValue(), "Email field should be filled");

        // verify button is visible and enabled
        assertTrue(mainPage.isSubmitButtonVisible(), "The button «Продолжить» must be visible");
        assertTrue(mainPage.isSubmitButtonEnabled(), "The button «Продолжить» must be clickable");

        // click button
        mainPage.clickSubmit();

        // wait for the payment widget iframe to appear after clicking the button
        assertTrue(mainPage.isPaymentIframeVisible(), "Payment widget iframe should appear");

        // switch the driver's focus inside the iframe
        mainPage.switchToIframe();

        // get a list of locators for the payment iframe
        Map<By, String> paymentIframeMap = mainPage.getPaymentIframeMapLocator();
        for (Map.Entry<By, String> entry : paymentIframeMap.entrySet()) {
            By fieldLocator = entry.getKey();
            String expectedText = entry.getValue();

            String actualText = mainPage.getIframeFieldTextById(fieldLocator);
            assertTrue(actualText.contains(expectedText), "Each placeholder must have valid value. Expected: " + expectedText +
                                                                                                        ", actual: " + actualText);
        }

        // get the list of payment logos
        List<WebElement> logosImg = mainPage.getPaymentIframeLogos();

        // there must be exactly 5 logos
        assertEquals(5, logosImg.size(), "There must be 5 payment system logos");

        // iterate through each logo and verify its loaded state
        for (WebElement logo : logosImg) {
            String srcAttribute = logo.getAttribute("src");

            // verify 'src' attribute is present and not empty
            assertNotNull(srcAttribute, "The 'src' attribute is missing for one of the logos");
            assertFalse(srcAttribute.isEmpty(), "The 'src' attribute is empty for one of the logos");

            // maestro logo switches to mir logo and back
            //assertTrue(logo.isDisplayed(), "The logo '" + srcAttribute + "' is not displayed");

            // verify image is actually loaded via JS
            assertTrue(mainPage.isLoadedImg(logo), "The logo '" + srcAttribute + "' is broken");
        }

        // back to the top-level main page
        mainPage.switchToDefaultContent();
    }
}
