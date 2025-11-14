package com.pluralsight.deli.models;

public class RegularTopping extends Topping {

    public RegularTopping(String name) {
        super(name, false);
    }

    @Override
    public double getPrice(String sandwichSize) {
        return 0.00;
    }
}