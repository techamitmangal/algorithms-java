/*
Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.



Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]


Constraints:

1 <= nums.length <= 6
-10 <= nums[i] <= 10
All the integers of nums are unique.
 */

package com.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.List;

public class Permutations_Leet_Code_46 {
    static int count = 0 ;
    public static void main (String[] args) {
        int[] nums = {1,2,3};
        System.out.print(permute(nums).toString());
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
        // find a solution, add to result
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int num : nums) {
            // if already have the number, skip
            System.out.print("calling for loop = " + count + "\n");
            count++;
            if (tempList.contains(num)) {
                System.out.print("Going to Continue = \n");
                continue;
            }
            tempList.add(num);
            System.out.print("tempList = " + tempList.toString() + "\n");
            // continue adding next one
            backtrack(result, tempList, nums);
            // remove the last added one
            System.out.print("tempList before removing = " + tempList.toString() + "\n" );
            tempList.removeLast();
            System.out.print("tempList after removing = " + tempList.toString() + "\n");
        }
    }

}
