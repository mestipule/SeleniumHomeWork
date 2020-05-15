package com.navigation.tests.olympics;

import com.navigation.base.TestBase;
import com.navigation.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class getSum extends TestBase {
    @Test
    public void getSum() {
        driver.get(ConfigurationReader.getProperty("url2016Olympics"));

        System.out.println( Arrays.toString(getBronzeSumThatEquals(18)) );
    }

    public String[] getBronzeSumThatEquals(int num) {
        List<WebElement> row = driver.findElements(By.xpath("//table[9]/tbody/tr"));
        row.remove(row.size()-1);
        row.remove(row.size()-1);
        WebElement selectedCountry = null;
        String[] sCountryArr = new String[10];
        int[][] sMedalsArr = new int[5][10];
        int counterI = 0;
        int counterJ = 0;
        for (WebElement eachRow : row) {
            // Start by reading the country
            WebElement header = eachRow.findElement(By.xpath(".//th"));
            sCountryArr[counterJ] = header.getText();

            // Read the medal counts.
            List<WebElement> elements = eachRow.findElements(By.xpath(".//td"));
            for(WebElement curCell : elements) {
                try {
                    sMedalsArr[counterI][counterJ] = Integer.parseInt(curCell.getText());
                } catch (NumberFormatException e) {
                    sMedalsArr[counterI][counterJ] = -1;
                }
                counterI++;
            }

            counterJ++;
            counterI = 0;
        }

        // Data has finished loading.
        // sMedalsArr[3] - Array is the bronze medal count
        for(int i = 0; i < sMedalsArr[3].length; i++) {
            if( sMedalsArr[3][i] < num ) {
                int iBronzeMedalCount = sMedalsArr[3][i];
                for(int j = i+1; j < sMedalsArr[3].length; j++) {
                    if( num == iBronzeMedalCount + sMedalsArr[3][j] ) {
                        int jBronzeMedalCount = sMedalsArr[3][j];
                        return new String[]{sCountryArr[i], sCountryArr[j]};
                    }
                }
            }
        }

        return new String[] { "", "" };
    }
}
