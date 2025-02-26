package com.algorithms.java.leetcode;

public class MedianOfTwoSortedArray {
    public static void main (String[] args) {
        int[] arr = {23, 34, 12, 56, 34, 89, 45, 33} ;
        sortArr (arr, 0, arr.length - 1) ;
        for (int i=0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }
    }

    public static void sortArr (int[] arr, int leftIndex, int rightIndex) {
        if (leftIndex < rightIndex) {
            int midIndex = (leftIndex + rightIndex) / 2 ;
            sortArr(arr, leftIndex, midIndex);
            sortArr(arr, midIndex + 1, rightIndex);
            mergeSort(arr, leftIndex, midIndex, rightIndex) ;
        }
    }

    public static void mergeSort (int[] arr, int leftIndex, int middleIndex, int rightIndex) {
        int n1 = middleIndex - leftIndex + 1 ;
        int n2 = rightIndex - middleIndex ;

        int L[] = new int [n1];
        int R[] = new int [n2];

        for (int i=0; i<n1; i++) {
            L[i] = arr[leftIndex + i];
        }

        for (int j=0; j<n2; j++) {
            R[j] = arr[middleIndex + 1 + j] ;
        }

        int i=0, j=0;
        int k = leftIndex ;

        while (n1>i && n2>j) {
            if (L[i]>R[j]) {
                arr[k] = R[j] ;
                j++;
            } else {
                arr[k] = L[i];
                i++;
            }
            k++;
        }

        while (n1>i) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (n2>j) {
            arr[k] = R[j];
            j++;
            k++;
        }

     }

}
