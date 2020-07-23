package leetcode.linkedlist;

import java.util.Stack;

/**
 *  https://leetcode.com/problems/palindrome-linked-list/
 *  234. Palindrome Linked List
 *  Easy
 *
 *  代码面试指南 P55 判断一个链表是否为回文结构
 */
public class PalindromeLinkedList {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * Runtime: 4 ms, faster than 18.17% of Java online submissions for Palindrome Linked List.
     * Memory Usage: 46.2 MB, less than 5.03% of Java online submissions for Palindrome Linked List.
     *
     * 利用栈压入所有节点，然后在对比出栈元素和链表元素
     */
    public static boolean isPalindrome1(ListNode head) {
        Stack<ListNode> stack = new Stack<ListNode>();
        ListNode cur = head;
        while(cur != null){
            stack.push(cur);
            cur = cur.next;
        }
        while(head!= null){
            if(head.val != stack.pop().val){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * Runtime: 8 ms, faster than 9.46% of Java online submissions for Palindrome Linked List.
     * Memory Usage: 45.1 MB, less than 9.34% of Java online submissions for Palindrome Linked List.
     *
     * 首先计算链表长度，利用栈压入后一半节点，然后在对比出栈元素和链表元素
     */
    public static boolean isPalindrome2(ListNode head) {
        if(head==null || head.next==null){
            return true;
        }
        ListNode cur = head;
        ListNode right = head.next;//找到中间靠右的节点
        while(cur.next!=null && cur.next.next!=null){
            right = right.next;
            cur = cur.next.next;
        }

        Stack<ListNode> stack = new Stack<ListNode>();
        while(right != null){
            stack.push(right);
            right = right.next;
        }
        while(!stack.isEmpty()){
            if(head.val != stack.pop().val){
                return false;
            }
            head = head.next;
        }
        return true;
    }

    /**
     * 找到中间节点和最后节点，然后反转右半区，记录最后一个节点，从两边检查回文，然后在恢复链表
     */
    public static boolean isPalindrome3(ListNode head) {
        return true;
    }
}
