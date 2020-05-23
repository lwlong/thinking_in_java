package leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

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
