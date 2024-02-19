package com.kiosk;

import com.kiosk.gui.KioskGui;

import javax.swing.*;

public class FastFoodDemo {

    public static void main(String[] args){
        Meal model = new Meal();
        MealController controller= new AdvancedMealController(model);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new KioskGui(model, controller).setVisible(true);
            }
        });
    }
}
