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

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MinNumOfMovesToMakePalindrome {

    public static void main (String[] args) {
        //String s = "eggeekgbbeg" ;
        //String s = "olstzgogeivvvgctrsbusvihcvbzzvsscycituqylxjoknhrcvuuzbtzlitovccykivkuavxzgvlmtiqtnmshonqclcknptabpewxxtqnvreoiyucsujxooxhoxwqirtqfzbgjgpsvlsmqfbmcsqlxirogcbwuiepmzifcljytcpougvfrihfjztikkjjtoyszhmfdqculcrmlwdameewzfznakyfgktonpqqouhnvvddtsoaxtbwhhyekokxpizxlhpdfghctuigaqcvpqsopgjrxoiroyfitofwojveowkqvosyqjuesovhqhrvryvdjbtykrvdrvrlyrayccfzzvcuagzziwmtbnrlvyytomwlzqqyworqmwuhnorihzgnrwbqbyqakrmfkdhutjlvjikxybztupvwqrrnxnfybbshxrbuwyxxgbrkbkvwutrcdtcryffdclccfdgljubxxefnxfvqfvwmtqyehslovoskmxdgiuncvlravylmdenqgzbirfvvakflzstzysfdmziurzmunxvijdlkjyrxlyndzleujdzhlcvuffbwsutlkbpqihdmqlbphvnhqgctogiqzsiwttbfycjbbwhhpfduuldcjwinrzuvspmumgzujyyhtqcekfrvcihnhhshnvipzjtjocmazghntrnruwkmko";
        //O/P = 17161;
        String s = "skwhhaaunskegmdtutlgtteunmuuludii";
        //O/P = 163;
        System.out.println("Min number of moves from my code = " + minMovesToMakePalindrome(s));
        System.out.println("Min number of moves from educative code = " + minMovesToMakePalindromeEducative(s));
    }
    public static int minMovesToMakePalindrome(String s) {
         int moves = 0;
         char[] chArr = s.toCharArray();
         int arrLen = s.length();
         int startIndex = 0;
         int endIndex = arrLen - 1;

         while (startIndex < endIndex) {
             //char ch = chArr[startIndex] ;
             int j = endIndex ;
             while (j>startIndex) {
                 if (chArr[j] == chArr[startIndex]) {
                     while (j<endIndex) {
                         char tempCh = chArr[j];
                         chArr[j] = chArr[j+1];
                         chArr[j+1] = tempCh;
                         ++j;
                         ++moves;
                     }
                     --endIndex;
                     break;
                 }
                 --j;
             }
             if (j == startIndex)  {
                 //Now we need to move ch at the center of the string. because string
                 // is odd therefore we didn't find this character in the string
                 moves += s.length() / 2 - startIndex;
                 System.out.println("Inside j==startIndex from my code");
             }
             startIndex++;
             //endIndex--;
         }

         return moves;
    }

    public static int minMovesToMakePalindromeEducative(String s) {
        char[] chars = s.toCharArray();

        int moves = 0;

        for (int i = 0, j = chars.length - 1; i < j; ++i) {
            int k = j;
            for (; k > i; --k) {
                if (chars[i] == chars[k]) {
                    for (; k < j; ++k) {
                        char temp = chars[k];
                        chars[k] = chars[k + 1];
                        chars[k + 1] = temp;
                        ++moves;
                    }
                    --j;
                    break;
                }
            }
            if (k == i) {
                moves += chars.length / 2 - i;
                System.out.println("Inside k == i from my educative code");
            }
        }
        return moves;
    }

    @Test
    public void minMovesToMakePalindromeTest() {
        String str1 = "skwhhaaunskegmdtutlgtteunmuuludii";
        String str2 = "olstzgogeivvvgctrsbusvihcvbzzvsscycituqylxjoknhrcvuuzbtzlitovccykivkuavxzgvlmtiqtnmshonqclcknptabpewxxtqnvreoiyucsujxooxhoxwqirtqfzbgjgpsvlsmqfbmcsqlxirogcbwuiepmzifcljytcpougvfrihfjztikkjjtoyszhmfdqculcrmlwdameewzfznakyfgktonpqqouhnvvddtsoaxtbwhhyekokxpizxlhpdfghctuigaqcvpqsopgjrxoiroyfitofwojveowkqvosyqjuesovhqhrvryvdjbtykrvdrvrlyrayccfzzvcuagzziwmtbnrlvyytomwlzqqyworqmwuhnorihzgnrwbqbyqakrmfkdhutjlvjikxybztupvwqrrnxnfybbshxrbuwyxxgbrkbkvwutrcdtcryffdclccfdgljubxxefnxfvqfvwmtqyehslovoskmxdgiuncvlravylmdenqgzbirfvvakflzstzysfdmziurzmunxvijdlkjyrxlyndzleujdzhlcvuffbwsutlkbpqihdmqlbphvnhqgctogiqzsiwttbfycjbbwhhpfduuldcjwinrzuvspmumgzujyyhtqcekfrvcihnhhshnvipzjtjocmazghntrnruwkmko";
        assertEquals(163, MinNumOfMovesToMakePalindrome.minMovesToMakePalindrome(str1)) ;
        assertNotEquals(17141, MinNumOfMovesToMakePalindrome.minMovesToMakePalindrome(str2));
    }


}
