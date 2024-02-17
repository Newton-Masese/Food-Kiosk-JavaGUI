package com.kiosk;


import com.kiosk.food.Food;

public class MealController {
    private final Meal model;

    /**
     * The constructor needs to get a model as its parameter as
     * it will need to trigger changes on it.
     *
     * @param m the model
     */
    public MealController(Meal m) {
        this.model = m;
    }

    /**
     * Method to add a food item to the model.
     *
     * @param f the new food item
     */
    public void addFoodItem(Food f) {
        model.add(f);
    }

    /**
     * Resets the model by checking out all items.
     */
    public void reset() {
        model.checkOutItems();
    }
}

