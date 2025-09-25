package org.uicatlog.utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AdvancedSignatureHelperV2 {

    private final AppiumDriver driver;
    private final Random random = new Random();

    public AdvancedSignatureHelperV2(AppiumDriver driver) {
        this.driver = driver;
    }

    /**
     * Draw realistic signature in a rectangle with multiple strokes and variable speed
     *
     * @param startX top-left X coordinate
     * @param startY top-left Y coordinate
     * @param width  width of rectangle
     * @param height height of rectangle
     * @throws InterruptedException
     */
    public void sign(int startX, int startY, int width, int height) throws InterruptedException {

        int strokes = 3 + random.nextInt(3); // 3-5 strokes

        for (int s = 0; s < strokes; s++) {
            drawStroke(startX, startY, width, height);
            Thread.sleep(200 + random.nextInt(300)); // pause between strokes
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

        // Generate 6-8 random points for a smooth curved stroke
        int points = 6 + random.nextInt(3);
        List<int[]> pathPoints = new ArrayList<>();
        pathPoints.add(new int[]{x, y});

        for (int i = 0; i < points; i++) {
            int newX = startX + 5 + random.nextInt(width - 10);
            int newY = startY + 5 + random.nextInt(height - 5);
            pathPoints.add(new int[]{newX, newY});

            // Variable speed per segment
            int duration = 100 + random.nextInt(200);
            draw.addAction(finger.createPointerMove(Duration.ofMillis(duration),
                    PointerInput.Origin.viewport(), newX, newY));
        }

        draw.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(List.of(draw));
    }

    /**
     * Optional: Draw signature with "pen thickness" concept (simulated by repeating strokes)
     *
     * @param startX
     * @param startY
     * @param width
     * @param height
     * @param thickness 1-3, higher = more overlapping strokes
     */
    public void signWithThickness(int startX, int startY, int width, int height, int thickness) throws InterruptedException {
        for (int t = 0; t < thickness; t++) {
            sign(startX, startY, width, height);
        }
    }
}


