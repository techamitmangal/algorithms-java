package com.algorithms.java.pattern.twopointers;

import java.util.Arrays;

/*
You are given two integer arrays nums1 and nums2 of lengths m and n respectively. nums1 and nums2 represent the digits of two numbers. You are also given an integer k.

Create the maximum number of length k <= m + n from digits of the two numbers. The relative order of the digits from the same array must be preserved.

Return an array of the k digits representing the answer.



Example 1:

Input: nums1 = [3,4,6,5], nums2 = [9,1,2,5,8,3], k = 5
Output: [9,8,6,5,3]
Example 2:

Input: nums1 = [6,7], nums2 = [6,0,4], k = 5
Output: [6,7,6,0,4]
Example 3:

Input: nums1 = [3,9], nums2 = [8,9], k = 3
Output: [9,8,9]


Constraints:

m == nums1.length
n == nums2.length
1 <= m, n <= 500
0 <= nums1[i], nums2[i] <= 9
1 <= k <= m + n
nums1 and nums2 do not have leading zeros.

 */
public class CreateMaximumNumber {
    public static void main (String[] args) {
        int[] nums1 = {5, 1, 0};
        int[] nums2 = {9, 2, 3};
        int k = 4 ;
        int[] actual = maxNumber(nums1, nums2, k);
        System.out.printf("\t The maximum number possible is: %s%n", Arrays.toString(actual));
        System.out.println(new String(new char[100]).replace('\0', '-'));
    }

    /*
    Try every possible way of taking x digits from nums1 and k-x digits from nums2, get the maximum subsequence
    from each, merge them greedily, and keep the best result.
     */
    public static int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] maxSumArr = new int[k];
        // maan lo hum x digits nums1 say lete hai to k-x digits nums2 say leni hogi.
        // ab is logic ke hisaab say x kabhi bhi k - len2 say chota nahi ho sakta aur x kabhi bhi len1 say bada nahi ho sakta kyuki
        // x = how many digits we take from nums1
        // k - x = how many digits we take from nums2
        //
        // x cannot be less than k - len2 because nums2 has only len2 digits.
        // x cannot be more than len1 because nums1 has only len1 digits.

        //nums1 se minimum kitne aur maximum kitne digits le sakte hain.

        //minimum digits from nums1
        //nums2 ke pass maximum len2 digits hai, agar answer ki length k hai to nums2 maximum len2 contribute kr sakta hai
        //Baaki digits nums1 say lene padenge to minimum from nums1 = k - len2.. Lekin yeah negative bhi ho sakta hai.
        // minimum digits  0 say k-len2 hogi jo bhi Maximum ho.

        int start = Math.max(0, k-len2) ;

        //maximum digits from nums1
        // nums1 mein total len1 digits hai aur answer ki length k hai... agar saari digits nums1 say le to nums1 say min(len1, k)
        // lena hoga.. yaani len1 agar k say chota hai to to saari digits aur agar len1 agar k say bada hai to k digits.

        int end = Math.min(len1, k) ;
        for (int x = start; x <= end; x++) {
            int[] part1 = maxSequence(nums1, x);
            int[] part2 = maxSequence(nums2, k-x);
            int[] bestPossible = merge(part1, part2) ;
            maxSumArr = bestPossible;
        }

        return maxSumArr;
    }

    private static int[] maxSequence (int[] nums, int len) {
        int[] stack = new int[len];
        int top = 0;
        int drop = nums.length - len; // Number of digits we are allowed to remove
        for (int digit : nums) {
            if ( top > 0 && drop > 0 && stack[top] < digit) {
                top-- ;
                drop-- ;
            }

            if (top < len) {
                stack[top] = digit ;
                top ++ ;
            } else {
                //Stack already full so this digit is skipped
                drop --;
            }
        }
        return stack ;
    }

    //Merge Two arrays into the largest possible
    private static int[] merge(int[] a, int[] b) {
        int i = 0;
        int j = 0;
        int k = 0;
        int aLen = a.length;
        int bLen = b.length;
        int[] mergedArray = new int[aLen + bLen];
        while (i < aLen && j < bLen) {
            if (a[i] > a[j]) {
                mergedArray[k] = a[i] ;
                i++;
                k++;
            } else {
                if (a[j] > a[i]) {
                    mergedArray[k] = a[j] ;
                    j++;
                    k++;
                } else {
                    mergedArray[k] = a[i];
                    i++;
                    j++;
                    k++;
                }
            }
        }
        return mergedArray ;
    }
}
