public class ArrayQueue<T> implements QueueInterface<T>
{
    public static final int MAX = 10;

    //use only these 3 instance variables!
    //you are NOT ALLOWED to add more instance variables
    private T elements[];
    private int front;
    private int rear;

    public ArrayQueue()
    {
        //awkward syntax!
        elements = (T[]) new Object[MAX];
        /* the usual initialisations
        front = MAX - 1;
        rear = MAX - 1;
        */
        //tweaked here to deliberately force early wrapping!
        front = MAX - 3;
        rear = MAX - 3;
    }
    
    //implement your methods with Javadoc comments here
    //again, you are NOT ALLOWED to add more instance variables
    
    public void insert(T element) throws QueueOverflowException
    {
        if (isFull())
            throw new QueueOverflowException ("Queue overflow"); 
        rear = rear + 1; 
        elements[rear] = element;
    }
    
    public T remove() throws QueueUnderflowException
    {
        return elements[0];
    }
    
    public Boolean isEmpty()
    {
        return rear == front;
    }
    
    public Boolean isFull()
    {
        return front + 1 == rear;
            
    }
}
