package Sorting;

import java.util.Random;

public class MergeSort
{
    public static void main(String[] args)
    {
        //Case 1

        int[] array1 = {7, 6, 4, 5, 2, 3};
        System.out.println("Before Merge Sort");

        for(int number: array1)
        {
            System.out.print(number + " ");
        }

        int lowIndex = 0;
        int highIndex = array1.length - 1;

        array1 = mergeSort(array1, lowIndex, highIndex);
        System.out.println("\nAfter Merge Sort");

        for(int number: array1)
        {
            System.out.print(number + " ");
        }

        //Case 2

        Random rand = new Random();
        int[] array2 = new int[1000000];

        for(int i = 0; i < array2.length; i++)
        {
            array2[i] = rand.nextInt(1000000);
        }

        long startTime = System.nanoTime();

        array2 = mergeSort(array2, 0, array2.length - 1);
        System.out.println("\nAfter merge sort array2: ");

        for(int number: array2)
        {
            System.out.print(number + " ");
        }

        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;

        System.out.println("\nCPU Time to complete of array2 is: " + totalTime / 1000000000.0 + " seconds!");
    }//Close main
    private static int[] mergeSort(int[] array, int lowIndex, int highIndex)
    {
        if(lowIndex == highIndex)
        {
            return new int[]{array[lowIndex]};
        }

        int midIndex = (highIndex + lowIndex) / 2;
        int[] leftHalf = mergeSort(array, lowIndex, midIndex);
        int[] rightHalf = mergeSort(array, midIndex + 1, highIndex);

        return merge(leftHalf, rightHalf);
    }//Close mergeSort
    private static int[] merge(int[] leftArray, int[] rightArray)
    {
        int[] result = new int[leftArray.length + rightArray.length];
        int left = 0;
        int right = 0;
        int index = 0;

        while(left < leftArray.length && right < rightArray.length)
        {
            if(leftArray[left] < rightArray[right])
            {
                result[index] = leftArray[left];
                left++; index++;
            }//Close if
            else
            {
                result[index] = rightArray[right];
                right++; index++;
            }//Close else
        }//close while
        while(left < leftArray.length)
        {
            result[index] = leftArray[left];
            left++; index++;
        }

        while(right < rightArray.length)
        {
            result[index] = rightArray[right];
            right++; index++;
        }

        return result;
    }//Close merge method
}
