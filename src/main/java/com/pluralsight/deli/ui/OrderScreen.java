package com.pluralsight.deli.ui;

import com.pluralsight.deli.models.*;
import java.util.Scanner;
import com.pluralsight.deli.services.ReceiptFileManager;

public class OrderScreen {
    private Scanner scanner;
    private Order order;

    public OrderScreen(Scanner scanner) {
        this.scanner = scanner;
        this.order = new Order();
    }

    public void display() {
        boolean ordering = true;

        while (ordering) {
            System.out.println("\n" + "=".repeat(50));
            System.out.println("CURRENT ORDER");
            System.out.println("=".repeat(50));

            if (order.getSandwiches().isEmpty() && order.getDrinks().isEmpty() && order.getChips().isEmpty()) {
                System.out.println("(Order is empty)");
            } else {
                System.out.println(order);
            }

            System.out.println("\n" + "=".repeat(50));
            System.out.println("1) Add Sandwich");
            System.out.println("2) Add Drink");
            System.out.println("3) Add Chips");
            System.out.println("4) Checkout");
            System.out.println("0) Cancel Order");
            System.out.println("=".repeat(50));
            System.out.print("Please select an option: ");

            String input = scanner.nextLine().trim();

            if (input.equals("1")) {
                addSandwich();
            } else if (input.equals("2")) {
                addDrink();
            } else if (input.equals("3")) {
                addChips();
            } else if (input.equals("4")) {
                checkout();
                ordering = false;
            } else if (input.equals("0")) {
                System.out.println("\nOrder cancelled.");
                ordering = false;
            } else {
                System.out.println("\nInvalid option. Please try again.");
            }
        }
    }

    private void addSandwich() {
        SandwichScreen sandwichScreen = new SandwichScreen(scanner);
        Sandwich sandwich = sandwichScreen.buildSandwich();

        if (sandwich != null) {
            order.addSandwich(sandwich);
        }
    }

    private void addDrink() {
        System.out.println("\n=== ADD DRINK ===");
        System.out.println("Select size:");
        System.out.println("1) Small");
        System.out.println("2) Medium");
        System.out.println("3) Large");
        System.out.print("Choose: ");

        String sizeChoice = scanner.nextLine().trim();
        String size = "";

        if (sizeChoice.equals("1")) {
            size = "Small";
        } else if (sizeChoice.equals("2")) {
            size = "Medium";
        } else if (sizeChoice.equals("3")) {
            size = "Large";
        } else {
            System.out.println("Invalid choice.");
            return;
        }

        System.out.print("Enter flavor (Coke, Sprite, Lemonade, etc.): ");
        String flavor = scanner.nextLine().trim();

        Drink drink = new Drink(size, flavor);
        order.addDrink(drink);
        System.out.println("\n✓ Added: " + drink);
    }

    private void addChips() {
        System.out.println("\n=== ADD CHIPS ===");
        System.out.print("Enter chip type (BBQ, Plain, Sour Cream & Onion, etc.): ");
        String type = scanner.nextLine().trim();

        Chips chips = new Chips(type);
        order.addChips(chips);
        System.out.println("\n✓ Added: " + chips);
    }

    private void checkout() {
        if (order.getSandwiches().isEmpty() && order.getDrinks().isEmpty() && order.getChips().isEmpty()) {
            System.out.println("\nYour order is empty! Please add items before checkout.");
            return;
        }

        System.out.println("\n" + "=".repeat(50));
        System.out.println("CHECKOUT");
        System.out.println("=".repeat(50));
        System.out.println(order);
        System.out.println("\n1) Confirm Order");
        System.out.println("0) Go Back");
        System.out.print("Please select an option: ");

        String input = scanner.nextLine().trim();

        if (input.equals("1")) {
            System.out.println("\n✓ Order confirmed! Thank you!");
            ReceiptFileManager.saveReceipt(order);
        }
    }
}