package t2_linkedlist;

import java.util.Random;

/**
 * 插入数据，查看是否存在
 *          1.存在 删除该节点  插入到头部
 *          2.不存在  查看是否已满
 *                  已满  删除链表尾部  将新数据插入到头部
 *                  未满  将新数据插入到头部
 * @param <T>
 */
public class LRULinkedList<T> {

    private int size;
    private int capacity;
    private Node<T> root;
    private static final int DEFAULT_CAPACITY = 10;


    public LRULinkedList() {
        this.root = new Node<>(null);
        this.capacity = DEFAULT_CAPACITY;
    }

    public LRULinkedList(int capacity) {
        this.root = new Node(null);
        this.capacity = capacity;
    }
    public boolean isFull() {
        return size == capacity;
    }

    public void add(T data) {
        Node node = havePreDeleteNode(data);
        //存在
        if (node != null) {
            //删除这个节点
            deleteNode(node);
            //链表首部添加
            addFirst(data);
        }else{
            if (isFull()) {
                //删除最后一个
                deleteLast();
                //添加首部
                addFirst(data);
            }else{
                //直接添加首部
                addFirst(data);
            }
        }
    }
    public void addFirst(T data) {
        Node tmp = root.next;
        Node<T> node = new Node<>(data);
        node.next = tmp;
        root.next = node;
        size++;
    }
    //获取删除元素的前一个节点
    public Node havePreDeleteNode(T data) {
        Node tmp = root;
        while (tmp.next != null) {
            if (data.equals(tmp.next.data)) {
                return tmp;
            }
            tmp = tmp.next;
        }
        return null;
    }
    public void deleteLast() {
        Node tmp = root;
        if (tmp.next == null) {
            return;
        }
        while (tmp.next != null) {
            tmp = tmp.next;
        }
        tmp = null;
        size--;
    }

    //删除下一个节点
    public void deleteNode(Node preNode) {
        Node tmp = preNode.next;
        preNode.next = tmp.next;
        size--;
    }
    public static class Node<T>{
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        LRULinkedList<Integer> lruLinkedList = new LRULinkedList<>();
        Random random = new Random();
        for (int i = 0; i < 15; i++) {
            lruLinkedList.add(random.nextInt(10));
        }
    }
}
