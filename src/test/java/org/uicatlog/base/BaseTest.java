
/*
// if run single device, then use this code
package org.uicatlog.base;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    public IOSDriver driver;

    @Parameters({"udid", "port"})
    @BeforeClass
    public void setUp(String udid, String port) {
        XCUITestOptions options = new XCUITestOptions()
                .setPlatformName("iOS")
                .setAutomationName("XCUITest")
                .setUdid(udid)
                .setPlatformVersion("18.5")
                .setDeviceName("iPhone Simulator")
                .setApp("/Users/ndewanshu/Desktop/ipaFiles/ios-uicatalog/UICatalog/build/Build/Products/Debug-iphonesimulator/UICatalog.app")
                .setNewCommandTimeout(java.time.Duration.ofSeconds(3600))
                .setConnectHardwareKeyboard(true);

        try {
            URL appiumServerUrl = new URL("http://127.0.0.1:" + port);
            driver = new IOSDriver(appiumServerUrl, options);
            System.out.println("✅ iOS Driver started successfully for device: " + udid);
        } catch (MalformedURLException e) {
            throw new RuntimeException("❌ Invalid Appium server URL for port: " + port, e);
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

 */





/*
// if run multiple device, then use this code
package org.uicatlog.base;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    public IOSDriver driver;

    @BeforeClass
    @Parameters({"udid", "deviceName", "platformVersion", "appPath", "appiumServerPort"})
    public void setUp(String udid, String deviceName, String platformVersion, String appPath, String appiumServerPort) {
        XCUITestOptions options = new XCUITestOptions()
                .setPlatformName("iOS")
                .setAutomationName("XCUITest")
                .setUdid(udid)
                .setDeviceName(deviceName)
                .setPlatformVersion(platformVersion)
                .setApp(appPath)
                .setNewCommandTimeout(Duration.ofSeconds(3600))
                .setConnectHardwareKeyboard(true);

        try {
            driver = new IOSDriver(new URL("http://127.0.0.1:" + appiumServerPort), options);
            System.out.println("✅ iOS Driver started successfully for device: " + deviceName);
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












/*
// if run multiple device, then use this code
package org.uicatlog.base;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {

    public IOSDriver driver;

    @Parameters({"udid", "port", "deviceName", "platformVersion"})
    @BeforeClass
    public void setUp(String udid, String port, String deviceName, String platformVersion) {
        XCUITestOptions options = new XCUITestOptions()
                .setPlatformName("iOS")
                .setAutomationName("XCUITest")
                .setUdid(udid)
                .setPlatformVersion(platformVersion)
                .setDeviceName(deviceName)
                .setApp("/Users/ndewanshu/Desktop/ipaFiles/ios-uicatalog/UICatalog/build/Build/Products/Debug-iphonesimulator/UICatalog.app")
                .setIncludeSafariInWebviews(true)
                .setNewCommandTimeout(Duration.ofSeconds(3600))
                .setConnectHardwareKeyboard(true);

        driver = new IOSDriver(getUrl(port), options);
        System.out.println("✅ iOS Driver started for device: " + deviceName + " (Port: " + port + ")");
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("🧹 Driver quit successfully.");
        }
    }

    private URL getUrl(String port) {
        try {
            return new URL("http://127.0.0.1:" + port);
        } catch (MalformedURLException e) {
            throw new RuntimeException("❌ Invalid Appium server URL", e);
        }
    }
}

 */









// // if run single device, normally then use this code
package org.uicatlog.base;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    public IOSDriver driver;

    @BeforeClass
    public void setUp() {
        XCUITestOptions options = new XCUITestOptions()
                .setPlatformName("iOS")
                .setAutomationName("XCUITest")
                .setUdid("47633498-69A3-4C11-922A-084186084D0F")
                .setPlatformVersion("18.5")
                .setDeviceName("iPhone 16 Plus")
                // .setApp("/Users/dewanshun/Desktop/UICatalogIOS/app/UIKitCatalog.app.zip")
                .setApp(System.getProperty("user.dir") + "/app/UIKitCatalog.app.zip")
                .setIncludeSafariInWebviews(true)
                .setNewCommandTimeout(java.time.Duration.ofSeconds(3600))
                .setConnectHardwareKeyboard(true);

        driver = new IOSDriver(getUrl(), options);
        System.out.println("✅ iOS Driver started successfully.");
        System.out.println("Driver is null? " + false);
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
