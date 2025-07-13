package MateAcademy.leetcode.LC02Medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-matching-of-players-with-trainers
 */

public class LC2410MaximumMatchingOfPlayersWithTrainers {
    public static void main(String[] args) {
        System.out.println(matchPlayersAndTrainers(new int[]{4, 7, 9}, new int[]{8, 2, 5, 8})); // 2
        System.out.println(matchPlayersAndTrainers(new int[]{1, 1, 1}, new int[]{10}));         // 1
    }

    public static int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);

        int i = 0, j = 0, matches = 0;

        while (i < players.length && j < trainers.length) {
            if (players[i] <= trainers[j]) {
                matches++;
                i++;
                j++;
            } else {
                j++;
            }
        }

        return matches;
    }
}
