package leetcode.hash;

import java.util.HashMap;

/**
 *  https://leetcode.com/problems/lru-cache/
 *  146. LRU Cache
 *  Medium
 *
 *  //代码面试指南 P465
 *  https://blog.csdn.net/qq_41231926/article/details/86173740
 *  双向链表保存LRU节点 新来的在后面
 *
 *  Runtime: 38 ms, faster than 15.08% of Java online submissions for LRU Cache.
 *  Memory Usage: 58.4 MB, less than 5.23% of Java online submissions for LRU Cache.
 */
public class LRUCache {

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        int result = -1;
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));      // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));      // returns -1 (not found)
        System.out.println(cache.get(3));      // returns 3
        System.out.println(cache.get(4));      // returns 4
    }

    private int capacity;
    private HashMap<Integer,Node> map;
    private NodeLinkedList nodeLinkedList;
    public LRUCache(int capacity) {
        this.nodeLinkedList = new NodeLinkedList();
        this.capacity = capacity;
        this.map = new HashMap<Integer, Node>();
    }

    public int get(int key) {
        if(this.map.containsKey(key)){
            Node node = map.get(key);
            this.nodeLinkedList.moveNodeToTail(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(this.map.containsKey(key)){
            Node node = this.map.get(key);
            node.value = value;
            this.nodeLinkedList.moveNodeToTail(node);
        }else{
            if(this.map.size()>=capacity){
                Node node = this.nodeLinkedList.removeHead();
                this.map.remove(node.key);
            }
            Node node = new Node(key, value);
            this.nodeLinkedList.addNode(node);
            this.map.put(key,node);
        }
    }

    public class Node {
        public int key;
        public int value;
        public Node last;
        public Node next;
        public Node(){};
        public Node(int key, int value){
            this.key = key;
            this.value=value;
        }
    }

    public class NodeLinkedList {
        //LRU 链表 新来的在后面
        private Node head;
        private Node tail;
        public NodeLinkedList(){
            this.head = new Node();
            this.tail = new Node();
            this.head.next = tail;
            this.head.last = null;
            this.tail.last = head;
            this.tail.next = null;
        }
        public void addNode(Node newNode){
            Node orignLast = this.tail.last;
            orignLast.next = newNode;
            newNode.next = this.tail;
            newNode.last = orignLast;
            this.tail.last = newNode;
        }
        public void delNode(Node node){
            Node preNode = node.last;
            Node nextNode = node.next;
            preNode.next = nextNode;
            nextNode.last = preNode;
            node.last = null;
            node.next = null;
        }

        public void moveNodeToTail(Node node){
            delNode(node);
            addNode(node);
        }
        public Node removeHead(){
            Node node = this.head.next;
            delNode(node);
            return node;
        }
    }


}
