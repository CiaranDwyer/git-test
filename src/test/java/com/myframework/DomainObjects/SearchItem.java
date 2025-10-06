package com.myframework.DomainObjects;

public class SearchItem {

    /*
    This class is like a container for the search term.
    It doesn’t do anything with the browser; it just holds the search term.

    What does it do?
    SearchItem holds the search term you want to search for.
    */

    private String searchTerm;

    public SearchItem(String searchTerm) {
        this.searchTerm = searchTerm; // SearchItem holds the search term you want to search for.
    }

    public String getSearchTerm() {  // This lets us get the search term whenever we need it.
        return searchTerm;
    }

    public void setSearchTerm(String searchTerm) {
        this.searchTerm = searchTerm;
    }
}
