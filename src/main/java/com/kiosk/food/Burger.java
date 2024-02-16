package com.kiosk.food;

/**
 * A concrete implementation of a menu Item (in this case, a burger).
 * A menu item is characterised by a price and an amount of calories.
 *
 * @see Food
 */
public class Burger implements Food{

    public static final int BURGER_CALORIES = 300;

    private final String description;
    private final double price;

    /**
     * Basic constructor for a burger.
     *
     * @param description the description of the burger (e.g. "Hamburger" or "Cheeseburger")
     */
    public Burger(String description) {
        this.description = description;
        this.price = (double)BURGER_CALORIES/100;
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
        return BURGER_CALORIES;
    }

    /**
     * a printout version of object of this class
     */
    @Override
    public String toString(){
        return this.description;
    }
}
