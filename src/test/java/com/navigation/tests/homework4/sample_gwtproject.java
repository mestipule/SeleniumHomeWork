package com.navigation.tests.homework4;

import com.navigation.base.TestBase;
import com.navigation.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class sample_gwtproject  extends TestBase {
    @Test
    public void checkBox() throws InterruptedException{
        String url = ConfigurationReader.getProperty("urlSample");
        driver.get(url);
        Random ran = new Random();
        int counter = 0;
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        List<WebElement> checkbox = driver.findElements(By.xpath("//input[@value='on']"));
        do {
            int selection = ran.nextInt(7);
            checkbox.get(selection).click();

            if (checkbox.get(selection).getAttribute("id").contains("Friday")) {
                counter++;
            }
        } while (counter < 3);
    }
}
