/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Lucas Borges Costa
 * Student ID: 21619
 */
public class AccountGenerator {
    public AccountGenerator(String firstName, String lastName, String email){
    
    String CurrentAddress = "C:\\Users\\lcost\\Documents\\Lucas Costa - Pesonal Documents\\College\\BSC2\\Programming";
    String SavingsAddress = "C:\\Users\\lcost\\Documents\\Lucas Costa - Pesonal Documents\\College\\BSC2\\Programming";
    String CustomerAddress = "C:\\Users\\lcost\\Documents\\Lucas Costa - Pesonal Documents\\College\\BSC2\\Programming";    
    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    String pinNumber;
    String newFirstName;
    String newLastName;
    String accountNumber;
    String Balance = "0.0";
    char firstLetter;
    char lastLetter;
    int size;
    int positionFirstLetter;
    int positionLastLetter;
    
    Scanner kb = new Scanner (System.in);
    
    size = firstName.length() + lastName.length();//To assossiate the length to the size of the variable.
    firstLetter = firstName.charAt(0);//To Associate the first letter from the First Name typed by the Employee.
    lastLetter = lastName.charAt(0);//To Associate the last letter from the Last Name typed by the Employee.
    
    
    positionFirstLetter = alphabet.indexOf(firstLetter)+1;//To Associate the position of the First Letter on the Alphabet.
    positionLastLetter = alphabet.indexOf(lastLetter)+1;//To Associate the position of the Second Letter on the Alphabet.
    
    accountNumber=String.valueOf(firstLetter)+String.valueOf(lastLetter)+"-"+Integer.toString(size)+"-"+Integer.toString(positionFirstLetter)+ "-"
    +Integer.toString(positionLastLetter);
    //DeleteCustomer user = new DeleteCustomer(accountNumber);
    pinNumber = Integer.toString(positionFirstLetter)+ Integer.toString(positionLastLetter);
    System.out.print(accountNumber);
    System.out.print(positionFirstLetter);
    System.out.print(positionLastLetter);
    
        try{
            FileWriter Savings = new FileWriter(SavingsAddress+accountNumber+"-Savings.txt");//To Associate the file with the name of the Document.
            FileWriter Current = new FileWriter(CurrentAddress+accountNumber+"-Current.txt");//To Associate the file with the name of the Document.
            FileWriter Customer = new FileWriter(CustomerAddress+"Customer.txt",true);//To Associate the file with the name of the Document.
            
            BufferedWriter Saving = new BufferedWriter(Savings);
            BufferedWriter CurrentAccount = new BufferedWriter(Current);
            BufferedWriter CustomerList = new BufferedWriter(Customer);
            
            PrintWriter pw = new PrintWriter(CustomerList);//To declare the printwriter to be able to print the values later.
            
            Saving.write("Account Number: " +accountNumber+ "\n"+ "Balance: "+Balance);
            Current.write("Account Number: " +accountNumber+ "\n"+ "Balance: "+Balance);
            System.out.println("\nAccount has been succesfully created.\n");
            pw.print("\tAccount Number: " + accountNumber + " Full name: "+firstName+ " " +lastName+" Email: "+email+" Pin Number: "+pinNumber+" Balance: "+Balance + "\n");
            
            Saving.close();//To close the files after writing the values.
            CurrentAccount.close();//To close the files after writing the values.
            pw.close();//To close the files after writing the values.

            System.out.println("   Press enter to Return to Menu.");
            kb.nextLine();
            BankMenu user = new BankMenu();//To Go Back to the Menu.
        }   
        catch(IOException e){    
        }   
    } 
}