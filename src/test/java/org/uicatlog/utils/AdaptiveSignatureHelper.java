package org.uicatlog.utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.imageio.ImageIO;

public class AdaptiveSignatureHelper {

    private final AppiumDriver driver;
    private final Random random = new Random();

    public AdaptiveSignatureHelper(AppiumDriver driver) {
        this.driver = driver;
    }

    /**
     * Automatically detect signature area from screenshot and draw realistic signature
     */
    public void autoSign() throws Exception {
        Rectangle signatureBox = detectSignatureBox();
        drawSignature(signatureBox.x, signatureBox.y, signatureBox.width, signatureBox.height);
    }

    /**
     * Optional thicker signature
     */
    public void autoSignWithThickness(int repetitions) throws Exception {
        for (int i = 0; i < repetitions; i++) {
            autoSign();
        }
    }

    /**
     * Detect signature box using screenshot heuristics
     * For demo, assumes largest white-ish rectangle near bottom of screen
     */
    private Rectangle detectSignatureBox() throws Exception {
        byte[] screenshotBytes = driver.getScreenshotAs(OutputType.BYTES);
        BufferedImage image = ImageIO.read(new ByteArrayInputStream(screenshotBytes));

        int width = image.getWidth();
        int height = image.getHeight();

        // Simple heuristic: bottom 20% of screen
        int startX = 20;
        int startY = height - height / 5;
        int boxWidth = width - 40;
        int boxHeight = height / 6;

        return new Rectangle(startX, startY, boxWidth, boxHeight);
    }

    /**
     * Draw realistic signature inside given rectangle
     */
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

        int points = 6 + random.nextInt(3); // 6-8 points per stroke
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
}

