module com.udemy.javafxdemoapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.udemy.javafxdemoapp to javafx.fxml;
    exports com.udemy.javafxdemoapp;
}