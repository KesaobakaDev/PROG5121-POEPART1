/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.poeprojectpart1;

/**
 *
 * @author kesao
 */


import java.util.Scanner;

public class POEprojectpart1 {

    // Stored user data 
    private static String storedUsername = null;
    private static String storedPassword = null;
    private static String storedFirstName = null;
    private static String storedLastName = null;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Registration & Login System ===\n");

        while (true) {
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    registerUser(scanner);        
                    break;

                case "2":
                    Login.loginUser(scanner);     
                    break;

                case "3":
                    System.out.println("Thank you for using the system. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid option. Please choose 1, 2 or 3.\n");
            }
            System.out.println();
        }
    }

    // REGISTRATION
    private static void registerUser(Scanner scanner) {
        System.out.println("\n=== USER REGISTRATION ===");

        System.out.print("Enter first name: ");
        String firstName = scanner.nextLine().trim();

        System.out.print("Enter last name: ");
        String lastName = scanner.nextLine().trim();

        String username;
        do {
            System.out.print("\nEnter username: ");
            username = scanner.nextLine().trim();
            if (checkUsername(username)) {
                System.out.println("Username successfully captured.");
            } else {
                System.out.println("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.");
            }
        } while (!checkUsername(username));

        String password;
        do {
            System.out.print("\nEnter password: ");
            password = scanner.nextLine().trim();
            if (checkPassword(password)) {
                System.out.println("Password successfully captured.");
            } else {
                System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number and a special character.");
            }
        } while (!checkPassword(password));

        String cellphone;
        do {
            System.out.print("\nEnter cellphone number with international code: ");
            cellphone = scanner.nextLine().trim();
            if (checkCellphone(cellphone)) {
                System.out.println("Cell phone number successfully added.");
            } else {
                System.out.println("Cell phone number is incorrectly formatted or does not contain an international code; please correct the number and try again.");
            }
        } while (!checkCellphone(cellphone));

        // Save the registered user
        storedUsername = username;
        storedPassword = password;
        storedFirstName = firstName;
        storedLastName = lastName;

        System.out.println("\n Account successfully created!\n");
    }

    //  VALIDATION METHODS 
    public static boolean checkUsername(String username) {
        return username != null && username.contains("_") && username.length() <= 5;
    }

    public static boolean checkPassword(String password) {
        if (password == null || password.length() < 8) return false;

        boolean hasUpper = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;

        for (char ch : password.toCharArray()) {
            if (Character.isUpperCase(ch)) hasUpper = true;
            else if (Character.isDigit(ch)) hasNumber = true;
            else if (!Character.isLetterOrDigit(ch)) hasSpecial = true;
        }
        return hasUpper && hasNumber && hasSpecial;
    }

    public static boolean checkCellphone(String cellphone) {
        if (cellphone == null) return false;
        return cellphone.startsWith("+27") && cellphone.length() <= 12;
    }

    // HELPER METHOD FOR JUNIT TESTS 
    
    public static void setTestUser(String username, String password, String firstName, String lastName) {
        storedUsername = username;
        storedPassword = password;
        storedFirstName = firstName;
        storedLastName = lastName;
    }

    // Getters 
    public static String getStoredUsername() { return storedUsername; }
    public static String getStoredPassword() { return storedPassword; }
    public static String getStoredFirstName() { return storedFirstName; }
    public static String getStoredLastName() { return storedLastName; }
}
