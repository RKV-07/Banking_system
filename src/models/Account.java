package models;

import java.util.ArrayList;
import java.util.List;

/** this is shows the utilization of encapsulation
 * Usage of private instance variables , getters and setters
 * this is one of the fundamental pillar's of object oriented programming
 */

public abstract class Account {
    // Encapsulation of private field i.e which are not meant to see by user
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private List<String> transactionHistory;

    // Constructor
    public Account(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
        this.transactionHistory = new ArrayList<>();
        addTransaction(" Account created with initial balance: $" + initialBalance);
    }

    // Encapsulation : Public getter
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }
//  this provides the return copy for encapsulation
    public List<String> getTransactionHistory() {
        return new ArrayList<>(transactionHistory);         // the copy of the encapsulation
    }

    // protected setter for derived classes
    protected void setBalance(double balance) {
        this.balance = balance;
    }

    protected void addTransaction(String transaction) {
        String timestamp = java.time.LocalDateTime.now().format(java.time.format.DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        transactionHistory.add("[" + timestamp + "] " + transactionHistory);
    }

    public abstract void withdraw(double amount); // for child classes

    public void deposit(double amount) {
        if (amount > 0) {
            addTransaction("Deposited : $" + amount);
            System.out.println("Successfully Deposited : $" + amount);
        } else {
            System.out.println("Invalid Deposit amount!!!");
        }

    }

    public void displayAccountInfo() {
        System.out.println("<== Account Info ==>");
        System.out.println("Account Number:" + accountNumber);
        System.out.println("Account HolderName:" + accountHolderName);
        System.out.println("Balance: $" + balance);
        System.out.println("AccountType:" + this.getClass().getSimpleName());
    }

    public void displayTransactionHistory() {
        System.out.println("<==TransactionHistory==>");
        if (transactionHistory.isEmpty()) {
            System.out.println("No TransactionHistory");
        } else {
            for (String Transaction : transactionHistory) {
                System.out.println(Transaction);
            }
        }
    }






































}






