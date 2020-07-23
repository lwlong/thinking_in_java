package leetcode.linkedlist;

/**
 *  https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 *  19. Remove Nth Node From End of List
 *  Medium
 *
 *  剑指offer P107 面试题15 链表中倒数第k个节点
 *  代码面试指南 P42 在单链表和双链表中删除倒数第k个节点
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
        System.out.println();
        cur = removeNthFromEnd1(node,2);
        while(cur!=null){
            System.out.print(cur.val+" ");
            cur = cur.next;
        }

    }

    /**
     * Runtime: 11 ms, faster than 5.20% of Java online submissions for Remove Nth Node From End of List.
     * Memory Usage: 39.8 MB, less than 5.07% of Java online submissions for Remove Nth Node From End of List.
     */
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

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Remove Nth Node From End of List.
     * Memory Usage: 39.6 MB, less than 5.07% of Java online submissions for Remove Nth Node From End of List.
     *
     * 链表长度为N，删除倒数第K个节点，倒数第K个节点的前一个节点就是第N-K个节点。
     * 在第一遍遍历后，K的值变为K-N。
     * 第二次遍历时，K的值不断加1，加到0就停止遍历，第二次遍历当然会听到第N-k个节点的位置。
     */
    public static ListNode removeNthFromEnd1(ListNode head, int n) {

        if(head==null || n<1){
            return head;
        }
        ListNode cur = head;
        while(cur != null){
            n--;
            cur = cur.next;
        }
        if(n==0){
            head = head.next;
        }
        if(n<0){
            cur = head;
            n++;
            while(n!=0){
                cur = cur.next;
                n++;
            }
            cur.next = cur.next.next;
        }
        return head;
    }
}
