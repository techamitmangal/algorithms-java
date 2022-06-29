package com.algorithms.java;

import java.util.ArrayList;
import java.util.Arrays;

/*
Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
Notice that the solution set must not contain duplicate triplets.
Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]
Example 2:

Input: nums = []
Output: []
Example 3:

Input: nums = [0]
Output: []

Constraints:

0 <= nums.length <= 3000
-105 <= nums[i] <= 105
 */
public class ThreeSum {
    public static void main (String[] args) {
        int[] nums = {-1,0,1,2,-1,-4} ;
        threeSumArray(nums);
    }

    public static void threeSumArray (int[] inputArr) {
        int arrayLength = inputArr.length;
        ArrayList<ArrayList<Integer>> tripleSum = new ArrayList<>();
        Arrays.sort(inputArr);
        for (int i=0; i<arrayLength; i++) {
            int j= i + 1 ;
            int k = arrayLength-1;
            while (j < k) {
                if (inputArr[i] + inputArr[j] + inputArr[k] == 0) {
                    ArrayList<Integer> tempList = new ArrayList<>();
                    tempList.add(inputArr[i]);
                    tempList.add(inputArr[j]);
                    tempList.add(inputArr[k]);
                    tripleSum.add(tempList);
                    while ( j+1 < k && inputArr[j+1] == inputArr[j]) j++;
                    while (k-1 > j && inputArr[k-1] == inputArr[k]) k--;
                    j++;
                    k--;
                } else {
                    if (inputArr[i] + inputArr[j] + inputArr[k] > 0) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }
            while (i+1 < arrayLength && inputArr[i] == inputArr[i+1]) i++;
        }
    }
}
