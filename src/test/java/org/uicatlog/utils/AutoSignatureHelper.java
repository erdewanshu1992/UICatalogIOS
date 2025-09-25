package org.uicatlog.utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AutoSignatureHelper {

    private final AppiumDriver driver;
    private final Random random = new Random();

    public AutoSignatureHelper(AppiumDriver driver) {
        this.driver = driver;
    }

    /**
     * Automatically draw a realistic signature in the given rectangle
     *
     * @param startX top-left X coordinate of rectangle
     * @param startY top-left Y coordinate of rectangle
     * @param width  width of rectangle
     * @param height height of rectangle
     * @throws InterruptedException
     */
    public void autoSign(int startX, int startY, int width, int height) throws InterruptedException {

        int strokes = 6 + random.nextInt(3); // 6-8 strokes

        for (int s = 0; s < strokes; s++) {
            drawCurvedStroke(startX, startY, width, height);
            Thread.sleep(150 + random.nextInt(200)); // random pause between strokes
        }
    }

    /**
     * Draw a single curved stroke with random points inside rectangle
     */
    private void drawCurvedStroke(int startX, int startY, int width, int height) throws InterruptedException {

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence draw = new Sequence(finger, 1);

        // Random start point inside rectangle
        int x = startX + 5 + random.nextInt(width - 10);
        int y = startY + 5 + random.nextInt(height / 3);
        draw.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y));
        draw.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        // Random points for smooth curved stroke
        int points = 6 + random.nextInt(3); // 6-8 points
        List<int[]> pathPoints = new ArrayList<>();
        pathPoints.add(new int[]{x, y});

        for (int i = 0; i < points; i++) {
            int newX = startX + 5 + random.nextInt(width - 10);
            int newY = startY + 5 + random.nextInt(height - 5);
            pathPoints.add(new int[]{newX, newY});

            int duration = 100 + random.nextInt(200); // variable speed
            draw.addAction(finger.createPointerMove(Duration.ofMillis(duration),
                    PointerInput.Origin.viewport(), newX, newY));
        }

        draw.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(List.of(draw));
    }

    /**
     * Draw signature with optional thickness (repeated strokes)
     *
     * @param startX
     * @param startY
     * @param width
     * @param height
     * @param thickness 1-3, higher = bolder signature
     */
    public void autoSignWithThickness(int startX, int startY, int width, int height, int thickness) throws InterruptedException {
        for (int t = 0; t < thickness; t++) {
            autoSign(startX, startY, width, height);
        }
    }
}

