package com.pluralsight.deli.models;

import java.util.ArrayList;
import java.util.List;

public class Sandwich {
    private String size;
    private String breadType;
    private List<Topping> toppings;
    private boolean toasted;

    public Sandwich(String size, String breadType) {
        this.size = size;
        this.breadType = breadType;
        this.toppings = new ArrayList<>();
        this.toasted = false;
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public void setToasted(boolean toasted) {
        this.toasted = toasted;
    }

    public String getSize() {
        return size;
    }

    public String getBreadType() {
        return breadType;
    }

    public List<Topping> getToppings() {
        return toppings;
    }

    public boolean isToasted() {
        return toasted;
    }

    public double getPrice() {
        double price = 0.00;

        if (size.equals("4\"")) {
            price = 5.50;
        } else if (size.equals("8\"")) {
            price = 7.00;
        } else if (size.equals("12\"")) {
            price = 8.50;
        }

        for (Topping topping : toppings) {
            price += topping.getPrice(size);
        }

        return price;
    }

    @Override
    public String toString() {
        String result = size + " " + breadType + " Sandwich";
        if (toasted) {
            result += " (Toasted)";
        }
        result += "\n";

        for (Topping topping : toppings) {
            result += "  - " + topping.toString() + "\n";
        }

        result += String.format("  Price: $%.2f", getPrice());
        return result;
    }
}