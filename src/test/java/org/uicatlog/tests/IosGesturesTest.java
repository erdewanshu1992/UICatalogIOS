package org.uicatlog.tests;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;
import org.uicatlog.utils.IosGestures;

public class IosGesturesTest {
    IOSDriver driver;

    public static void testGestures(IOSDriver driver) {
        // Example element
        WebElement chai = driver.findElement(
                AppiumBy.iOSNsPredicateString("label == 'Chai'")
        );
        // Example element with Class Chain
        WebElement loginBtn = driver.findElement(
                AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`label == 'Login'`]")
        );

        // Accessibility Id
        WebElement profile = driver.findElement(
                AppiumBy.accessibilityId("Profile")
        );


        // Tap / Double-tap / Long-press
        IosGestures.tap(driver, chai);
        IosGestures.doubleTap(driver, chai);
        IosGestures.longPress(driver, chai, 2.0); // 2 seconds

        // Swipes
        IosGestures.swipeUp(driver);                          // simple
        IosGestures.swipeCustom(driver, 200, 600, 200, 200);  // custom coordinates

        // Scroll until visible by predicate or name
        IosGestures.scrollToPredicate(driver, "label CONTAINS 'Chai'", "down");
        IosGestures.scrollToName(driver, "Chai", "down");
    }
}
