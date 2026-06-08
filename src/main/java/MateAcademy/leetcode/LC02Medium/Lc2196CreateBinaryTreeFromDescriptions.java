package MateAcademy.leetcode.LC02Medium;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * https://leetcode.com/problems/create-binary-tree-from-descriptions
 */

public class Lc2196CreateBinaryTreeFromDescriptions {
    public static void main(String[] args) {
        int[][] descriptions = {
                {20, 15, 1},
                {20, 17, 0},
                {50, 20, 1},
                {50, 80, 0},
                {80, 19, 1}
        };

        TreeNode root = createBinaryTree(descriptions);
        System.out.println("Root node value: " + (root != null ? root.val : "null")); // 50
    }

    public static TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> nodesMap = new HashMap<>();
        Set<Integer> childrenSet = new HashSet<>();

        for (int[] d : descriptions) {
            int parentVal = d[0];
            int childVal = d[1];
            boolean isLeft = d[2] == 1;

            nodesMap.putIfAbsent(parentVal, new TreeNode(parentVal));
            nodesMap.putIfAbsent(childVal, new TreeNode(childVal));

            TreeNode parent = nodesMap.get(parentVal);
            TreeNode child = nodesMap.get(childVal);

            if (isLeft) {
                parent.left = child;
            } else {
                parent.right = child;
            }

            childrenSet.add(childVal);
        }

        for (int parentVal : nodesMap.keySet()) {
            if (!childrenSet.contains(parentVal)) {
                return nodesMap.get(parentVal);
            }
        }

        return null;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}


