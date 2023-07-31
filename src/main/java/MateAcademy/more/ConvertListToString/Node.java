package MateAcademy.more.ConvertListToString;

class Node {
    private Integer data;
    private Node next;

    public Node(Integer data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public Integer getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }
}
