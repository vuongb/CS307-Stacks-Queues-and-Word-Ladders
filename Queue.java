import java.util.LinkedList;
import java.util.List;


public class Queue<E> implements IQueue<E>{
	// its actual type must be LinkedList
	private List<E> myCon;
	
	
	// Constructors
	public Queue() {
		myCon = new LinkedList<E>();
	}


}