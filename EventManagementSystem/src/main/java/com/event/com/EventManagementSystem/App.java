package com.event.com.EventManagementSystem;

/**
 * Hello world!
 *
 */

public class App {
    public static void main(String[] args) {
        System.out.println("Welcome to Event Management Application\n");
        
        // Create an instance of your custom Menu class
        Menu menu = new Menu();
        menu.displayMenu(); // This will now call your custom displayMenu() method
    }
}
