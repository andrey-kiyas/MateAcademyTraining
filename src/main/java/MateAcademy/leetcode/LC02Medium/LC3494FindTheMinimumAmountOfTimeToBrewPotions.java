package MateAcademy.leetcode.LC02Medium;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-the-minimum-amount-of-time-to-brew-potions/description
 */

public class LC3494FindTheMinimumAmountOfTimeToBrewPotions {
    public static void main(String[] args) {
        System.out.println(minTime(new int[]{1, 5, 2, 4}, new int[]{5, 1, 4, 2})); // 110
        System.out.println(minTime(new int[]{1, 1, 1}, new int[]{1, 1, 1}));       // 5
        System.out.println(minTime(new int[]{1, 2, 3, 4}, new int[]{1, 2}));       // 21
    }

    public static long minTime(int[] skill, int[] mana) {
        long sumSkill = Arrays.stream(skill).sum();
        long prevWizardDone = sumSkill * mana[0];

        for (int j = 1; j < mana.length; ++j) {
            long prevPotionDone = prevWizardDone;
            for (int i = skill.length - 2; i >= 0; --i) {
                prevPotionDone -= (long) skill[i + 1] * mana[j - 1];
                prevWizardDone = Math.max(prevPotionDone, prevWizardDone - (long) skill[i] * mana[j]);
            }
            prevWizardDone += sumSkill * mana[j];
        }

        return prevWizardDone;
    }
}
