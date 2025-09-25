package org.uicatlog.tests;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.uicatlog.base.BaseTest;
import org.uicatlog.utils.RetryAnalyzer;
import org.uicatlog.utils.SwipeStaticUtils;
import org.uicatlog.utils.SwipeUntil2ElementVisible;
import org.uicatlog.utils.SwipeUntilElementVisible;

import java.time.Duration;
import java.util.HashMap;


public class E2ENewsAppTest extends BaseTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testShowAndAcceptAlert() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement e1 = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//XCUIElementTypeStaticText[@name=\"Get News+\"]")));

        e1.click();

        System.out.println("✅ Test complete!" + e1.getText());

        // 2. Predicate string (powerful in iOS)
        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        AppiumBy.iOSNsPredicateString("name BEGINSWITH 'modal-host-vc-close'")
                )
        );
        element.click();

        // SwipeStaticUtils.swipeUpNTimes(driver, 5);

        SwipeUntilElementVisible utils = new SwipeUntilElementVisible(driver);

        // "Login" button tak scroll karega aur uspe click karega
        // utils.swipeUntilElementVisibleAndClick(AppiumBy.accessibilityId("More Apple News Top Stories "), 10);
        utils.swipeUntilElementVisibleAndClick(AppiumBy.accessibilityId("Subscription, National Geographic, A strange syndrome linked to cannabis use is on the rise, Stacey Colino"), 10);
        Thread.sleep(3000);

        WebElement popUps = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        AppiumBy.iOSNsPredicateString("name == \"SUBSCRIBE\" AND label == \"SUBSCRIBE\" AND value == \"SUBSCRIBE\"")
                )
        );
        popUps.click();

        System.out.println("✅ Test complete!" + " " + popUps.getText());

        SwipeStaticUtils.swipeUpNTimes(driver, 3);

        // driver.navigate().back();
        SwipeUntil2ElementVisible util = new SwipeUntil2ElementVisible(driver);
        // Ab upar scroll karke dusra element click
        util.swipeUntilElementVisibleAndClick(AppiumBy.iOSNsPredicateString("name == \"Done\" AND label == \"Done\" AND type == \"XCUIElementTypeButton\""), 5, "up");


        By newsTab = AppiumBy.iOSNsPredicateString("name == 'News+'");

        // Click na karke tap karega
        tapOnElement(newsTab);

        System.out.println("Touched on News Navigation bar" + " " + driver.findElement(newsTab).getText());

        By spotsTab = AppiumBy.iOSNsPredicateString("name == 'Sports'");

        // Click na karke tap karega
        tapOnElement(spotsTab);

        System.out.println("Touched on spots Tap Navigation bar");


        By okTab = AppiumBy.iOSNsPredicateString("name == 'OK'");

        // Click na karke tap karega
        tapOnElement(okTab);
        System.out.println(" Touched complete! on OK Text");

        WebElement followingTap = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        AppiumBy.iOSNsPredicateString("name == \"Following\"")
                )
        );
        followingTap.click();
        System.out.println("Clicked followingTap! Navigation bar");


    }







    // Tap karne ke liye reusable method
    public void tapOnElement(By locator) {
        WebElement element = driver.findElement(locator);

        HashMap<String, Object> tap = new HashMap<>();
        tap.put("x", element.getLocation().getX() + (element.getSize().getWidth() / 2));
        tap.put("y", element.getLocation().getY() + (element.getSize().getHeight() / 2));
        driver.executeScript("mobile: tap", tap);
    }





//    // Tap karne ke liye reusable method
//    public void tapOnElement(By locator) {
//        WebElement element = driver.findElement(locator);
//
//        HashMap<String, Object> tap = new HashMap<>();
//        tap.put("x", element.getLocation().getX() + (element.getSize().getWidth() / 2));
//        tap.put("y", element.getLocation().getY() + (element.getSize().getHeight() / 2));
//        driver.executeScript("mobile: tap", tap);
//    }

}

