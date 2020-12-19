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
public class Costumer {
    public Costumer(String firstName, String lastName, String pinNumber, String accountNumber){
     
    //String E-mail;
    double lodgeAmount=0.0;
    double withdrawAmount=0.0;
    int option = 0;    
        
    Scanner kb = new Scanner(System.in);//To make it possible to get the input from the User.
  
            do{
            //TRANSACTIONS - CUSTOMER
            System.out.println("Please select the correct Transaction");
            System.out.println("1- Lodge");
            System.out.println("2- Withdraw");
            option = kb.nextInt(); //To read the option selected by the User.

            if (option == 1){
            System.out.println("-----------------------------------");
            System.out.println("\t     LODGE");
            System.out.println("-----------------------------------");
            System.out.println("Please type the Account Number");
            kb.nextLine();
            accountNumber = kb.nextLine();//To read the info typed by the User.
            System.out.println("Please type the Amount:");
            lodgeAmount = kb.nextDouble();// to Read the lodge amount typed by the User.
            Transactions user = new Transactions();
            user.Lodge(lodgeAmount, accountNumber);        
            }

            else if(option == 2){
            System.out.println("-----------------------------------");
            System.out.println("\t      WITHDRAW");
            System.out.println("-----------------------------------");
            System.out.println("Please type the Account Number");
            kb.nextLine();
            accountNumber = kb.nextLine();//To reads the Account Number typed by the User.
            System.out.println("Please type the Amount:");
            withdrawAmount = kb.nextDouble();//To read the Withdraw Amount typed by the User.
            Transactions user = new Transactions();
            user.Withdraw(withdrawAmount, accountNumber);
            }
            
            }while(option<1 || option>2);
}
}

    