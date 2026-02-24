package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers
 */

public class LC1022SumOfRootToLeafBinaryNumbers {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,
                new TreeNode(0, new TreeNode(0), new TreeNode(1)),
                new TreeNode(1, new TreeNode(0), new TreeNode(1))
        );
        System.out.println(sumRootToLeaf(root)); // Output: 22
    }

    public static int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private static int dfs(TreeNode node, int currentSum) {
        if (node == null) {
            return 0;
        }

        currentSum = (currentSum << 1) | node.val;

        if (node.left == null && node.right == null) {
            return currentSum;
        }

        return dfs(node.left, currentSum) + dfs(node.right, currentSum);
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