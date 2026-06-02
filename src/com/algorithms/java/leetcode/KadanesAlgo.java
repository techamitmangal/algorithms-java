package com.algorithms.java.leetcode;

/*
Given an array of integers (which may contain both positive and negative numbers),
find the contiguous subarray with the largest sum and return that maximum sum.

Example 1

Input:

[-2, 1, -3, 4, -1, 2, 1, -5, 4]

Output:

6

Explanation:
The contiguous subarray [4, -1, 2, 1] has the largest sum:

4 + (-1) + 2 + 1 = 6
Example 2

Input:

[1]

Output:

1
Example 3

Input:

[5, 4, -1, 7, 8]

Output:

23
Constraints
1 <= n <= 10^5
-10^4 <= arr[i] <= 10^4
Goal

Design an algorithm that finds the maximum subarray sum in O(n) time and O(1) extra space.

This problem is commonly known as the Maximum Subarray Problem, and Kadane's Algorithm is the optimal linear-time solution.
 */
public class KadanesAlgo {
    public static void main (String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4} ;
        System.out.println("max Sub Array = " + maxSubarraySum(nums));
    }

    public static int maxSubarraySum (int[] nums) {
        int length = nums.length ;
        if (length == 0) {
            return 0 ;
        }
        int maxSum = nums[0] ;
        int sum = nums[0] ;
        int i = 1 ;


        while (i < length) {
            //Ye line: har index par ye decision leti hai:
            //Kya mujhe current element se nayi subarray start karni chahiye, ya purani subarray ko continue karna chahiye?
            sum = Math.max(nums[i], sum + nums[i]);
            //Ab tak jo sabse bada sum mila hai, use update kar lo.
            maxSum = Math.max(sum, maxSum);
            i++;
        }

        return  maxSum;
    }
}
