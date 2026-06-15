package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list
 */

public class LC2095DeleteTheMiddleNodeOfALinkedList {
    public static void main(String[] args) {
        // Тест 1: [1, 3, 4, 7, 1, 2, 6] -> Середина 7 -> Результат: [1, 3, 4, 1, 2, 6]
        ListNode head1 = createList(new int[]{1, 3, 4, 7, 1, 2, 6});
        printList(deleteMiddle(head1));

        // Тест 2: [1, 2, 3, 4] -> Середина 3 -> Результат: [1, 2, 4]
        ListNode head2 = createList(new int[]{1, 2, 3, 4});
        printList(deleteMiddle(head2));

        // Тест 3: [2, 1] -> Середина 1 -> Результат: [2]
        ListNode head3 = createList(new int[]{2, 1});
        printList(deleteMiddle(head3));
    }

    public static ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head.next.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = slow.next.next;

        return head;
    }

    private static void printList(ListNode head) {
        if (head == null) {
            System.out.println("[]");
            return;
        }
        StringBuilder sb = new StringBuilder("[");
        ListNode curr = head;
        while (curr != null) {
            sb.append(curr.val);
            if (curr.next != null) sb.append(", ");
            curr = curr.next;
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    private static ListNode createList(int[] arr) {
        if (arr == null || arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    public static class ListNode {
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
}
