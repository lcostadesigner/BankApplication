/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.util.Scanner;

/**
 * @author Lucas Borges Costa
 * Student ID: 21619
 */
public class Employee {
    public Employee(String pinNumber){
    
    String EmployeePin = "A1234";
    String firstName;
    String lastName;
    String email;
    String accountNumber;
    double lodgeAmount=0.0;
    double withdrawAmount=0.0;
    int option = 0;
    
    Scanner kb = new Scanner (System.in);//To read the option from the User.
        
        do{
            System.out.println("Please pick an Option:");
            System.out.println("1-Create Account");
            System.out.println("2-Delete Account");
            System.out.println("3-Lodge");
            System.out.println("4-Withdraw");
            System.out.println("5-Customers List");//To connect to the list with delete later.
            option = kb.nextInt();
        
        
            if(option == 1){
                System.out.println("\n-----------------------------------");
                System.out.println("\t     CREATE ACCOUNT");
                System.out.println("-----------------------------------");
                System.out.println("First name:");
                kb.nextLine();//To read the User's input.
                firstName = kb.nextLine();//To read the First Name input.
                System.out.println("\nLast name:");
                lastName = kb.nextLine();//To read the Last Name input.
                System.out.println("\nEmail:");
                email = kb.nextLine();//To read the E-mail input.
                System.out.println("");
                AccountGenerator user = new AccountGenerator(firstName, lastName, email);//To passe the values to the selected Class.

            }else if(option == 2){
                System.out.println("\n-----------------------------------");
                System.out.println("\t     DELETE ACCOUNT");
                System.out.println("-----------------------------------");
                System.out.println("Please type the Account Number to be Deleted");
                accountNumber = kb.nextLine();//To read the Account Number typed by the User.
                Transactions user = new Transactions();
                user.DeleteCustomer(accountNumber);
                

            }else if(option == 3){
                System.out.println("-----------------------------------");
                System.out.println("\t     LODGE");
                System.out.println("-----------------------------------");
                System.out.println("Please type the Account Number");
                kb.nextLine();
                accountNumber = kb.nextLine();//To read the info typed by the User.
                System.out.println("Please type the Amount:");
                lodgeAmount = kb.nextDouble();// To read the Lodge Amount typed by the User.
                Transactions user = new Transactions();
                user.Lodge(lodgeAmount, accountNumber);
            }

            else if(option == 4){
                System.out.println("-----------------------------------");
                System.out.println("\t      WITHDRAW");
                System.out.println("-----------------------------------");
                System.out.println("Please type the Account Number");
                kb.nextLine();
                accountNumber = kb.nextLine();//To read the Account Number typed by the User.
                System.out.println("Please type the Amount:");
                withdrawAmount = kb.nextDouble();//To read the Withdraw Amount typed by the User.
                Transactions user = new Transactions();
                user.Withdraw(withdrawAmount, accountNumber);

            }else{
                System.out.println("-----------------------------------");
                System.out.println("\t    CUSTOMER`S LIST");
                System.out.println("-----------------------------------");
                List user = new List();//To send the value to another Class.
               //user.List(firstName, lastName,email);
            }
          
            }while(option<1 || option>5);//To make sure that the condition is met.
    }
}   