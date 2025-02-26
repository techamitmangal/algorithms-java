/*
34. Find First and Last Position of Element in Sorted Array
Medium
17.9K
437
Companies
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
Example 2:

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
Example 3:

Input: nums = [], target = 0
Output: [-1,-1]


Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums is a non-decreasing array.
-109 <= target <= 109
 */

package com.algorithms.java.leetcode;

public class LeetCode34 {
    public static void main (String[] args) {
        int[] nums = {5};
        int target = 5;
        System.out.println("Range = " + searchRange(nums, target)[0] + " Second = " + searchRange(nums, target)[1]);
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] rangeArr = {-1,-1} ;
        if (nums == null || nums.length == 0) {
            return rangeArr ;
        }

        int arrLength = nums.length - 1;
        int left = 0 ;
        int right = arrLength ;
        int leftIndex = -1 ;
        int nextLeft = -1 ;
        while (right >= left) {
            int mid = left + (right - left) / 2 ;
            if (nums[mid] == target) {
                if (nextLeft == -1) {
                    nextLeft = mid;
                }
                leftIndex = mid ;
                right = mid - 1 ;
            } else {
                if (nums[mid] > target) {
                    right = mid - 1 ;
                } else {
                    left = mid + 1 ;
                }
            }
        }

        if (leftIndex == -1) {
            return rangeArr ;
        }

        rangeArr[0] = leftIndex ;
        left = nextLeft ;
        right = arrLength ;
        //Find right most index
        nextLeft = -1 ;
        while (right >= left) {
            int mid = left + (right - left) / 2 ;
            if (nums[mid] == target) {
                nextLeft = mid ;
                left = mid + 1 ;
            } else {
                right = mid - 1;
            }
        }
        if (nextLeft == -1) {
            rangeArr[1] = leftIndex ;
        } else {
            rangeArr[1] = nextLeft ;
        }

        return rangeArr;
    }
}
