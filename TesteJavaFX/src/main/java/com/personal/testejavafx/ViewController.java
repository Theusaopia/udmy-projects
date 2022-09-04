package com.personal.testejavafx;

import com.personal.testejavafx.model.entities.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ViewController implements Initializable {

    @FXML
    private ComboBox<Person> comboBoxPerson;

    @FXML
    private Button btAll;

    private ObservableList<Person> obsList;

    @FXML
    public void onComboBoxPersonAction() {
        Person person = comboBoxPerson.getSelectionModel().getSelectedItem();

        System.out.println(person);
    }

    @FXML
    public void onBtAllAction() {
        for (Person person : comboBoxPerson.getItems()) {
            System.out.println(person);
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<Person> list = new ArrayList<>();

        list.add(new Person(1, "Matheus", "matheus@email.com"));
        list.add(new Person(2, "Dias", "dias@email.com"));
        list.add(new Person(3, "Augusto", "augusto@email.com"));

        obsList = FXCollections.observableArrayList(list);

        comboBoxPerson.setItems(obsList);

        Callback<ListView<Person>, ListCell<Person>> factory = lv -> new ListCell<Person>() {
            @Override
            protected void updateItem(Person item, boolean empty) {
                super.updateItem(item, empty);
                setText(empty ? "" : item.getName());
            }
        };

        comboBoxPerson.setCellFactory(factory);
        comboBoxPerson.setButtonCell(factory.call(null));
    }
}