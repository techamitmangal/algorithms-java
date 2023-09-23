/*
There is an integer array nums sorted in ascending order (with distinct values).

Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].

Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
Example 2:

Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
Example 3:

Input: nums = [1], target = 0
Output: -1


Constraints:

1 <= nums.length <= 5000
-104 <= nums[i] <= 104
All values of nums are unique.
nums is an ascending array that is possibly rotated.
-104 <= target <= 104
 */

package com.algorithms.java;

public class SearchInRotatedSortedArray {
    public static void main (String[] args) {
        int[] nums = {1,3};
        int target = 3;
        System.out.println("Pivot Index = " + searchWithBinary(nums, target));
    }

    public static int searchWithBinary(int[] nums, int target) {
        int pivotIndex = -1 ;
        // Special case
        if (nums == null || nums.length == 0) {
            return pivotIndex;
        }

        int arrLength = nums.length - 1 ;
        int left = 0;
        int right = arrLength;

        while (right > left) {
            int mid = left + (right - left) / 2;
            if (nums[mid]  > nums[right]) {
                left = mid + 1;
            } else {
               right = mid;
            }
        }

        int pivot = left;
        left = 0;
        right = arrLength;

        if (target >= nums[pivot] && target <= nums[right]) {
            left = pivot;
        } else {
            right = pivot;
        }

        while (right >= left) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                pivotIndex = mid;
                break;
            } else {
                if (nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return pivotIndex;
    }

    public static int search(int[] nums, int target) {
        int pivotIndex = -1 ;
        int arrLength = nums.length - 1 ;
        for (int i=0, j=arrLength; j>=i; i++,j--) {
            int leftVal = nums[i];
            int rightVal = nums[j];

            if (target == leftVal) {
                pivotIndex = i ;
                break;
            }

            if (target == rightVal) {
                pivotIndex =  arrLength - i;
                break;
            }

        }
        return pivotIndex;
    }
}
