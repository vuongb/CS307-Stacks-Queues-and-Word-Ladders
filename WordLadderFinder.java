import java.util.ArrayList;

public class WordLadderFinder {

    // add instance variables here

    /**
     * create a Word Ladder Finder using the specified word list
     * @param wordList != null, wordList.length > 0,
     * no elements of wordList are null,
     * all elements of wordList are the same length,
     * elements of wordList are sorted in ascending order
     */
    public WordLadderFinder(String[] wordList) {

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
        return new ArrayList<String>();
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
        return new ArrayList<String>();
    }

    /**
     * returns the length of the words in this word ladder finder. All words must be same length
     * @return the length of the words in this word ladder finder
     */
    public int lengthOfWords() {
        // CS307 students, fix this method
        return -1;
    }

}
