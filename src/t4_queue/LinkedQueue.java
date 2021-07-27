package t4_queue;

public class LinkedQueue<T> {

    private Node<T> head;
    private Node<T> tail;

    public LinkedQueue() {
        this.head = new Node<>(null);
        this.tail = head;
    }

    public void enQueue(T data) {
        Node<T> tNode = new Node<>(data);
        tail.next = tNode;
        tail = tNode;
    }

    public T deQueue() {
        if (head.next == null) {
            tail = head;
            return null;
        }
        Node<T> old = head.next;
        head.next = head.next.next;
        if (head.next == null) {
            tail = head;
        }
        return old.data;
    }

    public static class Node<T>{
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        LinkedQueue<String> linkedQueue = new LinkedQueue<>();
        linkedQueue.enQueue("1");
        linkedQueue.enQueue("2");
        linkedQueue.enQueue("3");
        linkedQueue.enQueue("4");
        System.out.println(linkedQueue.deQueue());
        System.out.println(linkedQueue.deQueue());
        System.out.println(linkedQueue.deQueue());
        System.out.println(linkedQueue.deQueue());
        linkedQueue.enQueue("3");
        linkedQueue.enQueue("4");
        System.out.println(linkedQueue.deQueue());
        System.out.println(linkedQueue.deQueue());
    }
}
