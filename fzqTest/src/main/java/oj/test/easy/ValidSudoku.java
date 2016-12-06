package oj.test.easy;

import java.util.Arrays;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * A partially filled sudoku which is valid.<br/>
 * Note: A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int[] row;
        int[] col;
        int[] grid;
        for (int i = 0; i < 9; i++) {
            row = new int[12];
            col = new int[12];
            grid = new int[12];

            for (int j = 0; j < 9; j++) {
                if ('.' != board[i][j] && 0 < row[board[i][j] - '.']) {
                    return false;
                }
                row[board[i][j] - '.']++;

                if ('.' != board[j][i] && 0 < col[board[j][i] - '.']) {
                    return false;
                }
                col[board[j][i] - '.']++;

                int rowNum = i / 3 * 3 + j / 3;
                int colNum = i % 3 * 3 + j % 3;
                if ('.' != board[rowNum][colNum] && 0 < grid[board[rowNum][colNum] - '.']) {
                    return false;
                }
                grid[board[rowNum][colNum] - '.']++;
            }

        }

        return true;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'.', '8', '7', '6', '5', '4', '3', '2', '1'},
                {'2', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'3', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'4', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'5', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'6', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'8', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'9', '.', '.', '.', '.', '.', '.', '.', '.'}
        };
        System.out.println(new ValidSudoku().isValidSudoku(board));
    }
}
