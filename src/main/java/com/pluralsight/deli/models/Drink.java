package com.pluralsight.deli.models;

public class Drink {
    private String size;
    private String flavor;

    public Drink(String size, String flavor) {
        this.size = size;
        this.flavor = flavor;
    }

    public String getSize() {
        return size;
    }

    public String getFlavor() {
        return flavor;
    }

    public double getPrice() {
        switch (size) {
            case "Small":
                return 2.00;
            case "Medium":
                return 2.50;
            case "Large":
                return 3.00;
            default:
                return 0.00;
        }
    }

    @Override
    public String toString() {
        return String.format("%s %s - $%.2f" , size, flavor, getPrice());
    }
}