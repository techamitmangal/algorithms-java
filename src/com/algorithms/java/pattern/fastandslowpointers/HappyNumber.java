package com.algorithms.java.pattern.fastandslowpointers;

/*
Statement
Write an algorithm to determine if a number n is a happy number.

We use the following process to check if a given number is a happy number:

Starting with the given number n, replace the number with the sum of the squares of its digits.
Repeat the process until:
The number equals 1, which will depict that the given number n is a happy number.
It enters a cycle, which will depict that the given number n is not a happy number.
Return TRUE if n is a happy number, and FALSE if not.

Constraints: 1 <= n <= 2^31 -1

 */
public class HappyNumber {
    public static void main (String[] args) {
        System.out.println("Is Happy Number = " + isHappyNumber(19));
    }

    public static boolean isHappyNumber(int n) {
        if (n == 1) {
            return true;
        }
        /*
        We maintain track of two values using a slow pointer and a fast pointer.
        The slow runner advances one number at each step,
        while the fast runner advances two numbers.
        We detect if there is any cycle by comparing the two values and checking
        if fast runner == slow runner then cycle appear return false
        if fast runner == 1 then return true happy number
         */

        int slowNum = n ;
        int fastNum = n ;

        do {
            slowNum = squareOfDigits(slowNum) ;
            fastNum = squareOfDigits(squareOfDigits(fastNum)) ;
        } while (slowNum != fastNum) ;

        return slowNum == 1 ;
    }

    public static int squareOfDigits (int num) {
        int sum = 0 ;
        while (num != 0) {
            int digit = num % 10 ;
            num = num / 10 ;
            sum = sum + (digit * digit) ;
        }
        return sum;
    }


}
