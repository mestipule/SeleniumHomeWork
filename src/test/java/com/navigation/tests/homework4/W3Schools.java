package com.navigation.tests.homework4;

import com.navigation.base.TestBase;
import com.navigation.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class W3Schools extends TestBase {
    @Test
    public void testingATags() throws InterruptedException {
        String url = ConfigurationReader.getProperty("urlW3schools");
        driver.get(url);
        List<WebElement> aTags = driver.findElements(By.tagName("a"));


        String expected = "https://w3schools.com/";
        Assert.assertEquals(driver.getCurrentUrl(), expected);

        System.out.println(aTags.size());
        for (WebElement eachTag : aTags) {
            System.out.println(eachTag.getAttribute("href"));
        }

        WebElement iFrame = driver.findElement(By.xpath("//iframe[@class='goog-te-menu-frame skiptranslate']"));
        driver.switchTo().frame(iFrame);
        System.out.println("switch successfully");

        List<WebElement> aTagInside1 = driver.findElements(By.xpath("//div[@class='goog-te-menu2']/table/tbody/tr/td[*]/a"));
        System.out.println(aTagInside1.size());
        for (WebElement eachTag : aTagInside1) {
            System.out.println(eachTag.getAttribute("href"));
        }



        driver.switchTo().parentFrame();
        System.out.println(driver.getTitle());
        System.out.println("in the parent frame");

        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
        WebElement iFrame2 = driver.findElement(By.xpath("//iframe[@id='1084367405a46818'][@src='https://ads.pubmatic.com/AdServer/js/showad.js#PIX&kdntuid=1&p=1743386&gdpr=0&gdpr_consent=BOy73XQOy73XQDlDKAENDD-AAAAuuAAA&us_privacy=1---']"));
        driver.switchTo().frame(iFrame2);
        System.out.println("in the second iFrame");

    }

}
