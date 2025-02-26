package com.algorithms.java.leetcode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class The_kth_Factor_Of_N_LeetCode_1492 {

    public static void main (String[] args) {
        int  n = 4, k = 4;
        System.out.println("kth Factor = " + kthFactorOptimizedSqrt(n, k));
    }

    public static int kthFactor(int n, int k) {
          int sqrtRoot = (int) Math.sqrt(n);
          ArrayList<Integer> list = new ArrayList<>();
          for (int i=1; i<=sqrtRoot; i++) {
              int divisor = n%i ;
              if (divisor == 0) {
                  int quotient = n/i ;
                  --k;
                  if (k==0) {
                      return i;
                  } else {
                      if (quotient != i) {
                          list.add(quotient);
                      }
                  }
              }
          }
          if (list.size()==0 || k > list.size()) {
              return -1;
          } else {
              return list.get(list.size() - k);
          }

    }
   /*
        Efficient Approach: The problem can be solved in an optimized way in sqrt(n) complexity by using the
        fact that factors of any number remain in the form of pairs.
        In other words, if i is a factor of number n then n/i  will also be a factor of n.
   */
    public static int kthFactorOptimizedSqrt(int n, int k) {
        int d = 1;
        for (; d * d <= n; ++ d) {
            if (n % d == 0) {
                if (-- k == 0) {
                    return d;
                }
            }
        }
        for (d = d - 1; d >= 1; -- d) {
            if (d * d == n) continue;
            if (n % d == 0) {
                if (-- k == 0) {
                    return n / d;
                }
            }
        }
        return -1;
    }
   //Brute Force approach
    public static int kthFactorSeconIteration(int n, int k) {
        int count = 0;
        for(int i=1;i<=n;i++){
            if(n%i==0){
                count++;
            }
            if(count==k){
                return i;
            }
        }
        return -1;
    }
}
