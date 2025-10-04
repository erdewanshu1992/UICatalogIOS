package org.uicatlog.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import java.util.Set;


// Selenium 4.0+ Window Management
public class WindowManagement {
    public void manageWindows(WebDriver driver) {
        // Store the original window handle
        String originalWindowHandle = driver.getWindowHandle();

        // Get all window handles
        Set<String> windowHandles = driver.getWindowHandles();

        // Switch to specific window
        for (String handle : windowHandles) {
            driver.switchTo().window(handle);
            if (driver.getTitle().contains("Specific Page")) {
                break;
            }
        }

        // New window/tab methods
        WebDriver newWindow = driver.switchTo().newWindow(WindowType.WINDOW);
        WebDriver newTab = driver.switchTo().newWindow(WindowType.TAB);

        // Close current window and switch back
        driver.close();
        driver.switchTo().window(originalWindowHandle);
    }
}
