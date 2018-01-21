
public interface IQueue<E> {
    //pre:none
    //post: add data to the end of this Queue
    public void enqueue(E data);

    //pre: !isEmpty()
    //post: return the item that has been in this Queue the longest amount of time
    public E front();
    
    //pre: !isEmpty()
    //post: remove and return the item that has been in this Queue the longest amount of time    
    public E dequeue();
    
    public boolean isEmpty();
}
