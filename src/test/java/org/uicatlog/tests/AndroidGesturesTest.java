package org.uicatlog.tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.uicatlog.utils.AndroidGesturesUtils;

public class AndroidGesturesTest {

    public static void andGestures(AndroidDriver driver) {
        try {
            // Example: Locate Login button
            WebElement loginBtn = driver.findElement(AppiumBy.accessibilityId("test-LOGIN"));

            // ✅ Call utility gestures
            AndroidGesturesUtils.tapGesture(driver, loginBtn);

            AndroidGesturesUtils.longPressGesture(driver, loginBtn, 2000);

            AndroidGesturesUtils.tapGestureCoordinate(driver, 200, 400);

            AndroidGesturesUtils.swipeGesture(driver, loginBtn, "up", 0.5);

            WebElement chai = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Chai\")"));
            AndroidGesturesUtils.scrollGesture(driver, chai, "down");

            System.out.println("✅ Gestures executed successfully!");

        } finally {
            driver.quit();
        }
    }

}
