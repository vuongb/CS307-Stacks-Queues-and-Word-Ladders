// Student information for assignment

// Replace Bryan Vuong and Emil Dides with your names:

// On our honor, Bryan Vuong and Emil Dides, 
// this programming assignment is our own work and we have
// not provided this code to anyone else in the class.

// Student 1, Name: Bryan Vuong
// Student 1, UTEID: BKV85
// Student 1, CS307 class unique section id: 
// Student 1, email address: vuong.bryan@gmail.com
// Student 1, TA name: Oliver Jensen
//
// Student 2, Name: Emil Dides
// Student 2, UTEID: ED6295
// Student 2, CS307 class unique section id: 
// Student 2, email address: emildides@gmail.com
// Student 2, TA name: Oliver Jensen
//
// Number of slip days used on this assignment: 1

/*
 * Results of experiments and answers to questions from
 * questions.txt:
 * 
 * 
 * 
 * smart		brain
 * Linear Search: 0.584977429 seconds
 * Binary Search: 
 * 
 * devil		angel
 * Linear Search: 0.343679677 seconds.
 * Binary Search: 
 * 
 * money 		greed
 * Linear Search: 1.438972818 seconds.
 * Binary Search:
 * 
 * quiet		noise
 * Linear Search: 0.753207378 seconds.
 * Binary Search:
 * 
 * quiet		quite
 * Linear Search: 0.081855587 seconds.
 * Binary Search:
 * 
 * trees		angel
 * Linear Search: 1.847091365 seconds.
 * Binary Search:
 * 
 * xerox		zilch
 * Linear Search: 0.001012753 seconds.
 * Binary Search:
 * 
 * zebra		lions
 * Linear Search: 8.03066E-4 seconds.
 * Binary Search:
 * 
 * cools		heats
 * Linear Search: 0.111415078 seconds.
 * Binary Search:
 * 
 * blast		mends
 * Linear Search: 0.074276068 seconds.
 * Binary Search:
 * 
 * total		blank
 * Linear Search: 1.068999193 seconds.
 * Binary Search:
 * 
 * lives		death
 * Linear Search: 0.83097676 seconds.
 * Binary Search:
 * 
 * smile		frown
 * Linear Search: 0.624462586 seconds.
 * Binary Search:
 * 
 */

import java.util.ArrayList;

public class WordLadderTester
{   public void runTests()
    {   System.out.println("\nTest Harness");
        String[] wordList = {"bears", "beats", "crazy", "humid", "scuba", "sears",
                "smart", "stars", "start", "tumid"};
        String[] e1 = {"smart", "start", "stars", "sears", "bears", "beats"};
        String[] e2 = {"humid", "tumid", "timid"};
        String[] e3 = {"bimid", "timid"};
        String[] e5 = {"bears", "sears", "stars", "start"};
        WordLadderFinder f = new WordLadderFinder(wordList);
        ArrayList<String> actual;
        ArrayList<String> expected;

        //test 1
        actual = f.breadthFirstLinearSearch("smart", "beats");
        expected = buildExpected(e1);
        showTestResults(actual, expected, 1);

        //test 2
        actual = f.breadthFirstLinearSearch("humid", "timid");
        expected = buildExpected( e2 );
        showTestResults(actual, expected, 2);

        //test 3
        actual = f.breadthFirstLinearSearch("bimid", "timid");
        expected = buildExpected( e3 );
        showTestResults(actual, expected, 3);

        //test 4
        actual = f.breadthFirstLinearSearch("crazy", "scuba");
        expected.clear();
        showTestResults(actual, expected, 4);

        //test 5
        actual = f.breadthFirstLinearSearch("bears", "start");
        expected = buildExpected( e5 );
        showTestResults(actual, expected, 5);

        //test 6
        actual = f.breadthFirstLinearSearch("helps", "place");
        expected.clear();
        showTestResults(actual, expected, 6);
    }

    private ArrayList<String> buildExpected(String[] words)
    {   ArrayList<String> result = new ArrayList<String>();
        for(int i = 0; i < words.length; i++)
            result.add( words[i] );
        return result;
    }

    private void showTestResults( ArrayList<String> actual, ArrayList<String> expected, int testNum )
    {   
    	if( actual.equals(expected) )
            System.out.println( "Passed test " + testNum + ".");
        else
            System.out.println( "Failed test " + testNum + ".");
    }
}

