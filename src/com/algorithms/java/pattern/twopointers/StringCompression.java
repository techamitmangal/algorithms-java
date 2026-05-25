package com.algorithms.java.pattern.twopointers;

/*
Given an array of characters, chars, compress it in place according to the following rules:

Start with an empty string s.

For each group of consecutive repeating characters in chars:

If the group length is 1, append just the character to s.

Otherwise, append the character followed by the group length.

The compressed string s should not be returned separately; instead,
it must be written directly into the input character array chars. Note that if a group’s length is 10 or greater,
each digit of the length should be stored as a separate character in chars.

After modifying the array, return the new length of the compressed array.

Note: Your solution must use only constant extra space. Any characters beyond the returned length in chars can be ignored.

Constraints:
1 ≤ chars.length ≤ 2000
chars[i] is a lowercase English letter, an uppercase English letter, a digit, or a symbol.
 */

public class StringCompression {
    public static void main (String[] args) {
        char[] chars = {'a','a','b','b','c','c','c'} ;
        //char[] chars = {'a','b','c'} ;
        System.out.println("Compressed array length = " + compress(chars));
    }

    public static int compress(char[] chars) {
        int length = chars.length;
        int i = 0;
        int k = 0;
        while (i < length) {
            int j = i ;
            while (j < length && chars[j] == chars[i]) {
                j++;
            }
            int count = j - i ;
            chars[k++] = chars[i] ;
            if (count > 1) {
                for (char ch : String.valueOf(count).toCharArray()) {
                    chars[k++] = ch ;
                }
            }
            i = j ;
        }
        return k;
    }
}
