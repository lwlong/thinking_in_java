package leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 *  https://leetcode.com/problems/linked-list-cycle/
 *  141. Linked List Cycle
 *
 *  代码面试指南 P69 两个单链表相交的一系列问题
 *  判断是否链表是否有环
 *  https://www.cnblogs.com/yorkyang/p/10876604.html
 *
 */
public class LinkedListCycle {
    public static class ListNode {
        int val;
        ListNode next;
//        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = head;

        boolean result = hasCycle(head);
        System.out.println(result);

    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Linked List Cycle.
     * Memory Usage: 39.7 MB, less than 40.19% of Java online submissions for Linked List Cycle.
     * 快指针，慢指针如果相遇就是有环
     */
    public static boolean hasCycleV1(ListNode head) {
        if(head == null || head.next==null || head.next.next==null){
            return false;
        }
        ListNode n1 = head.next; //slow
        ListNode n2 = head.next.next; //fast
        while(n1 != n2){
            if(n2.next==null || n2.next.next==null){
                return false;
            }
            n2 = n2.next.next;
            n1 = n1.next;
        }
        return true;

    }

    /**
     * Runtime: 8 ms, faster than 5.24% of Java online submissions for Linked List Cycle.
     * Memory Usage: 43.2 MB, less than 5.02% of Java online submissions for Linked List Cycle.
     */
    public static boolean hasCycle(ListNode head) {
        Set<ListNode> list = new HashSet();
        int n = 0;
        int MAX_SIZE = 1000000;
        ListNode cur = head;
        while(cur != null && n<MAX_SIZE){
            if(list.contains(cur)){
                return true;
            }
            n++;
            list.add(cur);
            cur = cur.next;
        }
        if(cur == null){
            return false;
        }
        if(n>=MAX_SIZE){
            return true;
        }
        return false;
    }
}
