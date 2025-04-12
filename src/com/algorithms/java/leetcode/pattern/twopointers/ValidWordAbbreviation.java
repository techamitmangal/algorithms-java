package com.algorithms.java.leetcode.pattern.twopointers;

public class ValidWordAbbreviation {
    public static void main (String[] args) {
        String str = "whsfrmkvubvzhlnuubu";
        String abbr = "wh13232l1";
        System.out.println(validWordAbbreviation(str, abbr));
    }

    public static boolean validWordAbbreviation(String word, String abbr) {
        int abbrIndex = 0 ;
        int wordIndex = 0 ;
        int abbrLen = abbr.length();
        int wordLength = word.length();

        while (abbrIndex < abbrLen) {
            if (abbr.charAt(abbrIndex) == '0') {
                return false;
            }

            if (Character.isDigit(abbr.charAt(abbrIndex))) {
                int num = 0;
                while (abbrIndex < abbrLen && Character.isDigit(abbr.charAt(abbrIndex))) {
                    num = num * 10 + (abbr.charAt(abbrIndex) - '0');
                    abbrIndex++;
                }
                wordIndex = wordIndex + num;
            } else {
                if (wordIndex >= wordLength || abbr.charAt(abbrIndex) != word.charAt(wordIndex)) {
                    return false;
                } else {
                    abbrIndex++;
                    wordIndex++;
                }
            }
        }

        return abbrIndex == abbrLen && wordIndex == wordLength;
    }
}
