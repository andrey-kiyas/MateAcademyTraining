package MateAcademy.leetcode.LC02Medium;

/*
  https://leetcode.com/problems/avoid-flood-in-the-city
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class LC1488AvoidFloodInTheCity {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(avoidFlood(new int[]{1, 2, 3, 4})));       // [-1, -1, -1, -1]
        System.out.println(Arrays.toString(avoidFlood(new int[]{1, 2, 0, 0, 2, 1}))); // [-1, -1, 2, 1, -1, -1]
        System.out.println(Arrays.toString(avoidFlood(new int[]{1, 2, 0, 1, 2})));    // []
    }

    public static int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] result = new int[n];
        Map<Integer, Integer> full = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            int lake = rains[i];

            if (lake == 0) {
                result[i] = 1;
                dryDays.add(i);
            } else {
                result[i] = -1;
                if (full.containsKey(lake)) {
                    Integer dryDay = dryDays.higher(full.get(lake));
                    if (dryDay == null) {
                        return new int[0];
                    }

                    result[dryDay] = lake;
                    dryDays.remove(dryDay);
                }

                full.put(lake, i);
            }
        }

        return result;
    }
}
