package com.algorithms.java.pattern.twopointers;

import java.util.ArrayList;
import java.util.List;

/*

You are given a string s. Your task is to divide the string into as many parts as possible such that each letter appears in at most one part.

In other words, no character should occur in more than one partition. After concatenating all parts in order, the result should be the original string s.

For example, given s = "bcbcdd", a valid partition is ["bcbc", "dd"].
However, partitions like ["bcb", "cdd"] or ["bc", "bc", "dd"] are invalid because some letters appear in multiple parts.

Return a list of integers representing the sizes of these partitions.

Constraints:
1 <= s.length <= 500
s consists of lowercase English letters.

 */

public class PartitionLabels {
    public static void main (String[] args) {
        String s = "ababcbacadefegdehijhklij" ;
        System.out.println(partitionLabels(s).toString());
    }

    public static List<Integer> partitionLabels(String s)
    {
        int strLen = s.length();
        int[] lastOccurrence = new int[26] ;
        /*
            ASCII Unicode
            'a' = 97
            'b' = 98
            'c' = 99
            'd' = 100

            Agar current character 'c' hai:
            s.charAt(i) = 'c'
            'c' - 'a' = 99 - 97 = 2
             lastOccurrence[2] = i
             i traverse ker rahe hai aur her ek iteration mein bad raha hai
             ab agar phir say c mila yaani lastOccurrence[2] = new i matlab c ki nayi position mil gayi.

            'a' - 'a' = 0
            'b' - 'a' = 1
            'c' - 'a' = 2
            'd' - 'a' = 3
            ...
            'z' - 'a' = 25

         */

        for (int i = 0; i < strLen; i++) {
            lastOccurrence[s.charAt(i) - 'a'] = i ;
            //[ 8, 5, 7, 14, 15, 11, 13, 19, 22, 23, 20, 21, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ]
            //First character of string last time 8th index per dikhega
        }

        int partitionStart = 0;
        int partitionEnd = 0;

        List<Integer> partitionSizes = new ArrayList<Integer>() ;

        for (int i = 0; i < strLen; i++) {
            int j = lastOccurrence[s.charAt(i) - 'a']; //ith location mein jo bhi character hai uski lastOccurence nikali agar vo
            //partitionEnd ke ander aa rahi hai to partitionEnd ko pick kiya otherwise partitionEnd ko increase ker diya.
            //Current partition ko utna extend karo jitna andar mile hue sab characters ki last occurrence cover karne ke liye zaroori hai.
            partitionEnd = Math.max(partitionEnd, j);

            //Ab partition safely close kiya ja sakta hai kyunki iske kisi character ka future mein aur occurrence nahi bacha.
            if (i == partitionEnd) {
                partitionSizes.add(partitionEnd - partitionStart + 1) ;
                partitionStart = i + 1;
            }

        }

        return partitionSizes;
    }
}
