package com.myframework.Hooks;

import com.myframework.webDriverFactory.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {


    @Before(order = 0)
    public void before(Scenario scenario) {
        System.out.println("Launching browser...");
        // Parallel execution Thread information
        System.out.println("BEFORE THREAD INFO: " +Thread.currentThread().getId() + "," + "Scenario Name: " + scenario.getName());

        DriverFactory.initializeDriver();
    }


    @After(order = 1)
    public void teardown(Scenario scenario) {
        System.out.println("Closing browser after scenario: " + scenario.getName());
        System.out.println("BEFORE THREAD INFO: " +Thread.currentThread().getId() + "," + "Scenario Name: " + scenario.getName());
        DriverFactory.quitDriver();
    }
}

/*
@Before: Runs before each scenario. Launches the browser.
@After: Runs after each scenario. Closes the browser.
Scenario parameter gives you access to scenario name/status if needed.
*/