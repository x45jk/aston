package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
