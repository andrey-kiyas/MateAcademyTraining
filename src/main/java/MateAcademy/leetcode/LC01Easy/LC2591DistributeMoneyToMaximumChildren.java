package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/distribute-money-to-maximum-children
 */

public class LC2591DistributeMoneyToMaximumChildren {

    public static void main(String[] args) {
        System.out.println("Expected 1 - " + distMoney(20, 3) + " Output"); // Output: 1
        System.out.println("Expected 2 - " + distMoney(16, 2) + " Output"); // Output: 2
        System.out.println("Expected 0 - " + distMoney(4, 2) + " Output"); // Output: 0
        System.out.println("Expected 0 - " + distMoney(8, 2) + " Output"); // Output: 0
        System.out.println("Expected 0 - " + distMoney(9, 3) + " Output"); // Output: 0
        System.out.println("Expected 1 - " + distMoney(9, 2) + " Output"); // Output: 1
        System.out.println("Expected 2 - " + distMoney(16, 2) + " Output"); // Output: 2
        System.out.println("Expected 0 - " + distMoney(11, 5) + " Output"); // Output: 0
    }

    public static int distMoney(int money, int children) {
        // Everyone must receive at least 1 dollar.
        money -= children;
        if (money < 0) {
            return -1;
        }
        final int count7 = money / 7;
        final int remaining = money % 7;
        // Distribute 8 dollars to every child.
        if (count7 == children && remaining == 0) {
            return count7;
        }
        // Need to move 1 dollar from the last child with 4 dollars to one of other
        // children. That's why we need to substract 1.
        if (count7 == children - 1 && remaining == 3) {
            return count7 - 1;
        }
        // Though there might be child with 4 dollars, since count7 < children - 1,
        // we have "extra" spot to move money to if needed.
        return Math.min(children - 1, count7);
    }
}
