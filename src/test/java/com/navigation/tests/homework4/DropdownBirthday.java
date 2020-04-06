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

public class DropdownBirthday extends TestBase {
    @Test
    public void dropdownTest() throws InterruptedException {
        String url = ConfigurationReader.getProperty("urlDropdown");
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        WebElement year = driver.findElement(By.id("year"));
        WebElement month = driver.findElement(By.id("month"));
        WebElement day = driver.findElement(By.id("day"));
        Select yearSelections = new Select(year);
        yearSelections.selectByVisibleText("2010");
        Select monthSelections = new Select(month);
        monthSelections.selectByVisibleText("May");
        Select daySelections = new Select(day);
        daySelections.selectByVisibleText("30");
        List<WebElement> days = daySelections.getOptions();
//        System.out.println(days.size());
        Thread.sleep(10000);
    }
    @Test
    public void yourBirthday() {
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        String url = ConfigurationReader.getProperty("urlDropdown");
        driver.get(url);
        WebElement year = driver.findElement(By.id("year"));
        Select select = new Select(year);
        Random ran = new Random();
        int selection = ran.nextInt(99) + 1921;
        select.selectByValue(selection + "");
//        System.out.println("found a year " + selection);
        int numberOfDaysInFeb = selection % 4 == 0 ? 29 : 28;
        List<Integer> daysOfTheMonth = Arrays.asList(31, numberOfDaysInFeb, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31);
        List<Integer> actualDaysOfTheMonth = new ArrayList<>();
        WebElement month = driver.findElement(By.id("month"));

        WebElement day = driver.findElement(By.id("day"));

        Select monthSelections = new Select(month);

        Select daySelections = new Select(day);

        monthSelections.selectByVisibleText("January");
        actualDaysOfTheMonth.add(daySelections.getOptions().size());
        monthSelections.selectByVisibleText("February");
        actualDaysOfTheMonth.add(daySelections.getOptions().size());
        monthSelections.selectByVisibleText("March");
        actualDaysOfTheMonth.add(daySelections.getOptions().size());
        monthSelections.selectByVisibleText("April");
        actualDaysOfTheMonth.add(daySelections.getOptions().size());
        monthSelections.selectByVisibleText("May");
        actualDaysOfTheMonth.add(daySelections.getOptions().size());
        monthSelections.selectByVisibleText("June");
        actualDaysOfTheMonth.add(daySelections.getOptions().size());
        monthSelections.selectByVisibleText("July");
        actualDaysOfTheMonth.add(daySelections.getOptions().size());
        monthSelections.selectByVisibleText("August");
        actualDaysOfTheMonth.add(daySelections.getOptions().size());
        monthSelections.selectByVisibleText("September");
        actualDaysOfTheMonth.add(daySelections.getOptions().size());
        monthSelections.selectByVisibleText("October");
        actualDaysOfTheMonth.add(daySelections.getOptions().size());
        monthSelections.selectByVisibleText("November");
        actualDaysOfTheMonth.add(daySelections.getOptions().size());
        monthSelections.selectByVisibleText("December");
        actualDaysOfTheMonth.add(daySelections.getOptions().size());
        Assert.assertEquals(actualDaysOfTheMonth, daysOfTheMonth);
    }
}

