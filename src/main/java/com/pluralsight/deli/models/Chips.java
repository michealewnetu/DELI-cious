package com.pluralsight.deli.models;
public class Chips {
    private String type;
    private static final double PRICE = 1.50;

    public Chips(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public double getPrice(){
        return PRICE;
    }

    @Override
    public String toString(){
        return String.format("%s Chips - $%.2f" , type, PRICE);
    }
}
