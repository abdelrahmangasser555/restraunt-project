package com.example.restraunt2;



import java.io.*;
import java.util.*;

public class Tables {
    int tableNumber;
    int capacity;
    boolean isAvailable;

    // Default constructor
    public Tables() {
        this.tableNumber = 0;
        this.capacity = 0;
        this.isAvailable = false;
    }

    // Constructor that reads from a file and sets availability
    public Tables(int tableNumber, int capacity) {
        this.tableNumber = tableNumber;
        this.capacity = capacity;
        this.isAvailable = readAvailabilityFromFile(tableNumber);
    }

    // Method to read the availability from the file based on the table number
    private boolean readAvailabilityFromFile(int tableNumber) {
        File file = new File("tablesAvailability.txt");  // Assuming the file is in the project directory
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Split the line by comma, tableNumber and availability
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    int fileTableNumber = Integer.parseInt(parts[0].trim());
                    boolean available = Boolean.parseBoolean(parts[1].trim());

                    // Check if this line corresponds to the tableNumber
                    if (fileTableNumber == tableNumber) {
                        return available;  // Return the availability
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        return false;  // Default to false if not found or error occurred
    }

    // Getter and setter for tableNumber
    public int getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(int tableNumber) {
        this.tableNumber = tableNumber;
    }

    // Getter and setter for capacity
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // Getter and setter for isAvailable
    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;

        // Update the availability in the file
        updateAvailabilityInFile();
    }

    // Method to change the availability status in the file
    public void updateAvailabilityInFile() {
        File file = new File("tablesAvailability.txt");
        List<String> lines = new ArrayList<>();

        // Read the current file and store all lines
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }

        // Update the specific table's availability in the list
        boolean found = false;
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] parts = line.split(",");
            if (parts.length == 2) {
                int fileTableNumber = Integer.parseInt(parts[0].trim());

                // If this is the correct table, update its availability
                if (fileTableNumber == this.tableNumber) {
                    lines.set(i, tableNumber + ", " + isAvailable);  // Modify the line with new status
                    found = true;
                    break;
                }
            }
        }

        // If the table was not found, add a new entry for it
        if (!found) {
            lines.add(tableNumber + ", " + isAvailable);
        }

        // Write the updated lines back to the file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error writing to the file: " + e.getMessage());
        }
    }
}
