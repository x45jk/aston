package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPage {
    // create variables for the browser controller and for explicit waits
    private final WebDriver driver;
    private final WebDriverWait wait;

    // locators
       // (L) cookies
    private final By cookieAgreeButtonLocator = By.xpath("//*[@id='cookie-agree']");
    private final By cookieLocator = By.cssSelector(".cookie.show");
       // (L) header of the pay block
    private final By blockHeader = By.xpath("//div[@class='pay__wrapper']/h2");
       // (L)

    // constructor
       // (C) set explicit wait timeout (10 seconds)
    public MainPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // methods
       // (M) checking an element is visible and enabled such that you can click it
    private WebElement waitForClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
        // (M) checking that an element is either invisible or not present on the DOM
    private void waitForInvisible(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }
        // (M) checking that an element is present on the DOM of a page and visible
    private WebElement waitForVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
       // (M) get the visible text of this element specified by the locator
    private String getText(By locator) {
        return waitForVisible(locator).getText();
    }
       // (M)

    // actions
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
       // (A) get the visible text of this element specified by the locator
   public String getBlockName() {
       return getText(blockHeader);
   }
      // (A)
}
