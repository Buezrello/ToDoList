package com.igindin.todolist;

import com.igindin.todolist.datamodel.TodoItem;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextArea;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class Controller {

    private List<TodoItem> todoItems;

    @FXML
    private ListView<TodoItem> todoListView;
    @FXML
    private TextArea itemDetailsTextArea;

    public void initialize() {
        TodoItem item1 = new TodoItem("Mail birthday card", "Buy a 30th birthday card for John",
                LocalDate.of(2018, Month.JULY, 25));
        TodoItem item2 = new TodoItem("Doctor appointment", "See dr. Smith next month",
                LocalDate.of(2018, Month.AUGUST, 23));
        TodoItem item3 = new TodoItem("Finish design", "I promised to do it next week",
                LocalDate.of(2018, Month.JULY, 24));
        TodoItem item4 = new TodoItem("Pick up friend at the train station", "Did I missed it already?",
                LocalDate.of(2018, Month.JUNE, 26));
        TodoItem item5 = new TodoItem("Pick up dry cleaning", "Don't forget it - AGAIN!!!!",
                LocalDate.of(2018, Month.JULY, 27));

        todoItems  = new ArrayList<>();
        todoItems.add(item1);
        todoItems.add(item2);
        todoItems.add(item3);
        todoItems.add(item4);
        todoItems.add(item5);

        todoListView.getItems().setAll(todoItems);
        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
    }

    @FXML
    public void handleClickListView() {
        TodoItem item = todoListView.getSelectionModel().getSelectedItem();
//        System.out.println("Selected item is " + item);
        StringBuilder sb = new StringBuilder(item.getDetails());
        sb.append("\n\n\n\n");
        sb.append("Due: ");
        sb.append(item.getDeadline().toString());
        itemDetailsTextArea.setText(sb.toString());
    }
}
