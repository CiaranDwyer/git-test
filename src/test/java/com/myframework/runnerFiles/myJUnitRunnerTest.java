package com.myframework.runnerFiles;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/featureFiles/myGoogleSearch.feature", // Path to the feature file
        glue = {"com.myframework.stepDefinitionFiles", "com.myframework.Hooks"},// Path to the step definitions
        plugin = {"pretty", "html:target/cucumber-report.html"},
        tags = "@smoke",
        monochrome = true
)
public class myJUnitRunnerTest {
}

/*
Purpose: This class tells JUnit to run Cucumber.

CucumberOptions:

features: Where your .feature file is.

        glue: Where step definitions and hooks are found.
        plugin: Reporting format.
        monochrome: Makes console output readable.

This is the entry point when you run tests.
*/