package com.algorithms.java.leetcode;

import java.util.HashMap;

public class LongestCommonPrefix {
    public static void main (String[] args) {
        String[] strs = {"flower","flow","flight"} ;
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        int length = strs.length;
        if (length==0) return "" ;
        String prefixStr = strs[0];
        int longestCommonPreValue = Integer.MAX_VALUE ;
        for (int j=1; j<length; j++) {
            String strj = strs[j];
            int strjLength = strj.length();
            int prefixStrLength = prefixStr.length();
            int k;
            for (k=0; k<prefixStrLength && k<strjLength; k++) {
                Character ch = prefixStr.charAt(k);
                if (ch == null || ch != strj.charAt(k)) {
                    if (longestCommonPreValue > k) {
                        longestCommonPreValue = k ;
                        prefixStr = prefixStr.substring(0, longestCommonPreValue);
                    }
                    break;
                }
            }
            if (k==strjLength) {
                prefixStr = strj;
            }
        }
        return prefixStr;
    }
}
