/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchat;

/**
 *
 * @author Student
 */
public class Login {
    String username;
    String password;
//Used String data type for cellphone number because it contains non numerical characte which is "+" in "+27"

    // Username Validation
    
    public boolean checkUsername(String username) {
        return username.contains("_") && username.length() >= 5; 
    }

    // Password Validation
    public boolean checkPasswordComplexity(String password) {
        boolean hasCapital = false;
        boolean hasNumber = false;
        boolean hasSpecial = false;
        
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            
            if (Character.isUpperCase(c)) {
                hasCapital = true;
            }
            if (Character.isDigit(c)) {
                hasNumber = true;
            }
            if (!Character.isLetterOrDigit(c)) {  // checks if it's a special character
                hasSpecial = true;
            }
        }
        
        return password.length() >=8 && hasCapital && hasNumber && hasSpecial;
    }

    // Cell Phone Number Validation
    public boolean checkCellPhoneNumber(String phone) {
        return phone.startsWith("+27") && phone.length() == 12 && phone.length() == 12;  // Phone number must not be more than 12 characters long
    }

    // Register User Method
    public String registerUser(String username, String password, String phoneNumber) {
        if (!checkUsername(username)) {
            return "Username is not correctly formatted; please ensure that your username contains an underscore and is no more than 5 characters in length.";
        }

        if (!checkPasswordComplexity(password)) {
            return "Password is not correctly formatted; please ensure that the password contains at least eight characters, a capital letter, a number, and a special character.";
        }

        if (!checkCellPhoneNumber(phoneNumber)) {
            return "Cell phone number incorrectly formatted or does not contain international code.";
        }

        this.username = username;
        this.password = password;

        return "User registered successfully.";
    }

    // Login Feature
    public boolean loginUser(String username, String password) {
        if (username == null || password == null) {
            return false; // This checks if the user can log in with the given username and passwword
        }
        return this.username.equals(username) && this.password.equals(password); // this line checks if the username and password match the ones provided above
    }

    public String returnLoginStatus(boolean success) {
        if (success) {
            return "Welcome, " + username + ". It is great to see you again.";
        } else {
            return "Username or password incorrect, please try again."; 
        }
    }
}
    