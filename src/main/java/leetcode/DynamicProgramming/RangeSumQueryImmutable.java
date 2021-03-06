package leetcode.DynamicProgramming;

/**
 *
 *  https://leetcode.com/problems/range-sum-query-immutable/description/
 *  303. Range Sum Query - Immutable 区域和检索 - 数组不可变
 *  Easy
 *
 *  给定一个整数数组  nums，求出数组从索引 i 到 j  (i ≤ j) 范围内元素的总和，包含 i,  j 两点。
 *  Given nums = [-2, 0, 3, -5, 2, -1]
 *  sumRange(0, 2) -> 1
 */
public class RangeSumQueryImmutable {

    class NumArray {

        private int[] sums;

        public NumArray(int[] nums) {
            sums = new int[nums.length + 1];
            if(nums.length>0){
                sums[0] = nums[0];
            }
            for (int i = 1; i <= nums.length; i++) {
                sums[i] = sums[i - 1] + nums[i - 1];
            }
        }

        public int sumRange(int i, int j) {
            return sums[j + 1] - sums[i];
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(nums);


    }
}
