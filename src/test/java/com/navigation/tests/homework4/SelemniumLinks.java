package com.navigation.tests.homework4;

import com.navigation.base.TestBase;
import com.navigation.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SelemniumLinks extends TestBase {
    @Test
    public void getLink() {
        String url = ConfigurationReader.getProperty("urlSel");
        driver.get(url);
        WebElement logo = driver.findElement(By.id("logo"));
        System.out.println(logo.getAttribute("href"));
    }

}
