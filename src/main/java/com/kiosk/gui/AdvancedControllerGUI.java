package com.kiosk.gui;

import com.kiosk.AdvancedMealController;
import com.kiosk.food.Beverage;
import com.kiosk.food.Burger;
import com.kiosk.food.Dessert;

import javax.swing.*;
import java.awt.*;

public class AdvancedControllerGUI extends BasicControllerGui {

    private final JCheckBox beverageCheckBox = new JCheckBox("diet");
    private final JCheckBox burgerCheckBox = new JCheckBox("diet");
    private final JCheckBox dessertCheckBox = new JCheckBox("diet");

    /**
     * Creates a GUI for a controller element of the specialised kind.
     *
     * @param controller the advanced controller
     */
    public AdvancedControllerGUI(AdvancedMealController controller) {
        super(controller);

        JPanel checkBoxPanel = new JPanel();
        checkBoxPanel.setLayout(new BoxLayout(checkBoxPanel, BoxLayout.Y_AXIS));

        Dimension checkBoxSize = new Dimension(100, 30);
        beverageCheckBox.setMaximumSize(checkBoxSize);
        burgerCheckBox.setMaximumSize(checkBoxSize);
        dessertCheckBox.setMaximumSize(checkBoxSize);

        checkBoxPanel.add(beverageCheckBox);
        checkBoxPanel.add(burgerCheckBox);
        checkBoxPanel.add(dessertCheckBox);

        mainPanel.add(checkBoxPanel);
    }

    /**
     * The method to be called when the "Add beverage" button is pressed.
     * The method is overridden to check whether the beverage is diet
     *
     * @param b the new beverage
     */
    protected void addFoodItem(Beverage b) {
        AdvancedMealController advController = (AdvancedMealController) controller;
        advController.addFoodItem(b, beverageCheckBox.isSelected());
        beverageCheckBox.setSelected(false);
    }

    /**
     * The method to be called when the "Add burger" button is pressed
     * The method is overridden to check whether the burger is diet
     *
     * @param b the new burger
     */
    protected void addFoodItem(Burger b) {
        AdvancedMealController advController = (AdvancedMealController) controller;
        advController.addFoodItem(b, burgerCheckBox.isSelected());
        burgerCheckBox.setSelected(false);
    }

    /**
     * The method to be called when the "Add dessert" button is pressed
     * The method is overridden to check whether the dessert is diet
     *
     * @param d the new dessert
     */
    protected void addFoodItem(Dessert d) {
        AdvancedMealController advController = (AdvancedMealController) controller;
        advController.addFoodItem(d, dessertCheckBox.isSelected());
        dessertCheckBox.setSelected(false);
    }

    /**
     * The method to be called when the "Place order" button is pressed.
     * The method is overridden to reset the checkboxes
     *
     */
    @Override
    protected void reset() {
        beverageCheckBox.setSelected(false);
        burgerCheckBox.setSelected(false);
        dessertCheckBox.setSelected(false);

        super.reset();
    }


}
