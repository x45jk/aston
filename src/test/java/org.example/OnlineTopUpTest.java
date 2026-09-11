package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class OnlineTopUpTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeAll
    static void setupAll() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setup() {
        // Initialize driver and set explicit wait timeout (10 seconds)
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        // maximize window to avoid elements being outside the viewport
        driver.manage().window().maximize();
        // open the 'МТС' main page
        driver.get("https://www.mts.by/");

        // accept cookies if the banner appears
        try {
            WebElement cookieAgreeButton = wait.until(
                    ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='cookie-agree']"))
            );
            cookieAgreeButton.click();

            // wait for the banner to disappear to prevent overlapping other elements
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".cookie.show")));
            System.out.println("Cookies accepted");
        } catch (Exception e) {
            System.out.println("Cookie banner not found or already accepted");
        }
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
        // find the '<h2>' heading inside the '.pay__wrapper' block
        WebElement blockName = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='pay__wrapper']/h2"))
        );

        // expected text is uppercase due to CSS 'text-transform: uppercase;'
        //  '<br>' in HTML becomes '\n' in getText()
        String expectedName = "ОНЛАЙН ПОПОЛНЕНИЕ\nБЕЗ КОМИССИИ";
        String actualName = blockName.getText();

        assertEquals(expectedName, actualName);
    }

    @Test
    @DisplayName("Check for the presence of payment system logos")
    void checkPresenceOfPaymentLogos() {
        // wait for all payment system logos to become visible inside the '.pay__partners' block
        List<WebElement> logosImg = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".pay__partners img"))
        );

        // there must be exactly 5 logos
        assertEquals(5, logosImg.size(), "There must be 5 payment system logos");

/*        // temporarily break the image src to verify the check works
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].src = arguments[0].src + '1';", logosImg.get(4));*/

        // iterate through each logo and verify its attributes, visibility, and loaded state
        for (WebElement logo : logosImg) {
            // get 'src' and 'alt' attributes for verification
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

            // RestAssured doesn't work (too long timeout 60+ sec)
            //  verify image is actually loaded via DOM properties
            String widthStr = logo.getDomProperty("naturalWidth");
            String heightStr = logo.getDomProperty("naturalHeight");

            // naturalWidth/naturalHeight can be null if the property is missing
            assertNotNull(widthStr, "naturalWidth is missing for logo: " + altAttribute);
            assertNotNull(heightStr, "naturalHeight is missing for logo: " + altAttribute);

            int naturalWidth = Integer.parseInt(widthStr);
            int naturalHeight = Integer.parseInt(heightStr);

            // naturalWidth/naturalHeight > 0 means the image file is loaded successfully
            assertTrue(naturalWidth > 0 && naturalHeight > 0,
                    "The logo '" + altAttribute + "' is broken (Dimensions: " + naturalWidth + "x" + naturalHeight + ")");
        }
    }

    @Test
    @DisplayName("Check the functionality of the «Подробнее о сервисе» link")
    void checkFunctionalityOfLink() {
        // find the link and ensure it is clickable
        WebElement linkAboutService = wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Подробнее о сервисе')]"))
        );

        // the link must be visible and enabled before clicking
        assertTrue(linkAboutService.isDisplayed(), "The link must be visible");
        assertTrue(linkAboutService.isEnabled(),   "The link must be clickable");

        // get the href attribute and convert relative URL to absolute
        String expectedHref = linkAboutService.getAttribute("href");
        if (expectedHref != null && expectedHref.startsWith("/")) {
            expectedHref = "https://www.mts.by" + expectedHref;
        }

        // click the link and wait for navigation
        linkAboutService.click();

        // wait for the URL to change first, then for the title to update
        //  (URL changes before the page fully loads — this prevents Race Condition)
        wait.until(ExpectedConditions.urlContains("/help"));
        wait.until(ExpectedConditions.titleContains("Порядок оплаты"));

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

        // get the currently selected value from the dropdown
        WebElement activeItem = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".select__now"))
        );
        String activeItemText = activeItem.getText();

        // if the required option is not selected, switch to it
        if (!activeItemText.trim().equals(expectedItemText)) {
            // open the dropdown list
            WebElement dropdownButton = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".select__header")));
            dropdownButton.click();

            // wait for the list to become visible
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".select__list")));

            // select the required option
            WebElement option = wait.until(
                    ExpectedConditions.elementToBeClickable(
                            By.xpath("//li[contains(@class, 'select__item')]//p[contains(text(), '" + expectedItemText + "')]")
                    )
            );
            option.click();

            // wait until the displayed value updates
            wait.until(ExpectedConditions.textToBePresentInElementLocated(By.cssSelector(".select__now"), expectedItemText));
        }

        // verify the dropdown displays the expected value (even if already selected)
        activeItem = driver.findElement(By.cssSelector(".select__now"));
        activeItemText = activeItem.getText().trim();
        assertEquals(expectedItemText, activeItemText,
                "Expected dropdown value: '" + expectedItemText + "', actual: '" + activeItemText + "'");

        // enter phone number
        WebElement phoneInputField = wait.until(ExpectedConditions.elementToBeClickable(By.id("connection-phone")));
        phoneInputField.sendKeys("297777777");
        assertEquals("(29)777-77-77", phoneInputField.getAttribute("value"), "Phone field should be filled");

        // enter sum
        WebElement sumInputField = wait.until(ExpectedConditions.elementToBeClickable(By.id("connection-sum")));
        sumInputField.sendKeys("100");
        assertEquals("100", sumInputField.getAttribute("value"), "Sum field should be filled");


        // enter email
        WebElement emailInputField = wait.until(ExpectedConditions.elementToBeClickable(By.id("connection-email")));
        emailInputField.sendKeys("1@1.com");
        assertEquals("1@1.com", emailInputField.getAttribute("value"), "Email field should be filled");

        // click button
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#pay-connection button[type='submit']")));
        button.click();

        // wait for the payment widget iframe to appear after clicking the button
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.xpath("//iframe[@class='payment-widget-iframe']"))
        );
    }
}
