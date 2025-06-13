package org.uicatlog.utils;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class AllureUtils {

    public static void takeScreenshot(WebDriver driver) {
        if (driver == null) {
            System.err.println("⚠️ Screenshot skipped: WebDriver is null.");
            return;
        }
        byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        Allure.getLifecycle().addAttachment("Screenshot", "image/png", "png", screenshot);
    }

}