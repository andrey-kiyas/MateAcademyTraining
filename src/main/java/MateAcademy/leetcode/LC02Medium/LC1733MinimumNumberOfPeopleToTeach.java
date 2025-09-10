package MateAcademy.leetcode.LC02Medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.com/problems/minimum-number-of-people-to-teach
 */

public class LC1733MinimumNumberOfPeopleToTeach {
    public static void main(String[] args) {
        int n1 = 2;
        int[][] languages1 = {{1}, {2}, {1, 2}};
        int[][] friendships1 = {{1, 2}, {1, 3}, {2, 3}};
        System.out.println(minimumTeachings(n1, languages1, friendships1)); // 1

        int n2 = 3;
        int[][] languages2 = {{2}, {1, 3}, {1, 2}, {3}};
        int[][] friendships2 = {{1, 4}, {1, 2}, {3, 4}, {2, 3}};
        System.out.println(minimumTeachings(n2, languages2, friendships2)); // 2
    }

    public static int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        List<Set<Integer>> userLang = new ArrayList<>();
        for (int[] langList : languages) {
            Set<Integer> set = new HashSet<>();
            for (int l : langList) set.add(l);
            userLang.add(set);
        }

        Set<Integer> needTeach = new HashSet<>();
        for (int[] f : friendships) {
            int u = f[0] - 1, v = f[1] - 1;
            Set<Integer> langU = userLang.get(u);
            Set<Integer> langV = userLang.get(v);

            boolean canCommunicate = false;
            for (int l : langU) {
                if (langV.contains(l)) {
                    canCommunicate = true;
                    break;
                }
            }
            if (!canCommunicate) {
                needTeach.add(u);
                needTeach.add(v);
            }
        }

        if (needTeach.isEmpty()) return 0;

        int minTeach = Integer.MAX_VALUE;
        for (int lang = 1; lang <= n; lang++) {
            int count = 0;
            for (int user : needTeach) {
                if (!userLang.get(user).contains(lang)) {
                    count++;
                }
            }
            minTeach = Math.min(minTeach, count);
        }

        return minTeach;
    }
}
