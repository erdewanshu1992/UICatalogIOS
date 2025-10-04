package org.uicatlog.tests;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import io.appium.java_client.ios.IOSDriver;
import org.uicatlog.utils.IosGesturesUtils;

public class IosGestures2Test {
    IOSDriver driver;

    public void testGestures() {
        // Locate element
        WebElement chai = driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Chai'"));

        // Tap
        IosGesturesUtils.tapGesture(driver, chai);

        // Double Tap
        IosGesturesUtils.doubleTapGesture(driver, chai);

        // Long Press for 2 seconds
        IosGesturesUtils.longPressGesture(driver, chai, 2.0);

        // Scroll until "Chai" is visible
        IosGesturesUtils.scrollUntilElementVisible(driver, "label == 'Chai'");

        // Swipe up
        IosGesturesUtils.swipe(driver, "up");
    }
}

