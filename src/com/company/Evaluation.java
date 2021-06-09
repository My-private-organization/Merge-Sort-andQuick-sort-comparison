package com.company;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Evaluation {

    public static void main( String[] args ) {

        Scanner scanner = new Scanner(System.in);

        while(true) {

            System.out.print("Please enter the number of elements of the array: ");

            int n = scanner.nextInt();
            int[] array;

            System.out.print("Please enter order off array(1 for asc, 2 for desc, 3 for random): ");
            int order = scanner.nextInt();

            if(order == 1)
                array = generateAscArray(n);
            else if(order == 2)
                array = generateDescArray(n);
            else
                array = generateRandomArray(n);

            //This array will be used for quick sort
            int[] copyArray = Arrays.copyOf(array, n);

            long startTimeOfMergeSort = System.currentTimeMillis();
            MergeSort.mergeSort(array, 0, n-1);
            long stopTimeOfMergeSort = System.currentTimeMillis();
            System.out.println("Merge Sort took : " + (stopTimeOfMergeSort - startTimeOfMergeSort) + " milliseconds");

            long startTimeOfQuickSort = System.currentTimeMillis();
            QuickSort.quickSort(copyArray, 0, n-1);
            long stopTimeOfQuickSort = System.currentTimeMillis();
            System.out.println("Quick Sort took: " + (stopTimeOfQuickSort - startTimeOfQuickSort) + " milliseconds");

            

        }

    }

    private static int[] generateRandomArray(int n ) {
        return new Random().ints(n, 0, 10000).toArray();
    }

    private static int[] generateDescArray(int n ) {

        int rand = new Random().nextInt(Integer.MAX_VALUE - n) + n;
        int[] array = new int[n];

        array[0] = rand;

        for(int i=1; i<n; i++){
            array[i] = array[i-1] - 1;
        }

        return array;
    }

    private static int[] generateAscArray(int n ) {
        int rand = new Random().nextInt(100);

        int[] array = new int[n];
        array[0] = rand;

        for (int i = 1; i < n; i++) {
            array[i] = array[i-1] + 1;
        }

        return array;
    }
}
