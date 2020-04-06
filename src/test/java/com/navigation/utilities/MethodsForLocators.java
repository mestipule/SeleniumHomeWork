package com.navigation.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MethodsForLocators {
//    public static void verifyTitle(String title, String item) {
//        if (title.contains(title)) {
//            System.out.println(title + " contains " + item);
//        } else {
//            System.out.println("Fail");
//        }
//    }
    public static void titleEndsWith(String endURL, String url) {
        if (url.endsWith(endURL)){
            System.out.println("Pass " + url + " ends Selenium_(software)");
        } else {
            System.out.println("Fail " + url + " does not ends Selenium_(software)");
        }

    }
    public static void titleStartsWith(String title1, String title2) {
        if (title1.equals(title2)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("expectedTitle = " + title2);
            System.out.println("actualTitle = " + title1);
        }
    }
    public static void titleTest() throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://qa3.vytrack.com");
        WebElement username = driver.findElement(By.id("prependedInput"));
        username.sendKeys("salesmanager110");
        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");
        password.submit();
        WebElement user = driver.findElement(By.cssSelector("a[href='javascript: void(0);']"));
        Thread.sleep(3000);
        System.out.println(user.getText());
        user.click();

        Thread.sleep(3000);
        WebElement myConfiguration = driver.findElement(By.cssSelector("ul.dropdown-menu>li>a[href='/config/user/profile']"));
        myConfiguration.click();
        Thread.sleep(3000);
        String expected = user.getText();

        String actual = driver.getTitle();
        titleStartsWith(expected, actual);

        driver.close();
    }
    public static void shortCutFunctionality() throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://qa3.vytrack.com");
        WebElement username = driver.findElement(By.id("prependedInput"));
        username.sendKeys("salesmanager110");
        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");
        password.submit();
        WebElement user = driver.findElement(By.cssSelector("a[href='javascript: void(0);']"));
        Thread.sleep(3000);
        System.out.println(user.getText());
        user.click();

        String actualTitle = "Dashboard";
        String expectedTitle = driver.getTitle();
        if (actualTitle.equals(expectedTitle)) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL");
            System.out.println("expectedTitle = " + expectedTitle);
            System.out.println("actualTitle = " + actualTitle);
        }

        driver.close();
    }
    public static void errorMessageCheck() throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.get("http://qa3.vytrack.com");
        WebElement username = driver.findElement(By.id("prependedInput"));
        username.sendKeys("salesmanager110");
        WebElement password = driver.findElement(By.id("prependedInput2"));
        password.sendKeys("UserUser123");
        password.submit();
        WebElement user = driver.findElement(By.cssSelector("a[href='javascript: void(0);']"));
        Thread.sleep(3000);
        System.out.println(user.getText());
        user.click();

        String actualTitle = "Dashboard";
        String expectedTitle = driver.getTitle();
        MethodsForLocators.titleStartsWith(actualTitle, expectedTitle);
        driver.findElement(By.xpath("//div[@class='dropdown header-dropdown-shortcut header-utility-dropdown']")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("See full list")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Opportunities")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='dropdown header-dropdown-shortcut header-utility-dropdown']")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("See full list")).click();
        Thread.sleep(3000);
        driver.findElement(By.linkText("Vehicle Services Logs")).click();
        Thread.sleep(3000);
        WebElement errorMessage = driver.findElement(By.cssSelector(".message"));
        System.out.println(errorMessage.getText());
        MethodsForLocators.titleStartsWith("You do not have permission to perform this action.", errorMessage.getText());
        driver.close();

    }
}
