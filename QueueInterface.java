
public interface QueueInterface<T>
{
    void insert(T element) throws QueueOverflowException;

    T remove() throws QueueUnderflowException;

    Boolean isEmpty();
}
