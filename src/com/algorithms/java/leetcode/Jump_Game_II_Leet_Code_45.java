/*

You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].

Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i],
you can jump to any nums[i + j] where:

0 <= j <= nums[i] and
i + j < n
Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].



Example 1:

Input: nums = [2,3,1,1,4]
Output: 2
Explanation: The minimum number of jumps to reach the last index is 2. Jump 1 step from index 0 to 1, then 3 steps to the last index.
Example 2:

Input: nums = [2,3,0,1,4]
Output: 2


Constraints:

1 <= nums.length <= 104
0 <= nums[i] <= 1000
It's guaranteed that you can reach nums[n - 1].

*/


package com.algorithms.java.leetcode;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Jump_Game_II_Leet_Code_45 {
    public static void main (String[] args) {
        int[] nums = {2,3,1,1,4};
        System.out.print("Minimum jumps required = " + jump(nums));
    }
    public static int jump(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int minJump = 0;
        int destination  = nums.length - 1;
        int maxJumpIndex = 0;
        int lastJumpIndex = 0;
        for (int i=0; i<destination; i++) {
            maxJumpIndex = Math.max(maxJumpIndex, i + nums[i]);
            if (i == lastJumpIndex) {
                lastJumpIndex = maxJumpIndex ;
                minJump++;

                if (maxJumpIndex >= destination) {
                    return minJump ;
                }
            }
        }

        return minJump;
    }

    @Test
    public void testJump() {
        int nums[] = {2,3,1,1,4};
        int minJump = jump(nums);
        assertEquals(minJump, 2);
    }
}
