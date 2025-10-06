package com.myframework.utils;

import com.myframework.Constants.BrowserType;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {


    // 🔒 This is the only instance we will ever create
    private static ConfigReader configReader;

    // 📦 Java class to hold all the properties from the file
    private Properties properties;

    // 🚪 Private constructor so no one else can create this class
    private ConfigReader() {
        try {
            FileInputStream file = new FileInputStream("src/test/resources/config.properties");
            properties = new Properties();
            properties.load(file);  // 📥 Load the file into memory
        } catch (IOException e) {
            e.printStackTrace();  // ❌ Print error if a file not found or fails to load
        }
    }

    // ✅ Public method to get the single instance
    // "getInstance()" is just a special method used to get the shared version of an object when you're using the Singleton pattern.
    public static ConfigReader getInstance() {
        if(configReader == null) {
            configReader = new ConfigReader();  // Create only once
        }
        return configReader;
    }


    // 🌐 Example method to get the base URL
    public String getBaseUrl() {
        return properties.getProperty("base.url");
    }

    // Converts "chrome" to BrowserType.CHROME
    public BrowserType getBrowserType() {
        return BrowserType.valueOf(properties.getProperty("browser").toUpperCase());
    }

    // 🌐 Get search term
    public String getSearchTerm() {
        return properties.getProperty("search.term");
    }
}

