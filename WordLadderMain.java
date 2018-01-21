import java.util.Scanner;

public class WordLadderMain
{   
    public static void main(String[] args)
    {   Scanner s = new Scanner(System.in);
        System.out.print("Enter 1 to run test harness, 2 to run interactive word ladder sessions: ");
        if( s.next().equals("1") )
        {   WordLadderTester t = new WordLadderTester();
            t.runTests();
        }
        else
        {   WordLadderController c = new WordLadderController();
            c.go();
        }
    }

}
