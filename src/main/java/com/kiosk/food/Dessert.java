package com.kiosk.food;

/**
 * A concrete implementation of a menu Item (in this case, a dessert).
 * A menu item is characterised by a price and an amount of calories.
 *
 * @see Food
 */

public class Dessert implements Food{
    public static final int DESSERT_CALORIES = 200;

    private final String description;
    private final double price;

    /**
     * Basic constructor for a dessert.
     *
     * @param description the description of the dessert (e.g. "Cake" or "Brownie")
     */
    public Dessert(String description) {
        this.description = description;
        this.price = (double)DESSERT_CALORIES/100;
    }

    /**
     * Getter method for the price
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
        return DESSERT_CALORIES;
    }

    /**
     * a printout version of object of this class
     */
    @Override
    public String toString() {
        return this.description;
    }
}
