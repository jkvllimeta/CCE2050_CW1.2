/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cce2050_cw2;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
/**
 *
 * @author Joseph
 */
public class CCE2050_CW2 extends Thread{
   
   static Scanner s = new Scanner(System.in);
   static BankAccount simAccount = new BankAccount();
   static ArrayList<transactionRun> transactionThreads = new ArrayList<transactionRun>();
   static transactionRun saulGoodmanThread;
   static transactionRun walterWhiteThread;
   static transactionRun jessiePinkmanThread;
   static transactionRun hankSchraderThread;
   static ExecutorService exec = Executors.newCachedThreadPool();
   /*static double[] userTransactions[] = {
       {50,10,-20,10,-20,20,10,50,-10,10,-10,50},
       {20,20,-20,50,-20,10,50,50,-20,10,10},
       {50,10,10,-10,-10,50,20,10,20},
       {50,10,-20,20,10,-20}
   };*/
   
   //static ArrayList<ArrayList<Double>> userTransactionAL = new ArrayList<ArrayList<Double>>();
   static ArrayList<Double> saulTransactions = new ArrayList<Double>(Arrays.asList
   ((double)50,(double)10,(double)-20,(double)10,(double)-20,(double)20,(double)10,(double)50,(double)-10,(double)10,(double)-10,(double)50));
   static ArrayList<Double> walterTransactions = new ArrayList<Double>(Arrays.asList
   ((double)20,(double)20,(double)-20,(double)50,(double)-20,(double)10,(double)50,(double)50,(double)-20,(double)10,(double)10));
   static ArrayList<Double> jessieTransactions = new ArrayList<Double>(Arrays.asList
   ((double)50,(double)10,(double)10,(double)-10,(double)-10,(double)50,(double)20,(double)10,(double)20));
   static ArrayList<Double> hankTransactions = new ArrayList<Double>(Arrays.asList
   ((double)50,(double)10,(double)-20,(double)20,(double)10,(double)-20));
   
   static ArrayList<ArrayList<Double>> userTransactionAL = 
           new ArrayList<ArrayList<Double>>(Arrays.asList(saulTransactions, walterTransactions,jessieTransactions,hankTransactions));
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        Menu();
        
        
    }
    
    public static void Menu () {
        
        char choice1;
        
        System.out.println("------------------------------Bank Menu------------------------------");
        System.out.println("Enter the number of the action you wish to perform:");
        System.out.println("1. Create Bank Account");
        System.out.println("2. Create User");
        System.out.println("3. Run Simulation (Press M then Enter to go back to the Main Menu once trasactions are complete)");
        System.out.println("4. Exit");
        
        
        choice1 = s.next().toLowerCase().charAt(0);
        System.out.println(choice1);
        
        
        switch(choice1){
            case '1':
                createBankAccount();
                //Menu();
                break;
            
            case '2':
                createUser();
                break;
            
            case '3':
                
                System.out.println("Initial bank balance is: " + simAccount.getAccountBalance());
                
                if(transactionThreads.isEmpty()){
                    System.out.println("No users found. Please create users first.\n");
                    Menu();
                } else{
                
                    for (transactionRun tThread : transactionThreads){
                    
                    exec.submit(tThread);
                    
                    }
                }
                break;
                        
                
            case '4':
                System.exit(0);
                
            case 'm':
                Menu();
                
            default:
                Menu();
        }   
        
        Menu();
        
    }
    
    
    /*Menu developed for creating preset and custom users*/
    
    public static void createUser(){
        
        char ch2;
        char ch3;
        
        System.out.println("Would you like to create a preset User or make a custom User?");
        System.out.println("1. Create preset User");
        System.out.println("2. Create custom User");
        System.out.println("3. Go back to Main Menu");
        System.out.println("4. Exit Program");
        ch2 = s.next().charAt(0);
        
        switch(ch2){
            
            //Submenu for creating preset users
            case '1':
                System.out.println("Choose the accounts you wish to create");
                System.out.println("1. Create Saul Goodman");
                System.out.println("2. Create Walter White");
                System.out.println("3. Create Jessie Pinkman");
                System.out.println("4. Create Hank Schrader");
                System.out.println("5. Create All");
                System.out.println("6. Return to Create User Menu");
                
                ch3 = s.next().charAt(0);
                
                switch(ch3){
                    case '1':
                        User sGoodman = new User("Saul", "Goodman", simAccount, saulTransactions);
                        saulGoodmanThread = new transactionRun(sGoodman);
                        System.out.println("User " + sGoodman.getName() + " " + sGoodman.getSurname() + " has been created successfully" + "\n");
                        transactionThreads.add(saulGoodmanThread);
                        break;
                    
                    
                    
                    case '2':
                        
                        User wWhite = new User("Walter", "White", simAccount, walterTransactions);
                        walterWhiteThread = new transactionRun(wWhite);
                        System.out.println("User " + wWhite.getName() + " " + wWhite.getSurname() + " has been created successfully" + "\n");
                        transactionThreads.add(walterWhiteThread);
                        break;
                        
                    case '3':
                        
                        User jPinkman = new User("Jessie", "Pinkman", simAccount, jessieTransactions);
                        jessiePinkmanThread = new transactionRun(jPinkman);
                        System.out.println("User " + jPinkman.getName() + " " + jPinkman.getSurname() + " has been created successfully" + "\n");
                        transactionThreads.add(jessiePinkmanThread);
                        break;
                        
                    case '4':
                        
                        User hSchrader = new User("Hank", "Schrader", simAccount, hankTransactions);
                        hankSchraderThread = new transactionRun(hSchrader);
                        System.out.println("User " + hSchrader.getName() + " " + hSchrader.getSurname() + " has been created successfully" + "\n");
                        transactionThreads.add(hankSchraderThread);
                        break;
                    
                    case '5':
                        
                        sGoodman = new User("Saul", "Goodman", simAccount, saulTransactions);
                        saulGoodmanThread = new transactionRun(sGoodman);
                        System.out.println("User " + sGoodman.getName() + " " + sGoodman.getSurname() + " has been created successfully" + "\n");
                        transactionThreads.add(saulGoodmanThread);
                        
                        wWhite = new User("Walter", "White", simAccount, walterTransactions);
                        walterWhiteThread = new transactionRun(wWhite);
                        System.out.println("User " + wWhite.getName() + " " + wWhite.getSurname() + " has been created successfully" + "\n");
                        transactionThreads.add(walterWhiteThread);
                        
                        jPinkman = new User("Jessie", "Pinkman", simAccount, jessieTransactions);
                        jessiePinkmanThread = new transactionRun(jPinkman);
                        System.out.println("User " + jPinkman.getName() + " " + jPinkman.getSurname() + " has been created successfully" + "\n");
                        transactionThreads.add(jessiePinkmanThread);
                        
                        hSchrader = new User("Hank", "Schrader", simAccount, hankTransactions);
                        hankSchraderThread = new transactionRun(hSchrader);
                        System.out.println("User " + hSchrader.getName() + " " + hSchrader.getSurname() + " has been created successfully" + "\n");
                        transactionThreads.add(hankSchraderThread);
                        
                        break;
                    
                    case '6':
                        createUser();
                }
                break;
                
            //Custom user submenu
            case '2':
                int transactionIndex = 0;
                String newUserFirstName;
                String newUserSurname;
                ArrayList<Double> newTransactionList = new ArrayList<Double>();
                char whileChoice;
                transactionRun userThread;
                
                System.out.println("Please enter the first name of the User: ");
                newUserFirstName = s.next();
                
                System.out.println("Please enter the surname of the User: ");
                newUserSurname = s.next();
                
                System.out.println("Please enter your first transaction: ");
                System.out.println("Positive no = Deposit, Negative no = Withdraw ");
                double tempTransaction = s.nextDouble();
                newTransactionList.add(tempTransaction);
                
                System.out.println("Would you like to add another transaction?");
                System.out.println("Y/N?");
                whileChoice = s.next().toLowerCase().charAt(0);
                
                while(whileChoice == 'y'){
                System.out.println("Please enter your transaction: ");
                System.out.println("Positive no = Deposit, Negative no = Withdraw ");
                tempTransaction = s.nextDouble();
                newTransactionList.add(tempTransaction);
                
                System.out.println("Would you like to add another transaction?");
                System.out.println("Y/N?");
                whileChoice = s.next().toLowerCase().charAt(0);
                }
                
                User newUser = new User(newUserFirstName, newUserSurname, simAccount, newTransactionList);
                
                userThread = new transactionRun(newUser);
                System.out.println("User Account " + newUserFirstName + " " + newUserSurname + " created successfully.");
                transactionThreads.add(userThread);
                
                break;
            
            default:
                createUser();
                
        }
        Menu();
    }
    
    public static void createBankAccount(){
        
        //Bank Account initial balance is zero
        
        long newAcctNo;
        double newAcctBal;
        
        char ch4;
        
        System.out.println("Would you like to create a preset or custom Bank Account?");
        System.out.println("1. Create preset Bank Account");
        System.out.println("2. Create custom Bank Account");
        System.out.println("3. Go back to Main Menu");
        System.out.println("4. Exit Program");
        ch4 = s.next().charAt(0);
        
        switch(ch4){
            
            case '1':
                simAccount.createAccount();
                System.out.println("Bank Account successfully created\n");
                
                break;
                
                
            case '2':
                System.out.println("Please enter a Bank Account Number: ");
                newAcctNo = s.nextLong();
                simAccount.setAccountNo(newAcctNo);
                
                System.out.println("Please enter Bank Account Balance: ");
                newAcctBal = s.nextDouble();
                simAccount.setAccountBalance(newAcctBal);
                
                System.out.println("Bank Account with Account No. " + newAcctNo + " containing " + newAcctBal + " created successfully.\n");
                
                break;
                
            case '3':
                Menu();
                break;
                
            case '4':
                System.exit(0);
                
            default:
                createBankAccount();
                
        }
            
        createBankAccount();
        
    }
    
}
