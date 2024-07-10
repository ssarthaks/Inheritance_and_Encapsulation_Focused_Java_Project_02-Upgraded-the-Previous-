/**
 * BankGUI Class
 *
 * @author (Sarthak Sharma C13)
 * @Coursework (Java Programming Coursework)
 */
import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;

public class BankGUI implements ActionListener
{
    //Delaring array list of type Bankcard
    ArrayList<Bankcard> bankCards = new ArrayList<Bankcard>();
    //Declaring the objects of Creditcard and  Debitcard classes
    Debitcard debtobj;
    Creditcard credobj;
    //declaring of variables req for the GUI
    private JFrame jf;
    private JPanel jp;
    private JTextField cardid_tf,clientname_tf,bankissued_tf,bankacc_tf,balamt_tf,pinnum_tf,withdrawamt_tf,cvcnum_tf,interestrate_tf,graceperiod_tf,creditlimit_tf;
    private JLabel title1,title2,subtitle1,subtitle2,subtitle3,cardid,clientname,bankissued,bankacc,balamt,pinnum,cvcnum,withdrawamt,withdrawdate,creditlim,interestrate,graceperiod,credit_expdate,addtocreditcard_req,addtodebitcard_req,withdrawdebitcard_req,setcreditlimit_req,cancelcreditcard_req,backgroundimg;
    private JButton adddebitcard_jb,withdrawdebitcard_jb,addcreditcard_jb,setcreditlimit_jb,cancelcreditcard_jb,displaycreditcard_jb,displaydebitcard_jb,clear_jb;
    private JComboBox<String> credit_exp_month_cb,credit_exp_year_cb,debit_withdraw_day_cb,debit_withdraw_month_cb,debit_withdraw_year_cb;
    //Creating constructor and creating GUI here
    public BankGUI()
    {
        //Storing data into array to access for combobox
        String dayarray[]={"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        String montharray[]={"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
        String yeararray[]={"2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030"};
        
        jf = new JFrame();
        jp = new JPanel();
        
        //setting image as backgroundimg
        ImageIcon img = new ImageIcon("background.jpg");
        backgroundimg = new JLabel("",img,JLabel.CENTER);
        backgroundimg.setBounds(0,0,1366,777);
        jp.add(backgroundimg);
        
        cardid_tf = new JTextField();
        clientname_tf = new JTextField();
        bankissued_tf = new JTextField();
        bankacc_tf = new JTextField();
        balamt_tf = new JTextField();
        pinnum_tf = new JTextField();
        withdrawamt_tf = new JTextField();
        cvcnum_tf = new JTextField();
        interestrate_tf = new JTextField();
        graceperiod_tf = new JTextField();
        creditlimit_tf = new JTextField();
        
        title1 = new JLabel("---BANK APP---");
        title2 = new JLabel("Please Enter Your Details Accordingly");
        subtitle1 = new JLabel("# REQUIRED");
        subtitle2 = new JLabel("# Credentials For Debit Card");
        subtitle3 = new JLabel("# Credentials For Credit Card");
        cardid = new JLabel("CARD ID :");
        clientname = new JLabel("CLIENT NAME :");
        bankissued = new JLabel("ISSUER BANK :");
        bankacc = new JLabel("BANK ACCOUNT :");
        pinnum = new JLabel("PIN NUMBER :");
        cvcnum = new JLabel("CVC NUMBER :");
        balamt = new JLabel("BALANCE AMOUNT :");
        withdrawamt = new JLabel("WITHDRAWL AMOUNT :");
        withdrawdate = new JLabel("WITHDRAW DATE :");
        creditlim = new JLabel("CREDIT LIMIT :");
        interestrate = new JLabel("INTEREST RATE :");
        graceperiod = new JLabel("GRACE PERIOD :");
        credit_expdate = new JLabel("EXPIRATION DATE :");
        addtocreditcard_req = new JLabel("*CardID, ClientName, IssuerBank, BankAcc, BalanceAmt, CVCNum, IntRate, ExpDate");
        addtodebitcard_req = new JLabel("*CardID, ClientName, IssuerBank, BankAcc, BalaneAmt, PinNumber");
        withdrawdebitcard_req = new JLabel("*CardID, WithdrawAmt, WithdrawDate, PinNum");
        setcreditlimit_req = new JLabel("*CardID, CreditLimit, GracePeriod");
        cancelcreditcard_req = new JLabel("*CardID");
        
        credit_exp_month_cb = new JComboBox<String>(montharray);
        credit_exp_year_cb = new JComboBox<String>(yeararray);
        debit_withdraw_day_cb = new JComboBox<String>(dayarray);
        debit_withdraw_month_cb = new JComboBox<String>(montharray);
        debit_withdraw_year_cb = new JComboBox<String>(yeararray);
        
        adddebitcard_jb = new JButton("Add Debit Card");
        withdrawdebitcard_jb = new JButton("Withdraw From Debit Card");
        addcreditcard_jb = new JButton("Add Credit Card");
        setcreditlimit_jb = new JButton("Set Credit Limit");
        cancelcreditcard_jb = new JButton("Cancel Credit Card");
        displaycreditcard_jb = new JButton("Display Credit Card");
        displaydebitcard_jb = new JButton("Display Debit Card");
        clear_jb = new JButton("Clear");
        
        //Set Bounds for all the variables
        cardid_tf.setBounds(138,145,181,25);
        clientname_tf.setBounds(618,145,239,25);
        bankissued_tf.setBounds(1102,145,220,25);
        bankacc_tf.setBounds(354,217,223,25);
        balamt_tf.setBounds(1046,217,170,25);
        
        pinnum_tf.setBounds(168,334,84,25);
        withdrawamt_tf.setBounds(618,334,239,25);
        
        cvcnum_tf.setBounds(171,512,84,25);
        interestrate_tf.setBounds(417,512,187,25);
        graceperiod_tf.setBounds(797,512,166,25);
        creditlimit_tf.setBounds(1127,512,195,25);
        
        title1.setBounds(568,10,290,43);
        title1.setFont(new Font("Helvetica", Font.BOLD,30));
        title2.setBounds(470,53,492,53);
        title2.setFont(new Font("Helvetica", Font.PLAIN,26));
        title2.setForeground(Color.GRAY);
        
        subtitle1.setBounds(64,95,97,22);
        subtitle1.setFont(new Font("Helvetica", Font.BOLD,16));
        subtitle1.setForeground(Color.RED);
        cardid.setBounds(64,145,97,22);
        cardid.setFont(new Font("Helvetica", Font.PLAIN,14));
        clientname.setBounds(510,145,127,22);
        clientname.setFont(new Font("Helvetica", Font.PLAIN,14));
        bankissued.setBounds(992,145,114,22);
        bankissued.setFont(new Font("Helvetica", Font.PLAIN,14));
        bankacc.setBounds(229,217,146,22);
        bankacc.setFont(new Font("Helvetica", Font.PLAIN,14));
        balamt.setBounds(903,217,168,22);
        balamt.setFont(new Font("Helvetica", Font.PLAIN,14));
        
        subtitle2.setBounds(64,278,255,22);
        subtitle2.setFont(new Font("Helvetica", Font.BOLD,16));
        subtitle2.setForeground(Color.RED);
        pinnum.setBounds(64,332,112,22);
        pinnum.setFont(new Font("Helvetica", Font.PLAIN,14));
        withdrawamt.setBounds(450,334,170,22);
        withdrawamt.setFont(new Font("Helvetica", Font.PLAIN,14));
        withdrawdate.setBounds(980,334,205,22);
        withdrawdate.setFont(new Font("Helvetica", Font.PLAIN,14));
        adddebitcard_jb.setBounds(168,385,382,40);
        withdrawdebitcard_jb.setBounds(777,385,382,40);
        
        subtitle3.setBounds(64,446,255,22);
        subtitle3.setFont(new Font("Helvetica", Font.BOLD,16));
        subtitle3.setForeground(Color.RED);
        cvcnum.setBounds(64,511,141,22);
        cvcnum.setFont(new Font("Helvetica", Font.PLAIN,14));
        interestrate.setBounds(292,511,169,22);
        interestrate.setFont(new Font("Helvetica", Font.PLAIN,14));
        graceperiod.setBounds(677,511,181,22);
        graceperiod.setFont(new Font("Helvetica", Font.PLAIN,14));
        creditlim.setBounds(1020,511,127,22);
        creditlim.setFont(new Font("Helvetica", Font.PLAIN,14));
        credit_expdate.setBounds(292,564,191,22);
        credit_expdate.setFont(new Font("Helvetica", Font.PLAIN,14));

        addtocreditcard_req.setBounds(533,665,350,15);
        addtocreditcard_req.setFont(new Font("Helvetica", Font.PLAIN,9));
        addtocreditcard_req.setForeground(Color.RED);
        addtodebitcard_req.setBounds(533,430,350,15);
        addtodebitcard_req.setFont(new Font("Helvetica", Font.PLAIN,9));
        addtodebitcard_req.setForeground(Color.RED);
        withdrawdebitcard_req.setBounds(977,430,350,15);
        withdrawdebitcard_req.setFont(new Font("Helvetica", Font.PLAIN,9));
        withdrawdebitcard_req.setForeground(Color.RED);
        setcreditlimit_req.setBounds(977,600,350,15);
        setcreditlimit_req.setFont(new Font("Helvetica", Font.PLAIN,9));
        setcreditlimit_req.setForeground(Color.RED);
        cancelcreditcard_req.setBounds(67,600,350,15);
        cancelcreditcard_req.setFont(new Font("Helvetica", Font.PLAIN,9));
        cancelcreditcard_req.setForeground(Color.RED);
        
        credit_exp_month_cb.setBounds(433,564,65,25);
        credit_exp_year_cb.setBounds(503,564,65,25);
        debit_withdraw_day_cb.setBounds(1117,334,65,25);
        debit_withdraw_month_cb.setBounds(1187,334,65,25);
        debit_withdraw_year_cb.setBounds(1257,334,65,25);
        
        
        adddebitcard_jb.setBounds(530,386,350,40);
        addcreditcard_jb.setBounds(530,620,350,40);
        setcreditlimit_jb.setBounds(974,555,350,40);
        cancelcreditcard_jb.setBounds(64,555,191,40);
        withdrawdebitcard_jb.setBounds(974,386,350,40);
        displaycreditcard_jb.setBounds(64,620,350,40);
        displaydebitcard_jb.setBounds(64,386,350,40);
        clear_jb.setBounds(974,640,347,77);
             
        //adding items to Background
        backgroundimg.add(cardid_tf);
        backgroundimg.add(clientname_tf);
        backgroundimg.add(bankissued_tf);
        backgroundimg.add(bankacc_tf);
        backgroundimg.add(balamt_tf);
        backgroundimg.add(pinnum_tf);
        backgroundimg.add(withdrawamt_tf);
        backgroundimg.add(cvcnum_tf);
        backgroundimg.add(interestrate_tf);
        backgroundimg.add(graceperiod_tf);
        backgroundimg.add(creditlimit_tf);
        
        backgroundimg.add(title1);
        backgroundimg.add(title2);
        backgroundimg.add(subtitle1);
        backgroundimg.add(subtitle2);
        backgroundimg.add(subtitle3);
        backgroundimg.add(cardid);
        backgroundimg.add(clientname);
        backgroundimg.add(bankissued);
        backgroundimg.add(bankacc);
        backgroundimg.add(pinnum);
        backgroundimg.add(cvcnum);
        backgroundimg.add(balamt);
        backgroundimg.add(withdrawamt);
        backgroundimg.add(withdrawdate);
        backgroundimg.add(creditlim);
        backgroundimg.add(interestrate);
        backgroundimg.add(graceperiod);
        backgroundimg.add(credit_expdate);

        backgroundimg.add(addtocreditcard_req);
        backgroundimg.add(addtodebitcard_req);
        backgroundimg.add(withdrawdebitcard_req);
        backgroundimg.add(setcreditlimit_req);
        backgroundimg.add(cancelcreditcard_req);
        
        backgroundimg.add(credit_exp_month_cb);
        backgroundimg.add(credit_exp_year_cb);
        backgroundimg.add(debit_withdraw_day_cb);
        backgroundimg.add(debit_withdraw_month_cb);
        backgroundimg.add(debit_withdraw_year_cb);
        
        backgroundimg.add(adddebitcard_jb);
        backgroundimg.add(withdrawdebitcard_jb);
        backgroundimg.add(addcreditcard_jb);
        backgroundimg.add(setcreditlimit_jb);
        backgroundimg.add(cancelcreditcard_jb);
        backgroundimg.add(displaycreditcard_jb);
        backgroundimg.add(displaydebitcard_jb);
        backgroundimg.add(clear_jb);
        
        adddebitcard_jb.addActionListener(this);
        addcreditcard_jb.addActionListener(this);
        withdrawdebitcard_jb.addActionListener(this);
        setcreditlimit_jb.addActionListener(this);
        cancelcreditcard_jb.addActionListener(this);
        displaycreditcard_jb.addActionListener(this);
        displaydebitcard_jb.addActionListener(this);
        clear_jb.addActionListener(this);
        
        //adding JPanel into JFrame
        jf.add(jp);
        //Setting Layout and Size for JPanel
        jp.setLayout(null);
        jp.setSize(1366,840);
        //Setting Layout and Size for JFrame
        jf.setLayout(null);
        jf.setVisible(true);
        jf.setSize(1366,777);
        jf.setLocationRelativeTo(null);  
        //This doesnt let the Java Operation Run on Backgroundimg
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    private void clearFields() 
    {
        cardid_tf.setText("");
        clientname_tf.setText("");
        bankissued_tf.setText("");
        bankacc_tf.setText("");
        balamt_tf.setText("");
        pinnum_tf.setText("");
        withdrawamt_tf.setText("");
        cvcnum_tf.setText("");
        interestrate_tf.setText("");
        graceperiod_tf.setText("");
        creditlimit_tf.setText("");
        credit_exp_month_cb.setSelectedIndex(0);
        credit_exp_year_cb.setSelectedIndex(0);
        debit_withdraw_day_cb.setSelectedIndex(0);
        debit_withdraw_month_cb.setSelectedIndex(0);
        debit_withdraw_year_cb.setSelectedIndex(0);
    }
    
    @Override
    public void actionPerformed(ActionEvent eve)
    {
        //Button 1
        if(eve.getSource() == adddebitcard_jb){
            if( cardid_tf.getText().isEmpty() ||
                clientname_tf.getText().isEmpty() ||
                bankissued_tf.getText().isEmpty() ||
                bankacc_tf.getText().isEmpty() ||
                balamt_tf.getText().isEmpty() ||
                pinnum_tf.getText().isEmpty())
            {
                JOptionPane.showMessageDialog(jf,"Please Fill Out all the Required Fields !!!","Alert",JOptionPane.ERROR_MESSAGE);        
            }
            else
            {
                try{
                    //Getting text entered in GUI and storing them in Debitcard object and further storing them into arraylist and clearing fields
                    int cardid = Integer.parseInt(cardid_tf.getText());
                    String clientname = clientname_tf.getText();
                    String bankissued = bankissued_tf.getText();
                    String bankacc = bankacc_tf.getText();
                    double balamt = Double.parseDouble(balamt_tf.getText());
                    int pinnum = Integer.parseInt(pinnum_tf.getText());
                    
                    // Check if card ID already exists in the list
                    boolean cardExists = false;
                    //For each loop that iterates over collection of bankCards ans assign each card to variable "card"
                    for (Bankcard card : bankCards) {
                        //checks if card is instance of Debitcard and if the cardid matches
                        if (card instanceof Debitcard && card.getCardID() == cardid ) {
                            cardExists = true;
                            break;
                        }
                    }
                    
                    if (cardExists) {
                        JOptionPane.showMessageDialog(jf, "Debit card with this card ID already exists in the list!", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        //initializing the object of Debitcard class
                        debtobj = new Debitcard(cardid,clientname,bankissued,bankacc,balamt,pinnum);
                        //initializing the arraylist
                        bankCards.add(debtobj);
                        JOptionPane.showMessageDialog(jf, "Debit card added successfully !!!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        clearFields();
                    }
                }
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(jf, "Invalid Input Format !!!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        
        // Button 2
        else if(eve.getSource() == addcreditcard_jb){
            if( cardid_tf.getText().isEmpty() ||
                clientname_tf.getText().isEmpty() ||
                bankissued_tf.getText().isEmpty() ||
                bankacc_tf.getText().isEmpty() ||
                balamt_tf.getText().isEmpty() ||
                cvcnum_tf.getText().isEmpty() ||
                interestrate_tf.getText().isEmpty() ||
                credit_exp_month_cb.getItemCount() == 0 ||
                credit_exp_year_cb.getItemCount() == 0)
            {
                JOptionPane.showMessageDialog(jf,"Please Fill Out all the Required Fields !!!","Alert",JOptionPane.ERROR_MESSAGE);        
            }
            else
            {
                try{
                    //Getting text entered in GUI and storing them in Creditcard object and further storing them into arraylist and clearing fields
                    int cardid = Integer.parseInt(cardid_tf.getText());
                    String clientname = clientname_tf.getText();
                    String bankissued = bankissued_tf.getText();
                    String bankacc = bankacc_tf.getText();
                    double balamt = Double.parseDouble(balamt_tf.getText());
                    int cvcnum = Integer.parseInt(cvcnum_tf.getText());
                    double interestrate = Double.parseDouble(interestrate_tf.getText());
                    String expDate = credit_exp_month_cb.getSelectedItem().toString() + "/" + credit_exp_year_cb.getSelectedItem().toString();       
                    
                    boolean cardIdExists = false;
                    boolean cvcNumExists = false;
        
                    // Check if the card ID or CVC number already exists in the arraylist
                    //For each loop that iterates over collection of bankCards ans assign each card to variable "card"
                    for (Bankcard card : bankCards) {
                        //check if entered cardid matches the stored cardid
                        if (card.getCardID() == cardid) {
                            cardIdExists = true;
                            break;
                        }
                        //checks if card is instance of Creditcard and if the cvc number matches
                        if (card instanceof Creditcard && ((Creditcard) card).getCvcnum() == cvcnum) {
                            cvcNumExists = true;
                            break;
                        }
                    }
        
                    if (cardIdExists && cvcNumExists) {
                        JOptionPane.showMessageDialog(jf, "A credit card with the same ID and CVC number already exists. Please enter different values.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else if (cardIdExists) {
                        JOptionPane.showMessageDialog(jf, "A credit card with the same ID already exists. Please enter a different ID.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else if (cvcNumExists) {
                        JOptionPane.showMessageDialog(jf, "A credit card with the same CVC number already exists. Please enter a different CVC number.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        // If the card ID and CVC number are unique, create a new Creditcard object and add it to the arraylist
                        credobj = new Creditcard(cardid, clientname, bankissued, bankacc, balamt, cvcnum, interestrate, expDate);
                        bankCards.add(credobj);
        
                        JOptionPane.showMessageDialog(jf, "Credit card added successfully !!!", "Success", JOptionPane.INFORMATION_MESSAGE);
                        clearFields();
                    }
                }
                catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(jf, "Invalid Input Format !!!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        
        //Button 3
        else if (eve.getSource() == withdrawdebitcard_jb) {
            if (bankCards.isEmpty()) {
                JOptionPane.showMessageDialog(jf, "Add a card first !!!", "Empty List", JOptionPane.ERROR_MESSAGE);
            } else if (cardid_tf.getText().isEmpty() || 
                        withdrawamt_tf.getText().isEmpty() || 
                        debit_withdraw_day_cb.getItemCount() == 0 || 
                        debit_withdraw_month_cb.getItemCount() == 0 || 
                        debit_withdraw_year_cb.getItemCount() == 0 || 
                        pinnum_tf.getText().isEmpty()) {
                JOptionPane.showMessageDialog(jf, "Please Fill Out all the Required Fields !!!", "Alert", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    // Get input values from GUI
                    int cardId = Integer.parseInt(cardid_tf.getText());
                    // validate card id
                    if (cardId <= 0) {
                        // show error message if card id is invalid
                        JOptionPane.showMessageDialog(jf, "Invalid Card ID", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    int withdrawamt = Integer.parseInt(withdrawamt_tf.getText());
                    String withdrawdate = debit_withdraw_day_cb.getSelectedItem().toString() + "/" + debit_withdraw_month_cb.getSelectedItem().toString() + "/" + debit_withdraw_year_cb.getSelectedItem().toString();
                    int pinnum = Integer.parseInt(pinnum_tf.getText());

                    // Search for matching debit card
                    Debitcard matchingDebitcard = null;
                    //Bankcard object is assigned to the variable "card"
                    for (Bankcard card : bankCards) {
                        if (card instanceof Debitcard && card.getCardID() == cardId) {
                            // cast Bankcard object as Debitcard object
                            matchingDebitcard = (Debitcard) card;
                            break;
                        }
                    }

                    if (matchingDebitcard == null) {
                        JOptionPane.showMessageDialog(jf, "Invalid card ID or card is not a debit card.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else if (matchingDebitcard.getPinnum() != pinnum) {
                        JOptionPane.showMessageDialog(jf, "Incorrect PIN. Withdrawal failed.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else if (matchingDebitcard.getBalamt() < withdrawamt) {
                        JOptionPane.showMessageDialog(jf, "Insufficient balance. Withdrawal failed.", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        // Withdrawal is valid, call the Withdraw method
                        matchingDebitcard.Withdraw(withdrawamt, withdrawdate, pinnum);
                        JOptionPane.showMessageDialog(jf, "Withdrawal successful! Card ID: " + cardId + ", Amount: " + withdrawamt + ", Date: " + withdrawdate, "Success", JOptionPane.INFORMATION_MESSAGE);
                        clearFields();
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(jf, "Invalid Input Format !!!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        
        // Button 4
        else if (eve.getSource() == setcreditlimit_jb) {
            if (bankCards.isEmpty() == true) {
                JOptionPane.showMessageDialog(jf, "Add a card first !!!", "Empty List", JOptionPane.ERROR_MESSAGE);
            } else if (cardid_tf.getText().isEmpty() || creditlimit_tf.getText().isEmpty() || graceperiod_tf.getText().isEmpty()) {
                JOptionPane.showMessageDialog(jf, "Please Fill Out all the Required Fields !!!", "Alert", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    // get card ID, new credit limit, and new grace period from GUI input
                    int cardID = Integer.parseInt(cardid_tf.getText());
                    double newCreditLimit = Double.parseDouble(creditlimit_tf.getText());
                    int newGracePeriod = Integer.parseInt(graceperiod_tf.getText());
        
                    // Check if the card ID already exists in the ArrayList
                    boolean cardExists = false;
                    // Bankcard object is assigned to the variable "card"
                    for (Bankcard card : bankCards) {
                        // check for card ID
                        if (card instanceof Creditcard) {
                            if (card.getCardID() == cardID) {
                                // cast Bankcard object as Creditcard object
                                Creditcard creditCard = (Creditcard) card;
        
                                if (newCreditLimit <= (creditCard.getBalamt() * 2.5)) {
                                    creditCard.setCreditlim(newCreditLimit, newGracePeriod);
                                    // show confirmation message with new credit limit and grace period
                                    JOptionPane.showMessageDialog(null, "Credit limit for card " + cardID + " has been set to " + newCreditLimit + " and grace period has been set to " + newGracePeriod);
                                    clearFields();
                                    cardExists = true;
                                    break;
                                } else {
                                    JOptionPane.showMessageDialog(jf, "Credit Cannot be Issued !!!", "Error", JOptionPane.ERROR_MESSAGE);
                                    return;
                                }
                            }
                        }
                    }
        
                    if (!cardExists) {
                        // show error message if no matching credit card was found
                        JOptionPane.showMessageDialog(null, "Invalid card ID or card is not a credit card.");
                    }
        
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(jf, "Invalid Input Format !!!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        
        //Button 5
        else if (eve.getSource() == cancelcreditcard_jb) {
            if (bankCards.isEmpty() == true) {
                JOptionPane.showMessageDialog(jf, "Add a card first !!!", "Empty List", JOptionPane.ERROR_MESSAGE);
            } else if (cardid_tf.getText().isEmpty()) {
                JOptionPane.showMessageDialog(jf, "Please Fill Out all the Required Fields !!!", "Alert", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    // get card id from GUI input
                    Integer cardID = Integer.parseInt(cardid_tf.getText());
                    // validate card id
                    boolean cardExists = false;
                    // search for matching credit card
                    for (Bankcard card : bankCards) {
                        if (card instanceof Creditcard && card.getCardID() == cardID) {
                            // cast Bankcard object as Creditcard object
                            Creditcard credobj = (Creditcard) card;
                            // call cancel method
                            credobj.cancelCreditcard(credobj.getCvcnum(), credobj.getGraceperiod(), credobj.getCreditlim(), credobj.getIsGranted());
                            // show confirmation message
                            JOptionPane.showMessageDialog(null, "Credit card with ID : " + cardID + " has been canceled !");
                            cardExists = true;
                            // remove the credit card from the bankCards ArrayList
                            bankCards.remove(card);
                            break;
                        }
                    }
                    if (!cardExists) {
                        // show error message if no matching credit card was found
                        JOptionPane.showMessageDialog(null, "Invalid card ID or card is not a credit card !!!");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(jf, "Invalid Input Format !!!", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (ClassCastException ex) {
                    JOptionPane.showMessageDialog(jf, "Invalid card type !!!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }

        
        //Button 6
        else if (eve.getSource() == displaycreditcard_jb) {
            if (bankCards.isEmpty()) {
                JOptionPane.showMessageDialog(jf, "Add a card first !!!", "Empty List", JOptionPane.ERROR_MESSAGE);
            } else {
                boolean found = false; // add a boolean variable to check if a Creditcard object was found
                String creditCardInfo = "";
                for (Bankcard card : bankCards) {
                    if (card instanceof Creditcard) {
                        // cast Bankcard object as Creditcard object
                        Creditcard credobj = (Creditcard) card;
                        credobj.Display();
                        System.out.println("\n");
                        creditCardInfo += "Card ID: " + credobj.getCardID() + "\n"
                                        + "Bank Account: " + credobj.getBankacc() +"\n"
                                        + "Issuer Bank: " + credobj.getBankissued() + "\n"
                                        + "Client Name: " + credobj.getClientname() + "\n"
                                        + "Balance Amount: " + credobj.getBalamt() + "\n"
                                        + "CVC Number: " + credobj.getCvcnum() + "\n"
                                        + "Interest Rate: " + credobj.getInterestrate() + "\n"
                                        + "Grace Period: " + credobj.getGraceperiod() + "\n" 
                                        + "Credit Limit: " + credobj.getCreditlim() + "\n"
                                        + "Expiration Date: " + credobj.getExpdate() + "\n\n";
                        found = true; // set found to true if a Creditcard object was found
                    }
                }
                if (found) { // display Creditcard details in a JOptionPane
                    JOptionPane.showMessageDialog(jf, creditCardInfo, "Creditcard Details", JOptionPane.INFORMATION_MESSAGE);
                } else { // display error message if no Creditcard objects were found
                    JOptionPane.showMessageDialog(jf, "Creditcard Details Not Found or Doesn't Exist", "CreditNotFound", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        //Button 7
        else if(eve.getSource() == displaydebitcard_jb){
            if(bankCards.isEmpty() == true){
                JOptionPane.showMessageDialog(jf, "Add a card first !!!", "Empty List", JOptionPane.ERROR_MESSAGE);
            }
            else{
                String debitCardInfo = "";
                boolean debitCardsFound = false;
                for (Bankcard card : bankCards) {
                    if (card instanceof Debitcard) {
                        Debitcard debitObj = (Debitcard) card;
                        debitObj.Display();
                        System.out.println("\n");
        
                        debitCardInfo += "Card ID: " + debitObj.getCardID() + "\n"
                                        + "Bank Account: " + debitObj.getBankacc() + "\n"
                                        + "Issuer Bank: " + debitObj.getBankissued() + "\n"
                                        + "Client Name: " + debitObj.getClientname() + "\n"
                                        + "Balance Amount: " + debitObj.getBalamt() + "\n"
                                        + "PIN Number: " + debitObj.getPinnum() + "\n\n";
                        
                        debitCardsFound = true;
                    }    
                }
                
                if (!debitCardsFound) {
                    JOptionPane.showMessageDialog(jf, "Debitcard Details Not Found or Doesn't Exist", "DebitNotFound", JOptionPane.ERROR_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(jf, debitCardInfo, "Debit Card Details", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        }


        //Button 8
        else{
            cardid_tf.setText("");
            clientname_tf.setText("");
            bankissued_tf.setText("");
            bankacc_tf.setText("");
            balamt_tf.setText("");
            pinnum_tf.setText("");
            withdrawamt_tf.setText("");
            cvcnum_tf.setText("");
            interestrate_tf.setText("");
            graceperiod_tf.setText("");
            creditlimit_tf.setText("");
            credit_exp_month_cb.setSelectedIndex(0);
            credit_exp_year_cb.setSelectedIndex(0);
            debit_withdraw_day_cb.setSelectedIndex(0);
            debit_withdraw_month_cb.setSelectedIndex(0);
            debit_withdraw_year_cb.setSelectedIndex(0);
            JOptionPane.showMessageDialog(jf, "The Fields have been cleared !!!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }
    public static void main(String [] args)
    {        
        new BankGUI();
    }
}
        
 
