package com.pluralsight.deli.models;

public class Cheese extends Topping {

    public Cheese(String name, boolean extra) {
        super(name, extra);
    }

    @Override
    public double getPrice(String sandwichSize) {
        double basePrice = 0.00;
        double extraPrice = 0.00;

        if (sandwichSize.equals("4\"")) {
            basePrice = 0.75;
            extraPrice = 0.30;
        } else if (sandwichSize.equals("8\"")) {
            basePrice = 1.50;
            extraPrice = 0.60;
        } else if (sandwichSize.equals("12\"")) {
            basePrice = 2.25;
            extraPrice = 0.90;
        }

        if (isExtra()) {
            return basePrice + extraPrice;
        } else {
            return basePrice;
        }
    }
}