package com.my_new_leetcode_journey.arrays_hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * <h1>Valid Sudoku</h1>
 * <h2>Medium</h2>
 * <p>
 * You are given a 9 x 9 Sudoku board <code>board</code>. A Sudoku board is
 * valid if the following rules are followed:
 * </p>
 * <ul>
 * <li>Each row must contain the digits 1-9 without duplicates.</li>
 * <li>Each column must contain the digits 1-9 without duplicates.</li>
 * <li>Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9
 * without duplicates.</li>
 * </ul>
 * <p>
 * Return <code>true</code> if the Sudoku board is valid, otherwise return
 * <code>false</code>.
 * </p>
 * <p>
 * <strong>Note:</strong> A board does not need to be full or be solvable to be
 * valid.
 * </p>
 * 
 * <h3>Example 1:</h3>
 * 
 * <pre>
 * Input: board = 
 * [["1","2",".",".","3",".",".",".","."],
 *  ["4",".",".","5",".",".",".",".","."],
 *  [".","9","8",".",".",".",".",".","3"],
 *  ["5",".",".",".","6",".",".",".","4"],
 *  [".",".",".","8",".","3",".",".","5"],
 *  ["7",".",".",".","2",".",".",".","6"],
 *  [".",".",".",".",".",".","2",".","."],
 *  [".",".",".","4","1","9",".",".","8"],
 *  [".",".",".",".","8",".",".","7","9"]]
 * 
 * Output: true
 * </pre>
 * 
 * <h3>Example 2:</h3>
 * 
 * <pre>
 * Input: board = 
 * [["1","2",".",".","3",".",".",".","."],
 *  ["4",".",".","5",".",".",".",".","."],
 *  [".","9","1",".",".",".",".",".","3"],
 *  ["5",".",".",".","6",".",".",".","4"],
 *  [".",".",".","8",".","3",".",".","5"],
 *  ["7",".",".",".","2",".",".",".","6"],
 *  [".",".",".",".",".",".","2",".","."],
 *  [".",".",".","4","1","9",".",".","8"],
 *  [".",".",".",".","8",".",".","7","9"]]
 * 
 * Output: false
 * Explanation: There are two 1's in the top-left 3x3 sub-box.
 * </pre>
 * 
 * <h3>Constraints:</h3>
 * <ul>
 * <li><code>board.length == 9</code></li>
 * <li><code>board[i].length == 9</code></li>
 * <li><code>board[i][j]</code> is a digit 1-9 or '.'.</li>
 * </ul>
 */

public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Set<Character>> row = new HashMap<>();
        HashMap<Integer, Set<Character>> column = new HashMap<>();
        HashMap<Integer, Set<Character>> square = new HashMap<>();

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean squareValid = squareChecker(i, j, square, board);
                if (!squareValid) {
                    System.out.println("square invalid");
                    return false;
                }
                boolean rowValid = rowChecker(i, j, row, board);
                if (!rowValid) {
                    System.out.println("row invalid");
                    return false;
                }
                boolean columnValid = columnChecker(i, j, column, board);
                if (!columnValid) {
                    System.out.println("column invalid");
                    return false;
                }
            }
        }

        return true;

    }

    private boolean columnChecker(int i, int j, HashMap<Integer, Set<Character>> column, char[][] board) {
        char value = board[i][j];
        if (value == '.') return true;  // Skip checking for empty cells
        
        // Ensure the column set exists
        column.putIfAbsent(j, new HashSet<>());
        
        if (column.get(j).contains(value)) {
            return false;
        }
        column.get(j).add(value);
        return true;
    }
    
    private boolean rowChecker(int i, int j, HashMap<Integer, Set<Character>> row, char[][] board) {
        char value = board[i][j];
        if (value == '.') return true;  // Skip checking for empty cells
        
        // Ensure the row set exists
        row.putIfAbsent(i, new HashSet<>());
        
        if (row.get(i).contains(value)) {
            return false;
        }
        row.get(i).add(value);
        return true;
    }
    
    private boolean squareChecker(int i, int j, HashMap<Integer, Set<Character>> square, char[][] board) {
        char value = board[i][j];
        if (value == '.') return true;  // Skip checking for empty cells
        
        // Calculate square index
        int squareIndex = (i / 3) * 3 + j / 3;
        
        // Ensure the square set exists
        square.putIfAbsent(squareIndex, new HashSet<>());
        
        if (square.get(squareIndex).contains(value)) {
            return false;
        }
        square.get(squareIndex).add(value);
        return true;
    }
    
}
