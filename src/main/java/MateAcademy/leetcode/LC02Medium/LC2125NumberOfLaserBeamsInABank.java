package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/number-of-laser-beams-in-a-bank
 */

public class LC2125NumberOfLaserBeamsInABank {
    public static void main(String[] args) {
        String[] bank1 = {"011001", "000000", "010100", "001000"};
        String[] bank2 = {"000", "111", "000"};
        System.out.println(numberOfBeams(bank1)); // 8
        System.out.println(numberOfBeams(bank2)); // 0
    }

    public static int numberOfBeams(String[] bank) {
        int prev = 0;
        int total = 0;

        for (String row : bank) {
            int count = 0;
            for (char c : row.toCharArray()) {
                if (c == '1') count++;
            }
            if (count > 0) {
                total += prev * count;
                prev = count;
            }
        }

        return total;
    }
}
