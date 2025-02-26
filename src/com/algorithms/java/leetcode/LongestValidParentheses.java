/*
Given a string containing just the characters '(' and ')', return the length of the longest valid (well-formed) parentheses
substring
.
Example 1:

Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".
Example 2:

Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".
Example 3:

Input: s = ""
Output: 0


Constraints:

0 <= s.length <= 3 * 104
s[i] is '(', or ')'.
 */

package com.algorithms.java.leetcode;

import java.util.HashMap;
import java.util.Stack;

public class LongestValidParentheses {
    public static void main (String[] args) {
        String s = "(()" ;
        System.out.println("Longest Valid Parentheses = " + longestValidParentheses(s));
    }

    public static int longestValidParentheses(String s) {
        int strLength = s.length();
        int openParentheses = 0 ;
        int closeParentheses = 0 ;
        int longestValidCount = 0;

        for (int i=0; i<strLength; i++) {
            char tempChar = s.charAt(i) ;
            if (tempChar == '(') {
                ++openParentheses;
            } else {
                ++closeParentheses;
            }

            if (openParentheses == closeParentheses) {
                int length = openParentheses + closeParentheses ;
                longestValidCount = Math.max(longestValidCount, length) ;
            } else {
                if (closeParentheses > openParentheses) {
                    openParentheses = 0 ;
                    closeParentheses = 0 ;
                }
            }
        }
        openParentheses = 0 ;
        closeParentheses = 0 ;
        for (int i=strLength-1; i>=0; i--) {
            char tempChar = s.charAt(i) ;
            if (tempChar == '(') {
                ++openParentheses;
            } else {
                ++closeParentheses;
            }

            if (openParentheses == closeParentheses) {
                int length = openParentheses + closeParentheses ;
                longestValidCount = Math.max(longestValidCount, length) ;
            } else {
                if (openParentheses > closeParentheses) {
                    openParentheses = 0 ;
                    closeParentheses = 0 ;
                }
            }
        }


        return longestValidCount ;
    }

    public static int longestValidParenthesesUsingStack(String s) {
        int strLength = s.length();
        int maxLength = 0 ;
        Stack<Integer> paranthesesStack = new Stack<>();
        paranthesesStack.push(-1);

        for (int i=0; i<strLength; i++) {
            char tempChar = s.charAt(i) ;
            if (tempChar == '(') {
                paranthesesStack.push(i);
            } else {
                paranthesesStack.pop();
                if (paranthesesStack.isEmpty()) {
                    paranthesesStack.push(i);
                } else {
                    int stackPeak = paranthesesStack.peek();
                    maxLength = Math.max(maxLength, i - stackPeak);
                }
            }
        }

        return maxLength;
    }
}
