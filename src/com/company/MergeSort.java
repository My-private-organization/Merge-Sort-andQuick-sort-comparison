package com.company;

public class MergeSort {

    public static void mergeSort( int[] numbers, int low, int high)
    {
        if (low < high) {
            int mid =low+ (high-low)/2;

            mergeSort(numbers, low, mid);
            mergeSort(numbers, mid + 1, high);

            merge(numbers, low, mid, high);
        }
    }


    private static void merge(int[] numbers, int lower, int mid, int upper)
    {
        int n1 = mid - lower + 1;
        int n2 = upper - mid;

        int[] leftArray = new int[n1];
        int[] rightArray = new int[n2];

        System.arraycopy(numbers, lower, leftArray, 0, n1);

        for (int j = 0; j < n2; ++j)
            rightArray[j] = numbers[mid + 1 + j];


        int i = 0, j = 0;
        int k = lower;

        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                numbers[k++] = leftArray[i++];
            }
            else {
                numbers[k++] = rightArray[j++];
            }
        }

        while (i < n1) {
            numbers[k++] = leftArray[i++];
        }

        while (j < n2) {
            numbers[k++] = rightArray[j++];
        }
    }

}
