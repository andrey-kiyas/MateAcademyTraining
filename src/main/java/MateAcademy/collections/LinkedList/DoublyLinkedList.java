package MateAcademy.collections.LinkedList;

public class DoublyLinkedList {
    public static void insertNode(ListNode previous, ListNode newNode) {
        // write code here
        newNode.prev = previous.next.prev;
        newNode.next = previous.next;
        newNode.next.prev = newNode;
        newNode.prev.next = newNode;
    }

    public static void deleteNode(ListNode node) {
        // write code here
        node.prev.next = node.prev;
        node.next.prev = node.next;
    }
}


//        Input: head = [4, 9], previous = 4, newNode = 1
//        Output: [4, 1, 9]
//        Explanation: You are given the previous node with value 4 and a new node with value 1
//        the linked list should become 4 ⇆ 1 ⇆ 9 after calling your method
//        Input: head = [4, 1, 9], previous = 1, newNode = 5
//        Output: [4, 1, 5, 9]
//        Explanation: You are given the previous node with value 1 and a new node with value 5
//        the linked list should become 4 ⇆ 1 ⇆ 5 ⇆ 9 after calling your method