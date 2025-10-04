package org.uicatlog.tests;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;
import org.uicatlog.base.BaseAndroidTest;
import org.uicatlog.utils.RetryAnalyzer;

public class E2EMyntraTest extends BaseAndroidTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testAllTheFeature() throws InterruptedException {

        // driver.findElement(AppiumBy.iOSNsPredicateString("name == 'Username'")).sendKeys("standard_user");
        // driver.findElement(AppiumBy.iOSNsPredicateString("name == 'Password'")).sendKeys("secret_sauce");
        // driver.findElement(AppiumBy.iOSNsPredicateString("name == 'LOGIN'")).click();

        System.out.println("Myntra app launched successfully.");
    }
}
