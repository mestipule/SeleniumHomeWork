package com.navigation.tests;

import org.openqa.selenium.WebDriver;
import com.navigation.utilities.BrowserFactory;

public class GoogleResultTitle {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https:google.com");
        
    }
}
