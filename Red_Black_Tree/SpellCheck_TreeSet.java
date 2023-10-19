package Red_Black_Tree;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.io.File;
import java.io.FileNotFoundException;

public class SpellCheck_TreeSet
{
    public static void main(String[] args) throws FileNotFoundException
    {
        long start = System.currentTimeMillis();

// Read the dictionary (words) and the document (alice30.txt)
        Set<String> dictionaryWords = readWords("C:\\Users\\DJmus\\Downloads\\words");
        Set<String> documentWords = readWords("C:\\Users\\DJmus\\Downloads\\alice30.txt");

// Print all words that are in the document but not the dictionary
        System.out.println("The words are not contained in dictionary: ");

        for (String word : documentWords)
        {
            if (!dictionaryWords.contains(word))
            {
                System.out.println(word);
            }
        }
        long end = System.currentTimeMillis();
        long timeCost=end - start;
        double seconds=timeCost/1000.0;
        System.out.println("\nThe usage of CPU time - TreeSet is " + seconds + " seconds");
    }//Close Main
    public static Set<String> readWords(String filename) throws FileNotFoundException
    {
        Set<String> words = new TreeSet<String>();//O(log n) time complexity.
        Scanner in = new Scanner(new File(filename));
// Use any characters other than a-z or A-Z as delimiters
        //get rid of all characters besides letters a-z and A-Z
        in.useDelimiter("[^a-zA-Z]+");
        while (in.hasNext())
        {
            words.add(in.next().toLowerCase());
        }
        return words;
    }//Ending readWords method
}//Close class