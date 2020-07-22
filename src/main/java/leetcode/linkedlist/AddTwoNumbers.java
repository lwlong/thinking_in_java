package leetcode.linkedlist;

import java.util.Stack;

/**
 *  https://leetcode.com/problems/add-two-numbers/
 *  2. Add Two Numbers
 *
 *  //代码面试指南 P66 两个单链表生成相加链表
 *  Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 *  Output: 7 -> 0 -> 8
 *  Explanation: 342 + 465 = 807.
 */

public class AddTwoNumbers {
    public static void main(String[] args) {

//        Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)  342+465=807
//        Output: 7 -> 0 -> 8
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        ListNode result = AddTwoNumbers.addTwoNumbers(l1,l2);
        while(result!=null){
            System.out.println(result.val);
            result = result.next;
        }


    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Add Two Numbers.
     * Memory Usage: 40.2 MB, less than 6.37% of Java online submissions for Add Two Numbers.
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode result = null;
        ListNode next = null;
        int carryBit = 0;
        int num = 0;
        while(l1 != null || l2 != null || carryBit !=0){
            int num1 = 0;
            if(l1 != null){
                num1 = l1.val;
                l1 = l1.next;
            }
            int num2 = 0;
            if(l2 != null){
                num2 = l2.val;
                l2 = l2.next;
            }
            num = num1 + num2 + carryBit;
            carryBit = num >= 10 ? 1 : 0;
            num = num%10;
            ListNode tmp = new ListNode(num);
            if(result == null){
                result = tmp;
                next = tmp;
            }else{
                next.next = tmp;
                next = tmp;
            }

        }
        return result;
//        return new ListNode();
    }

}
