package org.uicatlog.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class GridEnhancements {

    // Remote WebDriver test execution
    public void executeDistributedTests() throws Exception {
        // Connect to Selenium Grid Hub
        WebDriver driver = new RemoteWebDriver(
                new URL("http://localhost:4444/wd/hub"), // Hub URL
                new ChromeOptions() // You can also use new FirefoxOptions()
        );

        driver.get("https://www.google.com");
        System.out.println("Page Title is: " + driver.getTitle());

        driver.quit();
    }

    // Example for Firefox
    public void runOnFirefox() throws Exception {
        WebDriver driver = new RemoteWebDriver(
                new URL("http://localhost:4444/wd/hub"),
                new FirefoxOptions()
        );

        driver.get("https://www.selenium.dev");
        System.out.println("Page Title is: " + driver.getTitle());

        driver.quit();
    }
}
