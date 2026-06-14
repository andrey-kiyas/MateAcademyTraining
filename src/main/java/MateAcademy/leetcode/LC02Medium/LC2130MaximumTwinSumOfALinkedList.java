package MateAcademy.leetcode.LC02Medium;

/**
 * https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list
 */

public class LC2130MaximumTwinSumOfALinkedList {
    public static void main(String[] args) {
        ListNode head1 = createList(new int[]{5, 4, 2, 1});
        System.out.println(pairSum(head1)); // 6

        ListNode head2 = createList(new int[]{4, 2, 2, 3});
        System.out.println(pairSum(head2)); // 7

        ListNode head3 = createList(new int[]{1, 100000});
        System.out.println(pairSum(head3)); // 100001
    }

    public static int pairSum(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null;
        ListNode curr = slow;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        ListNode firstHalf = head;
        ListNode secondHalf = prev;
        int maxTwinSum = 0;

        while (secondHalf != null) {
            int currentSum = firstHalf.val + secondHalf.val;
            maxTwinSum = Math.max(maxTwinSum, currentSum);

            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return maxTwinSum;
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
