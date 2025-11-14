# DELI-cious Sandwich Shop

## Project Description

DELI-cious is a point-of-sale application for a custom sandwich shop. This console-based application allows customers to build fully customized sandwich orders with various options for size, bread, meats, cheeses, toppings, and more. The application manages orders and automatically generates receipts saved to timestamped files.

This project was built as part of the Pluralsight Java Development Bootcamp to demonstrate Object-Oriented Programming principles including inheritance, polymorphism, and encapsulation.

## Features

- **Custom Sandwich Builder**: Choose size (4", 8", 12"), bread type, meats, cheeses, and toppings
- **Premium Toppings**: Size-based pricing for meats and cheeses with extra portion options
- **Free Toppings**: Unlimited regular toppings and sauces at no extra cost
- **Drinks & Chips**: Add beverages in three sizes and various chip flavors
- **Order Management**: View order summary with real-time price calculations
- **Receipt Generation**: Automatically saves receipts with timestamp filenames
- **User-Friendly Interface**: Clear menu-driven navigation system

## Application Screenshots

### Home Screen
![Home Screen](screenshots/home-screen.png)
*Main menu where users start a new order or exit the application*

### Order Screen
![Order Screen](screenshots/order-screen.png)
*Order management screen showing current order with options to add items or checkout*

### Sandwich Builder
![Sandwich Builder](screenshots/sandwich-builder.png)
*Interactive sandwich customization with step-by-step prompts*

### Checkout
![Checkout Screen](screenshots/checkout-screen.png)
*Final order summary with total price and confirmation*

## Class Structure

### Model Classes
- **Order**: Container for the complete order (sandwiches, drinks, chips)
- **Sandwich**: Customizable sandwich with size, bread, toppings, and toast option
- **Topping** (Abstract): Base class for all topping types
    - **Meat**: Premium topping with size-based pricing
    - **Cheese**: Premium topping with different pricing than meat
    - **RegularTopping**: Free toppings (vegetables, sauces)
- **Drink**: Beverage with size-based pricing (Small, Medium, Large)
- **Chips**: Single-price snack item

### UI Classes
- **HomeScreen**: Application entry point with main menu
- **OrderScreen**: Order management and item selection
- **SandwichScreen**: Interactive sandwich building interface

### Service Classes
- **ReceiptFileManager**: Handles saving orders to timestamped text files

## Interesting Code Highlight

One interesting aspect of this project is the use of polymorphism in the topping pricing system. The abstract `Topping` class defines a contract that all toppings must follow, but each type implements its own pricing logic:
```java
public abstract class Topping {
    private String name;
    private boolean extra;
    
    // Abstract method - each subclass implements differently
    public abstract double getPrice(String sandwichSize);
}

public class Meat extends Topping {
    @Override
    public double getPrice(String sandwichSize) {
        // Size-based pricing for meat
        // 4" = $1.00, 8" = $2.00, 12" = $3.00
        // Extra portions add 50% more
    }
}

public class RegularTopping extends Topping {
    @Override
    public double getPrice(String sandwichSize) {
        return 0.00;  // Always free!
    }
}
```

This design allows the `Sandwich` class to calculate its total price without knowing the specific type of each topping - it just calls `getPrice()` on each topping and they handle their own pricing logic. This is a clean example of the **Open/Closed Principle**: the Sandwich class is open for extension (we can add new topping types) but closed for modification (we don't need to change Sandwich when adding new toppings).

## Setup Instructions

### Prerequisites
- Java 17 or higher
- Maven 3.6 or higher

### Running the Application

1. Clone this repository:
```bash
   git clone https://github.com/YOUR-USERNAME/DELI-cious.git
   cd DELI-cious
```

2. Compile the project:
```bash
   mvn clean compile
```

3. Run the application:
```bash
   mvn exec:java
```

4. Follow the on-screen prompts to create orders!

5. Receipts are saved in the `receipts/` folder with format: `yyyyMMdd-HHmmss.txt`

## Technologies Used

- **Java 17**: Core programming language
- **Maven**: Build automation and dependency management
- **Object-Oriented Design**: Inheritance, polymorphism, encapsulation
- **File I/O**: Receipt generation and storage

## Future Enhancements

- Add signature sandwiches with preset configurations
- Implement order history and search functionality
- Add tax calculation
- Create a GUI interface
- Add database persistence for orders
- Implement user accounts for frequent customers

## Author

**Micheal Ewnetu**  
Pluralsight Java Development Bootcamp - Fall 2025

## Acknowledgments

- Pluralsight instructors for project requirements and guidance
- Java documentation and community resources