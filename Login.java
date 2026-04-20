/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.poeprojectpart1;

/**
 *
 * @author kesao
 */
import java.util.Scanner;

public class Login {

    public static boolean loginUser(Scanner scanner) {
        if (POEprojectpart1.getStoredUsername() == null) {
            System.out.println("No registered user found. Please register first.");
            return false;
        }

        System.out.println("\n=== LOGIN ===");
        System.out.print("Enter username: ");
        String enteredUsername = scanner.nextLine().trim();

        System.out.print("Enter password: ");
        String enteredPassword = scanner.nextLine().trim();

        if (POEprojectpart1.getStoredUsername().equals(enteredUsername) && 
            POEprojectpart1.getStoredPassword().equals(enteredPassword)) {
            
            System.out.println("\n" + returnLoginStatus(true));
            return true;
        } else {
            System.out.println("\n" + returnLoginStatus(false));
            return false;
        }
    }

    public static String returnLoginStatus(boolean success) {
        if (success) {
            return "Welcome " + POEprojectpart1.getStoredFirstName() + " " + 
                   POEprojectpart1.getStoredLastName() + ", it is great to see you again.";
        } else {
            return "Username or password incorrect, please try again.";
        }
    }
}