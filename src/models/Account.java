package models;

import java.util.ArrayList;
import java.util.List;

/** this is shows the utilization of encapsulation
 * Usage of private instance variables , getters and setters
 */

public abstract class Account {
    private String accountNumber;
    private String accountHolderName;
    private double balance;
    private List<String> transactionHistory;

    // Constructor
public Account(String accountNumber , String accountHolderName , double initialBalance){
            this.accountNumber=accountNumber;
            this.accountHolderName=accountHolderName;
            this.balance=initialBalance;
            this.transactionHistory= new ArrayList<>();
            addTransaction(" Account created with intial balance: $"+ initialBalance);
}
// Encapsulation : Public getter
    public String getAccountNumber() {
                return accountNumber;
    }
    public String getAccountHolderName() {
                return accountHolderName;
    }



}



