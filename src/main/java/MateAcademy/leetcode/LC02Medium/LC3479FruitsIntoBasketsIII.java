package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/fruits-into-baskets-iii
 */

public class LC3479FruitsIntoBasketsIII {
    private static int[] segTree;
    private static int n;

    public static void main(String[] args) {
        System.out.println(numOfUnplacedFruits(new int[]{4, 2, 5}, new int[]{3, 5, 4})); // 1
        System.out.println(numOfUnplacedFruits(new int[]{3, 6, 1}, new int[]{6, 4, 7})); // 0
    }

    public static int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        n = baskets.length;
        segTree = new int[4 * n];
        build(baskets, 0, n - 1, 1);

        int unplaced = 0;
        for (int fruit : fruits) {
            if (findAndUse(fruit, 0, n - 1, 1) == -1) {
                unplaced++;
            }
        }
        return unplaced;
    }

    private static void build(int[] baskets, int low, int high, int idx) {
        if (low == high) {
            segTree[idx] = baskets[low];
        } else {
            int mid = low + (high - low) / 2;
            build(baskets, low, mid, 2 * idx);
            build(baskets, mid + 1, high, 2 * idx + 1);
            segTree[idx] = Math.max(segTree[2 * idx], segTree[2 * idx + 1]);
        }
    }

    private static int findAndUse(int fruit, int low, int high, int idx) {
        if (segTree[idx] < fruit) {
            return -1;
        }
        if (low == high) {
            segTree[idx] = -1;
            return 1;
        }
        int mid = low + (high - low) / 2;
        int res;
        if (segTree[2 * idx] >= fruit) {
            res = findAndUse(fruit, low, mid, 2 * idx);
        } else {
            res = findAndUse(fruit, mid + 1, high, 2 * idx + 1);
        }
        segTree[idx] = Math.max(segTree[2 * idx], segTree[2 * idx + 1]);
        return res;
    }
}
