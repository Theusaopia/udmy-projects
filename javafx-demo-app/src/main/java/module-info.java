module com.udemy.javafxdemoapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.udemy.javafxdemoapp to javafx.fxml;
    exports com.udemy.javafxdemoapp;

    opens com.udemy.javafxdemoapp.controller to javafx.fxml;
    exports com.udemy.javafxdemoapp.controller;
}