package com.algorithms.java;

import java.util.HashMap;
import java.util.HashSet;

public class Valid_Sudoku_LeetCode_36 {
    public static void main (String[] args) {
        char[][] board ={{'5','3','.','.','7','.','.','.','.'}
                        ,{'6','.','.','1','9','5','.','.','.'}
                        ,{'.','9','8','.','.','.','.','6','.'}
                        ,{'8','.','.','.','6','.','.','.','3'}
                        ,{'4','.','.','8','.','3','.','.','1'}
                        ,{'7','.','.','.','2','.','.','.','6'}
                        ,{'.','6','.','.','.','.','2','8','.'}
                        ,{'.','.','.','4','1','9','.','.','5'}
                        ,{'.','.','.','.','8','.','.','7','9'}};

        System.out.println("Is Sudoku Valid = " + isValidSudoku(board));
    }
    
    public static boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board.length; j++) {
                char val = board[i][j] ;
                if (val != '.') {
                    if(!seen.add(val + "row = " + i) ||
                    !seen.add(val + "column = " + j) ||
                    !seen.add(val + "sub box row = " + i/3 + "sub box colum = " + j/3)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
