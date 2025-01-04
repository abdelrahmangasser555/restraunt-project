package com.example.restraunt2;

import java.io.*;
import java.util.ArrayList;

public class Menu {

    public static ArrayList<Recipe> recipeList = new ArrayList<>();
    private static final String FILE_NAME = "recipes.txt";

    static {
        loadData();
    }

    // Load data from the file if it exists; else initialize with default data
    public static void loadData() {
        File file = new File(FILE_NAME);
        if (file.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = br.readLine()) != null) {
                    String[] parts = line.split(",");
                    int id = Integer.parseInt(parts[0].trim());
                    int price = Integer.parseInt(parts[1].trim());
                    String name = parts[2].trim();
                    recipeList.add(new Recipe(id, price, name));
                }
            } catch (IOException e) {
                System.out.println("Error reading the file: " + e.getMessage());
            }
        } else {
            // File doesn't exist, initialize with default data and create the file
            recipeList.add(new Recipe(1, 10, "Burger"));
            recipeList.add(new Recipe(2, 20, "Pizza"));
            recipeList.add(new Recipe(3, 30, "Pasta"));
            recipeList.add(new Recipe(4, 40, "Sandwich"));
            recipeList.add(new Recipe(5, 50, "Noodles"));
            saveData();
        }
    }

    // Add a recipe to the list and update the file
    public static void addRecipe(Recipe recipe) {
        recipeList.add(recipe);
        saveData();
    }

    // Remove a recipe from the list and update the file
    public static void removeRecipe(Recipe recipe) {
        recipeList.remove(recipe);
        saveData();
    }

    // Save the current recipe list to the file
    private static void saveData() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Recipe recipe : recipeList) {
                bw.write(recipe.getId() + "," + recipe.getPrice() + "," + recipe.getName());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error saving the file: " + e.getMessage());
        }
    }
}
