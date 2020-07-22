package leetcode.linkedlist;

/**
 *  https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *  19. Remove Nth Node From End of List
 *
 *  剑指offer P107 面试题15 链表中倒数第k个节点
 */
public class RemoveNthNodeFromEndOfList {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node.next.next.next.next = new ListNode(5);
        ListNode cur = node;
        while(cur!=null){
            System.out.print(cur.val+" ");
            cur = cur.next;
        }
        cur = removeNthFromEnd(node,2);
        while(cur!=null){
            System.out.print(cur.val+" ");
            cur = cur.next;
        }

    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        int length = 0;
        ListNode cur = head;
        while(cur != null){
            length++;
            cur = cur.next;
        }
        System.out.println("length: "+length);
        if(n>length || n<=0){
            return head;
        }
        n = length-n;
        if(n == 0){
            return head.next;
        }
        if(n == 1){
            head.next = head.next.next;
            return head;
        }
        n--;
        ListNode pre = head;
        while(n > 0){
            pre = pre.next;
            n--;
        }
        pre.next = pre.next.next;
        return head;
    }
}
