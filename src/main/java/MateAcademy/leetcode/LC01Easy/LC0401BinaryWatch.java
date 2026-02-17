package MateAcademy.leetcode.LC01Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/binary-watch
 */

public class LC0401BinaryWatch {
    public static void main(String[] args) {
        System.out.println(readBinaryWatch(1));
        // ["0:01", "0:02", "0:04", "0:08", "0:16", "0:32", "1:00", "2:00", "4:00", "8:00"]
        System.out.println(readBinaryWatch(9));
        // []
    }

    public static List<String> readBinaryWatch(int turnedOn) {
        List<String> result = new ArrayList<>();

        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    result.add(String.format("%d:%02d", h, m));
                }
            }
        }

        return result;
    }
}
