package MateAcademy.leetcode.LC03Hard;

/**
 * https://leetcode.com/problems/count-good-triplets-in-an-array
 */

public class LC2179CountGoodTripletsInAnArray {
    public static void main(String[] args) {
        System.out.println(goodTriplets(
                new int[]{2, 0, 1, 3},
                new int[]{0, 1, 2, 3}
        ));                               // 1
        System.out.println(goodTriplets(
                new int[]{4, 0, 1, 3, 2},
                new int[]{4, 1, 0, 2, 3}
        ));                               // 4
    }

    public static long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] pos = new int[n];
        BinaryIndexedTree tree = new BinaryIndexedTree(n);
        for (int i = 0; i < n; ++i) {
            pos[nums2[i]] = i + 1;
        }
        long result = 0;
        for (int num : nums1) {
            int p = pos[num];
            long left = tree.query(p);
            long right = n - p - (tree.query(n) - tree.query(p));
            result += left * right;
            tree.update(p, 1);
        }
        return result;
    }
}

class BinaryIndexedTree {
    private final int n;
    private final int[] c;

    public BinaryIndexedTree(int n) {
        this.n = n;
        c = new int[n + 1];
    }

    public void update(int x, int delta) {
        while (x <= n) {
            c[x] += delta;
            x += lowbit(x);
        }
    }

    public int query(int x) {
        int s = 0;
        while (x > 0) {
            s += c[x];
            x -= lowbit(x);
        }
        return s;
    }

    public static int lowbit(int x) {
        return x & -x;
    }
}
