package t2_linkedlist;

public class MyLinkedList<T> {

    private Node<T> root;

    public MyLinkedList() {
    }

    public MyLinkedList(T t) {
        this.root = root;
    }
    public boolean isEmpty() {
        return root == null;
    }
    //插入链表的头部
    public void addFirst(T data) {
        Node node = new Node(data);
        if (root == null) {
            root = node;
        }else{
            node.next = root;
            root = node;
        }
    }

    //插入链表的尾部
    public void addLast(T data) {
        Node node = new Node(data);
        if (root == null) {
            root = node;
        }else{
            Node tmp = root;
            while (tmp.next != null) {
                tmp = tmp.next;
            }
            tmp.next = node;
        }
    }

    public boolean remove(T t) {

        if (root == null) {
            return false;
        }
        if (root.data.equals(t)) {
            root = root.next;
            return true;
        }
        Node tmp = root;
        while (tmp.next!= null) {
            if (tmp.next.data.equals(t)) {
                tmp.next = tmp.next.next;
                return true;
            }
            tmp = tmp.next;
        }
        return false;
    }
    //删除第一个节点
    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        T oldDate = root.data;
        root = root.next;
        return oldDate;
    }
    //删除最后一个
    public T removeLast() {
        //链表为空
        if (isEmpty()) {
            return null;
        }
        T oldData = null;
        //链表中只有一个元素
        if (root.next == null) {
            oldData = root.data;
            root = null;
            return oldData;
        }
        //链表中有多个元素
        Node tmp = root;
        while (tmp.next.next != null) {
            tmp = tmp.next;
        }
        oldData = (T) tmp.next.data;
        tmp.next = null;
        return oldData;
    }

    public static class Node<T>{
        private T data;
        private Node next;
        public Node(T data) {
            this.data = data;
        }

    }

    public void show() {
        if (root == null) {
            System.out.println("null");
        }else{
            Node tmp = root;
            while (tmp != null) {
                System.out.print(tmp.data + "  ");
                tmp = tmp.next;
            }
            System.out.println();
        }
    }

    //链表反转
    public static Node reverse(Node node) {
        Node pre = null;
        Node curr = node;
        while (curr != null) {
            Node tmp = curr.next;
            curr.next = pre;
            pre = curr;
            curr = tmp;
        }
        return pre;
    }

    public static void show(Node node) {
        Node tmp = node;
        while (tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }
    //检查是否有环
    public static boolean checkCircle(Node node) {
        if (node == null ) {
            return false;
        }
        Node fast = node.next;
        Node slow = node;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    //两个有序的链表合并
    public static Node marge(Node<Integer> first, Node<Integer> second) {
        Node<Integer> marge = new Node<>(null);
        Node<Integer> tmp = marge;
        Node<Integer> a = first;
        Node<Integer> b = second;
        while (a != null && b != null) {
            Integer m = a.data;
            Integer n = b.data;
            if (m > n) {
                tmp.next = new Node(n);
                b = b.next;
            }else{
                tmp.next = new Node(m);
                a = a.next;
            }
            tmp = tmp.next;
        }
        if (a == null) {
            tmp.next = b;
        }else{
            tmp.next = a;
        }

        return marge.next;
    }

    //删除链表倒数第n个节点
    //快指针先走n-1
    //然后快指针和慢指针一起走
    //快指针到头的时候 慢指针的位置就是待删除的前一个节点
    //删除下一个节点
    public static Node deleteNumberLast(Node node, int index) {
        Node fast = node;
        int i = 1;
        while (fast != null && i < index) {
            fast = fast.next;
            i++;
        }
        if (fast == null) {
            return node;
        }
        Node slow = node;
        Node pre = null;
        while (fast.next != null) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }
        if (pre == null) {
            node = node.next;
        }else{
            pre.next = pre.next.next;
        }
        return node;
    }

    //链表的中间节点
    public static Node findMidNode(Node node) {
        if (node == null) {
            return null;
        }
        Node fast = node;
        Node slow = node;
        while (fast!= null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    public static void main(String[] args) {
        /*MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.addFirst(1);
        linkedList.addFirst(2);
        linkedList.addFirst(3);
        linkedList.addFirst(4);
        linkedList.show();
        linkedList.addLast(1);
        linkedList.addLast(2);
        linkedList.addLast(3);
        linkedList.show();
        linkedList.remove(1);
        linkedList.remove(1);
        linkedList.removeLast();
        linkedList.removeLast();
        linkedList.show();*/
        //链表反转
//        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
//        linkedList.addLast(1);
//        linkedList.addLast(2);
//        linkedList.addLast(3);
//        linkedList.addLast(4);
//        Node reverse = MyLinkedList.reverse(linkedList.root);
//        MyLinkedList.show(reverse);
//        是否循环链表
//        System.out.println(MyLinkedList.checkCircle(linkedList.root));
//        Node node1 = new Node(1);
//        Node node2 = new Node(2);
//        Node node3 = new Node(3);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node1;
//        System.out.println(MyLinkedList.checkCircle(node1));
//                链表合并
//        Node<Integer> node1 = new Node<>(1);
//        Node<Integer> node2 = new Node<>(3);
//        Node<Integer> node3 = new Node<>(5);
//        Node<Integer> node4 = new Node<>(7);
//        Node<Integer> node5 = new Node<>(2);
//        Node<Integer> node6 = new Node<>(4);
//        Node<Integer> node7 = new Node<>(5);
//        Node<Integer> node8 = new Node<>(8);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node5.next = node6;
//        node6.next = node7;
//        node7.next = node8;
//        Node marge = MyLinkedList.marge(node1, node5);
//        MyLinkedList.show(marge);
        //删除链表倒数第n个节点
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        MyLinkedList.deleteNumberLast(node1, 2);
        MyLinkedList.show(node1);

    }
}
