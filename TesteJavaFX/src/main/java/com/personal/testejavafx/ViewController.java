package com.personal.testejavafx;

import com.personal.testejavafx.util.Alerts;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ViewController {

    @FXML
    private TextField txtNumber1;

    @FXML
    private TextField txtNumber2;

    @FXML
    private Label labelResult;

    @FXML
    private Button btSum;

    @FXML
    public void onBtSumAction() {

        try {
            double number1 = Double.parseDouble(txtNumber1.getText());
            double number2 = Double.parseDouble(txtNumber2.getText());

            double sum = number1 + number2;

            labelResult.setText(String.format("%.2f", sum));

            Alerts.showAlert("Alerta!", null, "Calculo realizado", Alert.AlertType.INFORMATION);
        }
        catch (NumberFormatException ex) {
            Alerts.showAlert("Error!", null, ex.getMessage(), Alert.AlertType.ERROR);
        }
    }
}