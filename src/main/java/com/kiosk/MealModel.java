package com.kiosk;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

/**
 * An abstract class representing the model in MVC design
 * The model is the holder of the relevant data, in this case
 * a list of food items.
 * It contains a PropertyChangeSupport element,which represents
 * the "observable" part of the model,
 * Defines constants to identify the events that will be
 * triggered by a change in the model
 */
public abstract class MealModel {
    public static final String CAL_COUNT_PROPERTY = "CaloriesCountChange";
    public static final String ITEM_COUNT_PROPERTY = "ItemCountChange";
    public static final String ITEM_LIST_PROPERTY = "ItemAdded";
    public static final String CHECKOUT_PROPERTY = "MealCheckout";
    private final PropertyChangeSupport observableSupport;

    public MealModel(){
        observableSupport = new PropertyChangeSupport(this);
    }

    /**
     * Method to add an observer to this model
     *
     * @param pcl the observer object (a PropertyChangeListener)
     */
    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        observableSupport.addPropertyChangeListener(pcl);
    }

    /**
     * Method to remove an observer from this model
     *
     * @param pcl the observer object (a PropertyChangeListener)
     */
    public void removePropertyChangeListener(PropertyChangeListener pcl) {
        observableSupport.removePropertyChangeListener(pcl);
    }

    /**
     * The method to trigger notifications to all registered observers.
     * It will send an event of our specific type (MealChangeEvent)
     *
     * @param event the MealChangeEvent containing the description and value of the
     *              property that's changed
     */
    protected void notifyChange(MealChangeEvent event) {

        observableSupport.firePropertyChange(event);
    }
}
