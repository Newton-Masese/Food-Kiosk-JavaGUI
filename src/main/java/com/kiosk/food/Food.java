package com.kiosk.food;

/**
 * Interface defining a generic menu Item,
 * characterised by containing an amount of calories
 * and by price
 */
public interface Food {
    /**
     * Getter method for the Price
     *
     * @return the price of this food item
     */
    public double getPrice();

    /**
     * Getter method for the calories
     *
     * @return the calories of this food item
     */
    public int getCalories();
}
