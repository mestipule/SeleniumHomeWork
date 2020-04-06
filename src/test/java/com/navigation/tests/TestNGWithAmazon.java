package com.navigation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNGWithAmazon {

    @Test
    public static void verifyTitile(String title1, String title2) {
        Assert.assertTrue(title2.contains(title1));
    }
}
