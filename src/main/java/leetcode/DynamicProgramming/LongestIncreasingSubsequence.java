package leetcode.DynamicProgramming;

/**
 *  https://leetcode.com/problems/longest-increasing-subsequence/
 *  300. Longest Increasing Subsequence
 *  Medium
 *
 *  最长递增子序列 本题只返回长度 较为简单
 *  代码面试指南 P210 最长递增子序列 默认情况下O(n2)复杂度  O(nlogn)需要用到二分查找
 *  dp[i] 表示以arr[i]结尾情况下的最长递增子序列的长度
 */
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        int result = lengthOfLIS(nums);//4   [2,3,7,101]
        System.out.println(result);
    }

    /**
     * Runtime: 19 ms, faster than 20.45% of Java online submissions for Longest Increasing Subsequence.
     * Memory Usage: 39.3 MB, less than 16.51% of Java online submissions for Longest Increasing Subsequence.
     */
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int maxLength = 0;
        for(int i=0; i<nums.length; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            maxLength = Math.max(maxLength,dp[i]);
        }

        return maxLength;
    }
}
