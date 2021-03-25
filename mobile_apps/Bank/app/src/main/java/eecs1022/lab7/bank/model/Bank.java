package eecs1022.lab7.bank.model;

public class Bank {

    // Attributes
    private Client[] clients;
    private int numClient;
    private String errorMsg;
    /*--------------------------------------------------------------------*/

    // Constructor
    public Bank() {
        this.clients = new Client[6];
    }

    /*--------------------------------------------------------------------*/

    // Accessor
    public String getStatus() {
        return  this.errorMsg;
    }

    public String[] getStatement(String name) {
        return  null;
    }

    /*--------------------------------------------------------------------*/


    // Mutator
    public  void deposit(String name, double amount) {
    }

    public void withdraw(String name, double amount) {

    }

    public  void transfer(String fromName, String toName, double amount) {

    }

    public void addClient(String name, double balance) {
//        this.clients[this.numClient]
        boolean stay = true;
        if (this.numClient >= 6) {
            this.errorMsg = "Error: Maximum Number of Accounts Reached";
        }
        else if (this.numClient > 0 && this.numClient < 6) {
            for (int i = 0; stay && i < this.numClient; i ++) {
                if (this.clients[i].getName().equals(name)) {
                    this.errorMsg = "Error: Client " + name + " already exists";
                    stay = false; // early exit
                }
            }
            this.numClient ++;
        }
        else if (balance <= 0) {
            this.errorMsg = "Error: Non-Positive Initial Balance";
        }

    }
}












