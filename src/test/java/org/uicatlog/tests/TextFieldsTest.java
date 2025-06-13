package org.uicatlog.tests;

import io.appium.java_client.AppiumBy;
import org.testng.annotations.Test;
import org.uicatlog.base.BaseTest;
import org.uicatlog.pages.TextFieldsPage;
import org.uicatlog.utils.RetryAnalyzer;

public class TextFieldsTest extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testEnterText() throws InterruptedException {
        driver.findElement(AppiumBy.accessibilityId("Text Fields")).click();

        TextFieldsPage textFieldsPage = new TextFieldsPage(driver);
        textFieldsPage.enterText("Hello Appium");
        textFieldsPage.hideKeyboard();

        Thread.sleep(2000);
    }
}