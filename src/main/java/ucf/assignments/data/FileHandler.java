/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Alex Fowler
 */
package ucf.assignments.data;

import ucf.assignments.todo.List;
import java.util.ArrayList;

public class FileHandler {
    public static void writeList(List list, String filePath) {
        // Get the list's data by calling App.todoLists.get(listIndex).getSaveData()

        // Save the raw data as a data file at the filePath.
    }

    public static void writeLists(ArrayList<List> lists, String filePath) {
        // Loop through lists calling writeList(list, filePath)
    }

    public static List readList(String filePath) {
        List newList = new List();
        // Parse JSON data into a List object full of Item objects.
        return newList;
    }
}
