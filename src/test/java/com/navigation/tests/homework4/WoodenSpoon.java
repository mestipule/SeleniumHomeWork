package com.navigation.tests.homework4;

import com.navigation.base.TestBase;
import com.navigation.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class WoodenSpoon extends TestBase {
    @Test
    public void woodenSpoonTestInTheCart() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String url = ConfigurationReader.getProperty("urlAmazon");
        driver.get(url);
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("wooden spoon" + Keys.ENTER);
        List<WebElement> woodenSpoon = driver.findElements(By.xpath("//span[@class='a-size-base-plus a-color-base a-text-normal']"));
        for (WebElement each : woodenSpoon) {
            System.out.println(each.getText());
        }
        Random ran = new Random();
        int selectRandom = ran.nextInt(66);
        WebElement randomWS = woodenSpoon.get(selectRandom);
        String randomItem = randomWS.getText();
        System.out.println("*************************************************************************************");
        randomWS.click();
        System.out.println("selected item");
        WebElement price = driver.findElement(By.xpath("//td[@class='a-span12']/span[@id='priceblock_ourprice']"));
        String textPrice = price.getText();
        System.out.println(randomItem + " and the price is " + textPrice);


        WebElement quantity = driver.findElement(By.id("a-autoid-0-announce"));
        String expectedQuantity = "Qty:1";
        System.out.println("quatnity" + quantity.getText());
        Assert.assertEquals(quantity.getText(), expectedQuantity);

    }
}
