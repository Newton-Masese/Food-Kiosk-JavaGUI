package com.kiosk;

import com.kiosk.food.Food;

import java.beans.PropertyChangeEvent;

/**
 * This class defines a specialised event for our hierarchy of Food.
 * The only purpose is to restrict the types of the arguments of the
 * constructor (PropertyChangeEvent accepts all primitive types and Object)
 *
 * @see PropertyChangeEvent
 */
public class MealChangeEvent extends PropertyChangeEvent {

    /**
     * Constructs an event based on two integers: can be used to notify
     * changes in properties involving counters.
     *
     * @param source       the model that triggered the event
     * @param propertyName the programmatic name of the property that was changed
     * @param oldValue     the old value of the counter
     * @param newValue     the new value of the counter
     */
    public MealChangeEvent(MealModel source, String propertyName, int oldValue, int newValue) {
        super(source, propertyName, oldValue, newValue);
    }

    /**
     * Constructs an event based on two doubles: can be used to notify
     * changes in properties representing specific values as double.
     *
     * @param source       the model that triggered the event
     * @param propertyName the programmatic name of the property that was changed
     * @param oldValue     the old value of the attribute
     * @param newValue     the new value of the attribute
     */
    public MealChangeEvent(MealModel source, String propertyName, double oldValue, double newValue) {
        super(source, propertyName, oldValue, newValue);
    }

    /**
     * Creates an event based on two Food objects: can be used to notify
     * changes related to the list of food items. At the moment, the only possible
     * event is the addition of a food item, so old value will be set to null and new value
     * will contain the value of the added Food object.
     *
     * @param source       the model that triggered the event
     * @param propertyName the programmatic name of the property that was changed
     * @param oldValue     set to null in case of the addition of a Food item
     * @param newValue     the newly added Food Item
     */
    public MealChangeEvent(MealModel source, String propertyName, Food oldValue, Food newValue) {
        super(source, propertyName, oldValue, newValue);
    }
}
