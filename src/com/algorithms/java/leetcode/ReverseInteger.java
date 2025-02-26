package com.algorithms.java.leetcode;

public class ReverseInteger {
    public static void main (String[] args) {
       System.out.println(reverseInt(-89));
    }

    public static int reverseInt(int inputInt) {
        int rev = 0;
        int top_limit = Integer.MAX_VALUE/10;
        int bottom_limit = Integer.MIN_VALUE/10;
        while (inputInt!=0) {
            if (rev > top_limit || rev < bottom_limit)
                return 0;
            rev = rev * 10 + inputInt % 10;
            inputInt /= 10;
        }
        return rev;
    }

 }
