package leetcode.array;

/**
 *  https://leetcode.com/problems/maximum-subarray/
 *  53. Maximum Subarray
 *  代码面试指南 数组和矩阵 P397
 *  Input: [-2,1,-3,4,-1,2,1,-5,4],
 *  Output: 6
 *  Explanation: [4,-1,2,1] has the largest sum = 6.
 */
public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        int result = maxSubArray(nums);
        System.out.println(result);
    }

    public static int maxSubArray(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int cur = 0;
        for(int i=0; i<nums.length; i++){
            cur += nums[i];
            max = Math.max(max, cur);
            cur = cur < 0 ? 0 : cur;
        }

        return max;
    }
}
