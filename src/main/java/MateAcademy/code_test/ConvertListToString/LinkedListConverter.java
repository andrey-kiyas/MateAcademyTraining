package MateAcademy.code_test.ConvertListToString;

public class LinkedListConverter {
    public static void main(String[] args) {
//        Node list = new Node(1, new Node(2, new Node(3)));
        Node list = new Node(0, new Node(1, new Node(4, new Node(9, new Node(16)))));
        System.out.println(convertListToString(list));


        ListNode head = new ListNode(1, new ListNode(0, new ListNode(0, new ListNode(1, new ListNode(0,
                new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(0, new ListNode(1))))))))));
        int expected = 605;

        System.out.println(convertListToDecimal(head));

    }

    public static String convertListToString(Node list) {
        // do your magic
        StringBuilder sb = new StringBuilder();
        while (list != null) {
            sb.append(list.getData()).append(" -> ");
            list = list.getNext();
        }
        return sb.append("null").toString();
    }

    public static int convertListToDecimal(ListNode head) {
        // do your magic
        StringBuilder sb = new StringBuilder();
        while (head != null) {
            sb.append(head.value); //.append(" -> ");
            head = head.next;
        }
        return Integer.parseInt(String.valueOf(sb),2);
    }
}
