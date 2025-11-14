package com.pluralsight.deli.models;

public class Meat extends Topping {

    public Meat(String name, boolean extra) {
        super(name, extra);
    }

    @Override
    public double getPrice(String sandwichSize) {
        double basePrice = 0.00;
        double extraPrice = 0.00;

        if (sandwichSize.equals("4\"")) {
            basePrice = 1.00;
            extraPrice = 0.50;
        } else if (sandwichSize.equals("8\"")) {
            basePrice = 2.00;
            extraPrice = 1.00;
        } else if (sandwichSize.equals("12\"")) {
            basePrice = 3.00;
            extraPrice = 1.50;
        }

        if (isExtra()) {
            return basePrice + extraPrice;
        } else {
            return basePrice;
        }
    }
}