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
public class transactionRun extends Thread {
    
    private User bankUser;
    
    public transactionRun (User newBankUser){
        this.bankUser = newBankUser;
    }
    
    public void run(){
        
        double[] runTransactionList = bankUser.getTransactionList();
        BankAccount bA = bankUser.getAccount();
        
        for(double transaction : runTransactionList){
            if(transaction < 0){
                bA.withdraw(transaction, bankUser);
            } else {
                bA.deposit(transaction, bankUser);
            }
        }
        
        
    }
    
}
