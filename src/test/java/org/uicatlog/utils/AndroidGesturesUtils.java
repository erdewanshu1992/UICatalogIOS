package org.uicatlog.utils;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;

public class AndroidGesturesUtils {

    // Tap (using element)
    public static void tapGesture(AndroidDriver driver, WebElement element) {
        HashMap<String, Object> tap = new HashMap<>();
        tap.put("elementId", ((RemoteWebElement) element).getId());
        driver.executeScript("mobile: clickGesture", tap);
    }

    // Tap (using coordinates)
    public static void tapGestureCoordinate(AndroidDriver driver, int x, int y) {
        HashMap<String, Object> tap = new HashMap<>();
        tap.put("x", x);
        tap.put("y", y);
        driver.executeScript("mobile: clickGesture", tap);
    }

    // Long Press
    public static void longPressGesture(AndroidDriver driver, WebElement element, int durationMs) {
        HashMap<String, Object> longPress = new HashMap<>();
        longPress.put("elementId", ((RemoteWebElement) element).getId());
        longPress.put("duration", durationMs); // in milliseconds
        driver.executeScript("mobile: longClickGesture", longPress);
    }

    // Swipe
    public static void swipeGesture(AndroidDriver driver, WebElement element, String direction, double percent) {
        HashMap<String, Object> swipe = new HashMap<>();
        swipe.put("elementId", ((RemoteWebElement) element).getId());
        swipe.put("direction", direction); // "left", "right", "up", "down"
        swipe.put("percent", percent); // 0.0 to 1.0
        driver.executeScript("mobile: swipeGesture", swipe);
    }

    // Scroll until element visible
    public static void scrollGesture(AndroidDriver driver, WebElement element, String direction) {
        HashMap<String, Object> scroll = new HashMap<>();
        scroll.put("elementId", ((RemoteWebElement) element).getId());
        scroll.put("direction", direction);
        scroll.put("percent", 1.0);
        driver.executeScript("mobile: scrollGesture", scroll);
    }
}
