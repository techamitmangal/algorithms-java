package com.algorithms.java.pattern.twopointers;

/*
Given a string s, reverse only the vowels in the string and return the resulting string.
The vowels are ‘a’, ‘e’, ‘i’, ‘o’, and ‘u’, and they can appear in both lowercase and uppercase, potentially more than once.

Constraints:
1 ≤ s.length ≤ 3 × 10^5

Example 1

Input:

s = "IceCreAm"

Output:

"AceCreIm"

Explanation:

The vowels in s are ['I', 'e', 'e', 'A'].
On reversing the vowels, s becomes "AceCreIm".

Example 2

Input:

s = "leetcode"

Output:

"leotcede"


*/
public class ReverseVowelsofaString {
    public static void main (String[] args) {
        System.out.print("Reversed String = " + reverseVowels("programming"));
    }

    public static String reverseVowels(String s) {
        char[] vowels = {'a', 'e', 'i', 'o','u', 'A', 'E', 'I', 'O', 'U'} ;
        return new String();
    }
}
