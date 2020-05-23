package leetcode.linkedlist;

/**
 * https://leetcode.com/problems/reverse-linked-list/
 * 206. Reverse Linked List
 */
public class ReverseLinkedList {
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

        int n =0;
        ListNode cur =reverseList(head);
        while(cur!=null){
            System.out.print(cur.val+" ");
            cur = cur.next;
            n++;
            if(n>8) break;
        }
        System.out.println();
        n=0;
        while(head!=null){
            System.out.print(head.val+" ");
            head = head.next;
            n++;
            if(n>8) break;
        }

    }


    public static ListNode reverseList(ListNode head) {
//        if(head == null || head.next==null){
//            return head;
//        }
//        ListNode pre = null;
//        ListNode next = head.next;
//        while(next!=null){
//            head.next = pre;
//            pre = head;
//            head = next;
//            next = next.next;
//        }
//        head.next = pre;
//        return head;


        ListNode pre = null;
        ListNode next = null;
        while(head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

}
