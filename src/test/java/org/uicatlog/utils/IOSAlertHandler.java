package org.uicatlog.utils;

import io.appium.java_client.AppiumBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class IOSAlertHandler {

    public static void handleAlertIfPresent(WebDriver driver, String buttonText) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));

            // Agar alert aaya to wait karega, warna TimeoutException me catch chala jayega
            wait.until(ExpectedConditions.alertIsPresent());

            // Alert text nikalna
            String alertMessage = driver.switchTo().alert().getText();
            System.out.println("⚡ Alert Text: " + alertMessage);

            // Alert ke sare button nikalna
            List<WebElement> buttons = driver.findElements(
                    AppiumBy.iOSClassChain("**/XCUIElementTypeButton")
            );

            for (WebElement btn : buttons) {
                System.out.println("Found Button: " + btn.getText());

                if (btn.getText().equalsIgnoreCase(buttonText)) {
                    btn.click();
                    System.out.println("👉 Clicked on button: " + buttonText);
                    return;
                }
            }

            System.out.println("❌ Required button not found: " + buttonText);

        } catch (Exception e) {
            // Agar alert hi nahi mila to ye chalega
            System.out.println("ℹ️ No alert popup found, continuing test...");
        }
    }
}








/*

// Agar alert aaya to handle ho jayega, agar nahi aaya to normal flow
IOSAlertHandler.handleAlertIfPresent(driver, "Allow While Using App");

// Next test steps...
System.out.println("➡️ Moving ahead with next steps...");

 */





//package org.uicatlog.utils;
//
//import io.appium.java_client.AppiumBy;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//import java.time.Duration;
//import java.util.List;
//
//public class IOSAlertHandler {
//
//    public static void handleAlert(WebDriver driver, String buttonText) {
//        try {
//            // Wait until alert appears
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//            wait.until(ExpectedConditions.alertIsPresent());
//
//            // Print alert text
//            String alertMessage = driver.switchTo().alert().getText();
//            System.out.println("⚡ Alert Text: " + alertMessage);
//
//            // Get all buttons in alert
//            List<WebElement> buttons = driver.findElements(
//                    AppiumBy.iOSClassChain("**/XCUIElementTypeButton")
//            );
//
//            for (WebElement btn : buttons) {
//                System.out.println("Found Button: " + btn.getText());
//
//                // Match with required button
//                if (btn.getText().equalsIgnoreCase(buttonText)) {
//                    btn.click();
//                    System.out.println("👉 Clicked on button: " + buttonText);
//                    return;
//                }
//            }
//
//            System.out.println("❌ Button not found: " + buttonText);
//
//        } catch (Exception e) {
//            System.out.println("⚠️ No alert present or error occurred: " + e.getMessage());
//        }
//    }
//}


/*

IOSAlertHandler.handleAlert(driver, "Allow While Using App");
// ya
IOSAlertHandler.handleAlert(driver, "Don't Allow");
// ya
IOSAlertHandler.handleAlert(driver, "Allow Once");

 */