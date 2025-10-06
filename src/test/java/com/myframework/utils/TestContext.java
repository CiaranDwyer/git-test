package com.myframework.utils;


// This class will hold shared objects like WebDriver

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;

public class TestContext {

    public WebDriver driver;


    public TestContext() {
        System.out.println("TestContext Constructor Called!!");
        // Set up the WebDriver (Chrome example)
        WebDriverManager.safaridriver().setup();
        driver = new SafariDriver();
    }

    public void cleanUp() {
        driver.quit();
    }

}
