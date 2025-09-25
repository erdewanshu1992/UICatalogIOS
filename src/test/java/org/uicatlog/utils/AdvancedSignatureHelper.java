package org.uicatlog.utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AdvancedSignatureHelper {

    private final AppiumDriver driver;
    private final Random random = new Random();

    public AdvancedSignatureHelper(AppiumDriver driver) {
        this.driver = driver;
    }

    /**
     * Draw a realistic signature inside a rectangle
     *
     * @param startX top-left X coordinate of rectangle
     * @param startY top-left Y coordinate of rectangle
     * @param width  width of rectangle
     * @param height height of rectangle
     * @throws InterruptedException
     */
    public void sign(int startX, int startY, int width, int height) throws InterruptedException {
        int strokes = 3 + random.nextInt(2); // 3-4 strokes
        for (int i = 0; i < strokes; i++) {
            drawStroke(startX, startY, width, height);
            Thread.sleep(500); // pause between strokes
        }
    }

    private void drawStroke(int startX, int startY, int width, int height) throws InterruptedException {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence draw = new Sequence(finger, 1);

        // Random start point inside rectangle
        int x = startX + 5 + random.nextInt(width - 10);
        int y = startY + 5 + random.nextInt(height / 3);
        draw.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y));
        draw.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        // Random intermediate points to create smooth stroke
        int points = 5 + random.nextInt(3); // 5-7 points
        for (int j = 0; j < points; j++) {
            int newX = startX + 5 + random.nextInt(width - 10);
            int newY = startY + random.nextInt(height);
            draw.addAction(finger.createPointerMove(Duration.ofMillis(150 + random.nextInt(150)),
                    PointerInput.Origin.viewport(), newX, newY));
        }

        draw.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(List.of(draw));
    }
}

