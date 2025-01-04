package com.example.restraunt2;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

import java.io.IOException;

public class HomeCustomer extends Application {
    private Stage stage;  // Store the stage object here

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;  // Initialize the stage field
        FXMLLoader fxmlLoader = new FXMLLoader(HomeCustomer.class.getResource("home-customer.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 720, 440);
        stage.setTitle("Customer Home");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void reserveTable() {
        System.out.println("Reserve Table");
    }

    @FXML
    void viewMenu() {
        System.out.println("View Menu");

    }
}
