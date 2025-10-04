package org.uicatlog.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;

import java.time.Duration;

// Selenium 4.0+ Enhanced Actions
public class EnhancedActions {
    public void demonstrateActions(WebDriver driver) {
        Actions actions = new Actions(driver);

        // Pause/Wait actions
        actions.pause(Duration.ofSeconds(2));

        // Key combinations
        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();

        // Enhanced click
        WebElement element = driver.findElement(By.id("element"));
        actions.moveToElement(element).pause(500).click().perform();

        // Scroll actions
        actions.scrollToElement(element);
        actions.scrollByAmount(0, 500); // Scroll down 500px
        actions.scrollFromOrigin(WheelInput.ScrollOrigin.fromElement(element), 0, 200);
    }
}

