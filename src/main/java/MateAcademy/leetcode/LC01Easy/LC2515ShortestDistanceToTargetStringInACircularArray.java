package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/shortest-distance-to-target-string-in-a-circular-array
 */

public class LC2515ShortestDistanceToTargetStringInACircularArray {
    public static void main(String[] args) {
        System.out.println(closestTarget(new String[]{"hello", "i", "am", "leetcode", "hello"}, "hello", 1)); // 1
        System.out.println(closestTarget(new String[]{"a", "b", "leetcode"}, "leetcode", 0));                 // 1
        System.out.println(closestTarget(new String[]{"i", "eat", "leetcode"}, "ate", 0));                    // -1
    }

    public static int closestTarget(String[] words, String target, int startIndex) {
        int n = words.length;
        int minDistance = Integer.MAX_VALUE;
        boolean found = false;

        for (int i = 0; i < n; i++) {
            if (words[i].equals(target)) {
                found = true;
                int dist = Math.abs(i - startIndex);
                int shortestDist = Math.min(dist, n - dist);

                minDistance = Math.min(minDistance, shortestDist);
            }
        }

        return found ? minDistance : -1;
    }
}
