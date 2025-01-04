package com.example.restraunt2;

public class Order {
    int orderId;
    Recipe recipe;
    float totalAmount;
    boolean status;
    boolean takeAway;


    // make 2 constructors
    public Order() {
        orderId = 0;
        recipe = new Recipe();
        totalAmount = 0;
        status = false;
        takeAway = false;
    }

    public Order(int orderId, Recipe recipe, float totalAmount, boolean status, boolean takeAway) {
        this.orderId = orderId;
        this.recipe = recipe;
        this.totalAmount = totalAmount;
        this.status = status;
        this.takeAway = takeAway;
    }
}
