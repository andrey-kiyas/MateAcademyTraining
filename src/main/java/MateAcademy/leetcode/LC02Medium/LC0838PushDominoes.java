package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/push-dominoes
 */

public class LC0838PushDominoes {
    public static void main(String[] args) {
        System.out.println(pushDominoes("RR.L"));               // RR.L
        System.out.println(pushDominoes(".L.R...LR..L.."));     // LL.RR.LLRRLL..
    }

    public static String pushDominoes(String dominoes) {
        int n = dominoes.length();
        char[] arr = dominoes.toCharArray();
        int[] forces = new int[n];

        int force = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 'R') force = n;
            else if (arr[i] == 'L') force = 0;
            else force = Math.max(force - 1, 0);
            forces[i] += force;
        }

        force = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] == 'L') force = n;
            else if (arr[i] == 'R') force = 0;
            else force = Math.max(force - 1, 0);
            forces[i] -= force;
        }

        StringBuilder sb = new StringBuilder();
        for (int f : forces) {
            if (f > 0) sb.append('R');
            else if (f < 0) sb.append('L');
            else sb.append('.');
        }

        return sb.toString();
    }
}
