package org.uicatlog.pages;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

public class TextFieldsPage {
    private final IOSDriver driver;

    private final By firstTextField = By.xpath("//XCUIElementTypeTextField[1]");

    public TextFieldsPage(IOSDriver driver) {
        this.driver = driver;
    }

    public void enterText(String text) {
        driver.findElement(firstTextField).sendKeys(text);
    }

    public void hideKeyboard() {
        try {
            driver.hideKeyboard();
        } catch (Exception ignored) {}
    }
}