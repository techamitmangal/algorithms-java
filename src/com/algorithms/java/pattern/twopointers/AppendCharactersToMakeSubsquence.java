package com.algorithms.java.pattern.twopointers;

/*
Problem: Append Characters to Make Target a Subsequence

You are given two strings, source and target, consisting of lowercase English letters.

Your task is to determine the minimum number of characters that must be appended to the end of
source so that target becomes a subsequence of the resulting string.

A subsequence is a string that can be formed by deleting zero or more characters from another
string without changing the order of the remaining characters.

Example

Input:

source = "coaching"
target = "coding"

Output:

4

Explanation:

The subsequence "co" already appears in source. To make "coding" a subsequence,
we need to append the remaining characters "ding" to the end of source.
 */

// Algorithm
/*
We create two pointers, sourceIndex and targetIndex, initialized to 0.

We also store the lengths of the strings in sourceLength and targetLength.

Iterate until sourceIndex is less than the sourceLength and targetIndex is less than the targetLength:

If during the iteration, source[sourceIndex] becomes equal to target[targetIndex]:

We increment targetIndex to use the next character of the target.

        Next, we increment sourceIndex to continue scanning the source string.

Once the loop breaks, we return the result calculated as the difference between targetLength and targetIndex.*/

public class AppendCharactersToMakeSubsquence {
    public static void main (String[] args) {
        System.out.println("Number of characters to append = " + appendCharacters("abc","abcbc"));
    }
    public static int appendCharacters(String source, String target) {
        int sourceIndex = 0;
        int targetIndex = 0;
        int sourceLength = source.length();
        int targetLength = target.length();
        while (sourceIndex < sourceLength && targetIndex < targetLength) {
            if (source.charAt(sourceIndex) == target.charAt(targetIndex)) {
                targetIndex++;
            }
            sourceIndex++;
        }
        return targetLength - targetIndex;
    }
}

/*
Time Complexity: O(n), since the sourceIndex pointer traverses the source string at most once.
Space Complexity: O(1), as the solution uses only a constant amount of extra space for a few integer variables
(sourceIndex, targetIndex, sourceLength, and targetLength).
 */
