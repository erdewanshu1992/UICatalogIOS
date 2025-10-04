package org.uicatlog.tests;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;
import org.uicatlog.base.BaseIOSTest;
import org.uicatlog.pages.SlidersPage;
import org.uicatlog.utils.RetryAnalyzer;

public class SlidersTest extends BaseIOSTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testSetSlider() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Sliders")).click();

        SlidersPage slidersPage = new SlidersPage(driver);
        slidersPage.setSliderValue("0.8");

        Thread.sleep(2000);
    }
}