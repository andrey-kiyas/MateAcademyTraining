package MateAcademy.leetcode.LC01Easy;

/**
 * https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer
 */

public class LC1290ConvertBinaryNumberInALinkedListToInteger {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1, new ListNode(0, new ListNode(1)));
        ListNode head2 = new ListNode(0);

        System.out.println(getDecimalValue(head1)); // 5
        System.out.println(getDecimalValue(head2)); // 0
    }

    public static int getDecimalValue(ListNode head) {
        int result = 0;
        while (head != null) {
            result = result * 2 + head.val;
            head = head.next;
        }
        return result;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}