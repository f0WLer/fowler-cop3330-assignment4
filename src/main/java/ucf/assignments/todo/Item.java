/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Alex Fowler
 */
package ucf.assignments.todo;

public class Item {
        private String description;
        private DueDate due;
        private Boolean completed;

        // Getters and Setters
        public String description() { return this.description; } // Getter
        public void description(String newDesc) { this.description = newDesc; } // Setter

        public DueDate due() { return this.due; } // Getter

        public Boolean completed() { return this.completed; } // Getter
        public void completed(Boolean newState) { this.completed = newState; } /// Setter

        // Save Data
        public String getSaveData() {
            String data = "";
            // Parse the item's data into a JSON string and return it
            return data;
        }
}
