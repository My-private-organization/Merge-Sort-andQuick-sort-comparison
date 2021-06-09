package com.company;

public class QuickSort {

    private static int partition(int[] numbers, int low, int high)
    {
        int pivot = numbers[high];

        int i = (low - 1);

        for(int j = low; j <= high - 1; j++)
        {
            if (numbers[j] < pivot)
            {
                i++;

                int temp = numbers[i];
                numbers[i] = numbers[j];
                numbers[j] = temp;
            }
        }

        int temp = numbers[i+1];
        numbers[i+1] = numbers[high];
        numbers[high] = temp;

        return (i + 1);
    }

    public static void quickSort(int[] arr, int low, int high)
    {
        if (low < high)
        {
            int part = partition(arr, low, high);
            quickSort(arr, low, part - 1);
            quickSort(arr, part + 1, high);
        }
    }

}
