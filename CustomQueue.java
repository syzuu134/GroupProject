
//import the LinkedList package
import java.util.LinkedList;

public class CustomQueue<Object>
{
    private LinkedList<Object> q;//Declare the object of queue 
    //using LinkedList
    int size = 0;

    //Constructor without param
    public CustomQueue()
    {
        q = new LinkedList<>();
    }//end of constructor

    //method to insert an object to a queue
    public void enqueue(Object item)
    {
        q.addLast(item);
        size++;
    }//end of enqueue

    //method to remove an object from a queue
    public Object dequeue() {
        if (!empty()) {
            // size--;
            return q.removeFirst(); // Remove the first element / front
        } else {
            System.out.println("Queue is empty!");
            return null; // Return null for an empty value
        }
    }
    //end of dequeue

    //method to test whether the queue is empty or not
    public boolean empty() 
    {
        return (q.size() == 0);
    }//end of empty 

    //return the element at the front without removing it
    public Object front()
    {
        return q.getFirst();
    }

    public boolean isEmpty() {
        return q.isEmpty();
    }

    public int size()
    {
        return size;
    }
}//end of Queue