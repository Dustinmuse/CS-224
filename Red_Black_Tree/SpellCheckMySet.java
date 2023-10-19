package Red_Black_Tree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Set;
import java.util.Scanner;

public class SpellCheckMySet
{
    public static void main(String[] args) throws FileNotFoundException
    {
// Read the dictionary and the document
        long start=System.currentTimeMillis();
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
        long end=System.currentTimeMillis();
        long timeCost=end - start;
        double seconds=timeCost/1000.0;
        System.out.println("\nThe usage of CPU – MySet time is " + seconds+" seconds");
    }//close main method
    /**
     Reads all words from a file.
     @param filename the name of the file
     @return a set with all lowercased words in the file. Here, a
     word is a sequence of upper- and lowercase letters.
     */
    public static Set<String> readWords(String filename)
            throws FileNotFoundException
    {
        Set<String> words = new MySet<String>();//with O(n) time complexity
        Scanner in = new Scanner(new File(filename));
// Use any characters other than a-z or A-Z as delimiters
        in.useDelimiter("[^a-zA-Z]+");
        while (in.hasNext())
        {
            words.add(in.next().toLowerCase());
        }
        return words;
    }
}
