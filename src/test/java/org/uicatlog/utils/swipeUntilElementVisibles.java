package org.uicatlog.utils;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

public class swipeUntilElementVisibles {
    IOSDriver driver;

    public swipeUntilElementVisibles(IOSDriver driver) {
        this.driver = driver;
    }

    public void swipeUntilElementVisible(By locator, int maxSwipes) {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);

        for (int i = 0; i < maxSwipes; i++) {
            List<WebElement> elements = driver.findElements(locator);
            if (!elements.isEmpty() && elements.get(0).isDisplayed()) {
                System.out.println("Element found after " + (i+1) + " swipes!");
                return;
            }

            HashMap<String, Object> params = new HashMap<>();
            params.put("direction", "up");
            params.put("fromX", startX);
            params.put("fromY", startY);
            params.put("toX", startX);
            params.put("toY", endY);
            driver.executeScript("mobile: swipe", params);

            System.out.println("Swipe #" + (i+1));

            try {
                Thread.sleep(2000);  // 2 sec ruk, content aane ka time milega
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Element not found after max swipes: " + maxSwipes);
    }

}
