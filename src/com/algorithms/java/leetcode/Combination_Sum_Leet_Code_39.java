package com.algorithms.java.leetcode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/*

Given an array of distinct integers candidates and a target integer target,
return a list of all unique combinations of candidates where the chosen numbers sum to target.
You may return the combinations in any order.

The same number may be chosen from candidates an unlimited number of times.
Two combinations are unique if the
frequency of at least one of the chosen numbers is different.

The test cases are generated such that the number of unique combinations
that sum up to target is less than 150 combinations for the given input.

Example 1:
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
Explanation:
2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
7 is a candidate, and 7 = 7.
These are the only two combinations.

Example 2:
Input: candidates = [2,3,5], target = 8
Output: [[2,2,2,2],[2,3,3],[3,5]]

Example 3:
Input: candidates = [2], target = 1
Output: []


 */

public class Combination_Sum_Leet_Code_39 {

    public static void main (String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7 ;
        combinationSum(candidates, target);
    }

    public static ArrayList<ArrayList<Integer>> combinationSum(int[] candidates, int target) {
        ArrayList<ArrayList<Integer>> finalCombSumList = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> currentCombSumList = new ArrayList<>();
        int arrLength = candidates.length;
        findCombination(candidates, target, 0, arrLength, currentCombSumList, finalCombSumList);
        for (ArrayList<Integer> combination : finalCombSumList) {
            System.out.println(combination);
        }
        return finalCombSumList ;
    }

    public static void findCombination(int[] candidates, int target, int start, int arrLength,
                                       ArrayList<Integer> currentCombSumList, ArrayList<ArrayList<Integer>> finalCombSumList) {

        if (target == 0) {
            finalCombSumList.add(new ArrayList<>(currentCombSumList));
            return;
        }

        for (int i=start; i<arrLength; i++) {
            if (candidates[i] <= target) {
                int candidate = candidates[i] ;
                currentCombSumList.add(candidate);
                findCombination(candidates, target - candidate, i, arrLength, currentCombSumList, finalCombSumList);
                currentCombSumList.remove(currentCombSumList.size()-1);
            }
        }

    }

    @Test
    public void  combinationSumTest() {
        ArrayList<Integer> comb1 = new ArrayList<Integer>(Arrays.asList(2, 2, 3));
        ArrayList<Integer> comb2 = new ArrayList<Integer>(Arrays.asList(7));
        assertEquals(new ArrayList<ArrayList<Integer>>(Arrays.asList(comb1,comb2)),
                Combination_Sum_Leet_Code_39.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

}
