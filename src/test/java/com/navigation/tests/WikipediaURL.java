package com.navigation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.navigation.utilities.BrowserFactory;
import com.navigation.utilities.MethodsForLocators;

public class WikipediaURL {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.navigate().to("https://www.wikipedia.org/");
        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver");
        System.out.println("input done");
        driver.findElement(By.xpath("//*/button[@class='pure-button pure-button-primary-progressive']")).click();
        //td[@class='score-time status']/a[normalize-space() = '16 : 00']
        System.out.println("clicking done");
        driver.findElement(By.className("searchmatch")).click();
        System.out.println("clicked selenium(software)");
        driver.getCurrentUrl();
        String url = driver.getCurrentUrl();
        System.out.println(url);
        String endURL = "Selenium_(software)";
        MethodsForLocators.titleEndsWith(endURL, url);
//        driver.close();
    }

}
