package com.algorithms.java.pattern.twopointers;

/*
You are given a string, word, and an integer numFriends, representing the number of friends participating in a game organized by Alice.

The game consists of multiple rounds, and in each round:

The string word is split into exactly numFriends non-empty substrings.

The split must be unique; no previous round has produced the same sequence of splits.

All resulting substrings from the split are placed into a box.

When all rounds are over and all possible unique splits have been performed, determine the
lexicographically largest string among all the substrings in the box.
Lexicographically Larger String (Plain English)

A string A is considered larger than string B if:

Compare both strings from left to right.
Find the first position where the characters are different.
The string with the character that comes later in the alphabet at that position is larger.
Example:
"cat" > "car" because 't' comes after 'r'.
"zebra" > "apple" because 'z' comes after 'a'.
If one string is an exact prefix of the other (all compared characters are the same), then the longer string is larger.
Example:
"abcd" > "abc"
"banana" > "ban"*/

public class LexicographicallyLargestString {
    public static void main (String[] args) {
        int numFriends = 2;
        String word = "banana";
        System.out.println("Laxicograp = " + answerString(word, numFriends));
    }

    public static String answerString(String word, int numFriends) {
        if (numFriends == 1) {
            return word;
        }
        int wordLen = word.length();

        //Agar total numFriends parts chahiye word string ke to
        //ek substring ko maximum bada banana hai, to baaki numFriends-1 parts ko minimum 1-1 character denge.
        int maxSubStrLen = wordLen - (numFriends - 1) ;

        int i = 0;
        int j = i + 1;
        int k = 0 ;
        /* i = first candidate suffix
        j = second candidate suffix
        k = currently matched chars count */

        // Step 1: Find starting index of lexicographically largest suffix using 2 pointers
        // Humein jo substring banani hai uska starting index nikalna hai is loop mein aur maxLen humein maalum hi hai.
        // Is loop mein hum Substring ka starting index nikalenge
        while (j+k < wordLen) {
            char a = word.charAt(i);
            char b = word.charAt(j);

            if (a == b) {
                k++ ;
            } else {
                if (a > b) {
                    // Suffix starting at i is better
                    j = j + k + 1;
                    k = 0;
                } else {
                    //Suffix starting at j is better
                    i = Math.max(i+k+1, j) ;
                    j = i + 1;
                    k = 0;
                }
            }
        }

        //Answer cannot be exceeded than the maxSubStrLen
        // yeah line isliye likhi hai taki substring string ke end ke bahar na chali jaye.
        int end = Math.min(wordLen, i + maxSubStrLen) ;
        return word.substring(i, end);
    }
}
