package com.pluralsight.deli.services;

import com.pluralsight.deli.models.Order;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ReceiptFileManager {

    public static void saveReceipt(Order order) {
        // Generate filename with current date/time
        String filename = generateFilename();
        String filepath = "receipts/" + filename;

        try {
            // Create FileWriter to write to file
            FileWriter writer = new FileWriter(filepath);

            // Write the order to the file
            writer.write(order.toString());

            // Close the file
            writer.close();

            System.out.println("\n✓ Receipt saved: " + filename);

        } catch (IOException e) {
            System.out.println("\n❌ Error saving receipt: " + e.getMessage());
        }
    }

    private static String generateFilename() {
        // Get current date and time
        LocalDateTime now = LocalDateTime.now();

        // Format as yyyyMMdd-HHmmss
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        String timestamp = now.format(formatter);

        // Add .txt extension
        return timestamp + ".txt";
    }
}