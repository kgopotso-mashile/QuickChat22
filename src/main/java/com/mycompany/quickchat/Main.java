/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.quickchat;

import java.util.Scanner;

/**
 *
 * @author Student
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Login login = new Login();

        System.out.println("=== USER REGISTRATION ===");
        System.out.print("Enter a username: ");
        String username = input.nextLine();
        System.out.print("Enter a password: ");
        String password = input.nextLine();
        System.out.print("Enter your South African phone number (+27...): ");
        String phone = input.nextLine();

        String response = login.registerUser(username, password, phone);
        System.out.println(response);

        System.out.println("\n=== USER LOGIN ===");
        System.out.print("Enter your username: ");
        String loginUsername = input.nextLine();
        System.out.print("Enter your password: ");
        String loginPassword = input.nextLine();
        

        boolean loggedIn = login.loginUser(loginUsername, loginPassword);
        System.out.println(login.returnLoginStatus(loggedIn));

        if (!loggedIn) {
            input.close();
            return;
        }

        System.out.println("Welcome to ChatApp");
        boolean running = true;
        while (running) {
           System.out.println("1) Send Message");
           System.out.println("2) Show recently deleted messages"); 
           System.out.println("3) Quit");
           

         int choice = 0;
          choice = input.nextInt(); 
          input.nextLine();
          
          switch (choice) {
              
          case 1 -> {
              System.out.println("Please type your message");
          }
          
          case 2 -> {
              System.out.println("Coming soon."); 
          }
          
          case 3 ->  {
              System.out.println("Quit.");
          
          running = false;// running = false; to exit the loop
          }
          default -> {
              System.out.println("Option not available please choose from the above options and try again.");
    }
 }
          

        //Message Count (For Loop)
         // Asking the user how messages they would to send 
          System.out.println("How many messages would you like to send?");
           int numMessages = 0; 
                scanner.nextLine();
            
            //Te For loop will run the same time as the numMessage, the amount of times numMessage runs, it will also run
          for (int i = 0; i < numMessages; i++) {
             int messageNumber = i + 1; 
             System.out.println("---Message " + messageNumber + "---"); 
            
                System.out.println("Enter the recipient's details: ");
            
                System.out.println("Type message: ");
                System.out.println("Message sent"); 
          }
          
    }    
}
}

