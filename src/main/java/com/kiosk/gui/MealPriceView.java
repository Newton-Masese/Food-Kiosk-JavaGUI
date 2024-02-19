package com.kiosk.gui;

import com.kiosk.MealChangeEvent;
import com.kiosk.MealModel;

import javax.swing.JLabel;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MealPriceView extends JLabel implements PropertyChangeListener {

    public MealPriceView(){
        this.setText("£ - ");
    }
    /**
     * This method gets called when a bound property is changed.
     *
     * @param evt A PropertyChangeEvent object describing the event source
     *            and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt instanceof MealChangeEvent) {
            String propertyName = evt.getPropertyName();

            if (MealModel.CHECKOUT_PROPERTY.equals(propertyName)) {
                double price = (Double) evt.getOldValue();
                this.setText(String.format("£ %5.2f ", price));
            } else if (MealModel.CAL_COUNT_PROPERTY.equals(propertyName)) {
                this.setText("£ - ");
            }
        } else {
            throw new IllegalArgumentException("Unknown event for property: " + evt.getPropertyName());
        }
    }
}
