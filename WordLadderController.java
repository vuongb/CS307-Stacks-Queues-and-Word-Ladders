import java.io.File;
import java.io.IOException;
import javax.swing.JFileChooser;
import java.util.ArrayList;
import java.util.TreeSet;
import java.util.Scanner;

/**
 * Runs an interactive session for finding word ladders
 * 
 * @author Mike Scott
 * @version 8/1/2005
 */
public class WordLadderController
{   public static final int WORD_SIZE = 5;
    public static final String BREADTH_FIRST = "1";
    public static final String DEPTH_FIRST = "3";
    public static final String BREADTH_FIRST_BINARY = "2";
    
    private Scanner keyboard = new Scanner(System.in);

    // call to run an interactive session of finding word ladders
    public void go()
    {   System.out.println("\nOpening a file chooser window to choose the file with the word list.\nYou may have to minimize other windows to see the file chooser window\n");
        String[] wordList = getWordList();
        runSession(wordList);
    } 

    private void runSession(String[] wordList)
    {   WordLadderFinder finder = new WordLadderFinder(wordList);
        ArrayList<String> result;
        String choice = getChoice();
        String startingWord;
        String endingWord;
        Stopwatch watch = new Stopwatch();
        
        while( isValid(choice) )
        {   startingWord = getWord("starting word", WORD_SIZE);
            endingWord = getWord("ending word", WORD_SIZE); 
            watch.start();
            if( choice.equals( BREADTH_FIRST ) )
                result = finder.breadthFirstLinearSearch(startingWord, endingWord);
            else if( choice.equals( DEPTH_FIRST ) )
                result = finder.depthFirst(startingWord, endingWord);
            else
                result = finder.breadthFirstBinarySearch(startingWord, endingWord);
            watch.stop();
            showResults( result, watch, startingWord, endingWord );
            choice = getChoice();
        } 
        System.out.println("\nEnding session");
    }
    
    private String getChoice()
    {   System.out.println("\nEnter choice for method of finding next ladder.");
        System.out.println("Enter " + BREADTH_FIRST + " to find a ladder using the breadth first method");
        System.out.println("Enter " + BREADTH_FIRST_BINARY + " to find a ladder using the breadth first method with a binary search");
        System.out.println("Enter " + DEPTH_FIRST + " to find a ladder using the depth first method");
        System.out.println("Enter any other character to quit.");
        System.out.print("Enter choice: ");
        return keyboard.next();
    }
    
    private String getWord(String description, int length)
    {   boolean valid = false;
        String result = "";
        while( !valid )
        {   System.out.print("\nEnter the " + description + " for the ladder: ");
            result = keyboard.next();
            valid = (result != null) && (result.length() == WORD_SIZE);
        }
        return result;
    }

    private boolean isValid(String choice)
    {   return choice.equals(BREADTH_FIRST) || choice.equals(DEPTH_FIRST) || choice.equals(BREADTH_FIRST_BINARY);
    }
    
    public void showResults(ArrayList<String> ladder, Stopwatch watch, String start, String end)
    {   String display;
        
        System.out.println( "\nProcess time to find ladder or prove none exists: " + watch );
        
        if( ladder.size() == 0 )
            System.out.println( "No ladder exists between " + start + " and " + end + ".");
        else
        {   System.out.println("Found a ladder of length " + ladder.size() + " between " + start + " and " + end + ".");
            System.out.print("\nDo you want to display the ladder? Enter Y for yes, anything else for no: ");
            display = keyboard.next();
            if( ( display != null ) && (display.length() > 0 ) && (display.substring(0,1).equalsIgnoreCase("Y") ) )
            {   System.out.println("\nComplete ladder:\n");
                for(int i = 0; i < ladder.size(); i++)
                    System.out.println( ladder.get(i) );
            }
        }
    }
    
    private String[] getWordList()
    {   Scanner s;
        String temp;
        JFileChooser chooser = new JFileChooser();
        TreeSet<String> words = new TreeSet<String>();
        
        //open the file chooser and get a file
        int retval = chooser.showOpenDialog(null);
        chooser.grabFocus();
        
        if (retval == JFileChooser.APPROVE_OPTION)
        {   File source = chooser.getSelectedFile();        
            try
            {   s = new Scanner( source );
                while( s.hasNext() )
                {   temp = s.next();
                    if( temp != null && temp.length() == WORD_SIZE )
                    {   words.add( temp.toLowerCase() );
                    }
                }
                
                s.close();
            }
            catch(IOException e)
            {   System.out.println("An error occured while trying to read from the file: " + e);
            }
        }
        return words.toArray(new String[words.size()]);
    }
}
