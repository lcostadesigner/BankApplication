/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Lucas Borges Costa
 * Student ID: 21619
 */
public class Transactions extends ImplementData { 
    public void Lodge(double lodgeAmount, String accountNumber){
    
    int option = 0;//To declare the initial variable for. 
    startFile(accountNumber);
    
    Scanner kb = new Scanner(System.in);
    
    do{
        System.out.println("Pick the Account Type:");
        System.out.println("1-Current");
        System.out.println("2-Savings");
        option = kb.nextInt();
        
    }while(option<1 || option>2);
    
    if(option == 1){
        try {
            getFile(filePathCurrent);
            FileWriter few = new FileWriter(filePathCurrent, true);//To virify the Information about the File.
            BufferedWriter bw = new BufferedWriter(few);//To write the content of the Values into the File.
            balanceGl += lodgeAmount;
            few.write("\nLodgement: "+lodgeAmount+" "+balanceGl);
            updateFile(filePathCustomer, accountNumber, balanceGl, option );//To update the File accessed by the Employee.
            bw.close();//To stop the program from keep writing New Content.
            System.out.println("\nYour logdment was succesfull.\n");
            BankMenu user = new BankMenu();//It will go back to the Initial Menu Class in order to give the User more options.
        }
        catch(IOException e){
        }
    
    }else if(option == 2){
        try {
            getFile(filePathSavings);
            FileWriter few = new FileWriter(filePathSavings, true);//Verify information about the file
            BufferedWriter bw = new BufferedWriter(few);//Writes the content of the values into the file
            balanceGl += lodgeAmount;
            few.write("\nLodgement"+":"+lodgeAmount+"  "+   "Balance:"+balanceGl);
            updateFile(filePathCustomer, accountNumber, balanceGl, option );//Updates the file accessed by the employee
            bw.close();//Stops the program from keep writing new content
            System.out.println("\nYour logdment was succesfull.\n");
            BankMenu user = new BankMenu();//It goes back to the Bank Menu.
        }
        catch(IOException e){}
    }
}
    
    public void Withdraw(double withdrawAmount, String accountNumber){
    
    int option = 0;//To declare the initial variable for. 
    startFile(accountNumber);
    
    Scanner kb = new Scanner(System.in);
    
    do{
        System.out.println("Pick the account:");
        System.out.println("1-Current");
        System.out.println("2-Savings");
        option = kb.nextInt();
        
    }while(option<1 || option>2);
    
    if(option == 1){
        try {
            
            getFile(filePathCurrent);
            FileWriter few = new FileWriter(filePathCurrent, true);//To verify the information about the File.
            BufferedWriter bw = new BufferedWriter(few);//To write the Content of the values into the File.
            
            if(balanceGl>=withdrawAmount){//To check if the Balance is higher than the Amount of the Withdraw.
               balanceGl-=withdrawAmount;
            
            few.write("\nWithdraw: "+withdrawAmount+" "+ "Balance: " + balanceGl);
            updateFile(filePathCustomer, accountNumber, balanceGl, option );//To update the File Accessed by the Employee.
            bw.close();//To stop the Program from keep writing New Content.
            System.out.println("\nYour withdraw was succesfull.\n");
            BankMenu user = new BankMenu();//To go back to the Bank Menu Class.
            }
            
            else{
                System.out.println("\nInsuficient Funds. Please try again.\n");
                BankMenu user = new BankMenu();//To go back to the Class to give the User more options.
            }
            
        }
        catch(IOException e){}
    
    }else if(option == 2){
        try {
            
            getFile(filePathSavings);
            FileWriter few = new FileWriter(filePathSavings, true);//To verify the information about the File.
            BufferedWriter bw = new BufferedWriter(few);//To write the Content of the values into the File.
            
            if(balanceGl>=withdrawAmount){
               balanceGl-=withdrawAmount;
            
            few.write("\nWithdraw" + "," + withdrawAmount + ","  + balanceGl);
            updateFile(filePathCustomer, accountNumber, balanceGl, option );//To update the File Accessed by the Employee.
            bw.close();//To stop the Program from keep writing New Content.
            System.out.println("\nYour withdraw was succesfull.\n");
            BankMenu user = new BankMenu();//To go back the Bank Menu Class.
            }
            
            else{
                System.out.println("\nInsuficient Funds. Please try again.\n");
                BankMenu user = new BankMenu();//To go back to the class to give the User more options.
            }
            
        }
        catch(IOException e){}
    }
}
    
   public void DeleteCustomer(String accountNumber){
        startFile(accountNumber);
        int option = 0;//To declare the initial variable for. 
        
        Scanner kb = new Scanner(System.in);
        
    
        do{
        System.out.println("Pick the Account Type:");
        System.out.println("1-Current");
        System.out.println("2-Savings");
        option = kb.nextInt();
        
    }while(option<1 || option>2);
    
    if(option == 1){
        try {
            
            getFile(filePathCurrent);
            FileWriter few = new FileWriter(filePathCurrent, true);//To verify the information about the File.
            BufferedWriter bw = new BufferedWriter(few);//To Write the Content of the values into the File.
            
            if(balanceGl==0){//To check if the balance is Equal to 0.
            
            few.write("\nAccount Successfully Deleted.");
            updateFile(filePathCustomer, accountNumber, balanceGl, option);//To update the File Accessed by the Employee.
            bw.close();//To Stop the Program from keep writing New Content.
            BankMenu user = new BankMenu();//To go back to the Initial Menu Class in order to give the User more options.
            }
            
        }
        catch(IOException e){}    
    }
    else if(option == 2){
    
        try {
            
            getFile(filePathSavings);
            FileWriter few = new FileWriter(filePathSavings, true);//To verify the information about the File.
            BufferedWriter bw = new BufferedWriter(few);//To write the Content of the values into the File.
            
            if(balanceGl==0){//To check if the Balance is Equal to 0 and only then the Account can be Deleted.
            
            few.write("\nAccount Successfully Deleted.");
            updateFile(filePathCustomer, accountNumber, balanceGl, option);//To update the File Accessed by the Employee.
            bw.close();//To stop the Program from keep writing New Content.
            BankMenu user = new BankMenu();//To go back to the Initial Menu Class in order to give the User more options.
            }
            
        }
        catch(IOException e){}       
}  
}
}




