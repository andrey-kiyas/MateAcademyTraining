package MateAcademy.leetcode.LC03Hard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.com/problems/count-number-of-trapezoids-ii
 */

public class LC3625CountNumberOfTrapezoidsII {
    public static void main(String[] args) {
        int[][] p1 = {{-3, 2}, {3, 0}, {2, 3}, {3, 2}, {2, -3}};
        System.out.println("Example 1 output = " + countTrapezoids(p1));              // expected 2

        int[][] p2 = {{0, 0}, {1, 0}, {0, 1}, {2, 1}};
        System.out.println("Example 2 output = " + countTrapezoids(p2));              // expected 1

        int[][] p3 = {
                {0, 0}, {2, 0}, {1, 1}, {3, 1}
        };
        System.out.println("Custom test output = " + countTrapezoids(p3));            // expected 1

        int[][] p_error = {{83, -25}, {74, 11}, {-65, -25}, {33, -25}, {17, -25},
                {1, 30}, {-84, -25}, {1, -25}, {1, -92}, {-87, 13}
        };
        System.out.println("Error test case output = " + countTrapezoids(p_error));   // expected 0


        int[][] p_error2 = {{-32, 12}, {-32, -94},
                {-32, -15}, {-30, 88}
        };
        System.out.println("Error 2 test case output = " + countTrapezoids(p_error)); // expected 0


        int[][] p_error3 = {{1, 0}, {2, 0}, {3, 0},
                {2, 2}, {3, 2}
        };
        System.out.println("Error 3 test case output = " + countTrapezoids(p_error)); // expected 3
    }

    public static int countTrapezoids(int[][] points) {
        int n = points.length;
        Map<Long, HashMap<Long, Integer>> cnt1 = new HashMap<>();
        Map<Long, HashMap<Long, Integer>> cnt2 = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            int x1 = points[i][0], y1 = points[i][1];
            for (int j = 0; j < i; ++j) {
                int x2 = points[j][0], y2 = points[j][1];
                int dx = x2 - x1;
                int dy = y2 - y1;

                long sk = slopeKey(dy, dx);

                long intercept;
                if (dx == 0) {
                    intercept = x1;
                } else if (dy == 0) {
                    intercept = y1;
                } else {
                    int g = gcd(dy, dx);
                    int A = dy / g;
                    int B = -dx / g;
                    if (dx < 0) {
                        A = -A;
                        B = -B;
                    }
                    intercept = (long) A * x1 + (long) B * y1;
                }

                cnt1.computeIfAbsent(sk, k -> new HashMap<>())
                        .merge(intercept, 1, Integer::sum);

                long mx = (long) x1 + x2;
                long my = (long) y1 + y2;
                long midKey = (mx << 32) ^ (my & 0xffffffffL);

                cnt2.computeIfAbsent(midKey, k -> new HashMap<>())
                        .merge(sk, 1, Integer::sum);
            }
        }

        long result = 0;

        for (HashMap<Long, Integer> map : cnt1.values()) {
            long s = 0;
            for (int t : map.values()) {
                result += s * t;
                s += t;
            }
        }

        for (HashMap<Long, Integer> map : cnt2.values()) {
            long s = 0;
            for (int t : map.values()) {
                result -= s * t;
                s += t;
            }
        }

        return (int) result;
    }

    private static long slopeKey(int dy, int dx) {
        if (dx == 0) {
            return (((long) 1) << 32) | (long) 0;
        }
        if (dy == 0) {
            return (((long) 0) << 32) | (long) 1;
        }
        int g = gcd(dy, dx);
        dy /= g;
        dx /= g;
        if (dx < 0) {
            dx = -dx;
            dy = -dy;
        }
        return (((long) dy & 0xffffffffL) << 32) | ((long) dx & 0xffffffffL);
    }

    private static int gcd(int a, int b) {
        if (a < 0) a = -a;
        if (b < 0) b = -b;
        while (b != 0) {
            int t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
