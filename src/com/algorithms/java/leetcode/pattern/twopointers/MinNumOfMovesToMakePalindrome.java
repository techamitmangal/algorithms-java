/*
Minimum Number of Moves to Make Palindrome
Try to solve the Minimum Number of Moves to Make Palindrome problem.

Statement
Given a string s, return the minimum number of moves required to transform s into a palindrome.
In each move, you can swap any two adjacent characters in s.

Note: The input string is guaranteed to be convertible into a palindrome.

Constraints:

1
≤
1≤
 s.length
≤
2000
≤2000

s consists of only lowercase English letters.

s is guaranteed to be converted into a palindrome in a finite number of moves.
 */

package com.algorithms.java.leetcode.pattern.twopointers;

public class MinNumOfMovesToMakePalindrome {

    public static void main (String[] args) {
        //String s = "ccxx" ;
        String s = "olstzgogeivvvgctrsbusvihcvbzzvsscycituqylxjoknhrcvuuzbtzlitovccykivkuavxzgvlmtiqtnmshonqclcknptabpewxxtqnvreoiyucsujxooxhoxwqirtqfzbgjgpsvlsmqfbmcsqlxirogcbwuiepmzifcljytcpougvfrihfjztikkjjtoyszhmfdqculcrmlwdameewzfznakyfgktonpqqouhnvvddtsoaxtbwhhyekokxpizxlhpdfghctuigaqcvpqsopgjrxoiroyfitofwojveowkqvosyqjuesovhqhrvryvdjbtykrvdrvrlyrayccfzzvcuagzziwmtbnrlvyytomwlzqqyworqmwuhnorihzgnrwbqbyqakrmfkdhutjlvjikxybztupvwqrrnxnfybbshxrbuwyxxgbrkbkvwutrcdtcryffdclccfdgljubxxefnxfvqfvwmtqyehslovoskmxdgiuncvlravylmdenqgzbirfvvakflzstzysfdmziurzmunxvijdlkjyrxlyndzleujdzhlcvuffbwsutlkbpqihdmqlbphvnhqgctogiqzsiwttbfycjbbwhhpfduuldcjwinrzuvspmumgzujyyhtqcekfrvcihnhhshnvipzjtjocmazghntrnruwkmko";
        System.out.println("Min number of moves = " + minMovesToMakePalindrome(s));
    }
    public static int minMovesToMakePalindrome(String s) {
         int moves = 0;
         char[] chArr = s.toCharArray();
         int arrLen = s.length();
         int startIndex = 0;
         int endIndex = arrLen - 1;

         while (startIndex < endIndex) {
             char ch = chArr[startIndex] ;
             int j = endIndex ;
             while (j>startIndex) {
                 if (chArr[j] == ch) {
                     while (j<endIndex) {
                         char tempCh = chArr[j];
                         chArr[j] = chArr[j+1];
                         chArr[j+1] = tempCh;
                         j++;
                         moves++;
                     }
                     break;
                 }
                 j--;
             }
             if (j == startIndex)  {
                // int mid = arrLen/2;
                 //char tempCh = chArr[mid];
                 //chArr[mid] = chArr[startIndex];
                // chArr[startIndex] = tempCh;
                 moves += chArr.length / 2 - startIndex;
             }
             startIndex++;
             endIndex--;
         }

         return moves;
    }


}
