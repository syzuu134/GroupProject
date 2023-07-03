public class CustomerInformation
{
    private String custID; //Customer's ID
    private double counterPaid; //Total paid
    private int totalItem;
    
    //Constructor without parameter
    public CustomerInformation()
    {
        custID = "";
        counterPaid = 0.00;
        //this.itemList = new LinkedList<>();
    }
    
    //Constructor with parameter
    public CustomerInformation(String ID, double cp)
    {
        custID = ID;
        counterPaid = cp;
    }
    
    //mutator for all attribute
    public void setAll(String ID, double cp)
    {
        custID = ID;
        counterPaid = cp;
    }
    
    //mutator for each attribute
    public void setID(String ID)
    {
        custID = ID;
    }
    
    public void setCP(double cp)
    {
        counterPaid = cp;
    }    
    
    public void setTotalItem(int totItem)
    {
        totalItem = totItem;
    }
    
    //accessor methods
    public String getID()
    {
        return custID;
    }
    
    public double getCP()
    {
        return counterPaid;
    }
    
    public int getTotalItem()
    {
        return totalItem;
    } 
    
    //display customer information 
    public String toString()
    {
        return String.format("%-20s  %-5.2f", custID, counterPaid);
    }
} //end CustomerInformation