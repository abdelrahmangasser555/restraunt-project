package com.example.restraunt2;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
public class ReserveTable extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BaseLayout.class.getResource("reserve-table.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 620, 240);
        stage.setTitle("Table reservation page");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
