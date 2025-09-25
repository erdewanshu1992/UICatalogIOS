package org.uicatlog.base;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseForWebTest {

        public IOSDriver driver;

        @BeforeClass
        public void setUp() {
            XCUITestOptions options = new XCUITestOptions()
                    .setPlatformName("iOS")
                    .setAutomationName("XCUITest")
                    .setUdid("7184F681-284E-4AD7-B2D6-284C48BDC5A7")
                    .setPlatformVersion("26")
                    .setDeviceName("iPhone 17 Pro Max");
            options.setCapability("browserName", "Safari");
            options.setNewCommandTimeout(Duration.ofSeconds(3600));
            options.setConnectHardwareKeyboard(true);

            driver = new IOSDriver(getUrl(), options);
            System.out.println("✅ iOS Driver started successfully for Safari browser.");
             driver.get("https://www.google.com");
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
