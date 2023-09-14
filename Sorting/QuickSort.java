package Sorting;

import java.util.Random;

public class QuickSort
{
    public static void main(String[] args)
    {
        QuickSort s1 = new QuickSort();

        //Case 1:

        int[] array1 = new int[] {2, 8, 7, 1, 3, 5, 6, 4};
        System.out.println("Before Quick Sort");

        for(int index = 0; index < array1.length; index++)
        {
            System.out.print(array1[index] + " ");
        }

        s1.quickSort(array1, 0, array1.length - 1);

        System.out.println("\nAfter Quick Sort");

        for(int number: array1)
        {
            System.out.print(number + " ");
        }

        //Case 2:

        Random rand = new Random();
        int[] array2 = new int[1000000];
        for(int i = 0; i < array2.length; i++)
        {
            array2[i] = rand.nextInt(1000000);
        }
        long startTime = System.nanoTime();

        s1.quickSort(array2, 0, array2.length - 1);

        System.out.println("\nAfter Quick Sort");

        for(int number : array2)
        {
            System.out.print(number + " ");
        }
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("\nCPU Time to complete of array2 is: " + totalTime / 1000000000.0 + " seconds");
    }//close main
    void quickSort(int [] array, int lowIndex, int highIndex)
    {
        if(lowIndex >= highIndex)
        {
            return;
        }
        int pivot = array[highIndex];
        int pivotIndex = partition(array, lowIndex, highIndex, pivot);

        //sort the left partition (lower values)
        quickSort(array, lowIndex, pivotIndex - 1);

        //sort the right partition (higher values)
        quickSort(array, pivotIndex - 1, highIndex);
    }//close quicksort method
    int partition(int [] array, int lowIndex, int highIndex, int pivot)
    {
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while(leftPointer < rightPointer)
        {
            //moving leftPointer to right
            while(array[leftPointer] <= pivot && leftPointer < rightPointer)
            {
                leftPointer++;
            }
            //moving rightPointer to left
            while(array[rightPointer] >= pivot && leftPointer < rightPointer)
            {
                rightPointer--;
            }
            swap(array, leftPointer, rightPointer);
        }
        swap(array, leftPointer, highIndex);//swap pivot position
        return leftPointer;//return pivot index position
    }//close partition
    void swap(int [] array, int index1, int index2)
    {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
}//close quicksort class
