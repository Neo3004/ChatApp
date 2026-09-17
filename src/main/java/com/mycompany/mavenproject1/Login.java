/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.util.regex.Pattern;
/**
 *
 * @author narea
 */

public class Login {
    private String registeredUsername;
    private String registeredPassword;
    private String registeredCellNumber;
    private String firstName;
    private String lastName;
  // Default Constructor
    public Login() {
    }

    // Parameterized Constructor
    public Login(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
 // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

       public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getRegisteredUsername() {
        return registeredUsername;
    }

    public String getRegisteredPassword() {
     return registeredPassword;
    }

    public String getRegisteredCellNumber() {
        return registeredCellNumber;
    }

    /**
     * Checks if username contains an underscore (_) and is no more than 5 characters.
     */
    public boolean checkUserName(String username) {
        if (username == null) {
            return false;
        }
        return username.contains("_") && username.length() <= 5;
    }
   
 /**
     * Checks password complexity:
     * - Minimum 8 characters long
     * - Contains a capital letter
     * - Contains a number
     * - Contains a special character
     */
    public boolean checkPasswordComplexity(String password) {
        if (password == null || password.length() < 8) {
            return false;
        }

        boolean hasCapital = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
 if (Character.isUpperCase(c)) {
                hasCapital = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else if (!Character.isLetterOrDigit(c)) {
                hasSpecial = true;
            }
        }
 return hasCapital && hasDigit && hasSpecial;
    }

    /**
     * Validates South African cell phone number with international country code (+27).
     * Reference: Regular Expression pattern matching international code prefix.
     */
    public boolean checkCellPhoneNumber(String cellNumber) {
        if (cellNumber == null) {
            return false;
        }
        // Regex ensures starting with +, international code (+27), followed by 9 digits
        String regex = "^\\+27[0-9]{9}$";
        return Pattern.matches(regex, cellNumber);
    }

    /**
     * Registers user and returns status message based on validation rules.
     */
    public String registerUser(String username, String password, String cellNumber) {
        if (!checkUserName(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.";
        }

        if (!checkPasswordComplexity(password)) {
           return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        if (!checkCellPhoneNumber(cellNumber)) {
            return "Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.";
        }
  this.registeredUsername = username;
        this.registeredPassword = password;
        this.registeredCellNumber = cellNumber;

        return "Username successfully captured.\nPassword successfully captured.\nCell number successfully captured.";
    }

    /**
     * Verifies entered credentials against registered credentials.
     */
    public boolean loginUser(String username, String password) {
        if (registeredUsername == null || registeredPassword == null) {
            return false;
             }
        return registeredUsername.equals(username) && registeredPassword.equals(password);
    }

    /**
     * Returns appropriate login status message.
     */
    public String returnLoginStatus(boolean isLoggedIn) {
        if (isLoggedIn) {
            return "Welcome " + firstName + " " + lastName + ", it is great to see you again.";
        } else {
             return "Username or password incorrect, please try again.";
        }
    }
}
        