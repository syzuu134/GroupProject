import java.util.*;
import java.util.Stack;
import javax.swing.*;
import java.io.*;

public class MainInformation
{
    public static void main(String [] args)
    {
        try 
        {
            CustomQueue<ItemInformation> qCustomer = new CustomQueue<>();
            Queue<ItemInformation> qCounter1 = new LinkedList<>();
            Queue<ItemInformation> qCounter2 = new LinkedList<>();
            Queue<ItemInformation> qCounter3 = new LinkedList<>();
            Queue<ItemInformation> qCompleted = new LinkedList<>();

            Stack<ItemInformation> CompletedStack = new Stack<>();

            // Read input file named CustomerInformation.txt
            BufferedReader in = new BufferedReader(new FileReader("CustomerInformation.txt"));

            // Create ArrayList
            LinkedList<CustomerInformation> customerList = new LinkedList();
            // Create ArrayList
            ArrayList<ItemInformation> itemList = new ArrayList();

            String inData = null;
            ItemInformation item;
            CustomerInformation cust;

            // How to read by line
            while ((inData = in.readLine()) != null) {
                StringTokenizer st = new StringTokenizer(inData, ";");
                String Id = st.nextToken();
                double counterPaid = Double.parseDouble(st.nextToken());

                cust = new CustomerInformation(Id,counterPaid);

                StringTokenizer newToken = new StringTokenizer(st.nextToken(), ":");
                while (newToken.hasMoreTokens()) {
                    StringTokenizer nt = new StringTokenizer(newToken.nextToken(), ",");
                    String itemID = nt.nextToken();
                    String itemName = nt.nextToken();
                    double price = Double.parseDouble(nt.nextToken());
                    String date = nt.nextToken();
                    int totItem = 1;
                    //create object
                    item = new ItemInformation(Id,counterPaid,itemID,itemName,price,date,totItem);

                    //item.setTotalItem(countTotalItem);
                    itemList.add(item);
                    item.setTotalItem(itemList.size());
                    //add into queue
                    qCustomer.enqueue(item);
                }
                //cust.setTotalItem(countTotalItem);
                //cust = new CustomerInformation(Id,counterPaid);

                customerList.add(cust);
            }
            in.close();
            //System.out.println(itemList.size());
            //System.out.println(customerList.size());

            int countTotalItem = 1;
            for (int i = 0; i < itemList.size() - 1; i++) {
                //CustomerInformation currentCust = customerList.get(i);
                CustomerInformation nextCust = itemList.get(i + 1);
                ItemInformation currentItem = itemList.get(i);

                String currentCustId = currentItem.getID();
                String nextCustId = nextCust.getID();

                // Compare custId(i) with custId(i+1)
                if (currentCustId.equals(nextCustId)) {
                    // custId(i) is equal to custId(i+1)
                    //System.out.println("IF SAME  "+nextCustId);
                    countTotalItem++;
                    // Perform the desired action
                } else {
                    // custId(i) is not equal to custId(i+1)
                    countTotalItem = 1;
                    // Perform the desired action
                }
                currentItem.setTotalItem(countTotalItem);
            }

            String previousId = null;
            String counter = "";
            for(int i=0;i<qCustomer.size();i++)
            {
                //item = (ItemInformation) qCustomer.dequeue();
                if (itemList.get(i).getTotalItem() <=5)
                {
                    if(qCounter1.size() <= qCounter2.size())
                    {
                        item = (ItemInformation) qCustomer.dequeue();
                        qCounter1.offer(item);
                        counter = "1";
                        break;
                        //System.out.println("Counter 1 : "+item);
                        //qCounter1.offer(item);
                        //countTotalItem = itemList.size();
                        //System.out.println(qCounter1 + "Counter1 " + countTotalItem + "\n"  );
                    }
                    else
                    {
                        item = (ItemInformation) qCustomer.dequeue();
                        //System.out.println("Counter 2 : "+item);
                        qCounter2.offer(item);
                        counter = "2";
                        
                        //countTotalItem = itemList.size();
                        //System.out.println(qCounter2 + "Counter2 " + countTotalItem + "\n"  );
                    }
                }
                else 
                {
                    item = (ItemInformation) qCustomer.dequeue();
                    qCounter3.offer(item);
                    counter = "3";
                    break;
                }

            }

            int menu = 0;
            do
            {
                String input;
                input = JOptionPane.showInputDialog("Menu 1 - Remove and add new customer at counter 1 "+ 
                    "\nMenu 2 - Remove and add new customer at counter 2"+
                    "\nMenu 3 - Remove and add new customer at counter 3"+
                    "\nMenu 4 - Exit and display completed customer");
                menu = Integer.parseInt(input);
                //counter 1
                if(menu == 1)
                {
                    while(!qCounter1.isEmpty())
                    {
                        for(int i=0;i<5;i++){
                            item = (ItemInformation) qCounter1.poll(); //hold dequeue item to an object
                            qCounter1.offer(qCustomer.dequeue()); //remove waiting customer & push into customer 1
                            
                            CompletedStack.push(item);
                        }
                        //ask user to remove another customer or not
                        String answer = JOptionPane.showInputDialog("Do you want to remove another customer? (Yes/No)");
                        if(answer.equalsIgnoreCase("Yes"))
                        {
                            continue;
                        }
                        else
                        {
                            break;
                        }
                    }
                }
                else if( menu == 2)
                {
                    while(!qCounter2.isEmpty())
                    {
                        for(int i=0;i<5;i++){
                            item = (ItemInformation) qCounter2.poll(); //hold dequeue item to an object
                            qCounter2.offer(qCustomer.dequeue()); //remove waiting customer & push into customer 2

                            //add into qCompleted
                            CompletedStack.push(item);
                        }
                        //ask user to remove another customer or not
                        String answer = JOptionPane.showInputDialog("Do you want to remove another customer? (Yes/No)");
                        if(answer.equalsIgnoreCase("Yes"))
                        {
                            continue;
                        }
                        else
                        {
                            break;
                        }
                    }
                }
                else if( menu == 3)
                {
                    while(!qCounter3.isEmpty())
                    {
                        for(int i=0;i<5;i++){
                            item = (ItemInformation) qCounter3.poll(); //hold dequeue item to an object
                            qCounter3.offer(qCustomer.dequeue()); //remove waiting customer & push into customer 3

                            //add into qCompleted
                            CompletedStack.push(item);
                        }
                        //ask user to remove another customer or not
                        String answer = JOptionPane.showInputDialog("Do you want to remove another customer? (Yes/No)");
                        if(answer.equalsIgnoreCase("Yes"))
                        {
                            continue;
                        }
                        else
                        {
                            break;
                        }
                    }
                }
            }while( menu != 4); 

            //display completed customer with total payment 
            while(!CompletedStack.isEmpty())
            {
                item = (ItemInformation) CompletedStack.pop(); //dequeue and save to object
                System.out.println("\t\t WELCOME TO SVT SUPERMARKET ");
                System.out.println("\t\t Thank you for purchasing!");
                System.out.println(" Customer Id : " + item.getID());
                System.out.println(" Item Purchased : "+ item.getItemId() +"\t"+ item.getItemName());
                double total = 0.00;
                for (int i = 0; i < itemList.size() - 1; i++) {
                    //CustomerInformation currentCust = customerList.get(i);
                    ItemInformation nextCust = itemList.get(i + 1);
                    ItemInformation currentItem = itemList.get(i);

                    String currentCustId = currentItem.getID();
                    String nextCustId = nextCust.getID();
                }

                System.out.println(" Total : RM " + item.getTotalPrice() );
                System.out.println(" Counter : " + counter );
                System.out.println("\t\tPlease visit us again!\n");
            }

        }
        catch (FileNotFoundException fnfe)
        {
            System.out.println ("File not found");
        }

        catch (IOException ioe)
        {
            System.out.println (ioe.getMessage());
        }
    }
}