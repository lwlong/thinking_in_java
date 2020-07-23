package leetcode.linkedlist;

import java.util.Stack;

/**
 *  https://leetcode.com/problems/add-two-numbers-ii/
 *  445. Add Two Numbers II
 *  Medium
 *
 *  代码面试指南 P66 两个单链表生成相加链表
 *  Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
 *  Output: 7 -> 8 -> 0 -> 7
 */
public class AddTwoNumbersII {
    public static void main(String[] args) {

    }
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * Runtime: 4 ms, faster than 57.32% of Java online submissions for Add Two Numbers II.
     * Memory Usage: 40.1 MB, less than 17.55% of Java online submissions for Add Two Numbers II.
     * 使用栈翻转链表
     */
    public  ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        while(l1 != null){
            s1.push(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            s2.push(l2.val);
            l2 = l2.next;
        }

        int ca = 0;
        int n1 = 0;
        int n2 = 0;
        int n = 0;
        ListNode node = null;
        ListNode pre = null;
        while(!s1.isEmpty() || !s2.isEmpty()){
            n1 = s1.isEmpty() ? 0 : s1.pop();
            n2 = s2.isEmpty() ? 0 : s2.pop();
            n = n1 + n2 + ca;
            pre = node;
            node = new ListNode(n%10);
            node.next = pre;
            ca = n/10;
        }
        if(ca==1){
            pre = node;
            node = new ListNode(1);
            node.next = pre;
        }
        return node;
    }

    /**
     * Runtime: 3 ms, faster than 81.55% of Java online submissions for Add Two Numbers II.
     * Memory Usage: 39.3 MB, less than 93.14% of Java online submissions for Add Two Numbers II.
     * 利用栈的逆序求解
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
       l1 = reverseList(l1);
       l2 = reverseList(l2);
       int ca = 0;
       int n1 = 0;
       int n2 = 0;
       int n = 0;
       ListNode c1 = l1;
       ListNode c2 = l2;
       ListNode node = null;
       ListNode pre = null;
       while(c1 != null || c2 != null){
           n1 = c1!=null ? c1.val : 0;
           n2 = c2!=null ? c2.val : 0;
           n = n1 + n2 + ca;
           pre = node;
           node = new ListNode(n%10);
           node.next = pre;
           ca = n/10;
           c1 = c1!=null ? c1.next : null;
           c2 = c2!=null ? c2.next : null;
       }
        if(ca==1){
            pre = node;
            node = new ListNode(1);
            node.next = pre;
        }
        reverseList(l1);
        reverseList(l2);

       return node;
    }

    public ListNode reverseList(ListNode head){
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
