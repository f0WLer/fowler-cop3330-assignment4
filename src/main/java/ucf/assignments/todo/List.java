/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Alex Fowler
 */
package ucf.assignments.todo;

import java.util.ArrayList;

public class List {
        private String title;
        private ArrayList<Item> items;

        // Getters and Setters
        public String title() { return this.title; }
        public void title(String newTitle) { this.title = newTitle; }

        // Item Manipulation
        public void addItem(Item newItem) { this.items.add(newItem); }
        public void removeItem(int itemIndex) { this.items.remove(itemIndex); }

        public Item getItem(int itemIndex) { return this.items.get(itemIndex); }
        public ArrayList<Item> getItems() { return this.items; }


        // Item Filtering
        public ArrayList<Item> getCompletedItems() {
            ArrayList<Item> completedItems = new ArrayList<>();

            // Loop through each item in this.items. If the item is completed, add it to completedItems.

            return completedItems;
        }
        public ArrayList<Item> getIncompleteItems() {
            ArrayList<Item> incompleteItems = new ArrayList<>();

            // Same as getCompletedItems, but only add incomplete items.

            return incompleteItems;
        }

        // Save Data
        public String getSavaData() {
            String data = "";
            // Loop through each item and do data += Item.getSaveData()
            return data;
        }
}
