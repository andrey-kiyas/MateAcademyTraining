package MateAcademy.leetcode.LC01Easy;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/delete-nodes-from-linked-list-present-in-array
 */

public class LC3217DeleteNodesFromLinkedListPresentInArray {
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
}

