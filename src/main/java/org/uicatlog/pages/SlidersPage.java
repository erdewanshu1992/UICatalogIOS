package org.uicatlog.pages;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SlidersPage {
    private final IOSDriver driver;

     private final By slider = By.className("XCUIElementTypeSlider");

    public SlidersPage(IOSDriver driver) {
        this.driver = driver;
    }

    public void setSliderValue(String value) {
        WebElement sliderElement = driver.findElement(slider);
        sliderElement.sendKeys(value);
    }
}