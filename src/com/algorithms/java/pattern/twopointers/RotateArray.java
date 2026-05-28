package com.algorithms.java.pattern.twopointers;

import java.util.Arrays;

/*

Given an integer array, nums, shift its elements to the right by k positions.
In other words, rotate the array to the right by k steps, where k is non-negative.

Example 1
Input:
nums = [1,2,3,4,5,6,7], k = 3

Output:
[5,6,7,1,2,3,4]
Explanation
rotate 1 step to the right: [7,1,2,3,4,5,6]
rotate 2 steps to the right: [6,7,1,2,3,4,5]
rotate 3 steps to the right: [5,6,7,1,2,3,4]
Example 2
Input:
nums = [-1,-100,3,99], k = 2

Output:
[3,99,-1,-100]

Explanation
rotate 1 step to the right: [99,-1,-100,3]
rotate 2 steps to the right: [3,99,-1,-100]
Constraints
1 <= nums.length <= 10^3
-2^31 <= nums[i] <= 2^31 - 1
0 <= k <= 10^3
Follow-up

Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.

Could you do it in-place with O(1) extra space?

*/
public class RotateArray {
    public static void main (String[] args) {
        int[] nums = {1,2,3,4,5} ;
        int k = 2 ;
        rotate(nums, k) ;
        System.out.println("Rotated Array is = " + Arrays.toString(nums));
    }

    /*
        Let’s look at the algorithm steps:

        Normalize the rotation steps. Compute the length of the array, n,
        and set k = k % n to handle cases where k is greater than n. This ensures we only rotate by the effective number of steps.

        Reverse the entire array. Set two pointers: left = 0 and right = n - 1.
        While left < right, swap nums[left] and nums[right], then move the pointers inward (left += 1, right -= 1).

        Reverse the first k elements. Set left = 0 and right = k - 1.
        While left < right, swap nums[left] and nums[right], then move both pointers inward.

        Reverse the remaining n - k elements. Set left = k and right = n - 1.
        While left < right, swap nums[left] and nums[right], then move both pointers inward.

        After these three reversals, all elements in nums will have been rotated to the right by k steps in place.
     */

    public static void rotate(int[] nums, int k) {
        int length = nums.length;
        if (k > length) {
            k = k % length ;
        }
        // Reverse the array
        int start = 0 ;
        int end = length - 1;
        reverse (nums, start, end);
        reverse(nums, 0, k-1);
        reverse(nums, k, end);
    }

    public static void reverse (int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start] ;
            nums[start] = nums[end] ;
            nums[end] = temp;
            start ++ ;
            end -- ;
        }
    }
}

