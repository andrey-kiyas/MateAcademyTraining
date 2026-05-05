package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/rotate-list
 */

public class LC0061RotateList {
    public static void main(String[] args) {
        ListNode head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5)))));
        printList(rotateRight(head1, 2)); // 4 -> 5 -> 1 -> 2 -> 3

        ListNode head2 = new ListNode(0, new ListNode(1, new ListNode(2)));
        printList(rotateRight(head2, 4)); // 2 -> 0 -> 1
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode tail = head;
        int n = 1;
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }

        k %= n;
        if (k == 0) return head;

        tail.next = head;

        ListNode newTail = head;
        for (int i = 0; i < n - k - 1; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }

    private static void printList(ListNode node) {
        while (node != null) {
            System.out.print(node.val + (node.next != null ? " -> " : ""));
            node = node.next;
        }
        System.out.println();
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