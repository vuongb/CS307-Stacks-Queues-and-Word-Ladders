import java.util.ArrayList;

public class Stack<E> implements IStack<E> {
	private ArrayList<E> myCon;


	// Constructors
	public Stack() {
		myCon = new ArrayList<E>();
	}
	
	// Pre: None
	// Post: data = top
	// Method adds the data to the top of the stack
    public void push(E data)
    {
    	myCon.add(data);
    }
    
    
    // Pre: !myCon.isEmpty()
    // Post: returns the top of the stack which is the last thing added
    // Method returns the top of the stack
    public E top()
    {
    	assert !myCon.isEmpty();
    	return myCon.get(myCon.size()-1);
    }
    
    
    // Pre: !myCon.isEmpty()
    // Post: the top of the stack is removed and returned
    // Method removes the top item in the stack
    public E pop()
    {
    	assert !myCon.isEmpty();
    	return myCon.remove(myCon.size()-1);
    }
    
    
    // Pre: None
    // Post: returns a boolean if stack is empty
    // Method determines if the stack is empty
    public boolean isEmpty()
    {
    	return myCon.isEmpty();
    }
    
    
    // Pre: None
    // Post: Returns a copy of the stack
    // Method returns an exact copy of the stack without modifying the contents of the original stack
    public IStack<E> getCopy()
    {
    	IStack<E> output = new Stack<E>();
    	for(int i = 0; i < myCon.size(); i++)
    		output.push(myCon.get(i));
    	
    	return output;
    }
	
}

