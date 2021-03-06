/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cce2050_cw2;

/**
 *
 * @author Joseph
 */
public class BankAccount {
    
    private long accountNo = 0;
    protected double accountBalance = 0;
    
    public BankAccount(){
        
    }
    
    public BankAccount (long accountNo, double accountBalance){
        this.accountNo = accountNo;
        this.accountBalance = accountBalance;
    }
    
    public void newAccount (double newBal){
        
        this.accountBalance = newBal;
        
    }
    
    public long getAccountNo(){
        
        return this.accountNo;
        
    }
    
    public double getAccountBalance(){
        
        return this.accountBalance;
        
    }
    
    public void setAccountNo(long acctNo){
        
        this.accountNo = acctNo;
        
    }
    
    public void setAccountBalance(double acctBal){
        
        this.accountBalance = acctBal;
        
    }
    
    
    synchronized public void deposit(double value, User u){
        
        this.accountBalance += value;
        System.out.println("User " + u.getName() + " " + u.getSurname() + " has deposited " + "£" + value + " into the account. " + "The current account balance is " + this.accountBalance + "\n");
        //System.out.println("The current account balance is " + this.accountBalance);
        //System.out.println(" ");
        
    }
    
    synchronized public void withdraw(double value, User u){
        try{
        if ((-value) <= this.accountBalance){
        this.accountBalance -= (-value);
        System.out.println("User " + u.getName() + " " + u.getSurname() + " has withdrawn " + "£" + -value + " from the account. " + "The current account balance is " + this.accountBalance + "\n");
        //System.out.println("The current account balance is " + this.accountBalance);
        } else {
            System.out.println("Insufficient funds. " + u.getName() + " " + u.getSurname() + "'s withdrawal of " + "£" + -value + "cannot be processed. Continuing to next transaction.");

        }
        } catch(Exception e){
           
        }
        //System.out.println(" ");
    }
    
    public void createAccount() {
        
        this.accountNo = 9876543210L;
        this.accountBalance = 1980;
        System.out.println("Account created with Account No. " + this.accountNo + " and balance " + "£" + this.accountBalance);
        
    }
    
    
}
