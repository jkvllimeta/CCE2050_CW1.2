/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cce2050_cw2;

import java.util.ArrayList;

/**
 *
 * @author Joseph
 */
public class User {
    
    private String name;
    private String surname;
    private BankAccount bankAccount;
    private double[] transactionList;
    private ArrayList<Double> transactionArrayList = new ArrayList<>();
    
    


public User (String n, String s, BankAccount bA, double[] tL){
    
    this.name = n;
    this.surname = s;
    this.bankAccount = bA;
    this.transactionList = tL;
}

public User (String n, String s, BankAccount bA, ArrayList<Double> tL){
    
    this.name = n;
    this.surname = s;
    this.bankAccount = bA;
    this.transactionArrayList = tL;
}

public String getName(){
    
    return name;
    
    }

public String getSurname(){
    
    return surname;
    
    }

public double[] getTransactionList(){
    
    return transactionList;
    
}

public ArrayList<Double> getTransactionArrayList(){
    
    return transactionArrayList;
    
}

public BankAccount getAccount(){
    
    return bankAccount;
    
}

}