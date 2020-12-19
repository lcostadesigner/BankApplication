/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

/**
 * @author Lucas Borges Costa
 * Student ID: 21619
 */
import java.util.Scanner;
public class BankMenu {
    public BankMenu() {
    
    String firstName;
    String lastName;
    String accountNumber;
    String pinNumber;
    String EmployeePin = "A1234";
    int option = 0; //To declate the variable initial point
    
    Scanner kb = new Scanner (System.in);// To Create the scanner to read option from the user
     
        //The Initial menu
        do{
            System.out.println("-----------------------------------");
            System.out.println("\t\tMENU");
            System.out.println("-----------------------------------\n");
            System.out.println("Please select your account type:");
            System.out.println("1- Employee");//The Employee account will be entered if the option 1 is selected. 
            System.out.println("2- Customer\n");//The Customer account will be entered if the option 2 is selected.

            option = kb.nextInt();

        }while(option<1 || option>2); //To make sure that our options are correctly selected and will keep running until the condition is met.

        if(option == 1){
            System.out.println("-----------------------------------");
            System.out.println("\t\tPASSWORD:");
            System.out.println("-----------------------------------\n");
            kb.nextLine();
            pinNumber = kb.nextLine();//To read the input from the user 


                if(pinNumber.contains(EmployeePin)){
                System.out.println("\n-----------------------------------");
                System.out.println("\t   WELCOME");
                System.out.println("-----------------------------------\n");
                Employee user = new Employee(pinNumber);//To send the value to the another class

                }else{
                System.out.println("\nYour pin is incorrect, please try again.\n");
                BankMenu user = new BankMenu();   

                }
        }

        else if(option == 2){
            System.out.println("Please type your First Name:");
            firstName = kb.nextLine();//Reads first name input
            kb.nextLine();
            System.out.println("Please type your Last Name:");
            lastName = kb.nextLine();//Reads last name input
            System.out.println("Please type your Account Number:");
            accountNumber = kb.nextLine();//Reads account number input
            System.out.println("Please type your PIN:");
            pinNumber = kb.nextLine();//Reads pin number input

                if(firstName.contains(firstName) && lastName.contains(lastName) & accountNumber.contains(accountNumber) && pinNumber.contains(pinNumber)){
                //To check if the details are correct and it will only be possible to enter the menu if they are correct.
                System.out.println("\n-----------------------------------");
                System.out.println("\t   WELCOME, CUSTOMER");
                System.out.println("-----------------------------------\n");
                Costumer user = new Costumer(firstName, lastName, accountNumber, pinNumber);//To send the value to another class.

                }else{
                System.out.println("\nYour details are incorrect, please try again.\n");
                BankMenu user = new BankMenu();   

                }

            System.out.println("\n\n");
            Costumer user = new Costumer(firstName, lastName, accountNumber, pinNumber);
        }

        else{
            System.out.printf("\nPlease try again\n");
            Bank user = new Bank();
        } 
      }
    }