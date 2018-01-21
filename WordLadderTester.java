// Student information for assignment

// Replace <NAME1> and <NAME2> with your names:

// On <my|our> honor, <NAME1> and <NAME2>, 
// this programming assignment is <my|our> own work and <we|I> have
// not provided this code to anyone else in the class.

// Student 1, Name:
// Student 1, UTEID:
// Student 1, CS307 class unique section id: 
// Student 1, email address:
// Student 1, TA name:
//
// Student 2, Name:
// Student 2, UTEID:
// Student 2, CS307 class unique section id: 
// Student 2, email address:
// Student 2, TA name:
//
// Number of slip days used on this assignment:

/*
 * Results of experiments and answers to questions from
 * questions.txt:
 * 
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
    {   if( actual.equals(expected) )
            System.out.println( "Passed test " + testNum + ".");
        else
            System.out.println( "Failed test " + testNum + ".");
    }
}
