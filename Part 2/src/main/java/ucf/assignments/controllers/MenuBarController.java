package ucf.assignments.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import org.json.JSONArray;
import org.json.JSONObject;
import ucf.assignments.App;
import ucf.assignments.data.FileHandler;
import ucf.assignments.todo.Item;
import ucf.assignments.todo.List;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class MenuBarController {

    @FXML
    private void file_new() {

    }

    // TODO: Create a general "newList" function that will also be used by list_new. Parse data here and then use it.
    @FXML
    private void file_open() throws IOException {
        // Open file chooser.
        FileChooser fc = new FileChooser();
        fc.setTitle("Open file...");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Todo List Files", "*.todo"));
        // Get file.
        File file = fc.showOpenDialog(App.gui.stage);
        if (file == null) // TODO;
            return;
        // Parse file into lists and add each list to the GUI.
        ArrayList<List> newLists = FileHandler.readFile(file);
        for (List newList : newLists)
            App.gui.newList(newList);
    }

    @FXML
    private void file_close() {

    }

    @FXML
    private void file_saveAs() throws IOException {
        FileChooser fc = new FileChooser();
        fc.setTitle("Save as...");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Todo List File", "*.todo"));
        // Get file.
        File file = fc.showSaveDialog(App.gui.stage);
        FileWriter writer = new FileWriter(file);
        JSONArray lists = new JSONArray();
        for (List l : App.lists())
            lists.put(new JSONObject(l.getSaveData()));
        writer.write(new JSONObject().put("lists", lists).toString());
        writer.close();
    }

    @FXML
    private void list_new() throws IOException {
        App.gui.newList(new List());
    }

    @FXML
    private void list_newItem() throws IOException {
        App.gui.newItem(new Item());
    }

    @FXML
    private void list_changeTitle() throws IOException {
        App.gui.promptForTitle(false);
    }
}
