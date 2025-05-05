package com.algorithms.java.leetcode;

/*Given a string str, find the length of the longest substring without repeating characters.
For “ABDEFGABEF”, the longest substring are “BDEFGA” and “DEFGAB”, with length 6.
For “BBBB” the longest substring is “B”, with length 1.
For “GEEKSFORGEEKS”, there are two longest substrings shown in the below diagrams, with length 7*/
public class LongestSubStringWithoutRepeating {

    public static void main (String[] args) {
        System.out.println("Longest substring length = " + longestSubString("geeksforgeeks"));
    }

    public static int longestSubString (String str) {
        String longestSubStr = "";
        int maxLength = -1 ;
        if (str.isEmpty()) {
            return 0 ;
        }
        if (str.length()==1){
            return 1;
        }
        for (char c : str.toCharArray()) {
            String tempStr = String.valueOf(c);
            if (longestSubStr.contains(tempStr)) {
                longestSubStr = longestSubStr.substring(longestSubStr.indexOf(tempStr)+1);
            }
            longestSubStr = longestSubStr + tempStr;
            maxLength = Math.max(longestSubStr.length(), maxLength);
        }
        return maxLength ;
    }
}

