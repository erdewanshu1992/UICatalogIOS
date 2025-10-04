package org.uicatlog.utils;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;

public class IosGesturesUtils {

    // Single Tap
    public static void tapGesture(IOSDriver driver, WebElement element) {
        HashMap<String, Object> tap = new HashMap<>();
        tap.put("elementId", ((RemoteWebElement) element).getId());
        driver.executeScript("mobile: tap", tap);
    }

    // Double Tap
    public static void doubleTapGesture(IOSDriver driver, WebElement element) {
        HashMap<String, Object> doubleTap = new HashMap<>();
        doubleTap.put("elementId", ((RemoteWebElement) element).getId());
        driver.executeScript("mobile: doubleTap", doubleTap);
    }

    // Long Press (Touch and Hold) - duration in seconds
    public static void longPressGesture(IOSDriver driver, WebElement element, double seconds) {
        HashMap<String, Object> longPress = new HashMap<>();
        longPress.put("elementId", ((RemoteWebElement) element).getId());
        longPress.put("duration", seconds);
        driver.executeScript("mobile: touchAndHold", longPress);
    }

    // Scroll until element visible using predicate string
    public static void scrollUntilElementVisible(IOSDriver driver, String predicate) {
        HashMap<String, Object> scrollObject = new HashMap<>();
        scrollObject.put("direction", "down");
        scrollObject.put("predicateString", predicate);
        driver.executeScript("mobile: scroll", scrollObject);
    }

    // Simple Swipe (direction only: up, down, left, right)
    public static void swipe(IOSDriver driver, String direction) {
        HashMap<String, Object> swipe = new HashMap<>();
        swipe.put("direction", direction);
        driver.executeScript("mobile: swipe", swipe);
    }
}
