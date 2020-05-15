package com.navigation.tests.olympics;

import com.navigation.base.TestBase;
import com.navigation.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class LocationByCountry extends TestBase {
    @Test
    public void getUnitedStatesLocation() {
        driver.get(ConfigurationReader.getProperty("url2016Olympics"));

        System.out.println(Arrays.toString(getCountryLocation("United States")));
    }

    public int[] getCountryLocation(String countryToFind) {
        List<WebElement> row = driver.findElements(By.xpath("//table[9]/tbody/tr"));
        row.remove(row.size()-1);
        row.remove(row.size()-1);
        int counter = 0;
        for (WebElement eachRow : row) {
            WebElement header = eachRow.findElement(By.xpath(".//th"));
            String countryWithAbbriviation = header.getText();
            if( countryWithAbbriviation.split("\\(")[0].trim().equals(countryToFind) ){
                return new int[]{counter, 1};
            }

            counter++;
        }

        return new int[]{-1, -1};
    }
}
