package com.kiosk.food;
/**
 * A concrete implementation of a menu Item (in this case, a diet food).
 * A menu item is characterised by a price and an amount of calories.
 *
 * @see Food
 */
public class DietFood implements Food{

    private final Food food;


    /**
     * Constructor for a diet food item.
     *
     * @param food the food item to be decorated
     */
    public DietFood(Food food){
        this.food = food;
    }

    /**
     * Getter method for the Price
     *
     * @return the price of this food item
     */
    @Override
    public double getPrice() {
        return this.food.getPrice();
    }

    /**
     * Getter method for the calories
     *
     * @return the calories of this food item
     */
    @Override
    public int getCalories() {
        return (int) (this.food.getCalories() * 0.8);
    }

    /**
     * a printout version of object of this class
     */
    @Override
    public String toString(){
        return "Diet" + this.food.toString();
    }
}
