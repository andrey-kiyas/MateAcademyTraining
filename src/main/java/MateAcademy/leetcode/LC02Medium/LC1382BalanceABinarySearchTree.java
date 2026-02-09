package MateAcademy.leetcode.LC02Medium;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/balance-a-binary-search-tree
 */

public class LC1382BalanceABinarySearchTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4))));
        TreeNode balanced = balanceBST(root);
        System.out.println("Balanced root value: " + balanced.val);
    }

    public static TreeNode balanceBST(TreeNode root) {
        List<Integer> sortedValues = new ArrayList<>();
        inorderTraversal(root, sortedValues);
        return buildBalancedTree(sortedValues, 0, sortedValues.size() - 1);
    }

    private static void inorderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) return;
        inorderTraversal(node.left, list);
        list.add(node.val);
        inorderTraversal(node.right, list);
    }

    private static TreeNode buildBalancedTree(List<Integer> list, int start, int end) {
        if (start > end) return null;

        int mid = start + (end - start) / 2;
        TreeNode node = new TreeNode(list.get(mid));

        node.left = buildBalancedTree(list, start, mid - 1);
        node.right = buildBalancedTree(list, mid + 1, end);

        return node;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
