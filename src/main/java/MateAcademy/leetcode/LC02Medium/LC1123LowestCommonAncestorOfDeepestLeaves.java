package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves
 */

public class LC1123LowestCommonAncestorOfDeepestLeaves {
    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(3,
                new TreeNode(5,
                        new TreeNode(6),
                        new TreeNode(2,
                                new TreeNode(7),
                                new TreeNode(4)
                        )
                ),
                new TreeNode(1,
                        new TreeNode(0),
                        new TreeNode(8)
                )
        );
        TreeNode root2 = new TreeNode(1);
        TreeNode root3 = new TreeNode(0,
                new TreeNode(1, null, new TreeNode(2)),
                new TreeNode(3)
        );
        System.out.println(lcaDeepestLeaves(root1)); // Ожидается: 2
        System.out.println(lcaDeepestLeaves(root2)); // Ожидается: 1
        System.out.println(lcaDeepestLeaves(root3)); // Ожидается: 2
    }

    public static TreeNode lcaDeepestLeaves(TreeNode root) {
        return dfs(root).node;
    }

    private static Result dfs(TreeNode root) {
        if (root == null) return new Result(null, 0);

        Result left = dfs(root.left);
        Result right = dfs(root.right);

        if (left.depth == right.depth) {
            return new Result(root, left.depth + 1);
        } else if (left.depth > right.depth) {
            return new Result(left.node, left.depth + 1);
        } else {
            return new Result(right.node, right.depth + 1);
        }
    }

    static class Result {
        TreeNode node;
        int depth;
        Result(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {}

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
}
