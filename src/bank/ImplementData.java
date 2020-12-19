/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Lucas Borges Costa
 * Student ID: 21619
 */
public class ImplementData {
    //To declare the Global Variables.
    public static String line, firstNameGl, lastNameGl, pinNumberGl, emailGl, accountNumberGl, attributesGl;
    public static double balanceGl, lastBalanceGl, newBalanceGl, lastTransactionGl;
    public static String filePathCurrent;
    public static String filePathSavings;
    public static String filePathCustomer;
    private static Scanner x;//The Variable is declared as private so, can only be accessed in this C.lass
    
    public static void startFile(String accountNumber){
    String currentAddress = "C:\\Users\\lcost\\Documents\\Lucas Costa - Pesonal Documents\\College\\BSC2\\Programming\\Bank\\src\\bank\\Database\\Current";//Created a new string for the file.txt
    String savingsAddress = "C:\\Users\\lcost\\Documents\\Lucas Costa - Pesonal Documents\\College\\BSC2\\Programming\\Bank\\src\\bank\\Database\\Savings";//Created a new string for the file.txt
    filePathCustomer = "C:\\Users\\lcost\\Documents\\Lucas Costa - Pesonal Documents\\College\\BSC2\\Programming\\Bank\\src\\bank\\Database\\Customer"; //Created a new string for the file.txt
    String accountTypeS = "-Savings.txt";
    String accountTypeC = "-Current.txt";
    filePathSavings = savingsAddress + accountNumber + accountTypeS;
    filePathCurrent = currentAddress + accountNumber + accountTypeC;
    //To StartFile will make it possible to turn the variables into Global. 
    }
    
    public static void getFile(String filePath) throws IOException{
        
        
        BufferedReader Reader = new BufferedReader(new FileReader(filePath));
        ArrayList<ImplementData> AccountData = new ArrayList<ImplementData>();
        //Array created to iterate with each characters of the First and Last Name typed by the User.
        line = null;
        
        while((line=Reader.readLine())!=null)
        {
            
            String[]Data = line.split(",");//
            if(Data.length==6)
            {
            accountNumberGl = Data[0];
            firstNameGl = Data[1];
            lastNameGl = Data[2];
            emailGl = Data[3];
            pinNumberGl = Data[4];
            balanceGl = Double.parseDouble(Data[5]);
            lastBalanceGl = balanceGl;
            
            }
            else if(Data.length == 3)
            {
                attributesGl = Data[0];
                lastTransactionGl = Double.parseDouble(Data[1]);
                balanceGl = Double.parseDouble(Data[2]); 
                lastBalanceGl = balanceGl;
            } 
        }
    }
    
    
    public static void updateFile(String filePath, String accountNumber, double balance, int option){
        String account= "";//This variable is initialized with no value.
        String firstName = "";
        String lastName = "";
        String email = "";
        String pinNumber = "";
        String balanceCurrent = "";
        String balanceSavings = "";
        String temporaryFile = "TemporaryFile.txt";//To declare the temporary File`s Name.
        
        File oldfile = new File(filePath);//To Open the Original File. 

        File newFile = new File(temporaryFile);//To open the File after a Transactin is made.
        
        try{
            FileWriter fw = new FileWriter(temporaryFile, true);//To open the File in order to check the Values.
            BufferedWriter bw = new BufferedWriter(fw);//to enable the computer to write the new Values on the File.
            PrintWriter pw = new PrintWriter(bw);//As the File was open and have a new value, the print will be able to produce the new result. 
            x = new Scanner(new File (filePath));//
            x.useDelimiter("[,\n]");//To detect the Value as the Parameter.
          
           while(x.hasNext()) 
           {
             account = x.next();
             firstName = x.next();
             lastName = x.next();
             email = x.next();
             pinNumber = x.next();
             balanceCurrent = x.next();
             balanceSavings = x.next();
             
             if(option == 1){
                 if (account.equals(accountNumber))//To find the Parameter to be changed.
                 {
                     pw.println(account + "," + firstName + "," + lastName + "," + email + "," + pinNumber + "," + balance + "," + balanceSavings);
                 }
                 
                 else{
                     pw.println(account + "," + firstName + "," + lastName + "," + email + "," + pinNumber + "," + balanceCurrent + "," + balanceSavings);
                 }}
             
             if(option == 2){
                 if (account.equals(accountNumber))//Find the parameter to be changed
                 {
                     pw.println(account + "," + firstName + "," + lastName + "," + email + "," + pinNumber + "," + balance + "," + balanceCurrent);
                 }
                 else{
                     pw.println(account + "," + firstName + "," + lastName + "," + email + "," + pinNumber + "," + balanceCurrent + "," + balanceSavings);
                 }
             }
            }
             x.close();//To close the memory acces.
             pw.flush();//To clean the memory from the buffer.
             pw.close();//To close the access.
             oldfile.delete();//To delete the old file.
             File bin = new File(filePath);
             newFile.renameTo(bin);//The file is Renamed.
             
            
        }catch(IOException e){
        }   
    }
    
}

