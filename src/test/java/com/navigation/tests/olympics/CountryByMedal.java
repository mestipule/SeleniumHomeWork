package com.navigation.tests.olympics;

import com.navigation.base.TestBase;
import com.navigation.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CountryByMedal extends TestBase {
    @Test
    public void getCountriesWithSilver() {
        driver.get(ConfigurationReader.getProperty("url2016Olympics"));
        List<WebElement> medals = driver.findElements(By.xpath("//table[9]/tbody/tr/td[2]"));
        medals.remove(medals.size()-1);
        medals.remove(medals.size()-1);
        List<Integer> numberOfMedals = medals.stream()
                .map(WebElement::getText)
                .map(o -> Integer.parseInt(o))
                .collect(Collectors.toList());

        int[] medalsArr = new int[medals.size()];
        for (int i = 0; i < medalsArr.length; i++) {
            medalsArr[i] = numberOfMedals.get(i);
        }
        System.out.println(getCountriesBySilverMedals());
    }

    public List<String> getCountriesBySilverMedals() {

        List<WebElement> row = driver.findElements(By.xpath("//table[9]/tbody/tr"));
        row.remove(row.size()-1);
        row.remove(row.size()-1);

        //Create a comparator to sort our list
        Comparator<WebElement> comp = (o1, o2) -> {
            // The third element is the silver medals
            WebElement o1Element = o1.findElements(By.xpath(".//td")).get(2);
            WebElement o2Element = o2.findElements(By.xpath(".//td")).get(2);
            int o1SilverCount = Integer.parseInt(o1Element.getText());
            int o2SilverCount = Integer.parseInt(o2Element.getText());
            // Sort so the larger number appears first
            return Integer.compare(o2SilverCount, o1SilverCount);
        };
        row.sort(comp);

        List<String> countries = new ArrayList<>();
        for (WebElement eachRow : row) {
            WebElement header = eachRow.findElement(By.xpath(".//th"));
            countries.add( header.getText() );
        }

        return countries;
    }
}