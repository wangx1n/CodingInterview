package Interview.tencent;

import java.util.HashMap;
import java.util.Map;

public class tencent20210929 {
    public static void main(String[] args) {
        LRU lru = new LRU(5);
        lru.put(1, 10);
        lru.put(2, 20);
        System.out.println(lru.get(2));
        lru.put(3, 30);
        lru.put(4, 40);
        lru.put(5, 50);
        System.out.println(lru.get(2));
        lru.put(6, 60);
        System.out.println(lru.map);
    }
}

class LRU {
    class Node {
        int key, value;
        Node pre, next;
        public Node(int k, int v) {
            key = k;
            value = v;
        }
        public Node(){}
    }

    Map<Integer, Node> map;
    Node head, tail;
    int capacity;

    // LRU 构造函数
    public LRU(int capacity) {
        map = new HashMap<>();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.pre = head;
        this.capacity = capacity;
    }

    // get
    public int get(int key) {
        Node res = map.get(key);
        if (res == null) {
            return -1;
        }
        afterGet(res);
        return res.value;
    }

    // afterGet get后移到链表头
    public void afterGet(Node node) {
        if (node.next == tail) {
            return;
        }
        removeNode(node);
        insertHead(node);
    }

    // moveHead 最近使用的数据放到链表头
    public void moveHead(Node node) {
        node.next = tail;
        node.pre = head;
        head.next = node;
        tail.pre = node;
    }

    // put
    public void put(int key, int value) {
        Node node = new Node(key, value);
        Node oldNode = map.put(key, node);
        if (oldNode != null) {
            removeNode(oldNode);
        }
        insertHead(node);
        if (map.size() > this.capacity) {
            int k = removeNode(head.next);
            map.remove(k);
        }
    }

    // insertHead
    public void insertHead(Node node) {
        node.next = tail;
        node.pre = tail.pre;
        tail.pre.next = node;
        tail.pre = node;
    }

    // removeNode
    public int removeNode(Node node) {
        int res = node.key;
        Node p = node.pre;
        Node n = node.next;
        p.next = n;
        n.pre = p;
        return res;
    }
}
