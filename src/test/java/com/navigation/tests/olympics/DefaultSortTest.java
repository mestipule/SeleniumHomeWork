package com.navigation.tests.olympics;

import com.google.common.collect.Comparators;
import com.navigation.base.TestBase;
import com.navigation.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class DefaultSortTest extends TestBase {
    @Test
    public void defaultSortTest() {
        driver.get(ConfigurationReader.getProperty("url2016Olympics"));
        List<WebElement> olympicsTable = driver.findElements(By.xpath("//table[9]/thead/tr/th"));
        System.out.println("found element?");
        for (WebElement each : olympicsTable) {
            System.out.println(each.getText());
        }
        List<WebElement> ranks = driver.findElements(By.xpath("//table[9]/tbody/tr/td[1]"));
        ranks.remove(ranks.size()-1);
        ranks.remove(ranks.size()-1);
        for (WebElement each : ranks) {
            System.out.println(each.getText());
        }

        System.out.println("********************");
        List<Integer> intRanks = ranks.stream()
                .map(WebElement::getText)
                .map(o -> Integer.parseInt(o))
                .collect(Collectors.toList());
        boolean isInOrder = Comparators.isInOrder(intRanks, (lhs, rhs) -> lhs - rhs);
        System.out.println("isInOrder = " + isInOrder);
        for (WebElement each : ranks) {
            System.out.println(each.getText());
        }
//        List<WebElement> sortedRanks = ranks.
//        Assert.assertTrue();

        WebElement country = driver.findElement(By.xpath("//table[9]/tbody/tr/th/img"));
        System.out.println("country.getText() = " + country.getText());
//        for (WebElement eachCountry : country) {
//            eachCountry.getAttribute("title");
//        }

    }

}
