package com.algorithms.java.pattern.twopointers;


/*
You are given an integer array, nums, and an integer, val.
Your task is to remove all occurrences of val from nums in place, meaning no additional memory
allocation should be used. The relative order of the elements in the array may be changed.
After modifying the array, return the number of elements that are not equal to val.

Let k represent the number of elements in nums that are not equal to val.
To successfully solve this problem, you need to ensure the following:

Modify the array, nums, such that the first k elements contain values that are not equal to val.

The remaining elements in the array do not matter, and the size of nums is irrelevant after the first k elements.
Return the value of k.
 */
public class RemoveElement {
    public static void main (String[] args) {
        int[] nums= {5, 8, 8, 5, 3} ;
        int val = 5;
        System.out.println("k elements contain values that are not equal to val = " + removeElement(nums, val));
    }

    public static int removeElement(int[] nums, int val) {
        // Replace this placeholder return statement with your code
        int length = nums.length ;
        int secondPointer = 0 ;
        for (int firstPointer = 0; firstPointer < length; firstPointer++) {
            if (nums[firstPointer] != val) {
                nums[secondPointer] = nums[firstPointer] ;
                secondPointer++;
            }
        }
        return secondPointer ;
    }
}
