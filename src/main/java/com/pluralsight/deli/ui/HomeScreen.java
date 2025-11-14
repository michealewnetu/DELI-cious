package com.pluralsight.deli.ui;

import java.util.Scanner;
import com.pluralsight.deli.ui.OrderScreen;

public class HomeScreen {
    private Scanner scanner;

    public HomeScreen(Scanner scanner) {
        this.scanner = scanner;
    }

    public void display() {
        while (true) {
            System.out.println("\n" + "=".repeat(50));
            System.out.println("Welcome to DELI-cious Sandwich Shop!");
            System.out.println("=".repeat(50));
            System.out.println("1) New Order");
            System.out.println("0) Exit");
            System.out.println("=".repeat(50));
            System.out.print("Please select an option: ");

            String input = scanner.nextLine().trim();

            if (input.equals("1")) {
                startNewOrder();
            } else if (input.equals("0")) {
                System.out.println("\nThank you for visiting DELI-cious!");
                break;
            } else {
                System.out.println("\nInvalid option. Please try again.");
            }
        }
    }

    private void startNewOrder() {
        OrderScreen orderScreen = new OrderScreen(scanner);
        orderScreen.display();
    }
}