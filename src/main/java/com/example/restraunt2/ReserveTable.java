package com.example.restraunt2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import java.io.IOException;

public class ReserveTable extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Create table objects
        Tables table1 = new Tables(1, 4);
        Tables table2 = new Tables(2, 6);
        Tables table3 = new Tables(3, 2);
        Tables table4 = new Tables(4, 4);
        Tables table5 = new Tables(5, 6);
        Tables table6 = new Tables(6, 2);
        Tables table7 = new Tables(7, 4);
        Tables table8 = new Tables(8, 6);
        Tables table9 = new Tables(9, 2);
        Tables table10 = new Tables(10, 4);



        // Set up the UI layout
        VBox vbox = new VBox();
        vbox.setSpacing(15);  // More spacing between elements
        vbox.setStyle("-fx-background-color: #f0f0f0; -fx-padding: 20;");  // Background color and padding

        // Add a header text
        Text header = new Text("Choose a Table to Reserve");
        header.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-fill: #003c71;");
        vbox.getChildren().add(header);

        // Add tables to the layout with their details
        addTableToLayout(vbox, table1);
        addTableToLayout(vbox, table2);
        addTableToLayout(vbox, table3);
        addTableToLayout(vbox, table4);
        addTableToLayout(vbox, table5);
        addTableToLayout(vbox, table6);
        addTableToLayout(vbox, table7);
        addTableToLayout(vbox, table8);
        addTableToLayout(vbox, table9);
        addTableToLayout(vbox, table10);


        // add a text and keep it empty

        // Set up scene and stage
        Scene scene = new Scene(vbox, 620, 640);
        stage.setTitle("Table Reservation Page");
        stage.setScene(scene);
        stage.show();
    }

    // Method to add a table's details to the layout
    private void addTableToLayout(VBox vbox, Tables table) {
        // Create a button to display the table details
        Button tableButton = new Button("Table Number: " + table.getTableNumber() +
                " | Capacity: " + table.getCapacity());

        // Set the style based on availability
        updateButtonStyle(tableButton, table);

        // Add event handler for the button click
        tableButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                // When the button is clicked, toggle availability
                if (table.isAvailable()) {
                    table.setAvailable(false);  // Mark as reserved
                    updateButtonStyle(tableButton, table);  // Update button style

                    // Show a message confirming the reservation
                    System.out.println("You have reserved Table Number " + table.getTableNumber());
                } else {
                    System.out.println("This table is already reserved.");
                }
            }
        });

        vbox.getChildren().add(tableButton);
    }

    // Method to update the button's style based on availability
    private void updateButtonStyle(Button button, Tables table) {
        if (table.isAvailable()) {
            button.setStyle("-fx-background-color: green; -fx-text-fill: white;");
            button.setText("Table Number: " + table.getTableNumber() +
                    " | Capacity: " + table.getCapacity());
        } else {
            button.setStyle("-fx-background-color: red; -fx-text-fill: white;");
            button.setText("Table Number: " + table.getTableNumber() + " (Reserved)");
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
