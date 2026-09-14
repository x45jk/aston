package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class MainPage {
    // create variables for the browser controller and for explicit waits
    private final WebDriver driver;
    private final WebDriverWait wait;

    //===== Locators
        // (L) cookies
    private final By cookieAgreeButtonLocator = By.xpath("//*[@id='cookie-agree']");
    private final By cookieLocator = By.cssSelector(".cookie.show");
        // (L) header of the pay block
    private final By blockHeaderLocator = By.xpath("//div[@class='pay__wrapper']/h2");
        // (L) partners logos
    private final By partnerLogosLocator = By.cssSelector(".pay__partners img");
        // (L) link to "Подробнее о сервисе"
    private static final By moreAboutServiceLinkLocator = By.xpath("//a[contains(text(), 'Подробнее о сервисе')]");
        // (L) selected item in the dropdown
    private static final By dropdownSelectedItemLocator = By.cssSelector(".select__now");
        // (L) dropdown arrow to expand/collapse the list of services
    private static final By dropdownArrowLocator = By.cssSelector(".select__header");
        // (L) the list of services
    private static final By listOfServicesLocator = By.cssSelector(".select__list");
        // (L) the phone field
    private static final By phoneFieldLocator = By.id("connection-phone");
        // (L) the sum field
    private static final By sumFieldLocator = By.id("connection-sum");
        // (L) the email field
    private static final By emailFieldLocator = By.id("connection-email");
        // (L) the pay button
    private static final By submitButtonLocator = By.cssSelector("#pay-connection button[type='submit']");
        // (L) the iframe element with card payment requests
    private static final By paymentIframeLocator = By.xpath("//iframe[@class='payment-widget-iframe']");
        // (L)

    //===== constructor
        // (C) set explicit wait timeout (10 seconds)
    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    //===== methods
        // (M) check an element is visible and enabled such that you can click it
    private WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
        // (M) check that an element is either invisible or not present on the DOM
    private void waitForInvisible(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
        // (M) check that an element is present on the DOM of a page and visible
    private WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
        // (M) get the visible text of this element specified by the locator
    private String getText(By locator) {
        return waitForVisible(locator).getText();
    }
        // (M) check that all web elements matching a specific locator become visible, and then returns them as a list
    private List<WebElement> waitForVisibleAllElements(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }
        // (M) check that an element is currently visible on the page
    private boolean isDisplayed(By locator) {
        //return driver.findElement(locator).isDisplayed();
        return waitForVisible(locator).isDisplayed();
    }

    //===== actions
        // (A) open the page in an active browser window at the specified URL
    public MainPage open(String url) {
        driver.get(url);
        return this;
    }
        // (A) try to accept cookies
    public MainPage acceptCookiesIfPresent() {
        try {
            click(cookieAgreeButtonLocator);
            waitForInvisible(cookieLocator);
            System.out.println("Cookies accepted");
        } catch (Exception e) {
            System.out.println("Cookie banner not found or already accepted");
        }
        return this;
    }
        // (A) click on the element specified by the locator
    private void click(By locator) {
        waitForClickable(locator).click();
    }
        // (A) get the visible text of the element specified by the locator
    public String getBlockName() {
        return getText(blockHeaderLocator);
    }
        // (A) get the list of elements specified by the locator
    public List<WebElement> getPartnerLogos() {
        return waitForVisibleAllElements(partnerLogosLocator);
    }
        // (A) check if an image is fully loaded and visible on a webpage by reading its natural pixel dimensions
    public boolean isLoadedImg(WebElement logo) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (Boolean) js.executeScript("return arguments[0].naturalWidth > 0 && arguments[0].naturalHeight > 0;", logo);
    }
        // (A) get the clickable link
    public WebElement getElementMoreAboutServiceLink() {
        return waitForClickable(moreAboutServiceLinkLocator);
    }
        // (A) return an absolute path
    public String getAbsolutePath(String path) {
        if (path != null && path.startsWith("/"))
            return "https://www.mts.by" + path;
        else
            return path;
    }
        // (A) click a link and wait until the browser successfully loads the new page
    public void clickLinkAndWait(WebElement link) {
        link.click();       // click the link

        // wait for the URL to change first, then for the title to update
        //   (URL changes before the page fully loads — this prevents Race Condition)
        wait.until(ExpectedConditions.urlContains("/help"));
        wait.until(ExpectedConditions.titleContains("Порядок оплаты"));
    }
        // (A) get the currently selected value from the dropdown
    public String getSelectedDropdownValue() {
        return getText(dropdownSelectedItemLocator).trim();
    }
        // (A) switch to the required option if it is not selected
    public MainPage selectDropdownOption(String selectedItem) {
        if (!getSelectedDropdownValue().equals(selectedItem)) {
            click(dropdownArrowLocator);                    // expand the dropdown list
            waitForVisible(listOfServicesLocator);          // wait for the list to become visible

            // select the required option
            By newItem = By.xpath(
                "//li[contains(@class, 'select__item')]//p[contains(text(), '" + selectedItem + "')]"
            );
            click(newItem);

            // wait until the displayed value updates
            wait.until(ExpectedConditions.textToBePresentInElementLocated(dropdownSelectedItemLocator, selectedItem));
       }
       return this;
    }
        // (A) enter the phone number in the phone field
    public MainPage enterPhone(String phone) {
        WebElement field = waitForClickable(phoneFieldLocator);
        field.sendKeys(phone);
        return this;
    }
        // (A) get the phone field value
    public String getPhoneValue() {
        return waitForVisible(phoneFieldLocator).getAttribute("value");
    }
        // (A) enter the sum number in the sum field
    public MainPage enterSum(String sum) {
        WebElement field = waitForClickable(sumFieldLocator);
        field.sendKeys(sum);
        return this;
    }
        // (A) get the sum field value
    public String getSumValue() {
        return waitForVisible(sumFieldLocator).getAttribute("value");
    }
        // (A) enter the email number in the email field
    public MainPage enterEmail(String email) {
        WebElement field = waitForClickable(emailFieldLocator);
        field.sendKeys(email);
        return this;
    }
        // (A) get the sum field value
    public String getEmailValue() {
        return waitForVisible(emailFieldLocator).getAttribute("value");
    }
        // (A) click to the button
    public MainPage clickSubmit() {
        click(submitButtonLocator);
        return this;
    }
        // (A) check that the payment widget iframe is visible on the page
    public boolean isPaymentIframeVisible() {
        return isDisplayed(paymentIframeLocator);
    }
        // (A) check that the submit button is visible on the page
    public boolean isSubmitButtonVisible() {
        return isDisplayed(sumFieldLocator);
    }
        // (A) check that the submit button is enabled and can be clicked
    public boolean isSubmitButtonEnabled() {
        return waitForVisible(sumFieldLocator).isEnabled();
    }
}
