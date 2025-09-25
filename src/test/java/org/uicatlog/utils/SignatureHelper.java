package org.uicatlog.utils;

import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.List;

public class SignatureHelper {

    IOSDriver driver;

    public SignatureHelper(IOSDriver driver) {
        this.driver = driver;
    }

    /**
     * Draw a signature inside the rectangle defined by startX, startY, width, height
     */
    public void signAtCoordinates(int startX, int startY, int width, int height) throws InterruptedException {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence draw = new Sequence(finger, 1);

        // Start at top-left inside the box
        draw.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(),
                startX + 5, startY + 5));
        draw.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        // Draw simple zigzag inside the box
        draw.addAction(finger.createPointerMove(Duration.ofMillis(200),
                PointerInput.Origin.viewport(),
                startX + width/2, startY + height/3));
        draw.addAction(finger.createPointerMove(Duration.ofMillis(200),
                PointerInput.Origin.viewport(),
                startX + width/3, startY + 2*height/3));
        draw.addAction(finger.createPointerMove(Duration.ofMillis(200),
                PointerInput.Origin.viewport(),
                startX + 3*width/4, startY + height - 5));

        draw.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(List.of(draw));
        Thread.sleep(1000); // optional pause
    }
}

