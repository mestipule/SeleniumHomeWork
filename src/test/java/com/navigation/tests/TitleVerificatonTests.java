package com.navigation.tests;

import org.openqa.selenium.WebDriver;
import com.navigation.utilities.BrowserFactory;

import java.util.Arrays;
import java.util.List;

public class TitleVerificatonTests {
    public static void main(String[] args) throws InterruptedException {
        //Here is test1
        List<String> url = Arrays.asList("http://practice.cybertekschool.com/",
                "http://practice.cybertekschool.com/dropdown",
                "http://practice.cybertekschool.com/login");

        WebDriver driver = BrowserFactory.getDriver("chrome");
        for (String each : url) {
            driver.get(each);
            Thread.sleep(3000);
            String eachURL = driver.getCurrentUrl();
            if (eachURL.contains("http://practice.cybertekschool.com")) {
                System.out.println("PASS = All of them starts with \"http://practice.cybertekschool.com\"");
            } else {
                System.out.println("FAIL = it's not expected");
            }
        }
        driver.close();


    }
}
