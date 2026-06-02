package com.algorithms.java.pattern.twopointers;


/*

You are given an integer array nums that is already sorted in non-decreasing order.
Your task is to remove the duplicate values in-place so that each element in the array appears only once,
while preserving the original relative order of the elements.

After removing the duplicates, let k be the number of unique elements remaining in the array.
The first k positions of nums should contain these unique elements in sorted order. Any values beyond index k - 1 are
irrelevant and can be ignored.

Your goal is to modify the array in-place and return the value k, representing the count of unique elements.

 */

public class RemoveDuplicatesFromSortedArray {
    public static void main (String[] args) {
        //int[] arr = {2,5,7,9,9,9} ;
        int[] arr = {2,2,3} ;
        removeDuplicates(arr);
    }

    public static int removeDuplicates(int[] nums) {
        int length = nums.length;
        int i = 0;
        int j = 1;
        while (j < length) {
            if (nums[i] == nums[j] ) {
                j ++;
            } else {
                nums[i+1] = nums[j];
                i++;
                j++;
            }
        }
        return i + 1;
    }
}

/*
Code review:
Your implementation of removeDuplicates uses the two pointers pattern correctly, which is the expected approach for this problem.

Strengths:

Uses two pointers (i and j) to traverse the array efficiently in O(n) time and O(1) space.
Properly overwrites duplicates in-place, preserving order.
Returns the correct new length.
Suggestions:

The code is clean and follows the pattern well. No issues found.
You could consider renaming i and j to something more descriptive (like “write” and “read”) for readability, but that’s optional.
Overall, well done applying the correct pattern to this problem!


Time Complexity:

The removeDuplicates function has a time complexity of O(n), where n is the length of the input array nums.
This is because each element is visited at most twice (once by j and possibly once by i).
All array accesses and assignments (nums[i], nums[j], nums[i+1] = nums[j]) are O(1) operations in Java.
No additional built-in Java functions with higher complexity are used.

Space Complexity:
The space complexity of removeDuplicates is O(1). The algorithm uses only a constant amount of extra variables (i, j, length)
regardless of input size, and does not use any Java built-in functions that require extra space.

 */