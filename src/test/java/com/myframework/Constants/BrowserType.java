package com.myframework.Constants;

public enum BrowserType {

    CHROME,
    FIREFOX,
    EDGE,
    SAFARI,
    /*
    But that’s risky. What if someone types "chorme" by accident?
    Instead, you can define:

    Now the only valid options are the ones you list — safe, readable, and typo-proof.

    In your test config, you might have:
    browser=chrome

    But in your Java code, you want to use that value in a type-safe way, like:
    BrowserType browser = BrowserType.CHROME;

     */
}
