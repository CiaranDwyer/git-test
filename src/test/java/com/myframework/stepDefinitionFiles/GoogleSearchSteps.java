package com.myframework.stepDefinitionFiles;

import com.myframework.Base.BaseClass;
import com.myframework.objectPages.GoogleSearchPage;
import com.myframework.utils.ConfigReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;


public class GoogleSearchSteps extends BaseClass {

    /*
    The GoogleSearchSteps class is where we connect the actions from the feature file (the test steps) to the code.

    What does it do?
    GoogleSearchSteps links the test steps to the SearchAction code.
    */

    GoogleSearchPage search;

    @Given("I am on the Google Search Page")
    public void i_am_on_the_google_search_page() throws InterruptedException {

        search = new GoogleSearchPage();

        String url = ConfigReader.getInstance().getBaseUrl();
        search.loadURL(url);

        //search.loadURL("https://www.google.com");
        search.acceptCookiesIfPresent();
        //new searchPage().navigateTO("https://www.google.com");
    }

    @When("I type {string} into the search box")
    public void i_type_into_the_search_box(String keyword) {

        search.enterSearchText(keyword);
    }

    @When("I press the search button")
    public void i_press_the_search_button() {

        search.submitSearch();
    }

    @Then("I should see the search results")
    public void i_should_see_the_search_results() {

        boolean result = search.isSearchResultDisplayed();
        Assert.assertTrue(search.isSearchResultDisplayed(), "Search results were not displayed!");
    }
}


