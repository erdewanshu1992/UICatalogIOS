package org.uicatlog.pages;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

public class ButtonsPage {
    private final IOSDriver driver;

    private final By firstButton = AppiumBy.accessibilityId("Buttons");

    public ButtonsPage(IOSDriver driver) {
        this.driver = driver;
    }

    public void tapFirstButton() {
        driver.findElement(firstButton).click();
    }
}