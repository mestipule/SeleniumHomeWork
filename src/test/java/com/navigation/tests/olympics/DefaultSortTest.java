package com.navigation.tests.olympics;

import com.google.common.collect.Comparators;
import com.navigation.base.TestBase;
import com.navigation.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

public class DefaultSortTest extends TestBase {
    @Test
    public void medalTableTest() {

        driver.get(ConfigurationReader.getProperty("url2016Olympics"));

//        List<WebElement> olympicsTable = driver.findElements(By.xpath("//table[9]/thead/tr/th"));
//        System.out.println("found element?");
//        for (WebElement each : olympicsTable) {
//            System.out.println(each.getText());
//        }
        List<WebElement> ranks = driver.findElements(By.xpath("//table[9]/tbody/tr/td[1]"));
        ranks.remove(ranks.size()-1);
        ranks.remove(ranks.size()-1);
        for (WebElement each : ranks) {
            System.out.println(each.getText());
        }

        List<Integer> intRanks = ranks.stream()
                //this is taking all the items in your list
                .map(WebElement::getText)
                //and getting each of them their text
                .map(o -> Integer.parseInt(o))
                //i will casting to change it from string to Integer
                .collect(Collectors.toList());
                //collect all my items and put them into my variable lise
                //it uses collectors, because you are using collection methods since we are creating a list

        System.out.println("********************");

        boolean isInOrder = Comparators.isInOrder(intRanks, (lhs, rhs) -> lhs - rhs);
        //comparing my left side number(which is 1) to right number (which is 10)
        System.out.println("isInOrder = " + isInOrder);
        for (WebElement each : ranks) {
            System.out.println(each.getText());
        }

       assertTrue(isInOrder);
    }

    @Test
    public void countryTableTest() {
        driver.get(ConfigurationReader.getProperty("url2016Olympics"));
        List<WebElement> countryNotSorted = driver.findElements(By.xpath("//table[9]/tbody/tr/th/a"));
        List<String> expectedResult = new ArrayList<>();
        for (WebElement eachCountry : countryNotSorted) {
            expectedResult.add(eachCountry.getText());
        }
        expectedResult.sort(String::compareTo);
        for (String each : expectedResult) {
            System.out.println(each);
        }
        System.out.println("************************");
        System.out.println("sorted");
        System.out.println("************************");

        WebElement nocButton = driver.findElement(By.xpath("//table[9]/thead/tr/th[@title='Sort ascending'][2]"));
        nocButton.click();
        List<WebElement> countrySorted = driver.findElements(By.xpath("//table[9]/tbody/tr/th/a"));
        for (WebElement eachSort : countrySorted) {
            System.out.println(eachSort.getText());
        }
        List<String> countryStringSorted = new ArrayList<>();
        for (WebElement eachCountry : countrySorted) {
           countryStringSorted.add(eachCountry.getText());
        }
        assertEquals(expectedResult, countryStringSorted);
    }

}
