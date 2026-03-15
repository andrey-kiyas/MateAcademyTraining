package MateAcademy.leetcode.LC03Hard;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/fancy-sequence
 */

public class LC1622FancySequence {
    public static void main(String[] args) {
        Fancy fancy = new Fancy();

        fancy.append(2);
        fancy.addAll(3);
        fancy.append(7);
        fancy.multAll(2);

        System.out.println("Index 0: " + fancy.getIndex(0)); // 10

        fancy.addAll(3);
        fancy.append(10);
        fancy.multAll(2);

        System.out.println("Index 0: " + fancy.getIndex(0)); // 26
        System.out.println("Index 1: " + fancy.getIndex(1)); // 34
        System.out.println("Index 2: " + fancy.getIndex(2)); // 20
        System.out.println("Index 5: " + fancy.getIndex(5)); // -1
    }
}

class Fancy {
    private static final int MOD = 1_000_000_007;
    private final List<Long> nums;
    private long a = 1;
    private long b = 0;

    public Fancy() {
        nums = new ArrayList<>();
    }

    public void append(int val) {
        long invA = power(a, MOD - 2);
        long normalized = ((val - b + MOD) % MOD * invA) % MOD;
        nums.add(normalized);
    }

    public void addAll(int inc) {
        b = (b + inc) % MOD;
    }

    public void multAll(int m) {
        a = (a * m) % MOD;
        b = (b * m) % MOD;
    }

    public int getIndex(int idx) {
        if (idx >= nums.size()) return -1;
        long res = (nums.get(idx) * a) % MOD;
        res = (res + b) % MOD;
        return (int) res;
    }

    private long power(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp /= 2;
        }
        return res;
    }
}