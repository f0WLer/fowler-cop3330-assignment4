/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Alex Fowler
 */
package ucf.assignments.controllers;

import ucf.assignments.App;
import ucf.assignments.data.FileHandler;
import ucf.assignments.todo.List;

public class MenuController {

    public void saveList() {
        // Get filePath through File Browser
        // App.saveList(App.currentList, filePath);
    }

    public void saveAllLists() {
        // Get filePath through File Browser
        // App.saveAllLists(filePath);
    }

    public void loadList() {
        // Get filePath through File Browser
        // App.loadList(filePath);
    }

    public void loadLists() {
        /*
        - The same principle as loadList, but will get an array of filePaths

        - Loop through the array calling App.loadList(filePaths[i])
         */
    }

    public void newList() {
        // Create a new empty list -- App.getLists().add(new List());
    }

    public void closeList() {
        // Close the current list -- App.removeList(App.currentListIndex);
    }

}
