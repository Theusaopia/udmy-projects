package com.personal.testejavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class ViewController {
    @FXML
    private Button btnMyButton;

    @FXML
    public void onMyButtonClick() {
        System.out.println("Olá");
    }
}