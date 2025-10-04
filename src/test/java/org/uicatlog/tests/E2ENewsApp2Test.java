package org.uicatlog.tests;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.uicatlog.base.BaseIOSTest;
import org.uicatlog.utils.RetryAnalyzer;
import org.uicatlog.utils.SwipeStaticUtils;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class E2ENewsApp2Test extends BaseIOSTest {

    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testShowAndAcceptAlert() throws InterruptedException {
        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Get News+\"]")).click();

//        Thread.sleep(2000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//
//        try {
//            // Check if alert is present
//            wait.until(ExpectedConditions.alertIsPresent());
//
//            // Debug: list all visible buttons
//            List<WebElement> buttons = driver.findElements(AppiumBy.iOSClassChain("**/XCUIElementTypeButton"));
//            for (WebElement btn : buttons) {
//                System.out.println("Button text: " + btn.getText());
//            }
//
//            // Switch to alert and accept
//            Alert alert = driver.switchTo().alert();
//            System.out.println("✅ Alert found: " + alert.getText());
//            alert.accept();
//
//        } catch (TimeoutException e) {
//            // If no alert comes
//            System.out.println("⚠️ No alert found, continuing test...");
//        }

//        List<WebElement> elements = driver.findElements(By.xpath("//XCUIElementTypeButton[@name=\"modal-host-vc-close-E268EC7A-0BEB-4D33-A5C3-147503143CEF\"]"));
//                // AppiumBy.accessibilityId("modal-host-vc-close-79F91A68-D4D0-40C7-A48B-D8EA779A2B7A"));
//        // AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"modal-host-vc-close-79F91A68-D4D0-40C7-A48B-D8EA779A2B7A\"`]")
//        System.out.println("Total elements found: " + elements.size());
//
//
//        WebElement element = wait.until(
//                ExpectedConditions.presenceOfElementLocated(
//                                By.xpath("//XCUIElementTypeButton[@name=\"modal-host-vc-close-79F91A68-D4D0-40C7-A48B-D8EA779A2B7A\"]")
//                )
//        ); // AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name == \"modal-host-vc-close-79F91A68-D4D0-40C7-A48B-D8EA779A2B7A\"`]")
//
//        element.click();


        // 1. Wildcard / partial match in iOSClassChain
//        WebElement element = wait.until(
//                ExpectedConditions.presenceOfElementLocated(
//                        AppiumBy.iOSClassChain("**/XCUIElementTypeButton[`name BEGINSWITH \"modal-host-vc-close\"`]")
//                )
//        );
//        element.click();

        // 2. Predicate string (powerful in iOS)
        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(
                        AppiumBy.iOSNsPredicateString("name BEGINSWITH 'modal-host-vc-close'")
                )
        );
        element.click();




//        HashMap<String, Object> params = new HashMap<>();
//        params.put("direction", "down");   // ya "up"
//        params.put("toVisible", true);     // jab tak element visible na ho
//        driver.executeScript("mobile: scroll", params);

        // swipeUp();
        // scrollToBottom();
        // swipeUpTillBottom();

        // swipeUpMultipleTimes(5);

//         swipeConstructorUpNTimes(5);


        SwipeStaticUtils.swipeUpNTimesUp(driver, 5);

        // OR
//        swipeConstructorUpNTimes swipeStaticUtils = new swipeConstructorUpNTimes(driver);
//        swipeStaticUtils.swipeUpNTimes(5);


//        MobileElement el = (MobileElement) driver.findElement(AppiumBy.id("loginBtn"));
//        el.tap(1, 500); // Mobile-specific action

    }


    public void swipeUpMultipleTimes(int count) {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.8);  // bottom se start
        int endY = (int) (size.height * 0.2);    // top tak le jao

        for (int i = 0; i < count; i++) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("direction", "up");
            params.put("velocity", 2500);
            params.put("fromX", startX);
            params.put("fromY", startY);
            params.put("toX", startX);
            params.put("toY", endY);

            driver.executeScript("mobile: swipe", params);
            System.out.println("✅ Swipe " + (i + 1) + " done");

            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void swipeUpNTimes(int times) {
        Dimension size = driver.manage().window().getSize();
        int startX = size.width / 2;
        int startY = (int) (size.height * 0.8);
        int endY = (int) (size.height * 0.2);

        for (int i = 0; i < times; i++) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("direction", "up");
            params.put("fromX", startX);
            params.put("fromY", startY);
            params.put("toX", startX);
            params.put("toY", endY);
            driver.executeScript("mobile: swipe", params);

            System.out.println("Swipe #" + (i+1));

            try {
                Thread.sleep(1500);  // 1.5 sec rukne de taaki content load ho jaye
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



//    public void swipeUpTillBottom() {
//        Dimension size = driver.manage().window().getSize();
//        int startX = size.width / 2;
//        int startY = (int) (size.height * 0.6);  // bottom se start
//        int endY = (int) (size.height * 0.2);    // top tak le jao
//
//        boolean canScrollMore = true;
//
//        while (canScrollMore) {
//            HashMap<String, Object> params = new HashMap<>();
//            params.put("direction", "up");
//            params.put("velocity", 2500);
//            params.put("fromX", startX);
//            params.put("fromY", startY);
//            params.put("toX", startX);
//            params.put("toY", endY);
//
//            canScrollMore = (Boolean) driver.executeScript("mobile: swipe", params);
//            System.out.println("Scrolled... more? " + canScrollMore);
//        }
//
//        System.out.println("✅ Reached bottom of the page!");
//    }


//    public void swipeUp() {
//        Dimension size = driver.manage().window().getSize();
//        int startX = size.width / 2;
//        int startY = (int) (size.height * 0.8);  // bottom se start
//        int endY = (int) (size.height * 0.2);    // top tak le jao
//
//        HashMap<String, Object> params = new HashMap<>();
//        params.put("direction", "up");
//        params.put("velocity", 2500); // fast swipe
//        params.put("fromX", startX);
//        params.put("fromY", startY);
//        params.put("toX", startX);
//        params.put("toY", endY);
//
//        driver.executeScript("mobile: swipe", params);
//    }



    public void scrollToBottom() {
        boolean canScrollMore = true;

        while (canScrollMore) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("direction", "up");
            canScrollMore = (Boolean) driver.executeScript("mobile: swipe", params);
            System.out.println("Scrolled... more? " + canScrollMore);
        }
        System.out.println("✅ Reached bottom of the page!");
    }




    public void scrollToElement(String elementName) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Map<String, Object> params = new HashMap<>();
        params.put("direction", "down");
        params.put("name", elementName);  // jis element ka "name" ya "label" hai
        js.executeScript("mobile: scroll", params);
    }

}







//package org.uicatlog.tests;
//
//import io.appium.java_client.AppiumBy;
//import org.openqa.selenium.Alert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.annotations.Test;
//import org.uicatlog.base.BaseTest;
//import org.uicatlog.pages.AlertsPage;
//import org.uicatlog.utils.RetryAnalyzer;
//
//import java.time.Duration;
//import java.util.List;
//
//public class E2ENewsAppTest extends BaseTest {
//
//    @Test(retryAnalyzer = RetryAnalyzer.class)
//    public void testShowAndAcceptAlert() throws InterruptedException {
//        // driver.findElement(AppiumBy.accessibilityId("Alert Views")).click();
//        driver.findElement(By.xpath("//XCUIElementTypeStaticText[@name=\"Get News+\"]")).click();
//
//        Thread.sleep(2000);
//
//        // Wait for alert
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//        wait.until(ExpectedConditions.alertIsPresent());
//
//        List<WebElement> buttons = driver.findElements(AppiumBy.iOSClassChain("**/XCUIElementTypeButton"));
//        for (WebElement btn : buttons) {
//            System.out.println("Button text: " + btn.getText());
//        }
//
//
//        Alert alert = driver.switchTo().alert();
//        alert.accept();
//
//    }
//}

