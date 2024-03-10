package com.algorithms.java;

public class MergeSort {
    public static void main (String[] args) {
        int arr[] = {34,45,23,89,56,67,89,88,55};
        int left = 0;
        int right = arr.length;
        sortItems(arr, left, right-1);
        printArray(arr);
    }

    /* A utility function to print array of size n */
    static void printArray(int arr[])
    {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void sortItems(int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            //Find the middle point
            int middle = leftIndex + (rightIndex-leftIndex)/2;;
            //sort first and second halves
            sortItems(arr, leftIndex, middle);
            sortItems(arr, middle + 1, rightIndex);
            //Merge the sorted halves
            merge(arr, leftIndex, middle, rightIndex);

        }
    }

    public static void merge (int[] arr, int leftIndex, int middleIndex, int rightIndex) {
        //Find the sizes of 2 subarrays to be merged
        int n1 = middleIndex - leftIndex + 1 ;
        int n2 = rightIndex - middleIndex ;

        /*Create temp arrays*/
        int L[] = new int [n1] ;
        int R[] = new int [n2] ;

        /*Copy Data to temp arrays*/
        for (int i=0; i<n1; i++)
            L[i] = arr[leftIndex + i]; //Take elements from left index to size of array from main array
        for (int j=0; j<n2; j++)
            R[j] = arr[middleIndex + 1 + j];

        //Merge temp SubArrays
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        //Initial index of merged subarray array
        int k = leftIndex ; // merged subarray will start from leftIndex and will go to rightIndex
        //We will start leftIndex from main array and merge that
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }

    }
}
