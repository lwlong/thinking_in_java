package leetcode.linkedlist;

/**
 *  https://leetcode.com/problems/partition-list/
 *  86. Partition List 分隔链表
 *  Medium
 *
 *  Input: head = 1->4->3->2->5->2, x = 3
 *  Output: 1->2->2->4->3->5
 *
 *  代码面试指南 P59 将单向链表按某值划分成左边小，中间相等，右边大的形式
 *  1.遍历一遍存储到一个数组中，然后利用类似快排的原理调整，然后再重新组合成链表
 *  2.直接创建三个链表，分别存储small，equal，big，然后再组合到一起
 *
 *  这里使用第二种，且更简单，只需要分两个链表，注意为了在前后的链表中依然保存先后顺序
 *
 */
public class PartitionList {
    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static void main(String[] args) {

    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Partition List.
     * Memory Usage: 39 MB, less than 72.75% of Java online submissions for Partition List.
     */
    public ListNode partition(ListNode head, int x) {
        ListNode sH = null; //小的头
        ListNode sT = null; //小的尾
        ListNode bH = null;
        ListNode bT = null;
        ListNode next = null;

        //所有的节点分进三个链表
        while(head != null){
            next = head.next;
            head.next = null;
            if(head.val < x){
                if(sH == null){
                    sH = head;
                    sT = head;
                }else{
                    sT.next = head;
                    sT = head;
                }
            } else{
                if(bH == null){
                    bH = head;
                    bT = head;
                }else{
                    bT.next = head;
                    bT = head;
                }

            }
            head = next;
        }
        //小的和大的重新链接
        if(sT != null){
            sT.next = bH;
        }
        return sH!=null ? sH : bH;
    }

    public ListNode partition3(ListNode head, int x) {
        ListNode sH = null; //小的头
        ListNode sT = null; //小的尾
        ListNode eH = null; //相等的头
        ListNode eT = null; //相等的尾
        ListNode bH = null;
        ListNode bT = null;
        ListNode next = null;

        //所有的节点分进三个链表
        while(head != null){
            next = head.next;
            head.next = null;
            if(head.val < x){
                if(sH == null){
                    sH = head;
                    sT = head;
                }else{
                    sT.next = head;
                    sT = head;
                }

            } else if(head.val == x){
                if(eH == null){
                    eH = head;
                    eT = head;
                }else{
                    eT.next = head;
                    eT = head;
                }

            } else{
                if(bH == null){
                    bH = head;
                    bT = head;
                }else{
                    bT.next = head;
                    bT = head;
                }

            }
            head = next;
        }
        //小的和相等的重新链接
        if(sT != null){
            sT.next = eH;
            eT = eT==null ? sT : eT;
        }

        //所有的重新连接
        if(eT != null){
            eT.next = bH;
        }

        if(sH != null){
            return sH;
        }else{
            if(eH != null){
                return eH;
            }else{
                return bH;
            }
        }
//        return sH!=null ? sH : eH!=null ? eH : bH;
    }
}
