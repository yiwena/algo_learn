package t3_stack;

public class LinkedStack<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private Node<T> head;
    private int capacity;
    private int size;

    public LinkedStack() {
        head = new Node<>(null);
        capacity = DEFAULT_CAPACITY;
        size = 0;
    }

    public LinkedStack(int capacity) {
        head = new Node<>(null);
        this.capacity = capacity;
        size = 0;
    }
    public T poll() {
        if (isEmpty()) {
            return null;
        }
        Node<T> tmp = head.next;
        head.next = head.next.next;
        return tmp.data;
    }

    public boolean push(T data) {
        if (isFull()) {
            return false;
        }
        Node<T> node = new Node<>(data);
        node.next = head.next;
        head.next = node;
        size++;
        return true;
    }
    public boolean isEmpty() {
        return size == 0;
    }
    public boolean isFull() {
        return size == capacity;
    }

    public static class Node<T>{
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        LinkedStack<Integer> linkedStack = new LinkedStack<>(5);
        linkedStack.push(1);
        linkedStack.push(2);
        linkedStack.push(3);
        linkedStack.push(4);
        linkedStack.push(5);
        System.out.println(linkedStack.poll());
        System.out.println(linkedStack.poll());
        System.out.println(linkedStack.poll());
        System.out.println(linkedStack.poll());
        System.out.println(linkedStack.poll());

    }
}
