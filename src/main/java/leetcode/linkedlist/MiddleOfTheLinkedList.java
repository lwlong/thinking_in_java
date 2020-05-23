package leetcode.linkedlist;

/**
 * https://leetcode.com/problems/middle-of-the-linked-list/
 * 876. Middle of the Linked List
 */
public class MiddleOfTheLinkedList {
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
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
//        head.next.next.next.next.next = new ListNode(6);

        ListNode cur = middleNode(head);
        System.out.println(cur.val);
        int n = 0;
        while(cur!=null){
            System.out.print(cur.val+" ");
            cur = cur.next;
            n++;
            if(n>8) break;
        }
    }

    public static ListNode middleNode(ListNode head) {
        ListNode pre = head;
        ListNode next = head;
        while(next!=null && next.next != null){
            pre = pre.next;
            next = next.next.next;
        }
        return pre;
    }
}
