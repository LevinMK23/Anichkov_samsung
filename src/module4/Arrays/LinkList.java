package module4.Arrays;

public class LinkList<T> {

    private class Node {

        T value;
        Node prev, next;

        public Node(T value) {
            this.value = value;
            prev = next = null;
        }
    }

    private Node head, tail;
    private int size;

    public LinkList() {
        head = tail = null;
        size = 0;
    }

    public void addBack(T value) {
        if (size == 0) {
            tail = head = new Node(value);
        } else {
            tail.next = new Node(value);
            tail.next.prev = tail;
            tail = tail.next;
        }
        size++;
    }

    public void add(int index, T value) {
        Node node = head;

    }

    @Override
    public String toString() {
        StringBuilder o = new StringBuilder();
        Node node = head;
        while (node != null) {
            o.append(node.value).append(' ');
            node = node.next;
        }
        return o.toString();
    }
}
