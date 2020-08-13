package leetcode.DynamicProgramming;

/**
 *  https://leetcode.com/problems/max-consecutive-ones/description/
 *  485. Max Consecutive Ones
 *  Easy
 *
 *  Input: [1,1,0,1,1,1]
 *  Output: 3
 *  代码面试指南 P397 子数组的最大累加和问题 技巧题
 */
public class MaxConsecutiveOnes {

    public static void main(String[] args) {

        int[] nums = {1,0,0,1,1,1,1,0,1,1};
        int result = findMaxConsecutiveOnes(nums);
        System.out.println(result);
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int cur = 0;
        int max = 0;
        for(int i=0;i<nums.length;i++){
            cur = nums[i] == 0 ? 0 : cur+1;
            max = Math.max(cur,max);
        }
        return max;
    }
}
