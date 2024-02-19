package com.kiosk;

import com.kiosk.food.Food;

import java.util.ArrayList;

public class Meal extends MealModel{

    private final ArrayList<Food> foodItems;

    private double price;
    private int calories;

    /**
     * Initialise the meal as an empty list
     *
     */
    public Meal(){
        foodItems = new ArrayList<>();
        this.price = 0;
        this.calories = 0;
    }

    /**
     * Returns the price as the sum of the price of the contained elements.
     *
     * @return the total price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns the calories as the sum of the calories of the contained elements.
     *
     * @return the total amount of calories
     */
    public int getCalories() {
        return calories;
    }

    /**
     * Returns the list of contained food items as an array
     * and empties the list of food items.
     * Calling this method will trigger a specific event
     * (labelled as checkout)
     *
     * @return the items added to this meal so far
     */
    public Food[] checkOutItems(){
        Food[] checkout = new Food[this.foodItems.size()];
        checkout = foodItems.toArray(checkout);

        double oldPrice = price;

        this.foodItems.clear();
        this.price = 0;
        this.calories = 0;

        super.notifyChange(new MealChangeEvent(this, MealModel.CHECKOUT_PROPERTY, oldPrice, price));

        return checkout;
    }
    /**
     * Adds a new food item to the list.
     * Note that this method will notify all the relevant changes to the
     * registered observers. When a new item is added, the count of items changes, the
     * count of calories changes and obviously the list of items changes as well.
     *
     * @param newItem the new food item to be added to the meal
     */
    public void add(Food newItem){
        int oldCount = this.foodItems.size();
        int oldCalories = calories;

        foodItems.add(newItem);
        price += newItem.getPrice();
        calories += newItem.getCalories();

        int newCount = this.foodItems.size();
        int newCalories = calories;

        super.notifyChange(new MealChangeEvent(this, MealModel.CAL_COUNT_PROPERTY, oldCalories, newCalories));
        super.notifyChange(new MealChangeEvent(this, MealModel.ITEM_COUNT_PROPERTY, oldCount, newCount));
        super.notifyChange(new MealChangeEvent(this, MealModel.ITEM_LIST_PROPERTY, null, newItem));
    }

}
