package com.algorithms.java.leetcode;
/*
Given an array of positive integers representing the values of coins in your possession,
write a function that returns the minimum amount of change (the minimum sum of money) that you cannot create.
The given coins can have any positive integer value and aren’t necessarily unique (i.e., you can have multiple coins of the same value).
For example, if you’re given coins = [1, 2, 5], the minimum amount of change that you can’t create is 4.
If you’re given no coins, the minimum amount of change that you can’t create is 1.

Sample Input
coins = [5, 7, 1, 1, 2, 3, 22]

Sample Output
20
 */

import java.util.Arrays;

public class NonConstructibleChange {
    public static void main (String[] args) {
        int[] intArray = new int[]{5, 7, 1, 1, 2, 3, 22};
        Arrays.sort(intArray);
        nonConstructibleChange(intArray);
    }

    public static void nonConstructibleChange (int[] sortedArr) {
        int minimumChange = 1 ;
        for (int i=0; i< sortedArr.length; i++) {
            if (sortedArr[i] > minimumChange) {
                break;
            }
            minimumChange = minimumChange + sortedArr[i] ;
        }
        System.out.println("minimum amount change = " + minimumChange);
    }
}
