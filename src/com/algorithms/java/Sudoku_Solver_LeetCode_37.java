package com.algorithms.java;

import java.util.Arrays;

/*
Write a program to solve a Sudoku puzzle by filling the empty cells.

A sudoku solution must satisfy all of the following rules:

Each of the digits 1-9 must occur exactly once in each row.
Each of the digits 1-9 must occur exactly once in each column.
Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
The '.' character indicates empty cells.

Input: board = {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}} ;


Output: [["5","3","4","6","7","8","9","1","2"],
["6","7","2","1","9","5","3","4","8"],
["1","9","8","3","4","2","5","6","7"],
["8","5","9","7","6","1","4","2","3"],
["4","2","6","8","5","3","7","9","1"],
["7","1","3","9","2","4","8","5","6"],
["9","6","1","5","3","7","2","8","4"],
["2","8","7","4","1","9","6","3","5"],
["3","4","5","2","8","6","1","7","9"]]

 */
public class Sudoku_Solver_LeetCode_37 {
    public static void main (String[] args) {
        char[][] board =
                {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}} ;
        int boardLength = board.length;
        solveSudoku(board);
    }

    public static void solveSudoku(char[][] board) {
        solveSudokuWithRecursion(board, board.length) ;
        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static boolean solveSudokuWithRecursion(char[][] board, int boardLength) {
        for (int row=0; row<boardLength; row++) {
            for (int column=0; column<boardLength; column++) {
                char emptyChar = board[row][column];
                if (emptyChar == '.') {
                    for (int i=1; i<=boardLength; i++) {
                        boolean isSafe = isNumberSafeToFill(board, row, column, boardLength, Character.forDigit(i, 10)) ;
                        if (isSafe) {
                            board[row][column] = Character.forDigit(i, 10) ;
                            boolean isSudokuValidForNextChar = solveSudokuWithRecursion(board, boardLength);
                            if (isSudokuValidForNextChar) {
                                return true;
                            } else {
                                board[row][column] = '.' ;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isNumberSafeToFill (char[][] board, int row, int column, int boardLength, char num) {
        for (int i=0; i<boardLength; i++) {
            if (board[i][column] == num) {
                return false;
            }
            if (board[row][i] == num) {
                return false;
            }
            // 9 by 9 box check
            int boxRow =  3 * (row/3) +  (i/3) ;
            int boxColumn =  3 * (column/3) +  (i%3) ;

            if (board[boxRow][boxColumn] == num) {
                return false;
            }
        }
        return true;
    }

}
