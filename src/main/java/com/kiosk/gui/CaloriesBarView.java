package com.kiosk.gui;

import com.kiosk.MealChangeEvent;
import com.kiosk.MealModel;

import javax.swing.JComponent;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CaloriesBarView extends JComponent implements PropertyChangeListener {
    public static final int MAX_CALORIES = 1000;

    private int currentValue;
    private final int maxValue;

    /**
     * Initialises the bar with a zero value and a default max.
     */
    public CaloriesBarView() {
        this(MAX_CALORIES);
    }

    /**
     * Initialises the bar with a zero value and a maximum
     *
     * @param maxValue the maximum amount of calories above which the bar will
     *                 saturate
     */
    public CaloriesBarView(int maxValue) {
        this.maxValue = maxValue;
        this.currentValue = 0;
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(200, 40);
    }

    @Override
    public Dimension getMaximumSize() {
        return new Dimension(200, 40);
    }

    /**
     * Specialises the painting of the component to draw the bar
     * in different colours depending on the amount of calories
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGradationBar(g);
    }

    private void drawGradationBar(Graphics g) {
        int gap = 10;
        int barWidth = getWidth() - 2 * gap;
        int barHeight = getHeight() - 2 * gap;

        // Compute the percentage for coloring
        double percentage = (double) currentValue / maxValue;
        if (currentValue > maxValue) {
            percentage = 1.0;
        }
        int gradationWidth = (int) (percentage * barWidth);

        Color gradationColor = computeColor(percentage);

        // Draw the background bar
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(gap, gap, barWidth, barHeight);

        // Draw the gradation bar
        g.setColor(gradationColor);
        g.fillRect(gap, gap, gradationWidth, barHeight);
    }

    private Color computeColor(double percentage) {
        // Compute the hue for coloring
        double hue = interpolate(120, 0, percentage);

        // Convert HSV to RGB

        return Color.getHSBColor((float) (hue / 360), 1.0f, 1.0f);
    }

    private double interpolate(double start, double end, double percentage) {
        return start + (end - start) * percentage;
    }

    /**
     * This is where we define the reaction to property changes.
     * The rationale is:
     * (1) check if the event is of the proper type (the type we've defined)
     * (2) check which property has changed (by comparing the String defining its name);
     * (3) if necessary, cast the arguments in the event to the proper Object (e.g.
     * Integer)
     * (4) implement the reaction by updating internal attributes
     * (5) for a GUI, typically: repaint()
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt instanceof MealChangeEvent) {
            String propertyName = evt.getPropertyName();

            if(MealModel.CAL_COUNT_PROPERTY.equals(propertyName)){
                this.currentValue = (Integer) evt.getNewValue();
                repaint();
            } else if (MealModel.CHECKOUT_PROPERTY.equals(propertyName)) {
                this.currentValue = 0;
                repaint();
            }

        } else {
            throw new IllegalArgumentException("Unknown event for property: " + evt.getPropertyName());
        }
    }
}
