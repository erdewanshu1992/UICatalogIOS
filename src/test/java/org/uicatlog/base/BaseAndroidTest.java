package org.uicatlog.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class BaseAndroidTest {
    public AndroidDriver driver;

    @BeforeClass
    public void setUp() {
        UiAutomator2Options options = new UiAutomator2Options()
                .setPlatformName("Android")
                .setAutomationName("UiAutomator2")
                .setPlatformVersion("16.0")
                .setDeviceName("Pixel 8 API 36")
                // Agar app already install hai, to package aur activity specify karo
                .setAppPackage("com.myntra.android")
                .setAppActivity("com.myntra.android/.activities.react.ReactActivity")
                .setAutoGrantPermissions(true)
                .setNoReset(true) // Play Store app hai, data reset nahi karna
                .setAutoGrantPermissions(true)

                // APK ka local path do
                // .setApp("/Users/qadew/Desktop/apps/MySampleApp.apk")

                .setNewCommandTimeout(Duration.ofSeconds(3600));


            driver = new AndroidDriver(getUrl(), options);
            System.out.println("✅ iOS Driver started successfully.");

    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("🧹 Driver quit successfully.");
        }
    }

    private URL getUrl() {
        try {
            return new URL("http://127.0.0.1:4723");
        } catch (MalformedURLException e) {
            throw new RuntimeException("❌ Invalid Appium server URL", e);
        }
    }

}
