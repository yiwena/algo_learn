package t4_queue;

public class ArrayQueue<T> {
    //队列的元素
    private T[] items;
    //队列的头部
    private int head;
    //队列的尾部
    private int tail;
    public static final int DEFAULT_CAPACITY = 5;

    public ArrayQueue() {
        items = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public ArrayQueue(int capacity) {
        //tail所在的位置默认不存数据
        items = (T[]) new Object[capacity+1];
    }

    public void enQueue(T data) {
        if (isFull()) {
            throw new RuntimeException("队列已满");
        }
        items[tail] = data;
        tail = (tail + 1) % items.length;
    }
    public T deQueue() {
        if (isEmpty()) {
            return null;
        }
        T data = items[head];
        head = (head + 1 + items.length) % items.length;
        return data;
    }

    public boolean isEmpty() {
        return head == tail;
    }
    public boolean isFull() {
        return (tail + 1) % items.length == head;
    }

    public static void main(String[] args) {
        ArrayQueue<String> arrayQueue = new ArrayQueue<>(5);
        arrayQueue.enQueue("1");
        arrayQueue.enQueue("2");
        arrayQueue.enQueue("3");
        arrayQueue.enQueue("4");
        arrayQueue.enQueue("5");
        System.out.println(arrayQueue.deQueue());
        System.out.println(arrayQueue.deQueue());
        System.out.println(arrayQueue.deQueue());
        arrayQueue.enQueue("3");
        arrayQueue.enQueue("4");
        arrayQueue.enQueue("5");
        System.out.println(arrayQueue.deQueue());
        System.out.println(arrayQueue.deQueue());
        System.out.println(arrayQueue.deQueue());
        System.out.println(arrayQueue.deQueue());
        System.out.println(arrayQueue.deQueue());
    }
}
