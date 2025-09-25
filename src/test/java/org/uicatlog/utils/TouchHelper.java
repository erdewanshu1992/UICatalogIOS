package org.uicatlog.utils;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.List;

public class TouchHelper {

    IOSDriver driver;

    public TouchHelper(IOSDriver driver) {
        this.driver = driver;
    }

    /**
     * Tap at given coordinates with optional delay after tap
     *
     * @param x     X coordinate
     * @param y     Y coordinate
     * @param delayMillis Delay after tap in milliseconds
     * @throws InterruptedException
     */
    public void tapAt(int x, int y, long delayMillis) throws InterruptedException {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);

        // Move to coordinate
        tap.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), x, y));

        // Tap down & up
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(List.of(tap));

        // Optional delay
        if (delayMillis > 0) {
            Thread.sleep(delayMillis);
        }
    }

    /**
     * Convenience method to tap with default 2 seconds delay
     */
    public void tapAt(int x, int y) throws InterruptedException {
        tapAt(x, y, 2000);
    }
}

