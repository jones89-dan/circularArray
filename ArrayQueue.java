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
    
    /**
    * insert method checks for full queue, if not adds to the rear of the queue.
    * 
    * @param element - generic item to be added to the queue.
    */
    public void insert(T element) throws QueueOverflowException
    {
        // checks if queue is full and throws exception if true
        if (isFull())
            throw new QueueOverflowException ("Queue overflow"); 
        
        // checks rear and wraps to the first position, else increments rear
        if (rear == MAX - 1) 
            rear = 0; 
        else 
            rear = rear + 1; 
        
        // insert element at the rear of queue
        elements[rear] = element;
    }
    
    /**
    * remove method checks for empty queue, if not removes first item.
    * 
    * @return temp - item removed from end of the queue.
    */
    public T remove() throws QueueUnderflowException
    {
        // checks if queue and throws exception if true
        if (isEmpty())
            throw new QueueUnderflowException ("Queue underflow"); 
       
        // checks front and wraps to the first position, else increments front
        if (front == MAX - 1)
            front = 0;
        else
            front = front + 1; 
        
        // item to be removed and returns the value
        T temp = elements[front];
        return temp;
    }
    
    /**
    * isEmpty checks for empy queue.
    * 
    * @return boolean - True if rear and front are at the same position in array.
    */
    public Boolean isEmpty()
    {
        return rear == front;
    }
    
    /**
    * isFull  checks for full queue.
    * 
    * @return boolean - True if we updated rear and front is equal to rear.
    */
    public Boolean isFull()
    {
        return rear + 1 == front;
            
    }
}