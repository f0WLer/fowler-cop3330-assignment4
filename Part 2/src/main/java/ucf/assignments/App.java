/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Alex Fowler
 */
package ucf.assignments;

import ucf.assignments.gui.GUI;
import ucf.assignments.todo.List;

import java.util.ArrayList;
import java.util.Arrays;

public class App {
    private static ArrayList<List> lists = new ArrayList<>();
    public static GUI gui;

    public static void main(String[] args) {
        // Launch GUI.
        App.gui = new GUI();
        App.gui.launch();
    }

    // List Getter
    public static ArrayList<List> lists() {
        return lists;
    }

    public static void spitError(Thread t, Throwable e) {
        System.out.println("ERROR:\n" + e + " : " + Arrays.toString(e.getStackTrace()));
    }

    public static void debugLog(String log) {
        // TODO: If debug arg
        System.out.println(log);
    }

}
