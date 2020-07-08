package leetcode.array;

/**
 *  https://leetcode.com/problems/median-of-two-sorted-arrays/
 *  4. Median of Two Sorted Arrays  寻找两个正序数组的中位数 hard
 *
 *  nums1 = [1, 2]
 *  nums2 = [3, 4]
 *  则中位数是 (2 + 3)/2 = 2.5
 *
 *  二分查找 分治算法 如何在2个有序数组数组中查找Top K的值
 *  代码面试指南 P512
 *  https://www.cnblogs.com/voidsky/p/5373982.html
 */
public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {
        int[] num1 = new int[]{1,2};
        int[] num2 = new int[]{3,4};
        double result= findMedianSortedArrays(num1, num2);
        System.out.println(result);

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        if(n > m)   //保证数组1一定最短
            return findMedianSortedArrays(nums2,nums1);
        int L1 = 0;
        int L2 = 0;
        int R1 = 0;
        int R2 = 0;
        int c1 = 0;
        int c2 = 0;
        int lo = 0;
        int hi = 2*n;//我们目前是虚拟加了'#'所以数组1是2*n+1长度
        while(lo <= hi)   //二分
        {
            c1 = (lo+hi)/2;  //c1是二分的结果
            c2 = m+n- c1;
            L1 = (c1 == 0)?Integer.MIN_VALUE:nums1[(c1-1)/2];   //map to original element
            R1 = (c1 == 2*n)?Integer.MAX_VALUE:nums1[c1/2];
            L2 = (c2 == 0)?Integer.MIN_VALUE:nums2[(c2-1)/2];
            R2 = (c2 == 2*m)?Integer.MAX_VALUE:nums2[c2/2];

            if(L1 > R2){
                hi = c1-1;
            } else if(L2 > R1){
                lo = c1+1;
            } else{
                break;
            }
        }
        return (Math.max(L1,L2)+ Math.min(R1,R2))/2.0;
    }
}
