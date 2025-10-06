package com.myframework.objectPages;

import com.myframework.Base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class GoogleSearchPage extends BaseClass {

    /*
    This class represents the Google Search page itself. It has instructions on how to interact with the elements on the page like the search box and the search button.

    What does it do?
    GoogleSearchPage class lets us type a search term into the search box and click the search button.
     */

    // PageFactory and Standard POM Design
    //@FindBy(name = "q") WebElement searchBOX;
    //@FindBy(xpath = "//div[normalize-space()='Accept all']" ) WebElement cookies;

    private final By searchBox = By.name("q");
    private final By acceptCookiesButton = By.xpath("//div[normalize-space()='Accept all']");


    public void enterSearchText(String searchTerm) {

        // Make sure you are highlighting the correct element
        WebElement input = driver.findElement(searchBox);
        //System.out.println(input.getTagName());
        input.clear();
        input.sendKeys(searchTerm);
    }


    public void submitSearch() {
        driver.findElement(searchBox).sendKeys(Keys.ENTER);
    }


    public void acceptCookiesIfPresent() throws InterruptedException {

        // Wait for a short time to let the element appear
        Thread.sleep(1000); // Basic wait; consider using WebDriverWait in production
        driver.findElement(acceptCookiesButton).click();
    }

    public boolean isSearchResultDisplayed() {
        return driver.getTitle().toLowerCase().contains("google");
    }
}

/*
Purpose: Encapsulates all actions related to Google Search Page.
Follows Page Object Model (POM) best practices.
It Can be reused in multiple tests.
Allows abstraction from WebDriver code in step definitions.
*/
