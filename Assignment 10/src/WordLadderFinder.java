import java.util.ArrayList;

public class WordLadderFinder {

    // add instance variables here
	private ArrayList<String> myCon;
	private int wordLength;

    /**
     * create a Word Ladder Finder using the specified word list
     * @param wordList != null, wordList.length > 0,
     * no elements of wordList are null,
     * all elements of wordList are the same length,
     * elements of wordList are sorted in ascending order
     */
    public WordLadderFinder(String[] wordList) {
    	
    	assert wordList != null && wordList.length > 0;
    	
    	myCon = new ArrayList<String>();
    	wordLength = wordList[0].length();
    	for(int i = 0; i < wordList.length; i++)
    	{
    		assert wordList[i].length() == wordLength && wordList[i] != null;
    		myCon.add(wordList[i]);
    	}
    	
    }

    /**
     * find a word ladder using the breadth first search and a linear search for words one letter different
     *
     * @param start != null, start.length() == lengthOfWords()
     * @param end != null, end.length() == lengthOfWords()
     * @return an ArrayList of size() 0 if no ladder exists between start and end, otherwise return an ArrayList that
     * contains the words of a minimum length ladder between start and end. start is at position 0, end is at
     * position size() - 1, and all other entries are in the proper order
     */
    public ArrayList<String> breadthFirstLinearSearch(String start, String end) {
    	
    	
    	assert start!= null && start.length() == lengthOfWords() && end != null
    		&& end.length() == lengthOfWords() && myCon.contains(start) && myCon.contains(end);
    	
    	ArrayList<String> output = new ArrayList<String>();
    	Stack<String> st = new Stack<String>();
    	Stack<String> tempSt = new Stack<String>();
    	Queue<Stack<String>> q = new Queue<Stack<String>>();
    	String stringTemp = "";
    	boolean ladderFound = false;
    	
    	ArrayList<String> myConCopy = new ArrayList<String>();
    	for(int i = 0; i < myCon.size(); i++)
    		myConCopy.add(myCon.get(i));

    	st.push(start);
    	q.enqueue(st);
    	
    	while(!q.isEmpty() && !ladderFound)
    	{
    		tempSt = q.dequeue();
    		stringTemp = tempSt.top();
    		if(letterDifference(stringTemp, end) == 1)
    		{
    			tempSt.push(end);
    			ladderFound = true;
    		}   		
    		else
    		{    			
    			// Linear Search
       			for(int i = 0; i < myConCopy.size(); i++)
    			{
    				stringTemp = myConCopy.get(i);
    				if(letterDifference(tempSt.top(), stringTemp) == 1)
    				{
    					st = (Stack<String>) tempSt.getCopy();
    					st.push(stringTemp);
    					q.enqueue(st);
    					myConCopy.remove(stringTemp);
    				}
    			}
    		}
    		if(ladderFound)
    			output = stackToArrayList(tempSt);
    	}
        return output;
    }
    



    /**
     * find a word ladder using the breadth first search and a binary search for words one letter different
     *
     * @param start != null, start.length() == lengthOfWords()
     * @param end != null, end.length() == lengthOfWords()
     * @return an ArrayList of size() 0 if no ladder exists between start and end, otherwise return an ArrayList that
     * contains the words of a minimum length ladder between start and end. start is at position 0, end is at
     * position size() - 1, and all other entries are in the proper order
     */
    public ArrayList<String> breadthFirstBinarySearch(String start, String end) {
    	
    	
    	assert start!= null && start.length() == lengthOfWords() && end != null
    		&& end.length() == lengthOfWords() && myCon.contains(start) && myCon.contains(end);
    	
    	ArrayList<String> output = new ArrayList<String>();
    	Stack<String> st = new Stack<String>();
    	Stack<String> tempSt = new Stack<String>();
    	Queue<Stack<String>> q = new Queue<Stack<String>>();
    	String stringTemp = "";
    	boolean ladderFound = false;
    	
    	ArrayList<String> myConCopy = new ArrayList<String>();
    	for(int i = 0; i < myCon.size(); i++)
    		myConCopy.add(myCon.get(i));

    	st.push(start);
    	q.enqueue(st);
    	
    	while(!q.isEmpty() && !ladderFound)
    	{
    		tempSt = q.dequeue();
    		stringTemp = tempSt.top();
    		if(letterDifference(stringTemp, end) == 1)
    		{
    			tempSt.push(end);
    			ladderFound = true;
    		}   		
    		else
    		{    	
    			
    			//Binary Search
    			int low = 0;
    			int high = myConCopy.size() - 1;
    			int mid;
    			while( low < high )
    			{
    				mid = low + ((high - low) / 2);		
    				String str = myConCopy.get(mid);
    				int compare = str.compareTo(tempSt.top());
    				if(letterDifference(str, tempSt.top()) == 1)
    				{
    					st = (Stack<String>) tempSt.getCopy();
    					st.push(str);
    					q.enqueue(st);
    					myConCopy.remove(str);
    				}
    				if(compare > 0)
    					high = mid - 1;
    				else if(compare < 0)
    					low = mid + 1;

    				//Need to fix, not looking for end looking for 1 character difference.
    				//Fix this if statement only, rest is OK!.    				
//    				if( myConCopy.get(mid).equals(end) )
//    				{
//    					result = mid;
//    					st = (Stack<String>) tempSt.getCopy();
//    					st.push(stringTemp);
//    					q.enqueue(st);
//    					System.out.println("PRINTTTT" +st);
//    					myConCopy.remove(stringTemp);
//    				}
//    		   
//    				else if( myConCopy.get(mid).compareTo(end) > 0)
//    					low = mid + 1;
//    				else
//    					high = mid - 1;
    		    }
    		}
    		if(ladderFound)
    			output = stackToArrayList(tempSt);
    	}
		return output;
    }
    


    /**
     * returns the length of the words in this word ladder finder. All words must be same length
     * @return the length of the words in this word ladder finder
     */
    public int lengthOfWords() {
        return wordLength;
    }
    
    
    // Method Checks how many letters the 2 words differ by in positions
    // Pre: str1 != null && str2 != null
    // Post: Return how many letters the 2 words differ by in positions; Returns -1 if not same length
    private int letterDifference(String str1, String str2)
    {
    	if(str1.length() != str2.length())
    		return -1;
    	
    	
    	int count = 0;
    	for(int i = 0; i < str1.length(); i++)
    	{
    		if(str1.charAt(i) != str2.charAt(i))
    			count++;
    	}
    	return count;
    }
    
    // Method takes a stack and adds it to an arrayList with the top of the stack at the end
    // Pre: None
    // Post: None
    private ArrayList<String> stackToArrayList(Stack<String> sta)
    {
    	ArrayList<String> result = new ArrayList<String>();
    	while(!sta.isEmpty())
    		result.add(0, sta.pop());
    	return result;
    }
   
    
    
    
    
    
    
    
    /**
     * find a word ladder using a depth first search
     *
     * @param start != null, start.length() == lengthOfWords()
     * @param end != null, end.length() == lengthOfWords()
     * @return an ArrayList of size() 0 if no ladder exists between start and end, otherwise return an ArrayList that
     * contains the words of a minimum length ladder between start and end. start is at position 0, end is at
     * position size() - 1, and all other entries are in the proper order
     */
    public ArrayList<String> depthFirst(String start, String end) {
        // You are not required to do this method. It is an extra option to explore if you would like.
        return new ArrayList<String>();
    }

}
