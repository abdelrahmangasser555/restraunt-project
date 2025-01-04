package com.example.restraunt2;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerController {

    // Method to navigate to another page (reserve table)
    @FXML
    void reserveTable() {
        try {
            // Load the new FXML file (make sure the path is correct)
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("home-view.fxml"));

            // Create the new scene with the loaded FXML
            Scene scene = new Scene(fxmlLoader.load(), 320, 240);

            // Get the current stage (window) and change the scene
            Stage stage = (Stage) ((Label) fxmlLoader.getNamespace().get("label")).getScene().getWindow();
            stage.setTitle("Customer Home");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.out.println("Error loading FXML file");
            e.printStackTrace(); // Handle exceptions properly
        }
    }
}
