package com.navigation.tests.homework4;

import com.navigation.base.TestBase;
import com.navigation.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class W3Schools extends TestBase {
    @Test
    public void testingATags() {
        String url = ConfigurationReader.getProperty("urlW3schools");
        driver.get(url);
        WebElement aTag = driver.findElement(By.xpath("//a[@class='w3schools-logo']"));

        String expected = "w3schools.com";
        Assert.assertEquals(aTag.getText(), expected);

        System.out.println(aTag.getText());
        System.out.println(aTag.getAttribute("href"));
    }

}
