package com.kiosk.gui;

import com.kiosk.AdvancedMealController;
import com.kiosk.MealController;
import com.kiosk.MealModel;

import javax.swing.*;

public class KioskGui extends JFrame {

    /**
     * Constructor needs to get a model and a controller to build GUIs for them.
     * @param model the model
     * @param controller the controller
     */
    public KioskGui(MealModel model, MealController controller){
        super("Fast Food Kiosk");


        // JFrame properties
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,400);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }
}
