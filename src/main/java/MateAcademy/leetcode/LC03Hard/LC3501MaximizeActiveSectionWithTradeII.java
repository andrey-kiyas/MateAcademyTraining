package MateAcademy.leetcode.LC03Hard;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/maximize-active-section-with-trade-ii
 */
public class LC3501MaximizeActiveSectionWithTradeII {

    public static void main(String[] args) {
        System.out.println(maxActiveSectionsAfterTrade("01", new int[][]{{0, 1}}));
        // [1]

        System.out.println(maxActiveSectionsAfterTrade("0100", new int[][]{{0, 3}, {0, 2}, {1, 3}, {2, 3}}));
        // [4, 3, 1, 1]

        System.out.println(maxActiveSectionsAfterTrade("1000100", new int[][]{{1, 5}, {0, 6}, {0, 4}}));
        // [6, 7, 2]

        System.out.println(maxActiveSectionsAfterTrade("01010", new int[][]{{0, 3}, {1, 4}, {1, 3}}));
        // [4, 4, 2]
    }

    public static List<Integer> maxActiveSectionsAfterTrade(String s, int[][] queries) {
        int n = s.length();
        int ones = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '1') {
                ones++;
            }
        }

        Pair<List<Group>, int[]> zeroData = getZeroGroups(s);
        List<Group> zeroGroups = zeroData.first;
        int[] zeroGroupIndex = zeroData.second;

        if (zeroGroups.isEmpty()) {
            List<Integer> defaultAns = new ArrayList<>();
            for (int i = 0; i < queries.length; i++) {
                defaultAns.add(ones);
            }
            return defaultAns;
        }

        SparseTable st = new SparseTable(getAdjacentGroupLengthSums(zeroGroups));
        List<Integer> ans = new ArrayList<>();

        for (int[] query : queries) {
            int l = query[0];
            int r = query[1];

            int left = zeroGroupIndex[l] == -1
                    ? -1
                    : (zeroGroups.get(zeroGroupIndex[l]).length -
                    (l - zeroGroups.get(zeroGroupIndex[l]).start));

            int right = zeroGroupIndex[r] == -1
                    ? -1
                    : (r - zeroGroups.get(zeroGroupIndex[r]).start + 1);

            int endGroupIdxParam = s.charAt(r) == '1' ? zeroGroupIndex[r] : zeroGroupIndex[r] - 1;
            Pair<Integer, Integer> adjacentIndices = mapToAdjacentGroupIndices(
                    zeroGroupIndex[l] + 1,
                    endGroupIdxParam
            );

            int startAdjacentGroupIndex = adjacentIndices.first;
            int endAdjacentGroupIndex = adjacentIndices.second;

            int activeSections = ones;

            if (s.charAt(l) == '0' && s.charAt(r) == '0' &&
                    zeroGroupIndex[l] + 1 == zeroGroupIndex[r]) {
                activeSections = Math.max(activeSections, ones + left + right);
            } else if (startAdjacentGroupIndex <= endAdjacentGroupIndex) {
                activeSections = Math.max(
                        activeSections,
                        ones + st.query(startAdjacentGroupIndex, endAdjacentGroupIndex)
                );
            }

            if (s.charAt(l) == '0' &&
                    zeroGroupIndex[l] + 1 <= (s.charAt(r) == '1' ? zeroGroupIndex[r] : zeroGroupIndex[r] - 1)) {
                activeSections = Math.max(
                        activeSections,
                        ones + left + zeroGroups.get(zeroGroupIndex[l] + 1).length
                );
            }

            if (s.charAt(r) == '0' && zeroGroupIndex[l] < zeroGroupIndex[r] - 1) {
                activeSections = Math.max(
                        activeSections,
                        ones + right + zeroGroups.get(zeroGroupIndex[r] - 1).length
                );
            }

            ans.add(activeSections);
        }

        return ans;
    }

    private static Pair<List<Group>, int[]> getZeroGroups(String s) {
        List<Group> zeroGroups = new ArrayList<>();
        int[] zeroGroupIndex = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (i > 0 && s.charAt(i - 1) == '0') {
                    zeroGroups.get(zeroGroups.size() - 1).length++;
                } else {
                    zeroGroups.add(new Group(i, 1));
                }
            }
            zeroGroupIndex[i] = zeroGroups.isEmpty() ? -1 : zeroGroups.size() - 1;
        }

        return new Pair<>(zeroGroups, zeroGroupIndex);
    }

    private static int[] getAdjacentGroupLengthSums(List<Group> zeroGroups) {
        if (zeroGroups.size() < 2) {
            return new int[0];
        }

        int[] adjacentGroupLengthSums = new int[zeroGroups.size() - 1];
        for (int i = 0; i < zeroGroups.size() - 1; i++) {
            adjacentGroupLengthSums[i] = zeroGroups.get(i).length + zeroGroups.get(i + 1).length;
        }

        return adjacentGroupLengthSums;
    }

    private static Pair<Integer, Integer> mapToAdjacentGroupIndices(int startGroupIndex, int endGroupIndex) {
        return new Pair<>(startGroupIndex, endGroupIndex - 1);
    }

    static class Group {
        int start;
        int length;

        Group(int start, int length) {
            this.start = start;
            this.length = length;
        }
    }

    static class Pair<K, V> {
        K first;
        V second;

        Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }
    }

    static class SparseTable {
        private final int n;
        private final int[][] st;

        public SparseTable(int[] nums) {
            this.n = nums.length;
            if (n == 0) {
                this.st = new int[0][0];
                return;
            }
            int maxLog = bitWidth(n) + 1;
            this.st = new int[maxLog][n + 1];

            System.arraycopy(nums, 0, st[0], 0, n);

            for (int i = 1; i <= bitWidth(n); ++i) {
                for (int j = 0; j + (1 << i) <= n; ++j) {
                    st[i][j] = Math.max(st[i - 1][j], st[i - 1][j + (1 << (i - 1))]);
                }
            }
        }

        private static int bitWidth(int n) {
            return n == 0 ? 0 : 32 - Integer.numberOfLeadingZeros(n);
        }

        public int query(int l, int r) {
            if (n == 0 || l > r) return 0;
            int i = bitWidth(r - l + 1) - 1;
            return Math.max(st[i][l], st[i][r - (1 << i) + 1]);
        }
    }
}