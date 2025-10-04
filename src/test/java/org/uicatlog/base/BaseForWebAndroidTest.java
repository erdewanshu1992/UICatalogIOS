package org.uicatlog.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseForWebAndroidTest {

    public AndroidDriver driver;

    @BeforeClass
    public void setUp() {
        // Configure options for a Chrome browser session on Android.
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setAutomationName("UiAutomator2")
                .setPlatformVersion("16.0")
                .setDeviceName("Pixel 8 API 36");
        options.setCapability("browserName", "Chrome");
        options.setCapability("appium:chromedriverExecutable", "/Users/qadew/Desktop/UICatalogIOS/driver/chromedriver");


        options.setNewCommandTimeout(Duration.ofSeconds(3600));

        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
            System.out.println("✅ Android Driver started successfully for Chrome browser.");

            // Once the driver is initialized, you can use the get() method to navigate to a website.
            driver.get("https://www.google.com");
        } catch (MalformedURLException e) {
            throw new RuntimeException("❌ Invalid Appium server URL", e);
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("🧹 Driver quit successfully.");
        }
    }
}
