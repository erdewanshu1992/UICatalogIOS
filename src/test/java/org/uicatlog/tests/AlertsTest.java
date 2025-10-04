package org.uicatlog.tests;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;
import org.uicatlog.base.BaseIOSTest;
import org.uicatlog.pages.AlertsPage;
import org.uicatlog.utils.RetryAnalyzer;


public class AlertsTest extends BaseIOSTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testShowAndAcceptAlert() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();

        AlertsPage alertsPage = new AlertsPage(driver);
        alertsPage.showAlert();

        Thread.sleep(2000);

        alertsPage.acceptAlert();

        Thread.sleep(2000);
    }
}