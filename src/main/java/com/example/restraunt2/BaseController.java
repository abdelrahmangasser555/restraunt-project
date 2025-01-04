package com.example.restraunt2;
import javafx.scene.control.Label;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import java.io.IOException;

public class BaseController {

    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }

    @FXML
    private void switchToSecondScene() throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BaseLayout.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());

        // Get the current stage and set the new scene
        Stage stage = (Stage) scene.getWindow();
        stage.setScene(scene);
    }

    @FXML
    protected void onGoodbyeButtonClick() {
       // make a print
        System.out.println("Goodbye!");
    }
}
