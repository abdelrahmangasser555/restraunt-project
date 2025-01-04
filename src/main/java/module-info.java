module com.example.restraunt2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.restraunt2 to javafx.fxml;
    exports com.example.restraunt2;
}