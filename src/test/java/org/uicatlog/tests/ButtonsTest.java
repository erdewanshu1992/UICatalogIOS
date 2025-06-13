package org.uicatlog.tests;

import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.uicatlog.base.BaseTest;
import org.uicatlog.pages.ButtonsPage;
import org.uicatlog.utils.RetryAnalyzer;

public class ButtonsTest extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testTapFirstButton() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Buttons")).click();

        ButtonsPage buttonsPage = new ButtonsPage(driver);
        buttonsPage.tapFirstButton();

        Thread.sleep(2000);
    }
}