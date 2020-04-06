package com.navigation.tests.homework4;

import com.navigation.base.TestBase;
import com.navigation.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.*;
import java.util.concurrent.TimeUnit;

public class Amazon extends TestBase {
    @Test
    public void notAlphabetic() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String url = ConfigurationReader.getProperty("urlAmazon");
        driver.get(url);
        WebElement allDep = driver.findElement(By.xpath("//select[@title='Search in']"));
        allDep.click();
        Select selectAllDep = new Select(allDep);
        List<WebElement> optionAllDep = selectAllDep.getOptions();
        List<WebElement> sorted = new ArrayList<>();
        sorted.addAll(optionAllDep);
//        Collections.sort(sorted);
//        Assert.assertEquals(selectAllDep, sorted);

    }
    @Test
    public void mainDepartment() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String url = ConfigurationReader.getProperty("urlAmazon");
        driver.get(url);
        WebElement allDep = driver.findElement(By.xpath("//select[@title='Search in']"));
        allDep.click();
        Select selectAllDep = new Select(allDep);
        List<WebElement> optionAllDep = selectAllDep.getOptions();
        for (WebElement eachDep : optionAllDep) {
            System.out.println(eachDep.getText());
        }
        System.out.println("*******************************************************************************************************************");
        List<WebElement> blueAllDep = driver.findElements(By.xpath("//h2[@class='fsdDeptTitle']"));
        for (WebElement eachBlueDep : blueAllDep) {
            System.out.println(eachBlueDep.getText());
        }
        for (WebElement eachBlueAllDep : blueAllDep) {
            Assert.assertTrue(allDep.getText().contains(eachBlueAllDep.getText()));
//            System.out.println(allDep.getText() + eachBlueAllDep.getText());
        }

    }
}
