package MateAcademy.leetcode.LC03Hard;

import java.util.*;

/**
 * https://leetcode.com/problems/recover-a-tree-from-preorder-traversal
 */

public class LC1028RecoverATreeFromPreorderTraversal {
    public static void main(String[] args) {
        System.out.println(levelOrder(recoverFromPreorder("1-2--3--4-5--6--7")));   // [1, 2, 5, 3, 4, 6, 7]
        System.out.println(levelOrder(recoverFromPreorder("1-2--3---4-5--6---7"))); // [1, 2, 5, 3, null, 6, null, 4, null, 7]
        System.out.println(levelOrder(recoverFromPreorder("1-401--349---90--88"))); // [1, 401, null, 349, 88, 90]
    }

    public static TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> stack = new Stack<>();
        int i = 0, n = traversal.length();

        while (i < n) {
            int depth = 0;
            while (i < n && traversal.charAt(i) == '-') {
                depth++;
                i++;
            }

            int value = 0;
            while (i < n && Character.isDigit(traversal.charAt(i))) {
                value = value * 10 + (traversal.charAt(i) - '0');
                i++;
            }

            TreeNode node = new TreeNode(value);

            while (stack.size() > depth) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                if (stack.peek().left == null) {
                    stack.peek().left = node;
                } else {
                    stack.peek().right = node;
                }
            }

            stack.push(node);
        }

        while (stack.size() > 1) {
            stack.pop();
        }

        return stack.peek();
    }

    public static List<Integer> levelOrder(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                res.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            } else {
                res.add(null);
            }
        }

        int lastIndex = res.size() - 1;
        while (lastIndex >= 0 && res.get(lastIndex) == null) {
            lastIndex--;
        }

        return res.subList(0, lastIndex + 1);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
