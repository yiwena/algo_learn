package t1_array;


/**
 * LRU算法
 *  //数组里面没有该元素
 *         //1.数组未满 直接插入头部
 *         //2.数组满 删除尾元素 插入头部
 *         //数组里面有该元素
 *         //删除该元素 并将该元素添加到头部
 * @param <T>
 */
public class LRUArray<T> {
    private T[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public LRUArray() {
        data = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public LRUArray(int capacity) {
        data = (T[]) new Object[capacity];
    }

    public int contains(T t) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(t)) {
                return i;
            }
        }
        return -1;
    }
    public void add(T t) {
        int index = contains(t);
        if (index!=-1) {
            //存在
            remove(index);
            addFirst(t);
        }else{
            //不存在
            if (isFull()) {
                removeLast();
                addFirst(t);
            }else{
                addFirst(t);
            }
        }
    }
    public boolean isFull() {
        return data.length == size;
    }

    public T removeLast() {
        return remove(size-1);
    }
    public T remove(int index) {
        T oldElement = data[index];
        int moved = size - index - 1;
        if (moved > 0) {
            System.arraycopy(data, index + 1, data, index, moved);
        }
        size--;
        return oldElement;
    }

    public void add(int index,T t) {
        System.arraycopy(data, index, data, index+1, size -index);
        data[index] = t;
        size++;
    }

    public void addFirst(T t) {
        add(0, t);
    }

    public void addLast(T t) {
        add(size - 1, t);
    }

    public static void main(String[] args) {
        LRUArray<Integer> array = new LRUArray<>(5);
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(4);
        array.add(5);
        array.add(2);
        array.add(1);
        array.add(1);
    }
}
