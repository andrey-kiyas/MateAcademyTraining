package MateAcademy.SetQueueStackComparator;

import java.util.EmptyStackException;

// https://medium.com/@Emmanuel.A/data-structure-stacks-java-598f5f181672

@SuppressWarnings("unchecked") // do not remove this line
public class Stack<T> {
    private static final int INITIAL_ARRAY_SIZE = 10;
    private Object[] data = new Object[INITIAL_ARRAY_SIZE];
    private int size = 0;

    public void push(T value) {
        resizeArray();
        data[size] = value;
        size++;
    }

    public T peek() {
        if (size() == 0) {
            throw new EmptyStackException();
        }
        return (T) data[size - 1];
    }

    public T pop() {
        if (size() == 0) {
            throw new EmptyStackException();
        }
        T result = (T) data[size - 1];
        data[size - 1] = null;
        size--;
        return result;
    }

    public int size() {
        return size;
    }

    public void resizeArray() {
        if (size == data.length) {
            Object[] boofer = new Object[data.length + (data.length >> 1)];
            System.arraycopy(data, 0, boofer, 0, size);
            data = boofer;
        }
    }
}

//public class Stack<T> {
//    private Node<T> top;
//    private int size;
//
//    public void push(T value) {
//        Node<T> node = new Node(value);
//        node.next = top;
//        top = node;
//        size++;
//    }
//
//    public T peek() {
//        if (size == 0) {
//            throw new EmptyStackException();
//        }
//        return top.value;
//    }
//
//    public T pop() {
//        if (size == 0) {
//            throw new EmptyStackException();
//        }
//        T tempNode = top.value;
//        top = top.next;
//        size--;
//        return tempNode;
//    }
//
//    public int size() {
//        return size;
//    }
//
//    private static class Node<T> {
//        private T value;
//        private Node<T> next;
//
//        private Node(T value) {
//            this.value = value;
//        }
//    }
//}
