package eecs1022.lab7.bank.model;

public class Bank {

    // Attributes
    private final Client[] clients;
    private int numClient;
    private String errorMsg;
    private boolean errorExist;  // this is a very essential variable! if there's any errors in the code this will be set to true so it could be used in the getStatus method.
    /*--------------------------------------------------------------------*/

    // Constructor
    public Bank() {
        this.clients = new Client[6]; // Max number of clients in the bank is 6
        this.errorExist = false;
    }

    /*--------------------------------------------------------------------*/

    // Accessor
    public String getStatus() {
        String result = "";
        String seq = "Accounts: {";

        for (int i = 0; i < this.numClient; i ++) {
            if (i < this.numClient - 1) {
                seq += this.clients[i].getStatus() + ", ";
            }
            else {
                seq += this.clients[i].getStatus();
            }
        }
        result = seq;
        result += "}";

        if (this.errorExist) {
            result = this.errorMsg;
        }

        return result;
    }

    public String[] getStatement(String name) {
        String[] tempName = null;
        boolean found = false;
        for (int i = 0; i < this.numClient; i ++) {
            if (this.clients[i].getName().equals(name)) {
                tempName = this.clients[i].getStatement();
                found = true; // This help us determine if heeyon exists or not - mainly for the error message
            }
        }

        if (!found) {
            String errorDoesntExits = "Error: From-Account " + name + " does not exist";
            changeErrorMsg(errorDoesntExits);
            this.errorExist = true;
        }
        return  tempName;
    }

    /*--------------------------------------------------------------------*/


    // Mutator
    public  void deposit(String name, double amount) {
        boolean found = false;
        this.errorExist = false;

        for (int i = 0; i < this.numClient; i ++) {
            if (this.clients[i].getName().equals(name) && amount > 0) {
                this.clients[i].deposit(amount); // deposits the amount to the account that matched the given argument name.
                found = true;
                break;
            }
            else if (this.clients[i].getName().equals(name) && amount <= 0){
                found = true;
                break;
            }
        }

        if (!found){
            changeErrorMsg("Error: To-Account " + name + " does not exist");
            this.errorExist = true;
        }
        else if (amount <= 0) {
            changeErrorMsg("Error: Non-Positive Amount");
            this.errorExist = true;
        }

    }

    public void withdraw(String name, double amount) {
        boolean found = false;
        this.errorExist = false;
        Client tempClient = null;

        for (int i = 0; i < this.numClient; i ++) {
            if (this.clients[i].getName().equals(name) && amount > 0 && amount < this.clients[i].getBalance()) {
                this.clients[i].withdraw(amount); // Withdraw the amount to the account that matched the given argument name.
                tempClient = this.clients[i];
                found = true;
                break;
            }
            else if (this.clients[i].getName().equals(name) && amount <= 0){
                found = true;
                break;
            }
            else if (this.clients[i].getName().equals(name) && amount > 0 && this.clients[i].getBalance() < amount){
                tempClient = this.clients[i];
                found = true;
                break;
            }
        }

        if (!found){
            changeErrorMsg("Error: From-Account " + name + " does not exist");
            this.errorExist = true;
        }
        else if (amount <= 0) {
            changeErrorMsg("Error: Non-Positive Amount");
            this.errorExist = true;
        }
        else if (found && (tempClient.getBalance() < amount )) {
            changeErrorMsg("Error: Amount too large to withdraw");
            this.errorExist = true;
        }
    }

    public  void transfer(String fromName, String toName, double amount) {
        boolean foundFrom = false;
        boolean foundTo = false;
        this.errorExist = false;
        Client tempClient = null;

        // Used to find if fromName exists - and withdrawing
        for (int i = 0; i < this.numClient; i ++) {
            if (this.clients[i].getName().equals(fromName) && amount > 0 && this.clients[i].getBalance() > amount) {
                this.clients[i].withdraw(amount); // Withdraws from account --> deposits to account in line #117
                tempClient = this.clients[i];
                foundFrom = true;
                break;
            }
            else if (this.clients[i].getName().equals(fromName) && amount <= 0){
                foundFrom = true;
                break;
            }
            else if (this.clients[i].getName().equals(fromName) && amount > 0 && this.clients[i].getBalance() < amount){
                foundFrom = true;
                tempClient = this.clients[i];
                break;
            }
        }


        // Used to find if toName exists
        for (int i = 0; i < this.numClient; i ++) {
            if (this.clients[i].getName().equals(toName)) {
                foundTo = true;
                break;
            }
        }

        // if fromName exists then it will deposit to toFrom
        if (foundFrom && foundTo) {
            for (int i = 0; i < this.numClient; i ++) {
                if (this.clients[i].getName().equals(toName) && amount > 0 && tempClient.getBalance() > amount) {
                    this.clients[i].deposit(amount);
                    break;
                }
            }
        }



        if (!foundFrom){
            changeErrorMsg("Error: From-Account " + fromName + " does not exist");
            this.errorExist = true;
        }
        else if (!foundTo) {
            changeErrorMsg("Error: To-Account " + toName + " does not exist");
            this.errorExist = true;
        }
        else if (amount <= 0) {
            changeErrorMsg("Error: Non-Positive Amount");
            this.errorExist = true;
        }
        else if (foundFrom && (tempClient.getBalance() < amount)) {
            changeErrorMsg("Error: Amount too large to transfer");
            this.errorExist = true;
        }
    }

    public void addClient(String name, double balance) {
        this.errorExist = false;
        boolean found = false;
        boolean added = false;


        for (int i = 0; i < this.numClient; i ++) { // checks if that client is already in the bank array. by comparing the name
            if (this.clients[i].getName().equals(name)) {
                found = true;
                break;
            }
        }
        if (this.numClient < 6 && !found && balance > 0) {
            this.clients[this.numClient] = new Client(name, balance);
            this.numClient ++;
            added = true; // If it was addition to a valid index
        }
        else if (this.numClient <= 6 && !found) {
            added = false; // if indices were full and no more room to be added
        }


        if (this.numClient > 5 && !added) { // This *boolean variable [added]* is overloaded - if the purpose of the user was to add more clients and the bank array was full, then it [added] would be false from previous if-statement and would be false. therefore !added will make it true.
            changeErrorMsg("Error: Maximum Number of Accounts Reached");  // if the purpose of the user was to just getStatus and not add any more client the added from previous if statement would be true which will make !added false causing the getStatus to raise an error. --- > Debug for further clearance.
            this.errorExist = true;
        }
        else if (found){
            changeErrorMsg("Error: Client " + name + " already exists");
            this.errorExist = true;
        }
        else if (balance <= 0) {
            changeErrorMsg("Error: Non-Positive Initial Balance");
            this.errorExist = true;

        }
    }

    // Helper method
    public void changeErrorMsg(String newError) { // vital one - used to change the error message so different error messages is covered.
        this.errorMsg = newError;
    }
}












