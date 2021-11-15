/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Alex Fowler
 */
package ucf.assignments;

import javafx.application.Application;
import javafx.stage.Stage;

import ucf.assignments.gui.Util;
import ucf.assignments.todo.List;

import java.util.ArrayList;

public class App extends Application {

    private static ArrayList<List> todoLists = new ArrayList<>();

    @Override
    public void start(Stage stage) throws Exception {
        // Load any lists in default save path to todoLists.

        System.out.println("Starting App.");
        // stage.setScene(Util.loadView(""));
        // stage.show();
    }

    // todoLists getter.
    public static ArrayList<List> getLists() {
        return todoLists;
    }

    ////// List Handling
    // Removes the list at index.
    public static void removeList(int index) { todoLists.remove(index); }

    // Adds a new list and returns it.
    public static List addList() {
        List newList = new List();
        //todoLists.add(newList);
        return newList;
    }

    ////// Save / Load
    // Saves a single list to a file.
    public static void saveList(int index, String filePath) {
        // FileHandler.writeList(App.getLists().get(index), filePath);
    }

    // Saves all current lists to a file.
    public static void saveAllLists(String filePath) {
        // FileHandler.writeLists(todoLists, filePath);
    }

    // Opens one or many lists from a file.
    public static void loadList(String filePath) {
        // todoLists.add(FileHandler.readList(filePath));
    }
}
