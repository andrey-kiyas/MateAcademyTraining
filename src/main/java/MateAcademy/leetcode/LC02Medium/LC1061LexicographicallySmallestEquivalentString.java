package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/lexicographically-smallest-equivalent-string
 */

public class LC1061LexicographicallySmallestEquivalentString {
    static int[] parent = new int[26];

    public static void main(String[] args) {
        System.out.println(smallestEquivalentString("parker", "morris", "parser"));         // makkek
        System.out.println(smallestEquivalentString("hello", "world", "hold"));             // hdld
        System.out.println(smallestEquivalentString("leetcode", "programs", "sourcecode")); // aauaaaaada
    }

    public static String smallestEquivalentString(String s1, String s2, String baseStr) {
        for (int i = 0; i < 26; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < s1.length(); i++) {
            union(s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        StringBuilder sb = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            sb.append((char) (find(c - 'a') + 'a'));
        }

        return sb.toString();
    }

    private static int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    private static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);
        if (pa == pb) return;
        if (pa < pb) {
            parent[pb] = pa;
        } else {
            parent[pa] = pb;
        }
    }
}
