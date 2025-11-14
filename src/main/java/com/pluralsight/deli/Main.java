package com.pluralsight.deli;

import com.pluralsight.deli.ui.HomeScreen;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HomeScreen homeScreen = new HomeScreen(scanner);
        homeScreen.display();
        scanner.close();
    }
}