package Sorting;

import java.util.Arrays;

public class SelectionSort {
    void sort(int arr[])
    {
        int n = arr.length;

        // One by one move boundary of unsorted subarray
        for (int i = 0; i < n-1; i++)
        {
            // Find the minimum element in unsorted array
            int min_idx = i;
            for (int j = i+1; j < n; j++)
                if (arr[j] < arr[min_idx])
                    min_idx = j;

            // Swap the found minimum element with the first
            // element
            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
     public static void main(String args[])
    {
        int arr[] = { 12, 11, 13, 5, 6 };

        System.out.println("Unsorted array : " + Arrays.toString(arr));
        
        SelectionSort ob = new SelectionSort();
        
        ob.sort(arr);

        System.out.println("Sorted array : " + Arrays.toString(arr));
        
    }
}
