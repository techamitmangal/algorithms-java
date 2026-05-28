package com.algorithms.java.pattern.twopointers;

/*
    Your task is to rearrange an array, nums, containing positive integers to form the
     next lexicographically greater permutation. This means finding the next permutation
     in the sequence of all possible arrangements sorted in dictionary order.

    For example, given the array [4,5,6], the next permutation is [4,6,5]
    . In the same way, [5,6,4] becomes [6,4,5]
    If the array is already in its highest possible order (sorted in descending order), such as [6,5,4],
    it’s not possible to find a lexicographically larger permutation. In this case,
    you must rearrange the array to its lowest possible order (sorted in ascending order), which would be [4,5,6].
    The entire operation must be completed in-place while using only a constant amount of extra memory.
*/

import java.util.Arrays;

public class NextPermutation {

    public static void main (String[] args) {
        int[] nums = {5, 6, 4} ;
        nextPermutation(nums) ;
    }

    /*

        Sabse right position dhundo jise increase kiya ja sakta hai
        Usko smallest possible larger value se replace karo
        Baaki suffix ko minimum bana do

        Step 1: Right se pehla decreasing point dhundo nums[i] < nums[i + 1].. Is position ko pivot (i) bolte hain.
        Jab pivot milta hai: tab uske right ka part already: descending order mein hota hai.

        Step 2: Right side se nums[i] se just bada number dhundo aur uss number ko nums[i] say swap ker do.
        (iske liye sabsay right say start karo aur jo pehla number mile nums[i] say bada dono position swap ker do..
        kyuki pivot (nums[i]) ke right ka part already: descending order mein hota hai)

        Step 3: i + 1 se end tak reverse karo

  */
    public static void nextPermutation(int[] nums) {
        // Write your code here
        int length = nums.length ;
        int i = length - 2 ;
        while (i >= 0 && nums[i] >= nums[i+1])
            i--;

        int j = length - 1 ;

        if (i>=0) {
            while (j >= i) {
                if (nums[j] >= nums[i]) {
                    int temp = nums[i] ;
                    nums[i] = nums[j] ;
                    nums[j] = temp ;
                    break;
                }
                j -- ;
            }
        }

        reverseArrayFromPivot(nums, i+1, length - 1) ;
        System.out.println("Next Permutation = " + Arrays.toString(nums));
    }

    public static void reverseArrayFromPivot (int[] nums, int start, int end) {
        while (start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
/*
    Time complexity:
    The time complexity of this solution is O(n), because in the worst-case scenario,
    we perform a single pass to find the pivot, another single pass to find the element to swap,
    and a final pass to reverse a part of the array.

    Space complexity
    The solution’s space complexity is O(1), as the permutation is done in-place, and only a constant amount
    of extra memory is used for variables.

 */
}
