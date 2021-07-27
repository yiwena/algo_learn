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
    public boolean push(T data) {
        if (isFull()) {
            return false;
        }
        items[size] = data;
        size++;
        return true;
    }
    //出栈
    public T poll() {
        if (isEmpty()) {
            return null;
        }
        size--;
        return items[size];
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public boolean isFull() {
        return size == capacity;
    }

    public static void main(String[] args) {
        ArrayStack<Integer> arrayStack = new ArrayStack<>(5);
        arrayStack.push(1);
        arrayStack.push(2);
        arrayStack.push(3);
        arrayStack.push(4);
        arrayStack.push(5);
        System.out.println(arrayStack.poll());
        System.out.println(arrayStack.poll());
        System.out.println(arrayStack.poll());
        System.out.println(arrayStack.poll());
        System.out.println(arrayStack.poll());
    }
}
