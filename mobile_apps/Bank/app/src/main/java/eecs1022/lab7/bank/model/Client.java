package eecs1022.lab7.bank.model;

import java.util.Objects;

public class Client {

    // Attributes
    private String name;
    private double balance;
    private String[] statFullArray; // Array used to store statements of transactions of clients as String.
    private String[] statBackup; // Will be used to take non-null indices of statFullArray
    private int countStat;
    /*--------------------------------------------------------------------*/

    // Constructor
    public Client(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.statFullArray = new String[11];
        this.countStat = 1;
    }

    /*--------------------------------------------------------------------*/


    // Accessor
    public String getStatus() {
        String result = "";
        result = this.name + ": $" + String.format("%.2f",this.balance);
        this.statFullArray[0] = result; // Because we change the 0 index regularly, that's why we haven't used this.countStat.
        return result;
    }

    public String[] getStatement() {
        this.statBackup = new String[this.countStat];
        for (int i = 0; i < this.countStat; i ++ ){ // statBackup array is taking non-null indices of statFullArray
            this.statBackup[i] = this.statFullArray[i];
        }
        return this.statBackup;
    }

    // Helper method by me

    public String getName() {
        return this.name;
    }

    /*--------------------------------------------------------------------*/

    // Mutator
    public void deposit(double addAmount) {
        this.balance += addAmount;
        this.statFullArray[this.countStat] = "Transaction DEPOSIT: $" + String.format("%.2f", addAmount);
        this.countStat ++;
    }

    public void withdraw(double removeAmount) {
        this.balance -= removeAmount;
        this.statFullArray[this.countStat] = "Transaction WITHDRAW: $" + String.format("%.2f", removeAmount);
        this.countStat ++;

    }
}















