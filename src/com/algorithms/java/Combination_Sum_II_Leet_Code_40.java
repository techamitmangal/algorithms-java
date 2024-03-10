package com.algorithms.java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*

Given a collection of candidate numbers (candidates) and a target number (target),
find all unique combinations in candidates where the candidate numbers sum to target.
Each number in candidates may only be used once in the combination.
Note: The solution set must not contain duplicate combinations.

Example 1:
Input: candidates = [10,1,2,7,6,1,5], target = 8
Output:
[
[1,1,6],
[1,2,5],
[1,7],
[2,6]
]
Example 2:

Input: candidates = [2,5,2,1,2], target = 5
Output:
[
[1,2,2],
[5]
]

Constraints:

1 <= candidates.length <= 100
1 <= candidates[i] <= 50
1 <= target <= 30

 */

public class Combination_Sum_II_Leet_Code_40 {
    public static void main (String[] args) {
        int[] candidates = {14,6,25,9,30,20,33,34,28,30,16,12,31,9,9,12,34,16,25,32,8,7,30,12,33,20,21,29,24,17,27,34,11,17,30,6,32,21,27,17,16,8,24,12,12,28,11,33,10,32,22,13,34,18,12};
        int target = 27;
        combinationSum2(candidates, target);
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> currentList = new ArrayList<>();
        int arrLength = candidates.length;
        Arrays.sort(candidates);
        findSum(candidates, target, arrLength, 0, currentList, result);
        for (List<Integer> combination : result) {
            System.out.println(combination);
        }
        return result;
    }

    public static void findSum(int[] candidates, int target, int arrLength, int start, List<Integer> currentList, List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        if (target < 0) {
            return;
        }

        for (int i = start; i<arrLength; i++) {
            if (i>start && candidates[i]==candidates[i-1]) {
                continue;
            }
            currentList.add(candidates[i]);
            findSum(candidates, target - candidates[i], arrLength, i+1, currentList, result);
            currentList.remove(currentList.size()-1);
        }
    }
}
