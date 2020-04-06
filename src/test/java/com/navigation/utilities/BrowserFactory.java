package com.navigation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class BrowserFactory {
    public static WebDriver getDriver(String browser) {
        WebDriver driver;
            if (browser.equalsIgnoreCase("chrome")) {
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.get("https://www.google.com/");
            } else {
                driver = null;
            }
            driver.manage().window().maximize();
        return driver;
    }

}
