package com.gui.todolist;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class ToDoListController implements Initializable {


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        datePicker.setValue(LocalDate.now());
    }

    @FXML
    Button addButton;
    @FXML
    Button deleteButton;
    @FXML
    TextField descriptionTextField;
    @FXML
    DatePicker datePicker;
    @FXML
    ListView<LocalEvent> eventList;

    ObservableList<LocalEvent> list = FXCollections.observableArrayList();

    //метод для добавление заметки
    @FXML
    private void addEvent() {
        list.add(new LocalEvent(datePicker.getValue(), descriptionTextField.getText()));
        eventList.setItems(list);
        saveToFile();
        refresh();
    }

    //метод для удаления заметки
    @FXML
    private void deleteEvent() {
        int selectedIndex = eventList.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            eventList.getItems().remove(selectedIndex);
        }
    }

    //Установка значений по умолчанию
    private void refresh() {
        datePicker.setValue(LocalDate.now());
        descriptionTextField.setText(null);
    }

    public void saveToFile() {
        LocalDate date = datePicker.getValue();
        String description = descriptionTextField.getText();

        try(BufferedWriter writer = new BufferedWriter(new FileWriter("log.txt",true))) {
            writer.write(date.toString());
            writer.write(", ");
            writer.write(description);
            writer.newLine();
        } catch (IOException ex) {
            System.out.println("Error message: " + ex);
        }
    }
}