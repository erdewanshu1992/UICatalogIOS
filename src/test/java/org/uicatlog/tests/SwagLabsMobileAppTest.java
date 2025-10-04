package org.uicatlog.tests;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.uicatlog.base.BaseIOSTest;
import org.uicatlog.utils.*;


public class SwagLabsMobileAppTest extends BaseIOSTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testAllTheFeature() throws InterruptedException {

        driver.findElement(AppiumBy.iOSNsPredicateString("name == 'Username'")).sendKeys("standard_user");
        driver.findElement(AppiumBy.iOSNsPredicateString("name == 'Password'")).sendKeys("secret_sauce");
        // driver.findElement(AppiumBy.iOSNsPredicateString("name == 'LOGIN'")).click();

        WebElement chai = driver.findElement(AppiumBy.iOSNsPredicateString("name == \"test-LOGIN\""));

        // Call your gesture methods
         SwipeStaticUtils.tapGesture(driver, 208, 319); // coordinate-based way

        // SwipeStaticUtils.tapGesture(driver, chai); // single tap -- nhi chal rha

        // SwipeStaticUtils.longPressGestureTouchAndHold(driver, chai, 2.0); // long press for 2 seconds
        // SwipeStaticUtils.tapGestureCoordinateBased(driver, chai); // OR coordinate-based way
        // SwipeStaticUtils.doubleTapGesture(driver, chai);    // double tap
        // SwipeStaticUtils.textScrollUntilElementVisible(driver); // scroll until "Chai"



        // driver.findElement(AppiumBy.iOSClassChain("**/XCUIElementTypeOther[`name == \"test-ADD TO CART\"`][1]")).click();

         driver.findElement(AppiumBy.iOSNsPredicateString("label == 'Sauce Labs Backpack'")).click();
         driver.findElement(AppiumBy.iOSNsPredicateString("name == 'test-ADD TO CART'")).click();

         SwipeStaticUtils.swipeUpNTimesUp(driver, 2);
         SwipeStaticUtils.swipeUpNTimesDown(driver, 2);

        driver.findElement(AppiumBy.accessibilityId("test-BACK TO PRODUCTS")).click();

        SwipeStaticUtils.swipeUpNTimesUp(driver, 3);
        SwipeStaticUtils.swipeUpNTimesDown(driver, 3);

        driver.findElement(AppiumBy.iOSNsPredicateString("name == \"test-Toggle\"")).click();
        Thread.sleep(2000);
        SwipeStaticUtils.swipeUpNTimesUp(driver, 2);
        SwipeStaticUtils.swipeUpNTimesDown(driver, 2);

        driver.findElement(AppiumBy.iOSNsPredicateString("name == \"test-Toggle\"")).click();

        SwipeStaticUtils.swipeUpNTimesUp(driver, 3);
        SwipeStaticUtils.swipeUpNTimesDown(driver, 3);


        TouchHelper touchHelper = new TouchHelper(driver);

        // Tap at first coordinate
        touchHelper.tapAt(32, 54);

        // Tap at second coordinate
        touchHelper.tapAt(66, 329);


        // SignatureHelper signatureHelper = new SignatureHelper(driver);

        // Draw signature inside rectangle from (50, 300) width 200, height 100
        // signatureHelper.signAtCoordinates(50, 300, 200, 100);

        // AdvancedSignatureHelper helper = new AdvancedSignatureHelper(driver);

        // Draw realistic signature in rectangle at (50, 300), width=300, height=150
        // helper.sign(50, 300, 300, 150);


//        AdvancedSignatureHelperV2 helper = new AdvancedSignatureHelperV2(driver);
//
//        // Normal signature
//        helper.sign(50, 300, 300, 150);
//
//        // Signature with "thicker pen" effect
//        helper.signWithThickness(50, 300, 300, 150, 2); // 2 overlapping strokes


//        AutoSignatureHelper helper = new AutoSignatureHelper(driver);
//
//        // Simple automatic signature
//        helper.autoSign(50, 300, 300, 150);
//
//        // Signature with "bolder pen" effect
//        helper.autoSignWithThickness(50, 300, 300, 150, 2); // 2 overlapping strokes


        DewanshuSignatureHelper helper = new DewanshuSignatureHelper(driver);

        // Draw name in rectangle at (50, 300), width=300, height=100
        helper.drawName(50, 300, 300, 100);


//        AdvancedNameSignatureHelper helper = new AdvancedNameSignatureHelper(driver);
//
//        // Draw realistic "Dewanshu" signature in rectangle at (50, 300), width=350, height=120
//        helper.drawName(50, 300, 350, 120);
//
//        // Thicker, more realistic handwriting
//        helper.drawNameWithThickness(50, 300, 350, 120, 2);










    }


}
