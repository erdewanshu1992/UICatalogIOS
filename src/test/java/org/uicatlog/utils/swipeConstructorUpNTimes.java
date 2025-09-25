package org.uicatlog.utils;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.Dimension;

import java.util.HashMap;

public class swipeConstructorUpNTimes {

    IOSDriver driver;

    // constructor to pass driver
    public swipeConstructorUpNTimes(IOSDriver driver) {
        this.driver = driver;
    }

    public void swipeUpNTimes(int times) {
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

            System.out.println("Swipe #" + (i+1));

            try {
                Thread.sleep(1500);  // wait for content
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}


// swipeConstructorUpNTimes(5);


/*
Case 1: Constructor वाला

IOSDriver driver;

public SwipeUtils(IOSDriver driver) {   // constructor injection
    this.driver = driver;              // driver ko class ke andar store kar liya
}

public void swipeUpNTimes(int times) {
    Dimension size = driver.manage().window().getSize();
    ...
}


Tera sochna ✅

Jo pehla wala hai (constructor), usme tu object banata hai aur driver ko initialize karta hai → ye hai Object Oriented style.

Jo doosra wala hai (static), usme tu object nahi banata, sirf method ko utility function ki tarah use karta hai → ye hai Functional style.

 */