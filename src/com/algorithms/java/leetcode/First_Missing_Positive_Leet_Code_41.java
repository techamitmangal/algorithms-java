package com.algorithms.java.leetcode;

/*

Given an unsorted integer array nums, return the smallest missing positive integer.

You must implement an algorithm that runs in O(n) time and uses O(1) auxiliary space.

Example 1:
Input: nums = [1,2,0]
Output: 3
Explanation: The numbers in the range [1,2] are all in the array.

Example 2:
Input: nums = [3,4,-1,1]
Output: 2
Explanation: 1 is in the array but 2 is missing.
Example 3:

Input: nums = [7,8,9,11,12]
Output: 1
Explanation: The smallest positive integer 1 is missing.


Constraints:

1 <= nums.length <= 105
-231 <= nums[i] <= 231 - 1

 */

import java.util.Arrays;

public class First_Missing_Positive_Leet_Code_41 {

    public static void main (String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,9,10,11,12,23,20}; /// O/P = 13
        System.out.println(firstMissingPositive(nums));
    }

    public static int firstMissingPositive(int[] nums) {
        int arrLength = nums.length;
        int i=0;
        for (; i<arrLength; i++) {
            if (nums[i] == 1) {
                break;
            }
        }

        if (i==arrLength) {
            return 1;
        }

        // If present then, again traverse the array. The largest possible answer is arrLength+1 where arrLength is the size of the array.
        // When traversing the array, if we find any number less than 1 or greater than arrLength, change it to 1.
        for (i=0; i<arrLength; i++) {
            if (nums[i]<1 || nums[i]>arrLength) {
                nums[i] = 1;
            }
        }

        for (i=0; i<arrLength; i++) {
            int index = nums[i];
            if (index<0) {
                index = -index;
            }
            index--;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        for (i=0; i<arrLength; i++) {
            if (nums[i]>0) {
                break;
            }
        }

        return i+1;
    }

    public static int firstMissingPositiveWithSorting(int[] nums) {
        int missingInt = 0 ;
        int arrLength = nums.length;

        //The smallest positive integer is 1. First, we will check if 1 is present in the array or not.
        // If it is not present then 1 is the answer.
        int i=0;
        for (; i<arrLength; i++) {
            if (nums[i] == 1) {
                break;
            }
        }

        if (i==arrLength) {
            missingInt = 1;
            return missingInt;
        }

        // If present then, again traverse the array. The largest possible answer is arrLength+1 where arrLength is the size of the array.
        // When traversing the array, if we find any number less than 1 or greater than arrLength, change it to 1.

        for (i=0; i<arrLength; i++) {
            if (nums[i]<1 || nums[i]>arrLength) {
                nums[i] = 1;
            }
        }

        sortArray(nums, 0, arrLength-1);

        for (i=0; i<arrLength-1; i++) {
            if (nums[i+1] == nums[i] || nums[i+1] == nums[i] + 1) {
                continue;
            } else {
                missingInt = nums[i] + 1;
                break;
            }
        }

        if (missingInt == 0) {
            missingInt = nums[arrLength-1] + 1;
        }

        return missingInt;
    }

    public static void sortArray (int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2 ;
            sortArray(nums, left, mid);
            sortArray(nums, mid+1, right);
            mergeSortedArray(nums, left, mid, right);
        }
    }

    public static void mergeSortedArray (int[] nums, int left, int mid, int right ) {
        int leftArrSize = mid - left + 1 ;
        int rightArrSize = right - mid ;

        //Create temp arrays
        int[] leftTempArr = new int[leftArrSize];
        int[] rightTempArr = new int[rightArrSize];

        //Copy data to temp Array
        for (int i=0; i<leftArrSize; i++) {
            leftTempArr[i] = nums[left+i];
        }

        for (int j=0; j<rightArrSize; j++) {
            rightTempArr[j] = nums[mid+1+j];
        }

        //Merge temp sub arrays
        int i = 0, j = 0;

        //Initial index of merged subarray array
        int k = left; // merged subarray will start from leftIndex and will go to rightIndex

        while (i<leftArrSize && j<rightArrSize) {
            int tempL = leftTempArr[i];
            int tempR = rightTempArr[j];
            if (tempL >= tempR) {
                nums[k] = tempR;
                j++;
            } else {
                nums[k] = tempL;
                i++;
            }
            k++;
        }

        while (i < leftArrSize) {
            nums[k] = leftTempArr[i];
            i++;
            k++;
        }

        while (j < rightArrSize) {
            nums[k] = rightTempArr[j];
            j++;
            k++;
        }

     }
}
