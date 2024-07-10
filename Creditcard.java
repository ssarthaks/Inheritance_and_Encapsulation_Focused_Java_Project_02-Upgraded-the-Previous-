/**
 * Creditcard Class
 *
 * @author (Sarthak Sharma C13)
 * @Coursework (Java Programming Coursework)
 */
public class Creditcard extends Bankcard
{
    // Instance Variables are declared
    private int cvcnum;
    private double creditlim;
    private double interestrate;
    private String expdate;
    private int graceperiod;
    private boolean isGranted;

    //Parameterized Constructor of Creditcard class is created
    public Creditcard(int cardID, String clientname, String bankissued, String bankacc, double balamt, int cvcnum, double interestrate, String expdate)
    {
        super(balamt, cardID, bankacc, bankissued);
        super.setClientname(clientname);
        super.setBalamt(balamt);
        //Instance variables are initialized
        this.cvcnum=cvcnum;
        this.interestrate=interestrate;
        this.expdate=expdate;
        this.isGranted=false;
    }
    //Getter/Accessor method for CVC number
    public int getCvcnum()
    {
        return this.cvcnum;
    }
    //Getter/Accessor method for Credit Limit
    public double getCreditlim()
    {
        return this.creditlim;
    }
    //Getter/Accessor method for Interest Rate
    public double getInterestrate()
    {
        return this.interestrate;
    }
    //Getter/Accessor method for Expire Date
    public String getExpdate()
    {
        return this.expdate;
    }
    //Getter/Accessor method for Grace Period
    public int getGraceperiod()
    {
        return this.graceperiod;
    }
    //Getter/Accessor method for isGranted
    public boolean getIsGranted()
    {
        return this.isGranted;
    }
    
    //Setter/Mutator Method for Credit Limit
    public void setCreditlim(double creditlim, int graceperiod)
    {
        /* 
         * Condition to check whether the given credit limit meets the required
         * condition i.e. credit limit must be equal to or less than
         * 2.5times the balance amount        
         */
        if(creditlim<=(super.getBalamt() * 2.5)){
            this.creditlim=creditlim;
            this.graceperiod=graceperiod;
            this.isGranted=true;
        }
        else{
            System.out.println("The credit cannot be issued");
        }
    }
    //Method for cancelling credit card
    public void cancelCreditcard(int cvcnum, int graceperiod, double creditlim, boolean isGranted)
    {
        //reseting values
        this.cvcnum=0;
        this.graceperiod=0;
        this.creditlim=0;
        this.isGranted=false;
    }
    //Method for displaying all the required information
    public void Display()
    {
        /*
         * Condition to check whether the credit card has been granted 
         * or not and display output 
         */
        if(isGranted==true){
            //calling display method from parent class i.e bankcard
            super.Display();
            System.out.println("Grace Period = "+this.graceperiod);
            System.out.println("Credit Limit = "+this.creditlim);
        }
        else{
            super.Display();
        }
    }
}
