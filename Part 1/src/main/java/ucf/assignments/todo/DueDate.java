/*
 *  UCF COP3330 Fall 2021 Assignment 4 Solution
 *  Copyright 2021 Alex Fowler
 */
package ucf.assignments.todo;

public class DueDate {
        private int year;
        private int month;
        private int day;

        // Getters and Setter
        public int year() { return this.year; } // Getter
        public void year(int newYear) { this.year = newYear; } // Setter

        public int month() { return this.month; } // Getter
        public void month(int newMonth) { this.month = newMonth; } // Setter

        public int day() { return this.day; } // Getter
        public void day(int newDay) { this.day = newDay; } // Setter
}
