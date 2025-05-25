package com.algorithms.java.leetcode.pattern.twopointers;

import java.util.Arrays;

/*
Given a numeric string, numStr, representing a palindrome (composed only of digits). Return the smallest palindrome larger than numStr that can be created by rearranging its digits. If no such palindrome exists, return an empty string "".

Consider the following example to understand the expected output for a given numeric string:

input string = "123321"

The valid palindromes made from the exact digits are "213312", "231132", "312213", "132231", "321123".

We return the palindrome "132231" because it is the smallest palindrome larger than the input string "123321".

Constraints:
1≤ numStr.length ≤ 10^5
numStr is a palindrome.
 */
public class NextPalindromeUsingSameDigits {
    public static void main (String[] args) {
        String s = "123321";
        //O/P = "132231"
        System.out.println("Next Palindrome = " + findNextPalindrome(s));
    }

    public static String findNextPalindrome(String numStr) {
        // Replace the following return statement with your code
        int strLength = numStr.length();
        int index = strLength/2 - 1;
        int[] numArr = Arrays.stream(numStr.split("")).mapToInt(Integer::parseInt).toArray();
        for (int i=0; i<=index; i++) {
            int tempNum = numArr[i];
        }
        return "";
    }

    public static String findNextPalindromeEducativeCode(String numStr) {

        // Replace the following return statement with your code
        return "";
    }
}
