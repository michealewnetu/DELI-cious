package com.pluralsight.deli.models;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Sandwich> sandwiches;
    private List<Drink> drinks;
    private List<Chips> chips;

    public Order() {
        this.sandwiches = new ArrayList<>();
        this.drinks = new ArrayList<>();
        this.chips = new ArrayList<>();
    }

    public void addSandwich(Sandwich sandwich) {
        sandwiches.add(sandwich);
    }

    public void addDrink(Drink drink) {
        drinks.add(drink);
    }

    public void addChips(Chips chips) {
        this.chips.add(chips);
    }

    public List<Sandwich> getSandwiches() {
        return sandwiches;
    }

    public List<Drink> getDrinks() {
        return drinks;
    }

    public List<Chips> getChips() {
        return chips;
    }

    public double calculateTotal() {
        double total = 0.00;

        for (Sandwich sandwich : sandwiches) {
            total += sandwich.getPrice();
        }

        for (Drink drink : drinks) {
            total += drink.getPrice();
        }

        for (Chips chip : chips) {
            total += chip.getPrice();
        }

        return total;
    }

    @Override
    public String toString() {
        String result = "==================================================\n";
        result += "ORDER SUMMARY\n";
        result += "==================================================\n\n";

        if (!sandwiches.isEmpty()) {
            result += "SANDWICHES:\n";
            for (int i = 0; i < sandwiches.size(); i++) {
                result += (i + 1) + ". " + sandwiches.get(i).toString() + "\n\n";
            }
        }

        if (!drinks.isEmpty()) {
            result += "DRINKS:\n";
            for (Drink drink : drinks) {
                result += "  - " + drink.toString() + "\n";
            }
            result += "\n";
        }

        if (!chips.isEmpty()) {
            result += "CHIPS:\n";
            for (Chips chip : chips) {
                result += "  - " + chip.toString() + "\n";
            }
            result += "\n";
        }

        result += "==================================================\n";
        result += String.format("TOTAL: $%.2f\n", calculateTotal());
        result += "==================================================";

        return result;
    }
}