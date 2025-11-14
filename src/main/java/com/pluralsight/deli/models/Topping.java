package com.pluralsight.deli.models;

public abstract class Topping {
    private String name;
    private boolean extra;

    public Topping(String name, boolean extra) {
        this.name = name;
        this.extra = extra;
    }

    public String getName() {
        return name;
    }

    public boolean isExtra() {
        return extra;
    }

    public abstract double getPrice(String sandwichSize);

    @Override
    public String toString() {
        if (extra) {
            return name + " (Extra)";
        } else {
            return name;
        }
    }
}