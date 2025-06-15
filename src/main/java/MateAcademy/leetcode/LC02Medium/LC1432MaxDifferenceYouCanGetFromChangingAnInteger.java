package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/max-difference-you-can-get-from-changing-an-integer
 */

public class LC1432MaxDifferenceYouCanGetFromChangingAnInteger {
    public static void main(String[] args) {
        System.out.println(maxDiff(555)); // Output: 888
        System.out.println(maxDiff(9));   // Output: 8
    }

    public static int maxDiff(int num) {
        String s = Integer.toString(num);
        char[] maxArr = s.toCharArray();
        char toReplaceMax = 0;
        for (char c : maxArr) {
            if (c != '9') {
                toReplaceMax = c;
                break;
            }
        }
        for (int i = 0; i < maxArr.length; i++) {
            if (maxArr[i] == toReplaceMax) {
                maxArr[i] = '9';
            }
        }
        int maxNum = Integer.parseInt(new String(maxArr));

        char[] minArr = s.toCharArray();
        char toReplaceMin = 0;
        if (minArr[0] != '1') {
            toReplaceMin = minArr[0];
            for (int i = 0; i < minArr.length; i++) {
                if (minArr[i] == toReplaceMin) {
                    minArr[i] = '1';
                }
            }
        } else {
            for (int i = 1; i < minArr.length; i++) {
                if (minArr[i] != '0' && minArr[i] != '1') {
                    toReplaceMin = minArr[i];
                    break;
                }
            }
            for (int i = 1; i < minArr.length; i++) {
                if (minArr[i] == toReplaceMin) {
                    minArr[i] = '0';
                }
            }
        }

        int minNum = Integer.parseInt(new String(minArr));
        return maxNum - minNum;
    }
}
