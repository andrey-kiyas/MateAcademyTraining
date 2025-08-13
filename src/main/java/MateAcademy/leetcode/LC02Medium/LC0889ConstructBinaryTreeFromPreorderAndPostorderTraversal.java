package MateAcademy.leetcode.LC02Medium;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC0889ConstructBinaryTreeFromPreorderAndPostorderTraversal {
    public static void main(String[] args) {
        System.out.println(treeToList(constructFromPrePost(
                                new int[]{1, 2, 4, 5, 3, 6, 7},
                                new int[]{4, 5, 2, 6, 7, 3, 1}))); // [1,2,3,4,5,6,7]
        System.out.println(treeToList(constructFromPrePost(
                                new int[]{1},
                                new int[]{1})));     // [1]
    }

    public static TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return build(preorder, postorder, new int[]{0}, 0, postorder.length - 1);
    }

    private static TreeNode build(int[] preorder, int[] postorder, int[] preIndex, int left, int right) {
        if (left > right) return null;

        TreeNode root = new TreeNode(preorder[preIndex[0]++]);

        if (left == right) return root;

        int leftSubtreeRootIndex = left;
        while (postorder[leftSubtreeRootIndex] != preorder[preIndex[0]]) {
            leftSubtreeRootIndex++;
        }

        root.left = build(preorder, postorder, preIndex, left, leftSubtreeRootIndex);
        root.right = build(preorder, postorder, preIndex, leftSubtreeRootIndex + 1, right - 1);

        return root;
    }

    public static List<Integer> treeToList(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                result.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            } else {
                result.add(null);
            }
        }

        while (!result.isEmpty() && result.get(result.size() - 1) == null) {
            result.remove(result.size() - 1);
        }

        return result;
    }
}
