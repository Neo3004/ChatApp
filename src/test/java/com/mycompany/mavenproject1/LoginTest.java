/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

package com.mycompany.mavenproject1;
        
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author narea
 */
 public class LoginTest {

    private Login login;

    @BeforeEach
    public void setUp() {
        login = new Login("Kagiso", "Mokoena");
    }
     // --- USERNAME TESTS ---

    @Test
    public void testCheckUserNameCorrect() {
        // Test Data: kyl_1
        assertTrue(login.checkUserName("kyl_1"));
    }

    @Test
    public void testCheckUserNameIncorrect() {
        // Test Data: kyle!!!!!!!
        assertFalse(login.checkUserName("kyle!!!!!!!"));
    }
 // --- PASSWORD TESTS ---

    @Test
    public void testCheckPasswordComplexitySuccess() {
        // Test Data: Ch&&sec@ke99!
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }

    @Test
    public void testCheckPasswordComplexityFailure() {
        // Test Data: password
        assertFalse(login.checkPasswordComplexity("password"));
    } 
 // --- CELL PHONE TESTS ---

    @Test
    public void testCheckCellPhoneNumberSuccess() {
        // Test Data: +27838968976
        assertTrue(login.checkCellPhoneNumber("+27838968976"));
    }

    @Test
    public void testCheckCellPhoneNumberFailure() {
        // Test Data: 08966553
        assertFalse(login.checkCellPhoneNumber("08966553"));
    }
     // --- LOGIN SYSTEM TESTS ---

    @Test
    public void testLoginUserSuccess() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertTrue(login.loginUser("kyl_1", "Ch&&sec@ke99!"));
    }

    @Test
    public void testLoginUserFailure() {
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertFalse(login.loginUser("kyl_1", "WrongPass1!"));
    }
}