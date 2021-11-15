/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Alex Fowler
 */
package ucf.assignments.controllers;

import ucf.assignments.App;

public class ListViewerController {

    public void setItemCompleted(int itemIndex, boolean state) {
        // App.currentList.get(itemIndex).completed(state);
    }

    public void removeItemFromListButton(int itemIndex) {
        // App.currentList.remove(itemIndex);
    }

    public void setText(int itemIndex, String oldText, String newText) {
        /*
        if newText is a valid description:
            App.currentList.get(itemIndex.description(newText);

        else:
            reset text area value to oldText
         */
    }

    public void setDueYear(int itemIndex, int oldYear, int newYear) {
        /*
        if newYear is a valid year:
            App.currentList.get(itemIndex).due().year(newYear);

        else:
            reset text area value to oldYear
         */
    }
    public void setDueMonth(int itemIndex, int oldMonth, int newMonth) {
        // Same as setDueYear.
    }
    public void setDueDay(int itemIndex, int oldDay, int newDay) {
        // Same as setDueDay.
    }

    public void newItemButton() {
        // Create a dummy item in the GUI for the user to set the data.
    }

    public void addItemToList(/* Necessary info for Item constructor*/) {
        // newItem = new Item(params);
        // App.currentList.add(newItem);
    }

    public void showCompletedItems(int listIndex) {
        // Call App.getLists.get(listIndex).getCompletedItems
        // Replace the currently displayed list with what's returned.
    }
    public void showIncompleteItems(int listIndex, boolean show) {
        // Same as showCompletedItems, but call getIncompleteItems().
    }
}
