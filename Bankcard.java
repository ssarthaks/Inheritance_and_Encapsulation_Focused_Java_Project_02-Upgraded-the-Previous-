/**
 * Bankcard Class
 *
 * @author (Sarthak Sharma C13)
 * @Coursework (Java Programming Coursework)
 */
//Create a class named Bankcard 
public class Bankcard
{
    // Instance variables are declared
    private int cardID;
    private String clientname;
    private String bankissued;
    private String bankacc;
    private double balamt;
    
    //Parameterized Constructor of Bankcard was made
    public Bankcard(double balamt, int cardID, String bankacc, String bankissued)
    {
        //Instance variables are initialized
        this.clientname="";
        this.cardID=cardID;
        this.bankissued=bankissued;
        this.bankacc=bankacc;
        this.balamt=balamt;
    }
    //Getter/Accessor method for CardID
    public int getCardID()
    {
        return this.cardID;
    }
    //Getter/Accessor method for Client Name
    public String getClientname()
    {
        return this.clientname;
    }
    //Getter/Accessor method for Issuer Bank
    public String getBankissued()
    {
        return this.bankissued;
    }
    //Getter/Accessor method for Bank Account
    public String getBankacc()
    {
        return this.bankacc;
    }
    //Getter/Accessor method for Balance Amount
    public double getBalamt()
    {
        return this.balamt;
    }
    //Setter/Mutator method for ClientName
    public void setClientname(String clientname)
    {
        this.clientname=clientname;
    }
    //Setter/Mutator method for BalanceAmount
    public void setBalamt(double balamt)
    {
        this.balamt=balamt;
    }
    //Display method for Output
    public void Display()
    {
        if(this.clientname.equals("")){
            System.out.println("The Clientname is not Assigned!");
        }
        else{
            System.out.println("The details of the Client is below:");
            System.out.println("Client Name = "+this.clientname);
            System.out.println("Card ID = "+this.cardID);
            System.out.println("Bank Issued = "+this.bankissued);
            System.out.println("Bank Account = "+this.bankacc);
            System.out.println("Balance Amount = "+this.balamt);
        }
    }
}

