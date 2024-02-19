package com.kiosk.gui;

import com.kiosk.MealController;
import com.kiosk.food.Beverage;
import com.kiosk.food.Burger;
import com.kiosk.food.Dessert;

import javax.swing.*;
import java.awt.*;

public class BasicControllerGui extends JPanel {

    protected final MealController controller;
    protected JPanel mainPanel;
    /**
     * Creates a GUI for a controller element
     *
     * @param controller the controller
     */
    public BasicControllerGui(MealController controller){
        this.controller = controller;

        this.setLayout(new BorderLayout());

        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));

        JButton addBeverageButton = new JButton("Add Beverage");
        addBeverageButton.addActionListener( e -> {
            Beverage b = new Beverage("Coke");
            this.addFoodItem(b);
        });
        JButton addBurgerButton = new JButton("Add Burger");
        addBurgerButton.addActionListener(e -> {
            Burger b = new Burger("Hamburger");
            this.addFoodItem(b);
        });

        JButton addDessertButton = new JButton("Add Dessert");
        addDessertButton.addActionListener(e -> {
            Dessert d = new Dessert("Sundae");
            this.addFoodItem(d);
        });

        Dimension buttonSize = new Dimension(150, 30);
        addBeverageButton.setMaximumSize(buttonSize);
        addBurgerButton.setMaximumSize(buttonSize);
        addDessertButton.setMaximumSize(buttonSize);

        buttonPanel.add(addBeverageButton);
        buttonPanel.add(addBurgerButton);
        buttonPanel.add(addDessertButton);

        mainPanel.add(buttonPanel);
        this.add(mainPanel, BorderLayout.CENTER);

        JButton placeOrderButton = new JButton("Place order");
        placeOrderButton.addActionListener(e -> {
            this.reset();
        });

        this.add(placeOrderButton, BorderLayout.SOUTH);
    }
    /**
     * The method to be called when the "Add beverage" button is pressed
     *
     * @param b the new beverage
     */
    protected void addFoodItem(Beverage b) {
        controller.addFoodItem(b);
    }

    /**
     * The method to be called when the "Add burger" button is pressed
     *
     * @param b the new burger
     */
    protected void addFoodItem(Burger b) {
        controller.addFoodItem(b);
    }

    /**
     * The method to be called when the "Add dessert" button is pressed
     *
     * @param d the new dessert
     */
    protected void addFoodItem(Dessert d) {
        controller.addFoodItem(d);
    }

    /**
     * The method to be called when the "Place order" button is pressed
     */
    protected void reset() {
        controller.reset();
    }


}
