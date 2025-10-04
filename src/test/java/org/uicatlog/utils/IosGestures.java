package org.uicatlog.utils;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;
import java.util.Map;

public final class IosGestures {

    private IosGestures() {}

    private static String idOf(WebElement el) {
        return ((RemoteWebElement) el).getId(); // Selenium 4 + Appium 8
    }

    // ---- Taps ----
    public static void tap(IOSDriver driver, WebElement el) {
        Map<String, Object> args = new HashMap<>();
        args.put("elementId", idOf(el));
        driver.executeScript("mobile: tap", args);
    }

    public static void doubleTap(IOSDriver driver, WebElement el) {
        Map<String, Object> args = new HashMap<>();
        args.put("elementId", idOf(el));
        driver.executeScript("mobile: doubleTap", args);
    }

    // ---- Long press (iOS uses touchAndHold; duration is in SECONDS) ----
    public static void longPress(IOSDriver driver, WebElement el, double seconds) {
        Map<String, Object> args = new HashMap<>();
        args.put("elementId", idOf(el));
        args.put("duration", seconds); // e.g., 2.0 means 2 seconds
        driver.executeScript("mobile: touchAndHold", args);
    }

    // ---- Swipes ----
    public static void swipeUp(IOSDriver driver) {
        Map<String, Object> args = new HashMap<>();
        args.put("direction", "up"); // Appium picks sensible start/end
        driver.executeScript("mobile: swipe", args);
    }

    public static void swipeCustom(IOSDriver driver, int fromX, int fromY, int toX, int toY) {
        Map<String, Object> args = new HashMap<>();
        args.put("fromX", fromX);
        args.put("fromY", fromY);
        args.put("toX", toX);
        args.put("toY", toY);
        driver.executeScript("mobile: swipe", args);
    }

    // ---- Scroll helpers ----
    public static void scrollToPredicate(IOSDriver driver, String predicate, String direction) {
        Map<String, Object> args = new HashMap<>();
        args.put("predicateString", predicate); // e.g., "label CONTAINS 'Chai'"
        args.put("direction", direction);       // "down" or "up"
        driver.executeScript("mobile: scroll", args);
    }

    public static void scrollToName(IOSDriver driver, String name, String direction) {
        Map<String, Object> args = new HashMap<>();
        args.put("name", name);                 // accessibility id / label / name
        args.put("direction", direction);       // "down" or "up"
        driver.executeScript("mobile: scroll", args);
    }
}

