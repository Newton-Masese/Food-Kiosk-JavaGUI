package com.kiosk.gui;

import com.kiosk.MealChangeEvent;
import com.kiosk.MealModel;
import com.kiosk.food.Food;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class MealItemsView extends JPanel implements PropertyChangeListener {

    private final JTextArea textArea;

    public MealItemsView(){
        this.setBorder(BorderFactory.createTitledBorder("Meal Items"));
        textArea = new JTextArea(10, 30);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(textArea);

        this.add(scrollPane);
    }

    /**
     * This method gets called when a bound property is changed.
     *
     * @param evt A PropertyChangeEvent object describing the event source
     *            and the property that has changed.
     */
    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt instanceof MealChangeEvent){
            String propertyName = evt.getPropertyName();

            if (MealModel.ITEM_LIST_PROPERTY.equals(propertyName)){
                Food newItem = (Food) evt.getNewValue();
                String descr = newItem + ": £" + newItem.getPrice() + " ["+ newItem.getCalories() + " cal]";
                this.textArea.append(descr + "\n");
                repaint();
            } else if (MealModel.CHECKOUT_PROPERTY.equals(propertyName)) {
                this.textArea.setText("");
            }
        }else {
            throw new IllegalArgumentException("Unknown event for property: " + evt.getPropertyName());
        }
    }
}
