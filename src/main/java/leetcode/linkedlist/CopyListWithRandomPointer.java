package leetcode.linkedlist;

import java.util.HashMap;

/**
 *  https://leetcode.com/problems/copy-list-with-random-pointer/
 *  138. Copy List with Random Pointer
 *  Medium
 *
 *  代码面试指南 P63 复制含有随机指针节点的链表
 *  两种方法，一种使用HashMap记录
 *  一种使用链表记录 1 > 1` > 2 > 2` > 3 > 3` > null
 *
 */
public class CopyListWithRandomPointer {

    public static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static void main(String[] args) {

    }

    /**
     * Runtime: 1 ms, faster than 26.61% of Java online submissions for Copy List with Random Pointer.
     * Memory Usage: 42.8 MB, less than 5.10% of Java online submissions for Copy List with Random Pointer.
     * HashMap 方法
     */
    public static Node copyRandomList1(Node head) {
        HashMap<Node,Node> map = new HashMap<>();
        Node cur = head;
        while(cur != null){
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            map.get(cur).next = map.get(cur.next);
            map.get(cur).random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Copy List with Random Pointer.
     * Memory Usage: 39 MB, less than 66.97% of Java online submissions for Copy List with Random Pointer.
     * 进阶链表保存法
     */
    public static Node copyRandomList2(Node head) {
        if(head == null){
            return null;
        }

        Node cur = head;
        Node next = null;
        while(cur != null){ //复制并链接每一个节点
            next = cur.next;
            cur.next = new Node(cur.val);
            cur.next.next = next;
            cur = next;
        }
        cur = head;
        Node curCopy = null;
        while(cur != null){//设置复制节点的random指针
            next = cur.next.next;
            curCopy = cur.next;
            curCopy.random = cur.random !=null ? cur.random.next : null;
            cur = next;
        }
        Node res = head.next;
        cur = head;
        while(cur != null){//拆分
            next = cur.next.next;
            curCopy = cur.next;
            cur.next = next;
            curCopy.next = next!=null ? next.next : null;
            cur = next;
        }
        return res;
    }


}
