package MateAcademy.leetcode.LC03Hard;

/*
  https://leetcode.com/problems/find-x-sum-of-all-k-long-subarrays-ii
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;


public class LC3321FindXSumOfAllKLongSubarraysII {
    private static Map<Integer, Integer> cnt;
    private static TreeSet<Integer> low;
    private static TreeSet<Integer> high;
    private static long currentSum;

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findXSum(new int[]{1, 1, 2, 2, 3, 4, 2, 3}, 6, 2))); // [6,10,12]
        System.out.println(Arrays.toString(findXSum(new int[]{3, 8, 7, 8, 7, 5}, 2, 2)));       // [11,15,15,15,12]
    }

    private static final Comparator<Integer> CMP = (a, b) -> {
        int freqA = cnt.getOrDefault(a, 0);
        int freqB = cnt.getOrDefault(b, 0);

        if (freqA != freqB) {
            return Integer.compare(freqA, freqB);
        }
        return Integer.compare(a, b);
    };

    public static long[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        long[] result = new long[n - k + 1];

        cnt = new HashMap<>();
        low = new TreeSet<>(CMP);
        high = new TreeSet<>(CMP);
        currentSum = 0;

        for (int i = 0; i < n; ++i) {
            update(nums[i], 1, x);

            int j = i - k;
            if (j >= 0) {
                update(nums[j], -1, x);
            }

            if (i >= k - 1) {
                result[i - k + 1] = currentSum;
            }
        }
        return result;
    }

    private static void update(int val, int delta, int x) {
        int oldFreq = cnt.getOrDefault(val, 0);
        int newFreq = oldFreq + delta;

        if (oldFreq > 0) {
            if (high.remove(val)) {
                currentSum -= (long) oldFreq * val;
            } else {
                low.remove(val);
            }
        }

        if (newFreq > 0) {
            cnt.put(val, newFreq);
        } else {
            cnt.remove(val);
        }

        if (newFreq > 0) {
            if (high.isEmpty() || CMP.compare(val, high.first()) >= 0) {
                high.add(val);
                currentSum += (long) newFreq * val;
            } else {
                low.add(val);
            }
        }

        while (high.size() > x) {
            Integer p = high.pollFirst();
            if (p != null) { // Защита от NPE
                currentSum -= (long) cnt.get(p) * p;
                low.add(p);
            }
        }

        while (high.size() < x && !low.isEmpty()) {
            Integer p = low.pollLast();
            if (p != null) {
                high.add(p);
                currentSum += (long) cnt.get(p) * p;
            }
        }

        while (!low.isEmpty() && !high.isEmpty() && CMP.compare(low.last(), high.first()) >= 0) {

            Integer p_low = low.pollLast();
            if (p_low != null) {
                high.add(p_low);
                currentSum += (long) cnt.get(p_low) * p_low;
            }

            if (high.size() > x) {
                Integer p_high = high.pollFirst();
                if (p_high != null) { // Защита от NPE
                    currentSum -= (long) cnt.get(p_high) * p_high;
                    low.add(p_high);
                }
            }
        }
    }
}
