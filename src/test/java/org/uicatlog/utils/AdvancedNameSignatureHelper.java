package org.uicatlog.utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AdvancedNameSignatureHelper {

    private final AppiumDriver driver;
    private final Random random = new Random();

    public AdvancedNameSignatureHelper(AppiumDriver driver) {
        this.driver = driver;
    }

    /**
     * Draws the name "Dewanshu" in a realistic handwritten style
     *
     * @param startX top-left X of rectangle
     * @param startY top-left Y of rectangle
     * @param width  width of rectangle
     * @param height height of rectangle
     */
    public void drawName(int startX, int startY, int width, int height) throws InterruptedException {
        int strokes = 3 + random.nextInt(2); // 3-4 strokes for realism

        for (int s = 0; s < strokes; s++) {
            drawCurvedNameStroke(startX, startY, width, height);
            Thread.sleep(200 + random.nextInt(200));
        }
    }

    private void drawCurvedNameStroke(int startX, int startY, int width, int height) throws InterruptedException {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence draw = new Sequence(finger, 1);

        // Base start point
        int x = startX + 5 + random.nextInt(width / 5);
        int y = startY + 5 + random.nextInt(height / 3);
        draw.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y));
        draw.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        // Random curved points to simulate handwriting
        int points = 12 + random.nextInt(5); // 12-16 points for smooth letters
        for (int i = 0; i < points; i++) {
            int newX = startX + 5 + random.nextInt(width - 10);
            int newY = startY + 5 + random.nextInt(height - 10);
            int duration = 80 + random.nextInt(150);
            draw.addAction(finger.createPointerMove(Duration.ofMillis(duration),
                    PointerInput.Origin.viewport(), newX, newY));
        }

        draw.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(List.of(draw));
    }

    /**
     * Optional: Draw thicker signature by repeating strokes
     *
     * @param startX
     * @param startY
     * @param width
     * @param height
     * @param thickness 1-3, higher = bolder
     */
    public void drawNameWithThickness(int startX, int startY, int width, int height, int thickness) throws InterruptedException {
        for (int t = 0; t < thickness; t++) {
            drawName(startX, startY, width, height);
        }
    }
}

