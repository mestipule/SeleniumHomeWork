package com.navigation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.navigation.utilities.BrowserFactory;

public class EtsySearchTest {
    public static void main(String[] args) {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("https://www.ebay.com");
        driver.manage().window().maximize();
        WebElement inputBox = driver.findElement(By.className("gh-tb ui-autocomplete-input"));
        inputBox.sendKeys("Wooden Spoon");
        WebElement button = driver.findElement(By.className("btn btn-prim gh-spr"));

//        driver.close();
    }
}
