package com.navigation.tests.homework4;

import com.navigation.base.TestBase;
import com.navigation.utilities.ConfigurationReader;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Prime extends TestBase {
    @Test
    public void ifPrime() throws InterruptedException{
//    COOKSMARK 5 Piece Bamboo Wood Nonstick Cooking Utensils - Wooden Spoons and Spatula Utensil Set with Multicolored Silicone Handles in Red Yellow Green Orange Blue
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String url = ConfigurationReader.getProperty("urlAmazon");
        driver.get(url);
        WebDriverWait wait = new WebDriverWait(driver, 3);
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("wooden spoon" + Keys.ENTER);
        Thread.sleep(5000);
//        WebElement prime = driver.findElement(By.cssSelector("input[type='checkbox']nth-of-type(2)"));
//        System.out.println("found it");
        List<WebElement> prime2 = driver.findElements(By.xpath("/html/body/div/div[2]/div/div/div/div[3]/span/div/div[1]/ul/li[2]/span/a/div/label/input"));
        for (WebElement each : prime2) {
            each.click();
        }
        System.out.println("found it");
//
        WebElement firstItem = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[2]/div/span[4]/div/div[18]"));
        firstItem.click();
        System.out.println("found element");
    }
}
