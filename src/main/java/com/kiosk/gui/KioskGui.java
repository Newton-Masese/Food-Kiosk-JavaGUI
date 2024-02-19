package com.kiosk.gui;

import com.kiosk.AdvancedMealController;
import com.kiosk.MealController;
import com.kiosk.MealModel;

import javax.swing.*;
import java.awt.*;

public class KioskGui extends JFrame {

    /**
     * The constructor needs to get a model and as controller to build the
     * appropriate GUIs for them.
     *
     * @param model the model
     * @param controller the controller
     */
    public KioskGui(MealModel model, MealController controller) {
        super("Fast Food Kiosk");

        JPanel controllerPanel = controller instanceof AdvancedMealController
                ? new AdvancedControllerGUI((AdvancedMealController) controller)
                : new BasicControllerGui(controller);

        controllerPanel.setBorder(BorderFactory.createTitledBorder("Controller"));

        JPanel viewPanel = new JPanel();
        viewPanel.setLayout(new BorderLayout());

        JPanel caloriesPanel = new JPanel();
        caloriesPanel.setLayout(new BoxLayout(caloriesPanel, BoxLayout.Y_AXIS));
        caloriesPanel.setBorder(BorderFactory.createTitledBorder("Calories View"));
        viewPanel.add(caloriesPanel, BorderLayout.CENTER);

        caloriesPanel.add(createLeftAlignedLabel("Calories intake:"));

        ///////////////////////
        // CALORIES BAR VIEW //
        ///////////////////////
        JPanel calBarPanel = new JPanel();
        calBarPanel.setAlignmentX(LEFT_ALIGNMENT);
        calBarPanel.setLayout(new BoxLayout(calBarPanel, BoxLayout.X_AXIS));
        calBarPanel.add(new JLabel("Daily %: "));
        CaloriesBarView caloriesBar = new CaloriesBarView(1000);
        model.addPropertyChangeListener(caloriesBar);
        calBarPanel.add(caloriesBar);

        caloriesPanel.add(calBarPanel);

        ////////////////////////
        // CALORIES TEXT VIEW //
        ////////////////////////
        JPanel calTextPanel = new JPanel();
        calTextPanel.setAlignmentX(LEFT_ALIGNMENT);
        calTextPanel.setLayout(new BoxLayout(calTextPanel, BoxLayout.X_AXIS));
        calTextPanel.add(new JLabel("Total cal: "));
        CaloriesTextView caloriesText = new CaloriesTextView();
        // TODO: uncomment the following line to add the CaloriesTextView as a listener to the model
        // model.addPropertyChangeListener(caloriesText);
        calTextPanel.add(caloriesText);

        caloriesPanel.add(calTextPanel);

        /////////////////////
        // MEAL ITEMS VIEW //
        /////////////////////
        MealItemsView mealItems = new MealItemsView();
        model.addPropertyChangeListener(mealItems);

        ///////////////////
        // CHECKOUT VIEW //
        ///////////////////
        JPanel checkoutPanel = new JPanel();
        checkoutPanel.setBackground(new Color(0, 153, 0));
        checkoutPanel.setLayout(new BoxLayout(checkoutPanel, BoxLayout.X_AXIS));

        checkoutPanel.setAlignmentX(LEFT_ALIGNMENT);
        checkoutPanel.setBorder(BorderFactory.createTitledBorder("Checkout View"));
        checkoutPanel.setMinimumSize(new Dimension(80, 150));
        //checkoutPanel.add(new JLabel("Price:"));
        checkoutPanel.add(createLeftAlignedLabel("<html><b>Please pay:</b></html>"));
        MealPriceView priceView = new MealPriceView();
        priceView.setMinimumSize(new Dimension(80, 200));
        model.addPropertyChangeListener(priceView);
        checkoutPanel.add(priceView);

        viewPanel.add(checkoutPanel, BorderLayout.SOUTH);

        this.setLayout(new BorderLayout());
        this.add(controllerPanel, BorderLayout.WEST);
        this.add(mealItems, BorderLayout.CENTER);
        this.add(viewPanel, BorderLayout.EAST);

        // Set frame properties
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setResizable(false);
        this.setLocationRelativeTo(null);
    }

    /**
     * Creates a left-aligned label with the given text.
     * @param text the text to be displayed
     * @return a left-aligned label
     */
    private static JLabel createLeftAlignedLabel(String text) {
        JLabel label = new JLabel(text);
        label.setAlignmentX(LEFT_ALIGNMENT);
        return label;
    }
}
