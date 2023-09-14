package Sorting;

import java.util.Random;

public class InsertionSort
{
    public static void main(String[] args)
    {
        InsertionSort s1 = new InsertionSort();

        //Case 1:

        int[] array1 = new int[]{5, 2, 4, 6, 1, 3};

        System.out.println("Before Insertion Sort");

        for(int index = 0; index < array1.length; index++)
        {
            System.out.print(array1[index] + " ");
        }

        s1.insertionSort(array1);

        System.out.println("\nAfter Insertion Sort");

        for(int number: array1)
        {
            System.out.print(number + " ");
        }

        //Case 2: Write late on

        Random rand = new Random();

        int[] array2 = new int[10000];

        for(int i = 0; i < array2.length; i++)
        {
            array2[i] = rand.nextInt(10000);
        }

        System.out.println("\nBefore Insertion Sort");

        for(int number: array2)
        {
            System.out.print(number + " ");
        }

        long startTime = System.nanoTime();

        s1.insertionSort(array2);

        System.out.println("\nAfter Insertion Sort");

        for(int number: array2)
        {
            System.out.print(number + " ");
        }

        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.println("\nCPU Time to complete of array2 is: " + totalTime / 1000000000.0 + " seconds");
    } //close main
    void insertionSort(int[] array)
    {
        for(int i = 1; i < array.length; i++) // O(n)
        {
            int key = array[i];
            int j = i - 1;
            while(j >= 0 && array[j] > key) // O(n)
            {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }
    } //close insertionSort
}
