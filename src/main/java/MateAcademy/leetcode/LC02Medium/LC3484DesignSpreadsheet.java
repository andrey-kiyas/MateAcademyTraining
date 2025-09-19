package MateAcademy.leetcode.LC02Medium;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/design-spreadsheet
 */

public class LC3484DesignSpreadsheet {
    public static void main(String[] args) {
        Spreadsheet spreadsheet = new Spreadsheet();

        System.out.println(spreadsheet.getValue("=5+7")); // 12
        spreadsheet.setCell("A1", 10);
        System.out.println(spreadsheet.getValue("=A1+6")); // 16
        spreadsheet.setCell("B2", 15);
        System.out.println(spreadsheet.getValue("=A1+B2")); // 25
        spreadsheet.resetCell("A1");
        System.out.println(spreadsheet.getValue("=A1+B2")); // 15
    }
}

class Spreadsheet {
    private final Map<String, Integer> cells;

    public Spreadsheet() {
        this.cells = new HashMap<>();
    }

    public void setCell(String cell, int value) {
        cells.put(cell, value);
    }

    public void resetCell(String cell) {
        cells.put(cell, 0);
    }

    public int getValue(String formula) {
        String expr = formula.substring(1);
        String[] parts = expr.split("\\+");

        int left = resolve(parts[0]);
        int right = resolve(parts[1]);

        return left + right;
    }

    private int resolve(String token) {
        if (Character.isDigit(token.charAt(0))) {
            return Integer.parseInt(token);
        }
        return cells.getOrDefault(token, 0);
    }
}