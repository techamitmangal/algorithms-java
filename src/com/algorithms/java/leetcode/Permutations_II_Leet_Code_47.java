package com.algorithms.java.leetcode;

import java.util.*;

/*
Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.



Example 1:

Input: nums = [1,1,2]
Output:
[[1,1,2],
 [1,2,1],
 [2,1,1]]
Example 2:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]


Constraints:

1 <= nums.length <= 8
-10 <= nums[i] <= 10

 */

public class Permutations_II_Leet_Code_47 {
    public static void main (String[] args) {
        int[] nums = {1,1,2};
        System.out.print(permuteUnique(nums));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> uniquePermuationList = new ArrayList<>();
        List<Integer> outputNums = new ArrayList<Integer>();
        //uniquePermutationUsingRecursion(nums, outputNums, uniquePermuationList);
        System.out.print(uniquePermuationList);
        return uniquePermuationList;
    }

    public static void uniquePermutationUsingRecursion(int[] inputNums, List<Integer> outputNums, List<List<Integer>> uniquePermuationList) {
        if (inputNums.length == 0) {
            uniquePermuationList.add(outputNums);
            return;
        }
        Set<Integer> isUsed = new HashSet<Integer>();
        for (int i=0; i<inputNums.length; i++)  {
                if (!isUsed.contains(inputNums[i])) {
                    isUsed.add(inputNums[i]) ;
                    List<Integer> newOutPut = new ArrayList<>(outputNums);
                    newOutPut.add(inputNums[i]);
                    int[] result = concatenateArrays(Arrays.copyOfRange(inputNums, 0, i), Arrays.copyOfRange(inputNums, i+1, inputNums.length));
                    uniquePermutationUsingRecursion(result, newOutPut, uniquePermuationList);
                }
        }
    }

    public static int [] concatenateArrays (int[] array1, int[] array2) {
        int[] result = new int[array1.length + array2.length];

        // Copy elements from array1
        System.arraycopy(array1, 0, result, 0, array1.length);

        // Copy elements from array2
        System.arraycopy(array2, 0, result, array1.length, array2.length);

        return result;
    }

    public static void uniquePermutationUsingBackTracing() {

    }
}
