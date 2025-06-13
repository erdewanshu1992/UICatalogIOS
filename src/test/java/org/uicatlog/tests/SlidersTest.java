package org.uicatlog.tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.uicatlog.base.BaseTest;
import org.uicatlog.pages.SlidersPage;
import org.uicatlog.utils.RetryAnalyzer;

public class SlidersTest extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testSetSlider() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Sliders")).click();

        SlidersPage slidersPage = new SlidersPage(driver);
        slidersPage.setSliderValue("0.8");

        Thread.sleep(2000);
    }
}