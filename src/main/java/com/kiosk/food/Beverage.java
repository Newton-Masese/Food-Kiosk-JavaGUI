package com.kiosk.food;

/**
 * A concrete implementation of a menu Item (in this case, a beverage).
 * A menu item is characterised by a price and an amount of calories.
 *
 * @see Food
 */
public class Beverage implements Food{
    public static final int BEVERAGE_CALORIES = 140;

    private final String description;
    private final double price;

    /**
     * Basic construction of a beverage
     *
     * @param description the description of the beverage (e.g. "coke" or "Fanta")
     */
    public Beverage(String description){
        this.description = description;
        this.price = (double)BEVERAGE_CALORIES/100;
    }

    /**
     * Getter method of the price
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
        return BEVERAGE_CALORIES;
    }

    /**
     * a printout version of object of this class
     */
    @Override
    public String toString(){
        return this.description;
    }
}
