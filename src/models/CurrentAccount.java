package models;

public class CurrentAccount extends Account {
    private double overdraftlimit;

    public CurrentAccount(String accountNumber, String accountHolderName, double initalBalance , double overdraftlimt){
        super(accountNumber,accountHolderName,initalBalance);
        this.overdraftlimit=overdraftlimit;

    }
    // Polymorphism of different implementation of withdraw
    @Override
    public void withdraw(double ammount){
        if (ammount>0){
            double newBalance = getBalance()- ammount;
            if (newBalance >= -overdraftlimit){
                setBalance(newBalance);
                addTransaction("Withdrawn:$"+ ammount);
                System.out.println("Successfully withdrew $"+ammount);
                if (newBalance < 0){
                    System.out.println("Warning : Account in overdraft");

                }
            }else{
                System.out.println(" withdrawal denied ! Overdraft limit exceeded");
            }
        }else {
            System.out.println("Invalid Withdrawl  ammount!");
        }
    }
    public  double getOverdraftlimit(){
        return overdraftlimit;
    }
    @Override
    public void displayAccountInfo(){
        super.displayAccountInfo();
        System.out.println("Overdraft limit : $"+ overdraftlimit);
    }














}
