package leetcode.array.sudoku;

import java.util.HashSet;
import java.util.Set;

public class Sudoku {

    public static void main(String[] args) {
        char[][] board = {{1,2}, {3,4}};
        isValidSudoku(board);
    }

    private static boolean isValidSudoku(char[][] board) {
        for (char[] line : board) {
            Set<Character> uniqueItems = new HashSet<>();
            for (char it : line) {
                if (it != '.' && uniqueItems.contains(it)) {
                    return false;
                }
                uniqueItems.add(it);
            }
        }
        for (int i = 0; i < board[0].length; i++) {
            Set<Character> uniqueItems = new HashSet<>();
            for (int j = 0; j < board.length; j++) {
                if (board[j][i] != '.' && uniqueItems.contains(board[j][i])) {
                    return false;
                }
                uniqueItems.add(board[j][i]);
            }
        }
        for (int i = 0; i < 3; i++) {
            Set<Character> boxOneUniqueItems = new HashSet<>();
            Set<Character> boxTwoUniqueItems = new HashSet<>();
            Set<Character> boxThreeUniqueItems = new HashSet<>();

            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    char val = board[j + 3*i][k];
                    if (val != '.' && boxOneUniqueItems.contains(val)) {
                        return false;
                    }
                    boxOneUniqueItems.add(board[j + 3*i][k]);
                }
                for (int k = 3; k < 6; k++) {
                    char val = board[j + 3*i][k];
                    if (val != '.' && boxTwoUniqueItems.contains(val)) {
                        return false;
                    }
                    boxTwoUniqueItems.add(board[j + 3*i][k]);
                }
                for (int k = 6; k < 9; k++) {
                    char val = board[j + 3*i][k];
                    if (val != '.' && boxThreeUniqueItems.contains(val)) {
                        return false;
                    }
                    boxThreeUniqueItems.add(board[j + 3*i][k]);
                }
            }
        }

        return true;
    }
}
