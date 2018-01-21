
public interface IStack<E> {
   //pre: none, post: top() = data
    public void push(E data);
    
    //pre: !isEmpty() 
    //post: return the top item of this stack
    public E top();
    
    public boolean isEmpty();
    
    //pre: !isEmpty()
    //post: remove and return the top item of this stack
    public E pop();  
    
    // return a copy of this stack
    public IStack<E> getCopy();
}
