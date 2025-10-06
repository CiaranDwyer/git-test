package com.myframework.Base;

import com.myframework.webDriverFactory.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

    protected WebDriver driver;
    protected WebDriverWait wait;

    /* or you can pass the driver instance using super in classes that
       extend the myBaseClass

    public myBaseClass(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    } */

    public BaseClass() {
        //this.driver = myDriverFactory.initializeDriver();
        this.driver = DriverFactory.getDriver();      // Access shared driver
        //PageFactory.initElements(driver, this);   // Init elements in child classes
    }

    public void loadURL(String url) {
        driver.get(url);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }
}

/*
Purpose: Common functionality for any class that needs the WebDriver.
All step definition and page object classes can extend this to use the driver.
*/
