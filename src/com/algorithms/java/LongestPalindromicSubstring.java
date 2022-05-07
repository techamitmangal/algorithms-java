package com.algorithms.java;

public class LongestPalindromicSubstring {
    public static void main (String[] args) {
        String subStr = longestPalindromicSubStr("jdfshajkhsafashjkhfaskhfs");
        String subStringWithDP = longestPalindromicSubStrWithDp("jdfshajkhsafashjkhfaskhfs");
        System.out.println("subStr = " + subStr) ;
        System.out.println("subStringWithDP = " + subStringWithDP);
    }
    static int resultLength = 0;
    static int resultStart ;
    public static String longestPalindromicSubStr(String inputStr) {
        int strLength = inputStr.length();
        if (strLength == 0) return  "";
        if (strLength == 1) return inputStr;

        for (int start = 0; start < strLength - 1; start++) {
            expandFromMiddle(inputStr, start, start);
            expandFromMiddle(inputStr, start, start+1);
        }
        return inputStr.substring(resultStart, resultStart + resultLength);
    }

    public static void expandFromMiddle (String str, int begin, int end) {
        while (begin >= 0 && end < str.length() && str.charAt(begin) == str.charAt(end)) {
            begin -- ;
            end ++ ;
        }
        if (resultLength < end - begin -1) {
            resultLength = end - begin -1;
            resultStart = begin + 1;
        }
    }

    // Using Dynamic Programming.
    /*
    1) Maintain a boolean table[n][n] that is filled in bottom up manner.
    2) The value of table[i][j] is true, if the substring is palindrome, otherwise false.
    3) To calculate table[i][j], check the value of table[i+1][j-1], if the value is true and str[i] is same as str[j], then we make table[i][j] true.
    4) Otherwise, the value of table[i][j] is made false.
    5) We have to fill table previously for substring of length = 1 and length =2 because
       as we are finding , if table[i+1][j-1] is true or false , so in case of
    6) (i) length == 1 , lets say i=2 , j=2 and i+1,j-1 doesn’t lies between [i , j]
    7) (ii) length == 2 ,lets say i=2 , j=3 and i+1,j-1 again doesn’t lies between [i , j].
     */

    public static String longestPalindromicSubStrWithDp(String str) {
        boolean dp[][] = new boolean[str.length()][str.length()];
        int lenght = 0 ;
        int startIndex = 0 ;
        for (int gap = 0; gap < str.length(); gap++) {
            //Start of each string from row 0
            //End of each string will be last column
            //Means every column start point will be 0, gap.. gap is representing column here
            //j will start from the gap and reach till end of the gap
            for (int i=0, j = gap; j < str.length(); i++, j++) {
                if (gap == 0) {
                    dp[i][j] = true;
                } else {
                    if (gap == 1) {
                        if (str.charAt(i) == str.charAt(j)) {
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = false;
                        }
                    } else {
                        //checking diagonally back to one step
                        if (str.charAt(i) == str.charAt(j) && dp[i + 1][j - 1] == true) {
                            dp[i][j] = true;
                        } else {
                            dp[i][j] = false;
                        }
                    }
                }
                if (dp[i][j]) {
                    lenght = gap + 1;
                    startIndex = i;
                }
            }
        }
        return str.substring(startIndex, startIndex+lenght) ;
    }

}
