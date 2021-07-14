package t3_stack;

public class ArrayStack<T> {

    private static final int DEFAULT_CAPACITY = 10;
    private T[] items;
    private int size;
    private int capacity;

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        items = (T[]) new Object[capacity];
        size = 0;
    }

    public ArrayStack() {
        this.capacity = DEFAULT_CAPACITY;
        items = (T[]) new Object[capacity];
        size = 0;
    }
    //入栈
    public boolean push() {
        return false;
    }
    //出栈
    public T poll() {
        return null;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public boolean isFull() {
        return size == capacity;
    }
}
