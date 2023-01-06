package leetcode.array.setmatrixzeroes;

import java.util.Arrays;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] input = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        new SetMatrixZeroes().setZeroes(input);
        System.out.println(input);
    }

    public void setZeroes(int[][] matrix) {
        int flagRowIndex = -1;
        int flagColumnIndex = -1;
        for (int i = 0; i < matrix.length; i++) {
            boolean containsZero = false;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    containsZero = true;
                    break;
                }
            }
            if (!containsZero) {
                flagRowIndex = i;
                break;
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            boolean containsZero = false;
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i] == 0) {
                    containsZero = true;
                    break;
                }
            }
            if (!containsZero) {
                flagColumnIndex = i;
                break;
            }
        }

        if (flagRowIndex == -1 || flagColumnIndex == -1) {
            fillAllZero(matrix);
            return;
        }

        markUpFlags(matrix, flagRowIndex, flagColumnIndex);

        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][flagColumnIndex] == 0) {
                Arrays.fill(matrix[i], 0);
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[flagRowIndex][i] == 0) {
                for (int j = 0; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
    }

    private void markUpFlags(int[][] matrix, int flagRowIndex, int flagColumnIndex) {
        for (int i = 0; i < matrix.length; i++) {
            if (i == flagRowIndex) {
                continue;
            }
            boolean rowToZero = false;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rowToZero = true;
                    break;
                }
            }
            if (rowToZero) {
                matrix[i][flagColumnIndex] = 0;
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if (i == flagColumnIndex) {
                continue;
            }
            boolean columnToZero = false;
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[j][i] == 0) {
                    columnToZero = true;
                    break;
                }
            }
            if (columnToZero) {
                matrix[flagRowIndex][i] = 0;
            }
        }
    }

    private void fillAllZero(int[][] matrix) {
        for (int[] ints : matrix) {
            Arrays.fill(ints, 0);
        }
    }
}
