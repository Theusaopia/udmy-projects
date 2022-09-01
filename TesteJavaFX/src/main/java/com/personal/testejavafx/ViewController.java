package com.personal.testejavafx;

import com.personal.testejavafx.util.Alerts;
import com.personal.testejavafx.util.constraints.Constraints;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewController implements Initializable {

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Constraints.setTextFieldInteger(txtNumber1);
        Constraints.setTextFieldDouble(txtNumber2);

        Constraints.setTextFieldMaxLength(txtNumber1, 3);
        Constraints.setTextFieldMaxLength(txtNumber2, 3);
    }
}