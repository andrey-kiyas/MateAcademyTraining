package MateAcademy.leetcode.LC02Medium;



public class LC3227VowelsGameInAString {
    public static void main(String[] args) {
        System.out.println(doesAliceWin("leetcoder")); // true
        System.out.println(doesAliceWin("bbcd"));      // false
    }

    public static boolean doesAliceWin(String s) {
        for (char c : s.toCharArray()) {
            if ("aeiou".indexOf(c) != -1) {
                return true;
            }
        }
        return false;
    }
}
