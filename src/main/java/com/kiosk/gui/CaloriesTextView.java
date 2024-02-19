package com.kiosk.gui;

import com.kiosk.MealChangeEvent;
import com.kiosk.MealModel;

import javax.swing.*;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class CaloriesTextView extends JLabel implements PropertyChangeListener {

    public static final int MAX_CALORIES = 1000;
    private int currentValue;

    public CaloriesTextView() {
        this.currentValue = 0;

        this.setBackground(Color.WHITE);
        this.setOpaque(true);
        this.setText(Integer.toString(currentValue));
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
        if(evt instanceof MealChangeEvent){
            String propertyName = evt.getPropertyName();

            if(MealModel.CAL_COUNT_PROPERTY.equals(propertyName)){
                this.currentValue = (Integer) evt.getNewValue();
                this.setText(Integer.toString(currentValue));
            } else if (MealModel.CHECKOUT_PROPERTY.equals(propertyName)) {
                this.currentValue = 0;
                this.setText(Integer.toString(currentValue));
            }
        }else {
            throw new IllegalArgumentException("Unknown event for property: " + evt.getPropertyName());
        }
    }
}
