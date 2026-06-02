package com.algorithms.java.pattern.twopointers;

/*
Given two strings s and t, determine whether s is a subsequence of t. Return TRUE if it is, or FALSE otherwise.
A subsequence of a string is a new string formed by deleting zero or more characters from the original string,
without changing the relative order of the remaining characters.
For example, "ace" is a subsequence of "abcde", whereas "aec" is not.
 */
public class IsSubsequence {
    public static void main (String[] args) {
        String s = "bd" ;
        String t = "abcdefgh" ;
        System.out.println("IsSubsequence = " + isSubsequence(s, t));
    }

    public static boolean isSubsequence(String s, String t) {
        int sLength = s.length();
        int tLength = t.length();
        int i = 0 ;
        int j = 0;
        while (j < tLength && i < sLength) {
            if (t.charAt(j) == s.charAt(i)) {
                i++;
            }
            j++;
        }

        return i == sLength;
    }
}
