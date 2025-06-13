package org.uicatlog.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

public class AlertsPage {
    private final IOSDriver driver;

    private final By accept = AppiumBy.accessibilityId("OK");
    private final By simple = AppiumBy.accessibilityId("Simple");

    public AlertsPage(IOSDriver driver) {
        this.driver = driver;
    }

    public void showAlert() {
        driver.findElement(simple).click();
    }

    public void acceptAlert() {
        driver.findElement(accept).click();
    }
}
