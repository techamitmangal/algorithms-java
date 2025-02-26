package com.algorithms.java.leetcode;
/*
Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.

Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.

Example 1:

Input: num1 = "2", num2 = "3"
Output: "6"
Example 2:

Input: num1 = "123", num2 = "456"
Output: "56088"

Constraints:
1 <= num1.length, num2.length <= 200
num1 and num2 consist of digits only.
Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 */

import java.util.ArrayList;

public class Multiply_Strings_Leet_Code_43 {
    public static void main (String[] args) {
        String num1 = "123" ;
        String num2 = "456" ;
        System.out.println(multiply(num1, num2));
    }

    public static String multiply(String num1, String num2) {
        if (num1.length()==0 || num2.length()==0) return "";
        int m=0 ;
        for (m=0; m<num1.length(); m++) {
            if (Integer.parseInt(num1.charAt(m) + "") == 0) {
                continue;
            } else {
                break;
            }
        }
        if (m==num1.length()) {
            return "0";
        }

        for (m=0; m<num2.length(); m++) {
            if (Integer.parseInt(num2.charAt(m) + "") == 0) {
                continue;
            } else {
                break;
            }
        }
        if (m==num2.length()) {
            return "0";
        }
        
        int num1Len = num1.length();
        int num2Len = num2.length();
        StringBuilder sumStrBuilder = new StringBuilder();

        for (int i=num1Len-1; i>=0; i--) {
            StringBuilder tempBuilder = new StringBuilder();
            int temp = Integer.parseInt(num1.charAt(i) + "") ;
            int carry = 0;
            for (int j=num2Len-1; j>=0; j-- ) {
                int temp2 = Integer.parseInt(num2.charAt(j) + "") ;
                int res = temp * temp2 + carry;
                if (res>9) {
                    carry =  res / 10;
                    res = res % 10 ;
                } else {
                    carry = 0;
                }
                tempBuilder.append(res);
            }
            if (carry>0) {
                tempBuilder.append(carry);
            }
            tempBuilder.reverse();
            for (int k=(num1Len-1)-i; k>0; k--) {
                tempBuilder.append("0");
            }
            sumStrBuilder = sumResult(sumStrBuilder.toString(), tempBuilder.toString());
            System.out.println("sumStrBuilder = " + sumStrBuilder);
        }

        return sumStrBuilder.toString();
    }

    public static StringBuilder sumResult (String str1, String str2) {
        System.out.println("str1 = " + str1 + " str2 = " + str2);
        StringBuilder sum = new StringBuilder();
        int str1Len = str1.length();
        int str2Len = str2.length();

        if (str2Len>str1Len) {
            int diff = str2Len - str1Len ;
            while (diff>0) {
                str1 = "0" + str1 ;
                diff--;
            }
        } else {
            if (str1Len>str2Len) {
                int diff = str1Len - str2Len ;
                while (diff>0) {
                    str2 = "0" + str2 ;
                    diff--;
                }
            }
        }

        int carry = 0 ;

        for (int i=str1.length()-1; i>=0; i--) {
            int sumRes = Integer.parseInt(str1.charAt(i) + "") + Integer.parseInt(str2.charAt(i) + "") + carry;
            if(sumRes>9) {
                carry = 1;
                sumRes = sumRes % 10 ;
            } else {
                carry = 0;
            }
            sum.append(sumRes);
        }
        if (carry == 1) {
            sum.append(carry);
        }
        return sum.reverse() ;
    }
}
