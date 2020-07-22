package leetcode.linkedlist;

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * 21. Merge Two Sorted Lists
 *
 *   剑指offer P114 面试题17 合并两个排序的链表
 */
public class MergeTwoSortedLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(3);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
        l2.next.next = new ListNode(4);


        //[-10,-10,-9,-4,1,6,6]
        //[-7]
//        ListNode l1 = new ListNode(-10);
//        l1.next = new ListNode(-10);
//        l1.next.next = new ListNode(-9);
//        l1.next.next.next = new ListNode(-4);
//        l1.next.next.next.next = new ListNode(1);
//
//        ListNode l2 = new ListNode(-7);


        ListNode cur = mergeTwoLists(l1,l2);
        int n = 0;
        while(cur!=null){
            System.out.print(cur.val+" ");
            cur = cur.next;
            n++;
            if(n>8) break;
        }

//        System.out.println();
//        while(l1!=null){
//            System.out.print(l1.val+" ");
//            l1 = l1.next;
//        }
//        System.out.println();
//        while(l2!=null){
//            System.out.print(l2.val+" ");
//            l2 = l2.next;
//        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        ListNode head = new ListNode();
//        ListNode cur = head;
//        while(l1!=null || l2!=null){
//            if(l1 == null){
//                cur.next = l2;
//                break;
//            }else if(l2 == null){
//                cur.next = l1;
//                break;
//            }else if(l1.val <= l2.val){
//                ListNode tmp = new ListNode(l1.val);
//                l1 = l1.next;
//                cur.next = tmp;
//                cur = tmp;
//            }else{
//                ListNode tmp = new ListNode(l2.val);
//                l2 = l2.next;
//                cur.next = tmp;
//                cur = tmp;
//            }
//        }
//        return head.next != null ? head.next : null;


        if(l1 == null && l2 == null) return null;
        if(l1 == null ) return l2;
        if(l2 == null) return l1;
        ListNode head = l1.val <= l2.val ? l1 : l2;
        ListNode cur1 = head;
        ListNode cur2 = head == l1 ? l2 : l1;
        ListNode pre = null;
        ListNode next = null;
        while(cur1!=null && cur2!=null){
            if(cur1.val <= cur2.val){
                pre = cur1;
                cur1 = cur1.next;
            }else{
                next = cur2.next;
                cur2.next = cur1;
                pre.next = cur2;
                pre = cur2;
                cur2 = next;
            }
        }
        pre.next = cur1 == null ? cur2 : cur1;
        return head;
    }
}
