package leetcode.hash;

import java.util.HashMap;

/**
 *  https://leetcode.com/problems/lru-cache/
 *  146. LRU Cache
 *  代码面试指南 P465
 *  //https://blog.csdn.net/qq_41231926/article/details/86173740
 *
 *  Runtime: 30 ms, faster than 19.15% of Java online submissions for LRU Cache.
 *  Memory Usage: 57.8 MB, less than 13.55% of Java online submissions for LRU Cache.
 *
 *
 */
public class LRUCacheV1 {

//    LoadingCache<String, Integer> cache = CacheBuilder.newBuilder()
//            .maximumSize(10)  //最多存放10个数据
//            .expireAfterWrite(10, TimeUnit.SECONDS)   //缓存10s
//            .recordStats()  //开启记录状态数据功能
//            .build(new CacheLoader<String, Integer>() {
//                @Override
//                public Integer load(String s) throws Exception {
//                    return -1;
//                }
//            });

    public static void main(String[] args) {
        LRUCacheV1 cache = new LRUCacheV1(2);
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

    private HashMap<Integer,Node> keyNodeMap;
    private HashMap<Node,Integer> nodeKeyMap;
    private NodeLinkedList nodeList;
    private int capacity;
    public LRUCacheV1(int capacity) {
        this.keyNodeMap = new HashMap<Integer, Node>();
        this.nodeKeyMap = new HashMap<Node, Integer>();
        this.nodeList = new NodeLinkedList();
        this.capacity = capacity;
    }

    public int get(int key) {
        if(this.keyNodeMap.containsKey(key)){
            Node res = this.keyNodeMap.get(key);
            this.nodeList.moveNodeToTail(res);
            return res.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(this.keyNodeMap.containsKey(key)){
            Node node = this.keyNodeMap.get(key);
            node.value = value;
            this.nodeList.moveNodeToTail(node);
        }else{

            Node node = new Node(value);
            this.keyNodeMap.put(key,node);
            this.nodeKeyMap.put(node,key);
            this.nodeList.addNode(node);
            if(this.keyNodeMap.size() == capacity+1){
                this.removeMostUnuserCache();
            }
        }
    }

    private void removeMostUnuserCache(){
        Node removeNode = this.nodeList.removeHead();
        Integer removeKey = this.nodeKeyMap.get(removeNode);
        this.nodeKeyMap.remove(removeNode);
        this.keyNodeMap.remove(removeKey);
    }

    public class Node {
        public int value;
        public Node last;
        public Node next;
        public Node(){};
        public Node(int value){
            this.value=value;
        }
    }

    public class NodeLinkedList {
        //LRU 链表 新来的在后面
        private Node head;
        private Node tail;
        public NodeLinkedList(){
            this.head = null;
            this.tail = null;
        }
        public void addNode(Node newNode){
            if(newNode == null){
                return;
            }
            if(this.head==null){
                this.head = newNode;
                this.tail = newNode;
            }else{
                this.tail.next = newNode;
                newNode.last = this.tail;
                this.tail = newNode;
            }
        }

        public void moveNodeToTail(Node node){
            if(this.tail == node){
                return;
            }
            if(this.head == node){
                this.head = node.next;
                this.head.last = null;
            }else{
                node.last.next = node.next;
                node.next.last = node.last;
            }
            node.last = this.tail;
            node.next = null;
            this.tail.next = node;
            this.tail = node;
        }
        public Node removeHead(){
            if(this.head==null){
                return null;
            }
            Node res = head;
            if(this.head == this.tail){
                this.head = null;
                this.tail = null;
            }else{
                this.head = res.next;
                res.next = null;
                this.head.last = null;
            }
            return res;
        }
    }


}
