package org.uicatlog.utils;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.List;

public class SwipeUntil2ElementVisible {
    IOSDriver driver;

    public SwipeUntil2ElementVisible(IOSDriver driver) {
        this.driver = driver;
    }

    // 🔽 Scroll until element found (direction configurable)
    public void swipeUntilElementVisibleAndClick(By locator, int maxSwipes, String direction) {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY, endY;

        if (direction.equalsIgnoreCase("up")) {
            startY = (int) (size.height * 0.2);
            endY = (int) (size.height * 0.8);
        } else { // default down
            startY = (int) (size.height * 0.8);
            endY = (int) (size.height * 0.2);
        }

        for (int i = 0; i < maxSwipes; i++) {
            List<WebElement> elements = driver.findElements(locator);

            if (!elements.isEmpty() && elements.get(0).isDisplayed()) {
                WebElement element = elements.get(0);
                System.out.println("Element found after " + (i+1) + " swipes! Clicking...");
                element.click();  // ✅ Click element
                return;
            }

            // Perform swipe
            HashMap<String, Object> params = new HashMap<>();
            params.put("direction", direction.toLowerCase());
            params.put("fromX", startX);
            params.put("fromY", startY);
            params.put("toX", startX);
            params.put("toY", endY);
            driver.executeScript("mobile: swipe", params);

            try {
                Thread.sleep(1500); // content load hone ka wait
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Element not found after max swipes: " + maxSwipes);
    }
}
