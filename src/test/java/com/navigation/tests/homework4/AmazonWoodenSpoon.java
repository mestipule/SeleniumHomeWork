package com.navigation.tests.homework4;

import com.navigation.base.TestBase;
import com.navigation.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AmazonWoodenSpoon extends TestBase {
    @Test
    public void getCheapestWoodenSpoon() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String url = ConfigurationReader.getProperty("urlAmazon");
        driver.get(url);
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("wooden spoon" + Keys.ENTER);

    }
}
