package org.uicatlog.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import java.util.HashMap;

public class SwipeStaticUtils {

    public static void swipeUpNTimesUp(IOSDriver driver, int times) {

        for (int i = 0; i < times; i++) {
            HashMap<String, Object> params = new HashMap<>();

            // Swipe up
            params.put("direction", "up");
            driver.executeScript("mobile: swipe", params);

        }
    }

    public static void swipeUpNTimesDown(IOSDriver driver, int times) {
        for (int i = 0; i < times; i++) {
            HashMap<String, Object> params = new HashMap<>();

            // Swipe down
            params.put("direction", "down");
            driver.executeScript("mobile: swipe", params);

        }
    }

    public static void tapGesture(IOSDriver driver) {
        HashMap<String, Object> tap = new HashMap<>();
        tap.put("x", 200);
        tap.put("y", 400);
        driver.executeScript("mobile: tap", tap);
    }

    public static void tapGesture(IOSDriver driver, int x, int y) {
        HashMap<String, Object> tap = new HashMap<>();
        tap.put("x", x);
        tap.put("y", y);
        driver.executeScript("mobile: tap", tap);
    }

    // Long Press
    public static void longPressGesture(IOSDriver driver, WebElement element) {
        HashMap<String, Object> longPress = new HashMap<>();
        longPress.put("elementId", ((RemoteWebElement) element).getId()); // cast needed
        longPress.put("duration", 2000); // milliseconds
        driver.executeScript("mobile: longClickGesture", longPress);
    }

    public static void longPressGestureTouchAndHold(IOSDriver driver, WebElement element, double seconds) {
        HashMap<String, Object> longPress = new HashMap<>();
        longPress.put("elementId", ((RemoteWebElement) element).getId());
        longPress.put("duration", seconds);
        driver.executeScript("mobile: touchAndHold", longPress);

    }

    public static void longPressGesture(AndroidDriver driver, WebElement element, int durationMs) {
        HashMap<String, Object> longPress = new HashMap<>();
        longPress.put("elementId", ((RemoteWebElement) element).getId());
        longPress.put("duration", durationMs); // in milliseconds
        driver.executeScript("mobile: longClickGesture", longPress);
    }

    // Double Tap
    public static void doubleTapGesture(IOSDriver driver, WebElement element) {
        HashMap<String, Object> doubleTap = new HashMap<>();
        doubleTap.put("elementId", ((RemoteWebElement) element).getId()); // cast needed
        driver.executeScript("mobile: doubleTap", doubleTap);
    }

    // Single Tap
    public static void tapGesture(IOSDriver driver, WebElement element) {
        HashMap<String, Object> tap = new HashMap<>();
        tap.put("elementId", ((RemoteWebElement) element).getId());
        driver.executeScript("mobile: tap", tap);
    }

    public static void tapGestureCoordinateBased(IOSDriver driver, WebElement element) {
        // Get element center
        int centerX = element.getRect().getX() + (element.getRect().getWidth() / 2);
        int centerY = element.getRect().getY() + (element.getRect().getHeight() / 2);

        HashMap<String, Object> tap = new HashMap<>();
        tap.put("x", centerX);
        tap.put("y", centerY);
        driver.executeScript("mobile: tap", tap);
    }

    public static void textScrollUntilElementVisible ( IOSDriver driver){

        HashMap<String, Object> scrollObject = new HashMap<>();
        scrollObject.put("direction", "down");
        scrollObject.put("predicateString", "label == 'Chai'");
        driver.executeScript("mobile: scroll", scrollObject);


    }


}
