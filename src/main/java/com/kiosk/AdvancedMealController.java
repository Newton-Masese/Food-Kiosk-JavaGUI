package com.kiosk;

import com.kiosk.food.DietFood;
import com.kiosk.food.Food;

/**
 * A specialised controller that is aware of diet food
 */
public class AdvancedMealController extends MealController{
    /**
     * The constructor needs to get a model as its parameter as
     * it will need to trigger changes on it.
     *
     * @param m the model
     */
    public AdvancedMealController(Meal m) {
        super(m);
    }

    /**
     * Method to add a food item to the model.
     * This is overridden to default to the case when
     * the food is not diet (attribute set to false)
     *
     * @param f the new food item
     */
    @Override
    public void addFoodItem(Food f) {
        this.addFoodItem(f, false);
    }

    /**
     * Specialised method to add a food item to the model,
     * which accounts for the fact that the food item might be a diet one.
     *
     * @param f the new food item
     * @param isDiet true if the food is assumed to be diet
     */
    public void addFoodItem(Food f, boolean isDiet) {
        if (isDiet) {
            super.addFoodItem(new DietFood(f));
        } else {
            super.addFoodItem(f);
        }
    }
}
