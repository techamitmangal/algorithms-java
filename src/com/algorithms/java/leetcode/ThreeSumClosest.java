package com.algorithms.java.leetcode;

import java.util.Arrays;

/*
Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.
Return the sum of the three integers.
You may assume that each input would have exactly one solution.
Example 1:
Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:

Input: nums = [0,0,0], target = 1
Output: 0

Constraints:
3 <= nums.length <= 1000
-1000 <= nums[i] <= 1000
-104 <= target <= 104

*/
public class ThreeSumClosest {
    public static void main (String[] args) {
        int[] nums = {0,0,0};
        System.out.println("Target Sum = " + threeSumClosest(nums, 1));
    }

    public static int threeSumClosest(int[] nums, int target) {
        int result = 0;
        int min = Integer.MAX_VALUE ;
        int arrayLength = nums.length;
        Arrays.sort(nums);
        for (int i=0; i<arrayLength; i++) {
            int j = i+1;
            int k = arrayLength - 1 ;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k] ;
                if ( sum == target) {
                    return target ;
                }
                int diff = Math.abs(sum - target);
                if (diff < min) {
                    min = diff;
                    result = sum ;
                }
                if (sum<=target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return result;
    }
}
