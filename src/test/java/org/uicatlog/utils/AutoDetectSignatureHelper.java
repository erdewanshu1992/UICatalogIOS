package org.uicatlog.utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AutoDetectSignatureHelper {

    private final AppiumDriver driver;
    private final Random random = new Random();

    public AutoDetectSignatureHelper(AppiumDriver driver) {
        this.driver = driver;
    }

    /**
     * Automatically detect signature area and draw realistic signature
     *
     * For demo, we assume signature box is at a fixed area on screen
     * (e.g., bottom 20% of the screen). In real app, adjust heuristics.
     */
    public void autoSign() throws InterruptedException {
        // Get screen size
        int screenWidth = driver.manage().window().getSize().getWidth();
        int screenHeight = driver.manage().window().getSize().getHeight();

        // Assume signature box at bottom 20% of screen
        int startX = 20;
        int startY = screenHeight - screenHeight / 5;
        int width = screenWidth - 40;
        int height = screenHeight / 6;

        // Call advanced signature draw
        drawSignature(startX, startY, width, height);
    }

    private void drawSignature(int startX, int startY, int width, int height) throws InterruptedException {
        int strokes = 6 + random.nextInt(3); // 6-8 strokes

        for (int s = 0; s < strokes; s++) {
            drawCurvedStroke(startX, startY, width, height);
            Thread.sleep(150 + random.nextInt(200));
        }
    }

    private void drawCurvedStroke(int startX, int startY, int width, int height) throws InterruptedException {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence draw = new Sequence(finger, 1);

        int x = startX + 5 + random.nextInt(width - 10);
        int y = startY + 5 + random.nextInt(height / 3);
        draw.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y));
        draw.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        int points = 6 + random.nextInt(3);
        for (int i = 0; i < points; i++) {
            int newX = startX + 5 + random.nextInt(width - 10);
            int newY = startY + 5 + random.nextInt(height - 5);
            int duration = 100 + random.nextInt(200);
            draw.addAction(finger.createPointerMove(Duration.ofMillis(duration),
                    PointerInput.Origin.viewport(), newX, newY));
        }

        draw.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(List.of(draw));
    }

    /**
     * Optional thicker signature
     */
    public void autoSignWithThickness(int repetitions) throws InterruptedException {
        for (int i = 0; i < repetitions; i++) {
            autoSign();
        }
    }
}
