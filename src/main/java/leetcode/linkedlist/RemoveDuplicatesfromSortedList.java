package leetcode.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 *  https://leetcode.com/problems/remove-duplicates-from-sorted-list/
 *  83. Remove Duplicates from Sorted List
 */
public class RemoveDuplicatesfromSortedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(6);
//        ListNode head = new ListNode(1);
//        head.next = new ListNode(1);
//        head.next.next = new ListNode(1);
//        head.next.next.next = new ListNode(1);
//        head.next.next.next.next = new ListNode(1);
//        head.next.next.next.next.next = new ListNode(1);

        ListNode cur = head;
        while(cur!=null){
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        System.out.println();

        cur = deleteDuplicates(head);
        System.out.println(cur.val);
        int n = 0;
        while(cur!=null){
            System.out.print(cur.val+" ");
            cur = cur.next;
            n++;
            if(n>8) break;
        }

    }

    public static ListNode deleteDuplicates(ListNode head) {
        Set<Integer> list = new HashSet();
        ListNode cur = head;
        while(cur != null){
            if(!list.contains(cur.val)){
                list.add(cur.val);
            }
            if(cur.next!=null){
                if(list.contains(cur.next.val)){
                    cur.next = cur.next.next;
                    continue;
                }
            }
            cur = cur.next;
        }
        return head;
    }
}
