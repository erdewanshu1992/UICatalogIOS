package org.uicatlog.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import java.util.HashMap;

public class SwipeStaticUtils2 {

    public static void swipeUpNTimeCustom (IOSDriver driver, int times) {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);

        for (int i = 0; i < times; i++) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("direction", "up");
            params.put("fromX", startX);
            params.put("fromY", startY);
            params.put("toX", startX);
            params.put("toY", endY);
            driver.executeScript("mobile: swipe", params);

            // System.out.println("Swipe #" + (i+1));

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void swipeUpNTimesCustom (IOSDriver driver, int times) {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);

        for (int i = 0; i < times; i++) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("direction", "up");
            driver.executeScript("mobile: swipe", params);
        }
    }

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

        // Example usage in testcase
        // WebElement chai = driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Chai'"));
        // IosGesturesUtils.longPressGestureTouchAndHold(driver, chai, 2.0); // long press for 2 seconds

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



// SwipeStaticUtils.swipeUpNTimes(driver, 5);






/*

Case 2: Static वाला

public static void swipeUpNTimes(IOSDriver driver, int times) {
    Dimension size = driver.manage().window().getSize();
    ...
}

👉 Concept:

Ye OOP ka Encapsulation + Constructor Injection hai.

Matlab ek object banega SwipeUtils swipeUtils = new SwipeUtils(driver);

Jo driver tu pass karega, wo this.driver me store ho jayega, aur har method usi driver ko use karega.

Isme har method ke liye alag-alag driver dene ki zarurat nahi hai.

💡 Ye instance method hai (static nahi). Object ke sath hi chalega.


Tera sochna ✅

Jo pehla wala hai (constructor), usme tu object banata hai aur driver ko initialize karta hai → ye hai Object Oriented style.

Jo doosra wala hai (static), usme tu object nahi banata, sirf method ko utility function ki tarah use karta hai → ye hai Functional style.
 */