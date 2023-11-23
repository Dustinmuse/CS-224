package Red_Black_Tree;

import java.util.Set;

public class TestMySet
{
    public static void main(String[] args)
    {
        Set<String> testSet = new MySet<>("C");

        testSet.add("B");

        testSet.add("A");

        System.out.println(testSet);

        testSet.remove("B");
        System.out.println(testSet);

        testSet.remove("A");
        System.out.println(testSet);
    }
}
