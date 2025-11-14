package com.pluralsight.deli.ui;

import com.pluralsight.deli.models.*;
import java.util.Scanner;

public class SandwichScreen {
    private Scanner scanner;

    public SandwichScreen(Scanner scanner) {
        this.scanner = scanner;
    }

    public Sandwich buildSandwich() {
        System.out.println("\n" + "=".repeat(50));
        System.out.println("BUILD YOUR SANDWICH");
        System.out.println("=".repeat(50));

        // Step 1: Choose size
        String size = chooseSize();
        if (size == null) return null;

        // Step 2: Choose bread
        String bread = chooseBread();
        if (bread == null) return null;

        // Create the sandwich
        Sandwich sandwich = new Sandwich(size, bread);

        // Step 3: Add meats
        addMeats(sandwich, size);

        // Step 4: Add cheese
        addCheese(sandwich, size);

        // Step 5: Add regular toppings
        addRegularToppings(sandwich);

        // Step 6: Add sauces
        addSauces(sandwich);

        // Step 7: Toast option
        addToastOption(sandwich);

        System.out.println("\n✓ Sandwich created!");
        System.out.println(sandwich);

        return sandwich;
    }

    private String chooseSize() {
        System.out.println("\nSelect sandwich size:");
        System.out.println("1) 4\" - $5.50");
        System.out.println("2) 8\" - $7.00");
        System.out.println("3) 12\" - $8.50");
        System.out.println("0) Cancel");
        System.out.print("Choose: ");

        String choice = scanner.nextLine().trim();

        if (choice.equals("1")) return "4\"";
        if (choice.equals("2")) return "8\"";
        if (choice.equals("3")) return "12\"";
        if (choice.equals("0")) return null;

        System.out.println("Invalid choice.");
        return chooseSize();
    }

    private String chooseBread() {
        System.out.println("\nSelect bread type:");
        System.out.println("1) White");
        System.out.println("2) Wheat");
        System.out.println("3) Rye");
        System.out.println("4) Wrap");
        System.out.println("0) Cancel");
        System.out.print("Choose: ");

        String choice = scanner.nextLine().trim();

        if (choice.equals("1")) return "White";
        if (choice.equals("2")) return "Wheat";
        if (choice.equals("3")) return "Rye";
        if (choice.equals("4")) return "Wrap";
        if (choice.equals("0")) return null;

        System.out.println("Invalid choice.");
        return chooseBread();
    }

    private void addMeats(Sandwich sandwich, String size) {
        System.out.println("\nAdd meat? (yes/no): ");
        String response = scanner.nextLine().trim().toLowerCase();

        if (!response.equals("yes") && !response.equals("y")) {
            return;
        }

        System.out.println("\nSelect meat:");
        System.out.println("1) Steak");
        System.out.println("2) Ham");
        System.out.println("3) Salami");
        System.out.println("4) Roast Beef");
        System.out.println("5) Chicken");
        System.out.println("6) Bacon");
        System.out.println("7) Turkey");
        System.out.print("Choose: ");

        String choice = scanner.nextLine().trim();
        String meatName = "";

        if (choice.equals("1")) meatName = "Steak";
        else if (choice.equals("2")) meatName = "Ham";
        else if (choice.equals("3")) meatName = "Salami";
        else if (choice.equals("4")) meatName = "Roast Beef";
        else if (choice.equals("5")) meatName = "Chicken";
        else if (choice.equals("6")) meatName = "Bacon";
        else if (choice.equals("7")) meatName = "Turkey";
        else {
            System.out.println("Invalid choice, skipping meat.");
            return;
        }

        System.out.print("Extra meat? (yes/no): ");
        String extraResponse = scanner.nextLine().trim().toLowerCase();
        boolean extra = extraResponse.equals("yes") || extraResponse.equals("y");

        sandwich.addTopping(new Meat(meatName, extra));
    }

    private void addCheese(Sandwich sandwich, String size) {
        System.out.println("\nAdd cheese? (yes/no): ");
        String response = scanner.nextLine().trim().toLowerCase();

        if (!response.equals("yes") && !response.equals("y")) {
            return;
        }

        System.out.println("\nSelect cheese:");
        System.out.println("1) American");
        System.out.println("2) Provolone");
        System.out.println("3) Cheddar");
        System.out.println("4) Swiss");
        System.out.print("Choose: ");

        String choice = scanner.nextLine().trim();
        String cheeseName = "";

        if (choice.equals("1")) cheeseName = "American";
        else if (choice.equals("2")) cheeseName = "Provolone";
        else if (choice.equals("3")) cheeseName = "Cheddar";
        else if (choice.equals("4")) cheeseName = "Swiss";
        else {
            System.out.println("Invalid choice, skipping cheese.");
            return;
        }

        System.out.print("Extra cheese? (yes/no): ");
        String extraResponse = scanner.nextLine().trim().toLowerCase();
        boolean extra = extraResponse.equals("yes") || extraResponse.equals("y");

        sandwich.addTopping(new Cheese(cheeseName, extra));
    }

    private void addRegularToppings(Sandwich sandwich) {
        System.out.println("\nAdd regular toppings? (yes/no): ");
        String response = scanner.nextLine().trim().toLowerCase();

        if (!response.equals("yes") && !response.equals("y")) {
            return;
        }

        String[] toppings = {"Lettuce", "Peppers", "Onions", "Tomatoes",
                "Jalapeños", "Cucumbers", "Pickles", "Guacamole", "Mushrooms"};

        System.out.println("\nAvailable toppings (FREE):");
        for (int i = 0; i < toppings.length; i++) {
            System.out.println((i + 1) + ") " + toppings[i]);
        }
        System.out.println("0) Done adding toppings");

        while (true) {
            System.out.print("Choose topping (or 0 to finish): ");
            String choice = scanner.nextLine().trim();

            if (choice.equals("0")) break;

            try {
                int index = Integer.parseInt(choice) - 1;
                if (index >= 0 && index < toppings.length) {
                    sandwich.addTopping(new RegularTopping(toppings[index]));
                    System.out.println("✓ Added " + toppings[index]);
                } else {
                    System.out.println("Invalid choice.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
            }
        }
    }

    private void addSauces(Sandwich sandwich) {
        System.out.println("\nAdd sauces? (yes/no): ");
        String response = scanner.nextLine().trim().toLowerCase();

        if (!response.equals("yes") && !response.equals("y")) {
            return;
        }

        String[] sauces = {"Mayo", "Mustard", "Ketchup", "Ranch", "Thousand Islands", "Vinaigrette"};

        System.out.println("\nAvailable sauces (FREE):");
        for (int i = 0; i < sauces.length; i++) {
            System.out.println((i + 1) + ") " + sauces[i]);
        }
        System.out.println("0) Done adding sauces");

        while (true) {
            System.out.print("Choose sauce (or 0 to finish): ");
            String choice = scanner.nextLine().trim();

            if (choice.equals("0")) break;

            try {
                int index = Integer.parseInt(choice) - 1;
                if (index >= 0 && index < sauces.length) {
                    sandwich.addTopping(new RegularTopping(sauces[index]));
                    System.out.println("✓ Added " + sauces[index]);
                } else {
                    System.out.println("Invalid choice.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
            }
        }
    }

    private void addToastOption(Sandwich sandwich) {
        System.out.print("\nWould you like it toasted? (yes/no): ");
        String response = scanner.nextLine().trim().toLowerCase();

        if (response.equals("yes") || response.equals("y")) {
            sandwich.setToasted(true);
            System.out.println("✓ Sandwich will be toasted");
        }
    }
}