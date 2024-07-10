
/**
 * Debitcard Class
 *
 * @author (Sarthak Sharma C13)
 * @Coursework (Java Programming Coursework)
 */
public class Debitcard extends Bankcard
{
    // Instance variables are decalared
    private int pinnum;
    private int withdrawamt;
    private String withdrawdate;
    private boolean hasWithdraw;

    //Parameterized Constructor of Debitcard class is created
    public Debitcard(int cardID, String clientname, String bankissued, String bankacc, double balamt, int pinnum)
    {
        //call is made to the parent/super class constructor
        super( balamt, cardID, bankacc, bankissued);
        //setter method for clientname
        super.setClientname(clientname);
        //Instance variables are initialized
        this.pinnum=pinnum;
        this.hasWithdraw=false;
    }
    //Getter/Accessor method for Pin Number
    public int getPinnum()
    {
        return this.pinnum;
    }
    //Getter/Accessor method for Withdrawl Amount
    public int getWithdrawamt()
    {
        return this.withdrawamt;
    }
    //Getter/Accessor method for date of Withdrawl
    public String getWithdrawdate()
    {
        return this.withdrawdate;
    }
    //Getter/Accessor method for hasWithdrawn 
    public boolean getHasWithdraw()
    {
        return this.hasWithdraw;
    }
    //Setter/Mutator method for withdrawl amount
    public void setWithdrawamt(int withdrawamt)
    {
        this.withdrawamt=withdrawamt;
    }
    //Withdraw method is created
    public void Withdraw(int withdrawamt, String withdrawdate, int pinnum)
    {
        /*
         * If/Else condition to check if the pin num matches the actual pin
           number and check if theres sufficient amount in bank account to withdraw
        */
           if(pinnum==this.pinnum && withdrawamt<=super.getBalamt()){
               this.hasWithdraw=true;
               this. withdrawamt=withdrawamt;
               this.withdrawdate=withdrawdate;
               super.setBalamt(super.getBalamt() - withdrawamt);
           }
           else if(pinnum != this.pinnum){
               System.out.println("The pin number entered is not correct!");
           }
           else if(pinnum==this.pinnum && withdrawamt>=super.getBalamt()){
               System.out.println("Sorry ! You have insufficient amount of funds in your bank account");
           }
    }
    public void Display()
    {
        //Display method from parent class i.e. Bankcard is called 
        super.Display();
        /** If else condition to check if money has been withdrawn or not,
            and display appropriate output
        **/
        if(hasWithdraw = true){
            System.out.println("Pin number is= "+this.pinnum);
            System.out.println("Withdraw amount is= "+this.withdrawamt);
            System.out.println("Withdraw Date is= "+this.withdrawdate);
        }
        else{
            System.out.println("Balance amount = "+super.getBalamt());               
        }
    }
}
