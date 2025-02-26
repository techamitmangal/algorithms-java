/*
Given a sorted array of distinct integers and a target value, return the index if the target is found.
If not, return the index where it would be if it were inserted in order.

You must write an algorithm with O(log n) runtime complexity.

Example 1:

Input: nums = [1,3,5,6], target = 5
Output: 2
Example 2:

Input: nums = [1,3,5,6], target = 2
Output: 1
Example 3:

Input: nums = [1,3,5,6], target = 7
Output: 4


Constraints:

1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums contains distinct values sorted in ascending order.
-104 <= target <= 104
 */

package com.algorithms.java.leetcode;

public class LeetCode35 {
    public static void main (String[] args) {
        int[] nums = {1,3};
        int target = 2;
        System.out.println("Target Index = " + searchInsert(nums, target));
    }

    public static int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length ==0 || target < nums[0]) {
            return 0;
        }
        int arrLength = nums.length - 1;
        if (target > nums[arrLength]) {
            return arrLength + 1;
        }

        int targetIndex = -1 ;
        int left = 0;
        int right = arrLength;

        while (right >= left) {
            int mid = left + (right - left) / 2 ;
            if (nums[mid] == target) {
                targetIndex = mid ;
                break;
            } else {
                if (target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        if (targetIndex == -1) {
            return left;
        }
        return targetIndex;
    }

}
