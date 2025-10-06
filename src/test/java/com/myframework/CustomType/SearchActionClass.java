package com.myframework.CustomType;

import com.myframework.DomainObjects.SearchItem;
import com.myframework.objectPages.GoogleSearchPage;

public class SearchActionClass {

    /*
     The SearchAction class combines the GoogleSearchPage and SearchItem classes to perform the search action:
     typing the search term and clicking the search button.

     What does it do?
     SearchAction combines both the page (GoogleSearchPage) and the search term (SearchItem) to perform the search action.
    */

    // Object Variables of Both Classes
    private final GoogleSearchPage googleSearchPage;
    private final SearchItem searchItem;

    // Constructor to initialize GoogleSearchPage and SearchItem
    public SearchActionClass(GoogleSearchPage googleSearchPage, SearchItem searchItem) {
        this.googleSearchPage = googleSearchPage;
        this.searchItem = searchItem;
    }

    // Method to perform the search (enter text and click button)
    public void performSearch() {
        googleSearchPage.enterSearchText(searchItem.getSearchTerm());
        googleSearchPage.submitSearch();
    }

    public void cookies() throws InterruptedException {
        googleSearchPage.acceptCookiesIfPresent();
    }


    // Method to verify if search results are displayed
    public boolean verifySearchResults() {
        return googleSearchPage.isSearchResultDisplayed();
    }
}
