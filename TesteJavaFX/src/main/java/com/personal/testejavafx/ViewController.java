package com.personal.testejavafx;

import com.personal.testejavafx.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;

public class ViewController {
    @FXML
    private Button btnMyButton;

    @FXML
    public void onMyButtonClick() {
        Alerts.showAlert("Alerta!", "Alerta do Matheus", "Esteja alertado", Alert.AlertType.INFORMATION);
    }
}