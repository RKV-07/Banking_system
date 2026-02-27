package models;

import java.sql.SQLOutput;

public  class SavingsAccount extends Account {
    /**
     * Savings account deplicts the OOPS pillar of inheritance
     * this will inherit From Account and Adds saving specific features
     */
    private double intrestRate;
    private double minimumBalance;

    public SavingsAccount(String accountNumber, String accountHolderName, double initialBalance , double intrestRate){
        // Inheritance by calling parent constructor using super()
        super(accountNumber,accountHolderName,initialBalance);
        this.intrestRate = intrestRate;
        this.minimumBalance=100.0; // assume 100 bucks as an minimum balance requirement
    }
    // using Polymorphism by Method Overriding
    @Override
    public void withdraw(double ammount){

        if(ammount > 0) {
            double newBalance = getBalance() - ammount;
            if (newBalance >= minimumBalance) {
                setBalance(newBalance);
                addTransaction("WithDrawn: $" + ammount);
                System.out.println("Successfully withdrew $" + ammount);
            } else {
                System.out.println("Withdrawal denied! Minimum balance requirement not met");

            }
        }
        else{
                System.out.println("invlaid Withdrawal ammount!");
            }

    }
    // specific method for saving account
    public void applyIntrest(){
        double intrest = getBalance()+intrestRate/100;
        setBalance(getBalance()+intrest);
        addTransaction("Intrest applied :$"+intrest);
        System.out.println("Intrest of $"+ intrest + "applied to account");
    }
    public double getIntrestRate(){
        return intrestRate;
    }
    @Override
    public void displayAccountInfo(){
        super.displayAccountInfo(); // resuing the parent method
        System.out.println("intrest Rate:"+ intrestRate+"%");
        System.out.println("Minimum Balance :$"+ minimumBalance);
    }













}