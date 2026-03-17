import models.Account;
import models.SavingsAccount;
import models.CurrentAccount;
import Services.BankService;
import java.util.Scanner;

/**
 * This is the main class where our code combines and runs
 */

public class Main {
    public static void main(String[] args) {
        BankService bankService = new BankService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bank Management System");

        // Create a sample accounts
        bankService.createSavingsAccount("SA001","Alice",1000.0,2.5);
        bankService.createCurrentAccount("CA001","BOB",500.0,200);
        boolean running =true;

        while (running){
            System.out.println("\n --Main Menu --");
            System.out.println("1.Create Savings Account");
            System.out.println("2.Create Current Account");
            System.out.println("3.Deposit Money");
            System.out.println("4.Withdraw Money");
            System.out.println("5.Check Balance ");
            System.out.println("6.View Transaction History");
            System.out.println("7.Apply Intrest (Savings)");
            System.out.println("8.View All Accounts");
            System.out.println("9.Exit");
            System.out.println("Choose an Option:");
            int choice =scanner.nextInt();
            scanner.nextLine(); // takes the valve of next line
            switch (choice){
                case 1:
                    createSavingsAccount(bankService,scanner);
                    break;
                case 2:
                    createCurrentAccount(bankService,scanner);
                    break;
                case 3:
                    performDeposit(bankService,scanner);
                    break;
                case 4:
                    performWithdrawnal(bankService,scanner);
                    break;
                case 5:
                    checkBalance(bankService,scanner);
                    break;
                case 6:
                    viewTransactionHistory(bankService,scanner);
                    break;
                case 7:
                    applyIntrest(bankService,scanner);
                    break;
                case 8:
                    bankService.displayAllAccounts();
                    break;
                case 9:
                    running = false;
                    System.out.println("Thank you for Using our banking systems");
                    break;
                default:
                    System.out.println("Invalid option ! Please try again.");
            }

        }

        scanner.close();




    }
    private static void createSavingsAccount(BankService bankService, Scanner scanner){
        System.out.print("Enter account number:");
        String accNumber = scanner.nextLine();
        System.out.print("Enter account holder name:");
        String name = scanner.nextLine();
        System.out.print("Enter inital balance:");
        double balance = scanner.nextDouble();
        System.out.print("Enter intreset rate:");
        double intrestRate = scanner.nextDouble();

        bankService.createSavingsAccount(accNumber,name,balance,intrestRate);
    }
    private static  void createCurrentAccount(BankService bankService,Scanner scanner){
        System.out.print("Enter account number:");
        String accNumber = scanner.nextLine();
        System.out.print("Enter account holder name:");
        String name = scanner.nextLine();
        System.out.print("Enter inital balance:");
        double balance = scanner.nextDouble();
        System.out.print("Enter intreset rate:");
        double overdraft = scanner.nextDouble();

        bankService.createCurrentAccount(accNumber,name,balance,overdraft);
    }
    private static void performDeposit(BankService bankService, Scanner scanner) {
        System.out.print("Enter account number: ");
        String accNumber = scanner.nextLine();
        Account account = bankService.getAccount(accNumber);

        if (account != null) {
            System.out.print("Enter deposit amount: ");
            double amount = scanner.nextDouble();
            account.deposit(amount);
        } else {
            System.out.println("Account not found!");
        }
    }
    private static void performWithdrawnal(BankService bankService,Scanner scanner){
        System.out.print("Enter account number:");
        String accNumber = scanner.nextLine();
        Account account = bankService.getAccount(accNumber);

        if(account != null) {
            System.out.print("Enter wihdrawl ammount:");
            double amount = scanner.nextDouble();
            account.withdraw((amount));
        }else {
            System.out.println("Account not Found!");
        }
    }
    private static void checkBalance(BankService bankService,Scanner scanner){
        System.out.print("Enter account number:");
        String accNumber = scanner.nextLine();
        Account account = bankService.getAccount(accNumber);

        if(account != null) {
            account.displayAccountInfo();
        }else {
            System.out.println("Account not Found!");
        }
    }
    private  static void viewTransactionHistory(BankService bankService, Scanner scanner){
        System.out.print("Enter account number:");
        String accNumber = scanner.nextLine();
        Account account = bankService.getAccount(accNumber);
        if(account != null) {
            account.displayTransactionHistory();
        }else {
            System.out.println("Account not Found!");
        }
    }
    private static void applyIntrest(BankService bankService,Scanner scanner){
        System.out.print("Enter account number:");
        String accNumber = scanner.nextLine();
        Account account = bankService.getAccount(accNumber);
        if(account instanceof SavingsAccount){
            ((SavingsAccount)account).applyIntrest();

        } else if (account != null) {
            System.out.println("This feature is only for savings accounts!");


        }else {
            System.out.println("account not found");
        }
    }





















}

