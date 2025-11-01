package MateAcademy.leetcode.LC01Easy;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array
 */

public class LC3217DeleteNodesFromLinkedListPresentInArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        ListNode head1 = makeList(new int[]{1, 2, 3, 4, 5});
        System.out.println("Example 1: " + listToString(modifiedList(nums1, head1))); // [4, 5]

        int[] nums2 = {1};
        ListNode head2 = makeList(new int[]{1, 2, 1, 2, 1, 2});
        System.out.println("Example 2: " + listToString(modifiedList(nums2, head2))); // [2, 2, 2]

        int[] nums3 = {5};
        ListNode head3 = makeList(new int[]{1, 2, 3, 4});
        System.out.println("Example 3: " + listToString(modifiedList(nums3, head3))); // [1, 2, 3, 4]
    }

    public static ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> s = new HashSet<>();
        for (int x : nums) {
            s.add(x);
        }

        ListNode dummy = new ListNode(0, head);

        for (ListNode pre = dummy; pre.next != null;) {
            if (s.contains(pre.next.val)) {
                pre.next = pre.next.next;
            } else {
                pre = pre.next;
            }
        }

        return dummy.next;
    }

    static ListNode makeList(int[] arr) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for (int x : arr) {
            cur.next = new ListNode(x);
            cur = cur.next;
        }
        return dummy.next;
    }

    static String listToString(ListNode head) {
        StringBuilder sb = new StringBuilder("[");
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) sb.append(", ");
            head = head.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

