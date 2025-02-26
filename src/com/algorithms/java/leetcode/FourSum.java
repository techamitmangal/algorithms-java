package com.algorithms.java.leetcode;

import javax.swing.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourSum {
    static class Pair {
        public int x, y;
        Pair (int x, int y) {
            this.x = x ;
            this.y = y ;
        }
    }
    public static void main (String[] args) {
        int[] nums = { 2, 7, 4, 0, 9, 5, 1, 3};
        int target = 20;
        System.out.println("Four Sum = " + hasQuadruplet(nums, target)) ;
    }
    //Naive recursive approach
    public static void hasQuadrupletNaiveRecursive() {

    }

    public static boolean hasQuadruplet(int[] numArr, int numTarget) {
        //create an empty map
        //key -> target of a pair
        // value -> list storing an index of every pair having that sum
        Map<Integer, List<Pair>> map = new HashMap<>();
        int arrLength = numArr.length;
        for (int i=0; i<arrLength-1; i++) {
            //Start from i+1 element until the last element
            for (int j=i+1; j < arrLength; j++) {
                //calculate the remaining sum
                int val = numTarget - (numArr[i] + numArr[j]) ;
                //if the remaining sum is found in map,
                //We have found the quadruplet
                if (map.containsKey(val)) {
                    // check every pair having a sum equal to the remaining sum
                    for (Pair pair: map.get(val)) {
                        int x = pair.x;
                        int y = pair.y;
                        //if a quadruplet doesn't overlap, print it and
                        // return true
                        if ((x != i && x != j) && (y != i && y != j)) {
                            System.out.println("Quadruplet Found ("
                                    + numArr[i] + ", " + numArr[j] + ", "
                                    + numArr[x] + ", " + numArr[y] + ")");
                            return true;
                        }
                    }
                }
                //insert the current pair into the map
                // null check (java 8)
                map.putIfAbsent(numArr[i] + numArr[j], new ArrayList<>());
                map.get(numArr[i] + numArr[j]).add(new Pair(i, j));
            }
        }

        return false ;
    }
}
