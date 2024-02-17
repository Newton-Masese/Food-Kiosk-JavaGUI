package com.kiosk;

public class FastFoodDemo {

    public static void main(String[] args){
        Meal model = new Meal();
        MealController controller = new MealController(model);
    }
}
