import java.util.LinkedList;
import java.util.List;


public class Queue<E> implements IQueue<E>{
	// its actual type must be LinkedList
	private List<E> myCon;

	
	// Constructors
	public Queue() {
		myCon = new LinkedList<E>();
	}
	
	
	// Method adds an item to the end of the queue
	// Pre: None
	// Post: parameter item is now added to the end of the queue
	public void enqueue(E data)
	{
		myCon.add(data);
	}
	
	
	// Method returns the item that has been waiting the longest
	// Pre: !list.isEmpty()
	// Post: return the item that has been in this Queue the longest amount of time
	public E front() {
		assert !myCon.isEmpty();
		return myCon.get(0);
	}
	
	// Method removes and returns the item that has been waiting the longest
	// Pre: !list.isEmpty()
	// Post: remove and return the item that has been waiting the longest
	public E dequeue() {
		assert !myCon.isEmpty();
		
		return myCon.remove(0);
	}
	
	public boolean isEmpty(){
		return myCon.isEmpty();
	}
	

}