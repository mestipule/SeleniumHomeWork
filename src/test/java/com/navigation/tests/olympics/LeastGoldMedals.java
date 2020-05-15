package com.navigation.tests.olympics;

import com.navigation.base.TestBase;
import com.navigation.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LeastGoldMedals extends TestBase {
    @Test (description = "printing the least number of medals")
    public void leastMedals() {
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

        System.out.println(getGoldMedal(medalsArr));
        System.out.println(getSilverMedal(medalsArr));
        System.out.println(getBronzeMedal(medalsArr));

    }

    public String getGoldMedal(int[] num) {
        int temp = 0;
        for (int i = 0; i < num.length; i++) {

            for (int j = i + 1; j < num.length; j++) {
                if (num[i] > num[j]) {
                    temp = num[j];
                    num[i] = num[j];
                    num[j] = temp;
                }
            }
        }

        String tempString = temp + "";
        List<WebElement> row = driver.findElements(By.xpath("//table[9]/tbody/tr"));
        row.remove(row.size()-1);
        row.remove(row.size()-1);
        WebElement selectedCountry = null;
        String[] sCountryArr = new String[10];
        int[][] sMedalsArr = new int[7][10];
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
        // To find smallest number of gold medals find the index of the smallest value.
        // sMedalsArr[0] - Array is the rank
        // sMedalsArr[1] - Array is the gold medal count
        // sMedalsArr[2] - Array is the silver medal count
        // sMedalsArr[3] - Array is the bronze medal count
        // sMedalsArr[4] - Array is the total medal count

    int goldModelIndex =  smallestIndexInArray(sMedalsArr[1]);
//        System.out.println(sCountryArr[goldModelIndex]);

//        for(String[] curList: sCountryArr) {
//            for(String curString: curList) {
//                System.out.println(curString);
//            }
//        }
////        System.out.println(Arrays.asList(sCountryArr));
////        System.out.println("selectedCountry = " + selectedCountry.getText());
        return sCountryArr[goldModelIndex];
    }
    public String getSilverMedal(int[] num) {
        int temp = 0;
        for (int i = 0; i < num.length; i++) {

            for (int j = i + 1; j < num.length; j++) {
                if (num[i] > num[j]) {
                    temp = num[j];
                    num[i] = num[j];
                    num[j] = temp;
                }
            }
        }

        String tempString = temp + "";
        List<WebElement> row = driver.findElements(By.xpath("//table[9]/tbody/tr"));
        row.remove(row.size()-1);
        row.remove(row.size()-1);
        WebElement selectedCountry = null;
        String[] sCountryArr = new String[10];
        int[][] sMedalsArr = new int[7][10];
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
        // To find smallest number of gold medals find the index of the smallest value.
        // sMedalsArr[0] - Array is the rank
        // sMedalsArr[1] - Array is the gold medal count
        // sMedalsArr[2] - Array is the silver medal count
        // sMedalsArr[3] - Array is the bronze medal count
        // sMedalsArr[4] - Array is the total medal count

        int goldModelIndex =  smallestIndexInArray(sMedalsArr[2]);
//        System.out.println(sCountryArr[goldModelIndex]);

//        for(String[] curList: sCountryArr) {
//            for(String curString: curList) {
//                System.out.println(curString);
//            }
//        }
////        System.out.println(Arrays.asList(sCountryArr));
////        System.out.println("selectedCountry = " + selectedCountry.getText());
        return sCountryArr[goldModelIndex];

    }

    public String getBronzeMedal(int[] num) {
        int temp = 0;
        for (int i = 0; i < num.length; i++) {

            for (int j = i + 1; j < num.length; j++) {
                if (num[i] > num[j]) {
                    temp = num[j];
                    num[i] = num[j];
                    num[j] = temp;
                }
            }
        }

        String tempString = temp + "";
        List<WebElement> row = driver.findElements(By.xpath("//table[9]/tbody/tr"));
        row.remove(row.size()-1);
        row.remove(row.size()-1);
        WebElement selectedCountry = null;
        String[] sCountryArr = new String[10];
        int[][] sMedalsArr = new int[7][10];
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
        // To find smallest number of gold medals find the index of the smallest value.
        // sMedalsArr[0] - Array is the rank
        // sMedalsArr[1] - Array is the gold medal count
        // sMedalsArr[2] - Array is the silver medal count
        // sMedalsArr[3] - Array is the bronze medal count
        // sMedalsArr[4] - Array is the total medal count

        int goldModelIndex =  smallestIndexInArray(sMedalsArr[3]);
//        System.out.println(sCountryArr[goldModelIndex]);

//        for(String[] curList: sCountryArr) {
//            for(String curString: curList) {
//                System.out.println(curString);
//            }
//        }
////        System.out.println(Arrays.asList(sCountryArr));
////        System.out.println("selectedCountry = " + selectedCountry.getText());
        return sCountryArr[goldModelIndex];
    }

    private int smallestIndexInArray(int[] arr) {
        int index = 0;
        int min = arr[index];

        for (int i=1; i<arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                index = i;
            }
        }
        return index;
    }
}
