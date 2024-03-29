package eecs1022.lab7.bank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import eecs1022.lab7.bank.model.Bank;

public class MainActivity extends AppCompatActivity {

    /* Hint: How do you share the same bank object between button clicks (attached with controller methods) of the app? */
    Bank bank; // Attribute type bank has been declared so we can use its methods here.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Hint: How do you initialize an empty bank and displays its status to the output textview
         * when the app is first launched?
         */
        bank = new Bank(); // When first launched a bank with no clients added will be created.
        setContentsOfTextView(R.id.labelOutput, bank.getStatus());

    }

    /* this mutator sets the output label */
    private void setContentsOfTextView(int id, String newContents) {
        View view = findViewById(id);
        TextView textView = (TextView) view;
        textView.setText(newContents);
    }

    /* this accessor retrieves input entered on the text view  */
    private String getInputOfTextField(int id) {
        View view = findViewById(id);
        EditText editText = (EditText) view;
        String input = editText.getText().toString();
        return input;
    }

    /* this accessor retrieves input chosen from some spinner (drop-down menu) */
    private String getItemSelected(int id) {
        View view = findViewById(id);
        Spinner spinner = (Spinner) view;
        String string = spinner.getSelectedItem().toString();
        return string;
    }

    /* Hints on controller methods:
     *
     * Declare two controller methods, each of which declared with a parameter with type View (see Week 9 Tutorials).
     *  - One method (say cm1) should be attached to the "ADD A NEW ACCOUNT" button,
     *      whereas the other method (say cm2) should be attached to the "CONFIRM" button.
     *
     *  - Controller method cm1 should:
     *    + Retrieve the name of client and the initial balance in the corresponding textfields.
     *      You may need to convert the retrieved text, e.g., "23.4" to a double value using Double.parseDouble.
     *    + Then, invoke the relevant method on the shared bank object to add a new client/account accordingly.
     *    + Finally, display the status of the bank to the output textview.
     *
     * - Controller method cm2 should:
     *    + Retrieve the chosen service type listed in the spinner (Deposit, Withdraw, Transfer, Print Statement)
     *    + Depending on the service type chosen, retrieve the from-account, to-account, and/or amount accordingly.
     *      (See the "Assumed Usage Pattern of the App" section in your Lab7 PDF instructions)
     *    + Then, invoke the relevant method(s), depending on the chosen service type, on the shared bank object.
     *    + Finally, display the status of the bank (in the case of a deposit, withdraw, or transfer)
     *          or the statement of an account (in the case of print statement) to the ouptut textview.
     */

    public void buttonAddaNewAccount(View view) {
        String name = getInputOfTextField(R.id.inputName); // Retrieved name.
        String balanceString = getInputOfTextField(R.id.inputBalance); // Retrieved balance in String.
        double balanceDouble = Double.parseDouble(balanceString); // Changing String to double
        bank.addClient(name, balanceDouble);

        String output = bank.getStatus();
        setContentsOfTextView(R.id.labelOutput, output);
    }

    public void buttonConfirm(View view) {
            String inputSpinner = getItemSelected(R.id.spinnerServices);
            String stringStatement = "";
            String fromName = getInputOfTextField(R.id.inputFromAccount); // retrieved name

            // We have 4 conditions on spinner, therefore, we have apply different instructions for each one of them.
            if (inputSpinner.equals("Print Statement")) {
                String[] fromNameStatement = bank.getStatement(fromName);
                for (int i = 0; i < fromNameStatement.length; i ++) {   // Takes the statement according to the entered name by the user, which has all the information including the balance, the withdrawal amount, and the amount that has been deposited.
                    stringStatement += fromNameStatement[i] + "\n";
                }
                setContentsOfTextView(R.id.labelOutput, stringStatement);
            }
            else if (inputSpinner.equals("Deposit")) {
               String nameToAccount = getInputOfTextField(R.id.inputToAccount);
               String transacAmountString = getInputOfTextField(R.id.inputAmount);
               double transacAmountDouble = Double.parseDouble(transacAmountString);
               bank.deposit(nameToAccount, transacAmountDouble);
               setContentsOfTextView(R.id.labelOutput, bank.getStatus());
            }
            else if (inputSpinner.equals("Withdraw")) {
                String nameFromAccoubt = getInputOfTextField(R.id.inputFromAccount);
                String transacAmountString = getInputOfTextField(R.id.inputAmount);
                double transacAmountDouble = Double.parseDouble(transacAmountString);
                bank.withdraw(nameFromAccoubt, transacAmountDouble);
                setContentsOfTextView(R.id.labelOutput, bank.getStatus());
            }
            else if (inputSpinner.equals("Transfer")) {
                String nameFrom = getInputOfTextField(R.id.inputFromAccount);
                String nameTo = getInputOfTextField(R.id.inputToAccount);

                String transacAmountString = getInputOfTextField(R.id.inputAmount);
                double transacAmountDouble = Double.parseDouble(transacAmountString);

                bank.transfer(nameFrom, nameTo, transacAmountDouble);
                setContentsOfTextView(R.id.labelOutput, bank.getStatus());

            }
    }
	
}
