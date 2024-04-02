module com.gui.todolist {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.gui.todolist to javafx.fxml;
    exports com.gui.todolist;
}