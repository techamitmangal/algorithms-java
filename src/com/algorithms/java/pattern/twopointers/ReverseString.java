package com.algorithms.java.pattern.twopointers;

import java.util.Arrays;

public class ReverseString {
    public static void main (String[] args) {
        char[] s ={'a', 'b', 'c', 'd', 'e'};
       reverseString(s);
    }

    public static void reverseString(char[] s) {
        // Write your code here
        int length = s.length;
        int startPointer = 0;
        int endPointer = length - 1 ;
        while (startPointer <= endPointer) {
            char chStart = s[startPointer];
            s[startPointer] = s[endPointer] ;
            s[endPointer] = chStart;
            startPointer++;
            endPointer--;
        }
        System.out.println("Reversed string is " + Arrays.toString(s));
    }
}
