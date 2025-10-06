package com.myframework.webDriverFactory;

import com.myframework.Constants.BrowserType;
import com.myframework.utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver initializeDriver() {
        if(driver == null) {

            // 💡 Get browser from config using the singleton ConfigReader
            BrowserType browser = ConfigReader.getInstance().getBrowserType();

            // 🔀 Switch on Browser Type
            switch (browser){
                case CHROME:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;

                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;

                case SAFARI:
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;

                default:
                    throw new RuntimeException("Unsupported Browser: " +browser);
            }

            driver.manage().window().maximize();
        }
        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }


    public static void quitDriver() {
        if(driver != null) {
            driver.quit();
            driver = null;
        }
    }
}

/*
Purpose: Provides a centralized way to manage the WebDriver instance.

initializeDriver():
Checks if the driver is already initialized. If not, creates one.

getDriver():
Used by other classes to retrieve the active driver.

quitDriver():
Quits the driver and sets it to null to allow reinitialization in next scenario.

Ensures only one driver per scenario, and it's cleaned up after.
*/



















