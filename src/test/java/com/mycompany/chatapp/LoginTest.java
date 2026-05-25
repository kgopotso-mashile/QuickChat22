package com.mycompany.chatapp;

import com.mycompany.quickchat.Login;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Student
 */
public class LoginTest {
    
    public LoginTest() {
    }
    Login login = new Login(); 
    
    //===================================================================================================================
    //                              USERNAME TESTS
    //===================================================================================================================
    
    @Test
    public void testValidUsername() {
        //This checks if the username is correct 
        assertTrue(login.checkUsername("kyl_1"));    
    }
   
    @Test
    public void testInvalidUsername_NoUnderscore() {
        // This is to check if the username does not have any underscore 
        assertFalse(login.checkUsername("kyle!!!!")); 
    }
    
    //==================================================================================================================
    
    //                                          PASSWORD TEST 
    
    //======================================================================================================================
    
    @Test
    public void testValidPassword() { 
        //This is to check if the password is correct 
        assertTrue(login.checkPasswordComplexity("Ch&&sec@ke99!"));
    }
    @Test
    public void testInvalidPassword() { 
        //This is to check if the password is Invalid and if it contains a special charecter, a number and a capital letter 
        assertFalse(login.checkPasswordComplexity("password")); 
    }
    
    //======================================================================================================================
    
    //                                             CELLPHONE NUMBER TEST
    
    //======================================================================================================================
    
    @Test
    public void testValidCellPhone() {
        //This is to check if the cellphone number is correctly formatted and if it contains an international code 
        assertTrue(login.checkCellPhoneNumber("+2783968976")); 
    }
    
    @Test
    public void testInvalidCellPhone() {
        // This is to check if the cellphone number is incorrect and does not have a South African incorrect code
        assertFalse(login.checkCellPhoneNumber("08966553")); 
    }
    
    @Test
    public void testLoginSuccessful() { 
        //Register a new user and attempt to login 
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+27838968976");
        assertTure(login.loginUser("kyl_1", "Ch&&sec@ke99!")); 
    }
    
    @Test 
    public void testLoginFailed() { 
        login.registerUser("kyl_1", "Ch&&sec@ke99!", "+278389676");
        assertFalse(login.loginUser("kyl_1", "password"));
    }

    private void assertTure(boolean loginUser) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}