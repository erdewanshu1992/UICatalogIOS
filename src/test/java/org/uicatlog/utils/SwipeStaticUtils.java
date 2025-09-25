package org.uicatlog.utils;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Dimension;

import java.util.HashMap;

public class SwipeStaticUtils {

    public static void swipeUpNTimes(IOSDriver driver, int times) {
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