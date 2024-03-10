    package com.algorithms.java;

    /*
    Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.

    Example 1:
    Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
    Output: 6
    Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
    In this case, 6 units of rain water (blue section) are being trapped.

    Example 2:
    Input: height = [4,2,0,3,2,5]
    Output: 9

    Constraints:
    n == height.length
    1 <= n <= 2 * 104
    0 <= height[i] <= 105
    */

    public class Trapping_Rain_Water_Leet_Code_42 {
    public static void main (String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("Trapped Water = " + trap(height));
    }

    public static int trap(int[] height) {
        int trappedWater = 0;
        int arrLength = height.length;
        int leftIndex = 0;
        int rightIndex = arrLength - 1;
        int leftMaxHeight = 0;
        int rightMaxHeight = 0;

        while (leftIndex<=rightIndex) {
            if (height[leftIndex] <= height[rightIndex]) {
                if (height[leftIndex] >= leftMaxHeight) {
                    leftMaxHeight = height[leftIndex] ;
                } else {
                    trappedWater = trappedWater + leftMaxHeight - height[leftIndex] ;
                }
                ++leftIndex;
            } else {
                if (height[rightIndex]>=rightMaxHeight) {
                    rightMaxHeight = height[rightIndex] ;
                } else {
                    trappedWater = trappedWater + rightMaxHeight - height[rightIndex] ;
                }
                --rightIndex;
            }
        }

        return trappedWater;
    }
    }
