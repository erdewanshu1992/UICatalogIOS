package org.uicatlog.utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class DewanshuSignatureHelper {

    private final AppiumDriver driver;

    public DewanshuSignatureHelper(AppiumDriver driver) {
        this.driver = driver;
    }

    /**
     * Draw the name "Dewanshu" in a rectangle
     *
     * @param startX top-left X of rectangle
     * @param startY top-left Y
     * @param width  width of rectangle
     * @param height height of rectangle
     */
    public void drawName(int startX, int startY, int width, int height) throws InterruptedException {

        // Scale factor for rectangle size
        double scaleX = width / 300.0;
        double scaleY = height / 100.0;

        // Define simple stroke coordinates per letter (example, simplified)
        List<int[][]> letters = new ArrayList<>();

        // D
        letters.add(new int[][]{
                {0,0},{0,80},{30,70},{0,0}  // vertical + curve
        });

        // e
        letters.add(new int[][]{
                {35,40},{60,40},{60,60},{35,60},{35,40}
        });

        // w
        letters.add(new int[][]{
                {65,80},{75,20},{85,80},{95,20},{105,80}
        });

        // a
        letters.add(new int[][]{
                {110,60},{120,20},{130,60},{120,40},{110,60}
        });

        // n
        letters.add(new int[][]{
                {140,80},{140,20},{150,20},{150,80}
        });

        // s
        letters.add(new int[][]{
                {160,20},{180,20},{160,50},{180,50},{160,80},{180,80}
        });

        // h
        letters.add(new int[][]{
                {190,80},{190,20},{190,50},{210,50},{210,80}
        });

        // u
        letters.add(new int[][]{
                {220,20},{220,70},{240,70},{240,20}
        });

        // Draw letters
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence draw = new Sequence(finger, 1);

        for (int[][] letter : letters) {
            boolean first = true;
            for (int[] point : letter) {
                int x = startX + (int)(point[0]*scaleX);
                int y = startY + (int)(point[1]*scaleY);

                if (first) {
                    draw.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y));
                    draw.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
                    first = false;
                } else {
                    draw.addAction(finger.createPointerMove(Duration.ofMillis(150), PointerInput.Origin.viewport(), x, y));
                }
            }
            draw.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        }

        driver.perform(List.of(draw));
    }
}
