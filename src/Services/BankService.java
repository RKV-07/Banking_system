package Services;
import models.Account;
import models.SavingsAccount;
import models.CurrentAccount;
import java.util.HashMap;
import java.util.Map;

/**
 * Bank Service class for handiling multiple Accounts
 */

public class BankService {
    private Map<String,Account> accounts;
    public BankService(){
        this.accounts= new HashMap<>();
    }
    public void createSavingsAccount(String accountNumber , String accountHolderName,double initialBalance,double intrestRate){
        if (!accounts.containsKey(accountNumber)){
            SavingsAccount account = new SavingsAccount(accountNumber,accountHolderName,initialBalance,intrestRate);
            accounts.put(accountNumber,account);
            System.out.println("Savings account created successfully");
        }else{
            System.out.println("Account number already Exists");
        }
    }
    public void createCurrentAccount(String accountNumber , String accountHolderName,double initialBalance,double overdraftlimit){
        if (!accounts.containsKey(accountNumber)){
            CurrentAccount account = new CurrentAccount(accountNumber,accountHolderName, initialBalance, overdraftlimit);
            accounts.put(accountNumber,account);
            System.out.println("Current account created successfully");
        }else{
            System.out.println("Account number already Exists");
        }
    }
    public Account getAccount(String accountNumber){
        return accounts.get(accountNumber);
    }
    public void displayAllAccounts(){
        System.out.println("\n---All Accounts ---");
        for (Account account : accounts.values()){
            account.displayAccountInfo();
            System.out.println("------------------");
        }
    }






}
