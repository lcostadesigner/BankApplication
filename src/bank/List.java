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
public class List extends ImplementData{
    public static void List(String accountNumber){
        startFile(firstNameGl);
        startFile(lastNameGl);
        startFile(emailGl);
        startFile(accountNumberGl);
        System.out.println("\tAccount Number: " + accountNumberGl + " Full name: "+firstNameGl+ " " +lastNameGl+
                " Email: "+emailGl);
    }
}
    

