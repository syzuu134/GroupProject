public class ItemInformation extends CustomerInformation
{
    private String itemId; //Item id
    private String itemName; //Item name
    private double itemPrice; //Item price
    private String datePurchase; //Date purchase
    private int totalItem;

    //Constructor w/o parameter
    public ItemInformation()
    {
        super ();
        itemId = "";
        itemName = "";
        itemPrice = 0.0;
        datePurchase = "";
        totalItem = 0;
    }

    //Constructor with parameter
    public ItemInformation(String ID, double cp, String id, String name, double price, String date,int totItem)
    {
        super (ID, cp);
        itemId = id;
        itemName = name;
        itemPrice = price;
        datePurchase = date;
        totalItem = totItem;
    }

    //Mutator for all attribute
    public void setItemInformation(String ID, double cp, String id, String name, double price, String date,int totItem)
    {
        setAll(ID, cp);
        itemId = id;
        itemName = name;
        itemPrice = price;
        datePurchase = date; 
        totalItem = totItem;
    }

    //Mutator for each attribute
    public void setItemId(String id)
    {
        itemId = id;
    }

    public void setItemName(String name)
    {
        itemName = name;
    }

    public void setItemPrice(double price)
    {
        itemPrice = price;
    }

    public void setDatepurchase(String date)
    {
        datePurchase = date;
    }

    public void setTotalItem(int totItem)
    {
        totalItem = totItem;
    }

    //Accessor for each attribute
    public String getItemId()
    {
        return itemId;
    }

    public String getItemName()
    {
        return itemName;
    }

    public double getItemPrice()
    {
        return itemPrice;
    }

    public String getDatePurchase()
    {
        return datePurchase;
    }

    /*public int getTotalItem()
    {
        if(getID().equals(getID()))
        {
            totalItem++;
        }
        else
        {
            totalItem = 1;
        }
        return totalItem;
    } */
    
    public double getTotalPrice()
    {
        double totalPrice = 0.00;
        totalPrice += getItemPrice();
        return totalPrice;
    }
    //Display String toString
    public String toString()
    {
        return String.format (super.toString() + "%-10s %-30s %-5.2f %30s", itemId, itemName, itemPrice, datePurchase);
    }
} //end Item Information
