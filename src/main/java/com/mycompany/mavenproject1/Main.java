/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author narea
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Login userLogin = new Login();
 System.out.println("=== USER REGISTRATION ===");
        
        System.out.print("Enter First Name: ");
        userLogin.setFirstName(scanner.nextLine());

        System.out.print("Enter Last Name: ");
        userLogin.setLastName(scanner.nextLine());

        String regUsername = "";
        while (true) {
            System.out.print("Enter Username: ");
            regUsername = scanner.nextLine();
            if (userLogin.checkUserName(regUsername)) {
                System.out.println("Username successfully captured.");
                break; } else {
                System.out.println("Username is not correctly formatted; please ensure that your username contains an underscore and is no more than five characters in length.");
            }
        }
         String regPassword = "";
        while (true) {
            System.out.print("Enter Password: ");
            regPassword = scanner.nextLine();
            if (userLogin.checkPasswordComplexity(regPassword)) {
                System.out.println("Password successfully captured.");
                break;
                  } else {
                System.out.println("Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.");
            }
        }

        String regCell = "";
        while (true) {
            System.out.print("Enter Cell Phone Number (+27...): ");
            regCell = scanner.nextLine();
            if (userLogin.checkCellPhoneNumber(regCell)) {
                System.out.println("Cell number successfully captured.");
                break;
            } else {
        System.out.println("Cell number is incorrectly formatted or does not contain an international code; please correct the number and try again.");
            }
        }
         // Complete registration process
        String regStatus = userLogin.registerUser(regUsername, regPassword, regCell);
        System.out.println("\nRegistration Status:\n" + regStatus);

        System.out.println("\n=== USER LOGIN ===");
        System.out.print("Enter Username: ");
        String loginUsername = scanner.nextLine();

        System.out.print("Enter Password: ");
        String loginPassword = scanner.nextLine();

        boolean loginSuccess = userLogin.loginUser(loginUsername, loginPassword);
        String loginMessage = userLogin.returnLoginStatus(loginSuccess);

        System.out.println("\n" + loginMessage);
         scanner.close();
    }
}