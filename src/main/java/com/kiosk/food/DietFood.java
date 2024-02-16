package com.kiosk.food;
/**
 * A concrete implementation of a menu Item (in this case, a diet food).
 * A menu item is characterised by a price and an amount of calories.
 *
 * @see Food
 */
public class DietFood implements Food{
    public static final int DIET_FOOD_CALORIES = 20;

    private final String description;
    private final double price;

    /**
     * Basic construction of a DietFood
     *
     * @param description the description of the diet food
     */
    public DietFood(String description){
        this.description = description;
        this.price = (double)DIET_FOOD_CALORIES/100;
    }

    /**
     * Getter method for the Price
     *
     * @return the price of this food item
     */
    @Override
    public double getPrice() {
        return this.price;
    }

    /**
     * Getter method for the calories
     *
     * @return the calories of this food item
     */
    @Override
    public int getCalories() {
        return DIET_FOOD_CALORIES;
    }

    /**
     * a printout version of object of this class
     */
    @Override
    public String toString(){
        return this.description;
    }
}
