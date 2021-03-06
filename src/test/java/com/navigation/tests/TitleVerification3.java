package com.navigation.tests;

import org.openqa.selenium.WebDriver;
import com.navigation.utilities.BrowserFactory;

import java.util.Arrays;
import java.util.List;

public class TitleVerification3 {
    public static void main(String[] args) throws InterruptedException {
        List<String> url = Arrays.asList("https://luluandgeorgia.com",
                "https://wayfair.com", "https://www.westelm.com", "https://walmart.com");
        for (String each : url) {
            WebDriver driver = BrowserFactory.getDriver("chrome");
            driver.get(each);
            Thread.sleep(3000);
            String eachTitle = driver.getTitle();
            if (eachTitle.contains(eachTitle)) {
                System.out.println("PASS = Their url contains " + eachTitle);
            } else {
                System.out.println("FAIL = it's not expected");
            }
            driver.close();
        }

    }
}
