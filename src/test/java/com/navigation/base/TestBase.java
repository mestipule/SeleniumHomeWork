package com.navigation.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.navigation.utilities.Driver;
public class TestBase {
    protected WebDriver driver;
    @BeforeMethod
    public void setUp() {
            driver = Driver.getDriver();
            driver.manage().window().maximize();
    }
    @AfterMethod
    public void tearDown() throws InterruptedException{
        Thread.sleep(3000);
        Driver.closeDriver();
    }
}
