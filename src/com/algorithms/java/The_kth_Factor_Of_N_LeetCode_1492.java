package com.algorithms.java;

public class The_kth_Factor_Of_N_LeetCode_1492 {

    public static void main (String[] args) {
        int  n = 4, k = 4;
        System.out.println("kth Factor = " + kthFactor(n, k));
    }

    public static int kthFactor(int n, int k) {
          int sqrtRoot = (int) Math.sqrt(n);
          for (int i=1; i<=sqrtRoot; i++) {
              if (n%i ==0 && --k ==0) {
                  return n/i;
              }
          }

          for (int i=sqrtRoot+1; i>1; i--) {
              
          }

          return -1;
    }
}
