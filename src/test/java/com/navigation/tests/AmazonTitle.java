package com.navigation.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.navigation.utilities.BrowserFactory;
//import static com.navigation.utilities.MethodsForLocators.verifyTitle;

public class AmazonTitle {
    String property = System.getProperty("os.name");
    WebDriver driver = BrowserFactory.getDriver("chrome");
    @BeforeMethod
        public void beforeMethod() throws InterruptedException {
            driver.get("https://www.amazon.com/");
            Thread.sleep(3000);
        }
    @Test
    private void verifyTitle() throws InterruptedException {
        String item = "laptop";
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(item);
//        System.out.println("found input box");
        Thread.sleep(3000);
        driver.findElement(By.className("nav-input")).click();
//        System.out.println("clikcked box");
        String title = driver.getTitle();
//        System.out.printf(driver.getTitle());
        Assert.assertTrue(title.contains(item));
    }
    @AfterMethod
    private void afterMethod() {
        System.out.println("\tThis runs after each test");
        driver.close();
    }

}

//    public static void verifyTitile(String title1, String title2) {
//
//    }

