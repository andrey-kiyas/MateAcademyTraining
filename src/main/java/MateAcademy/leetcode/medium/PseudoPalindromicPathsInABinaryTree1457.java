package MateAcademy.leetcode.medium;

/**
 * https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree
 */

public class PseudoPalindromicPathsInABinaryTree1457 {

    public static void main(String[] args) {
        // Примеры
        TreeNode root1 = new TreeNode(2,
                new TreeNode(3,
                        new TreeNode(3),
                        new TreeNode(1)),
                new TreeNode(1,
                        null,
                        new TreeNode(1)));
        System.out.println("Expected: 2, Output: " + pseudoPalindromicPaths(root1));

        TreeNode root2 = new TreeNode(2,
                new TreeNode(1,
                        new TreeNode(1,
                                new TreeNode(1,
                                        null,
                                        new TreeNode(1)),
                                new TreeNode(3)),
                        null),
                null);
        System.out.println("Expected: 1, Output: " + pseudoPalindromicPaths(root2));

        TreeNode root3 = new TreeNode(9);
        System.out.println("Expected: 1, Output: " + pseudoPalindromicPaths(root3));
    }

    public static int pseudoPalindromicPaths(TreeNode root) {
        return countPaths(root, new int[10]);
    }

    private static int countPaths(TreeNode node, int[] digitCount) {
        if (node == null) {
            return 0;
        }

        digitCount[node.val]++;

        if (node.left == null && node.right == null) {
            int oddCount = 0;
            for (int count : digitCount) {
                if (count % 2 != 0) {
                    oddCount++;
                }
            }

            // Путь является псевдо-палиндромным, если у нас не более одной нечетной частоты для цифр
            return (oddCount <= 1) ? 1 : 0;
        }

        int leftPaths = countPaths(node.left, digitCount.clone());
        int rightPaths = countPaths(node.right, digitCount.clone());

        return leftPaths + rightPaths;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
