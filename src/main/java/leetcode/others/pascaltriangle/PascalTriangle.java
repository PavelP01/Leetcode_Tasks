package leetcode.others.pascaltriangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        new PascalTriangle().generate(5);
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> rows = new ArrayList<>();
        rows.add(Collections.singletonList(1));
        if (numRows == 1) {
            return rows;
        }
        rows.add(List.of(1, 1));
        if (numRows == 2) {
            return rows;
        }

        populateRows(rows, 3, numRows);
        return rows;
    }

    private void populateRows(List<List<Integer>> rows, int currentRow, int numRows) {
        if (currentRow > numRows) {
            return;
        }

        List<Integer> row = new ArrayList<>();
        row.add(1);

        List<Integer> previousRow = rows.get(currentRow - 2);
        for (int i = 1; i < currentRow - 1; i++) {
            row.add(previousRow.get(i - 1) + previousRow.get(i));
        }

        row.add(1);
        rows.add(row);

        populateRows(rows, currentRow + 1, numRows);
    }
}
