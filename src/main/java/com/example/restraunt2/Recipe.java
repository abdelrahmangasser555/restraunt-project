package com.example.restraunt2;

public class Recipe {
    private int id;  // Unique identifier for the recipe
    private float price;  // Price of the recipe
    private String name;  // Name of the recipe

    // Default constructor
    public Recipe() {
        this.id = 0;
        this.price = 0.0f;
        this.name = "";
    }

    // Constructor with parameters to initialize the Recipe object
    public Recipe(int id, float price, String name) {
        this.id = id;
        this.price = price;
        this.name = name;
    }

    // Getter for id
    public int getId() {
        return id;
    }

    // Setter for id
    public void setId(int id) {
        this.id = id;
    }

    // Getter for price
    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void updatePrice(float newPrice) {
        this.price = newPrice;
    }

    @Override
    public String toString() {
        return "Recipe{id=" + id + ", price=" + price + ", name='" + name + "'}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Recipe recipe = (Recipe) obj;
        return id == recipe.id && Float.compare(recipe.price, price) == 0 && name.equals(recipe.name);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + Float.floatToIntBits(price);
        result = 31 * result + name.hashCode();
        return result;
    }
}
