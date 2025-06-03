package MateAcademy.leetcode.LC02Medium;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree
 */

public class LC1261FindElementsInAContaminatedBinaryTree {
    public static void main(String[] args) {
        FindElements findElements = new FindElements(new TreeNode(-1, null, new TreeNode(-1)));

        System.out.println(findElements.find(1)); // false
        System.out.println(findElements.find(2)); // true
    }
}

class FindElements {
    private Set<Integer> values = new HashSet<>();

    public FindElements(TreeNode root) {
        recoverTree(root, 0);
    }

    private void recoverTree(TreeNode node, int val) {
        if (node == null) return;
        node.val = val;
        values.add(val);
        recoverTree(node.left, 2 * val + 1);
        recoverTree(node.right, 2 * val + 2);
    }

    public boolean find(int target) {
        return values.contains(target);
    }
}