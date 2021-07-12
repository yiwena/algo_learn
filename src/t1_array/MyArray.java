package t1_array;

import java.util.Arrays;

public class MyArray<T>{
    //默认容量
    private static final int DEFAULT_CAPACITY = 10;
    //数组元素
    private T[] data;
    //数组长度
    private int size;

    public MyArray() {
        data = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public MyArray(int capacity) {
        data = (T[]) new Object[capacity > DEFAULT_CAPACITY ? capacity : DEFAULT_CAPACITY];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void checkForAdd(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("数组下标越界");
        }
    }

    public void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("数组下标越界");
        }
    }
    //扩容
    public void checkAndGrow() {
        if (data.length > size) {
            //不需要扩容
            return;
        }
        //扩容逻辑
        int oldCapacity = data.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity < 0) {
            //防止溢出
            newCapacity = Integer.MAX_VALUE;
        }
        //复制到新数组
        data = Arrays.copyOf(data, newCapacity);
    }
    //添加操作
    public void add(T t) {
        checkAndGrow();
        data[size] = t;
        size++;
    }
    //在指定下表位置添加
    public void add(int index, T t) {
        checkForAdd(index);
        checkAndGrow();

        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = t;
        size++;
    }

    public T get(int index) {
        checkIndex(index);
        return data[index];
    }

    public int find(T e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }
    //在首部添加
    public void addFirst(T t) {
        add(0, t);
    }
    //在尾部添加
    public void addLast(T t) {
        add(t);
    }

    //删除指定index的元素
    public T remove(int index) {
        checkIndex(index);
        T oldData = get(index);
        int moved = size - index - 1;
        if (moved > 0)
        System.arraycopy(data, index+1, data, index, moved);
        size--;
        return oldData;
    }

    public boolean remove(T t) {
        if (t == null) {
            for (int i = 0; i < size; i++) {
                if (data[i] == null) {
                    remove(i);
                    return true;
                }
            }
        }else{
            for (int i = 0; i < size; i++) {
                if (data[i].equals(t)) {
                    remove(i);
                    return true;
                }
            }
        }
        return false;
    }
    @Override
    public String toString() {
        return Arrays.toString(data);
    }

    public static void main(String[] args) {
        MyArray<Integer> array = new MyArray<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.remove(2);
        System.out.println(array.toString());
        for (int i = 0; i < 10; i++) {
            array.add(i);
        }
        System.out.println(array.get(10));
        array.addLast(1);
        array.remove(2);
        System.out.println(array.toString());

    }
}
