package leetcode.DynamicProgramming;

/**
 *  https://leetcode.com/problems/maximum-length-of-repeated-subarray/
 *  718. Maximum Length of Repeated Subarray
 *
 *  代码面试指南 P223 最长公共子串问题
 *  dp[i][j] 当以A的i和B的j为当作公共子串的最后一个字符情况下，公共子串最长能有多长
 *  如果A[i] != B[j] 那么 dp[i][j] = 0
 */
public class MaximumLengthOfRepeatedSubarray {

    public static void main(String[] args) {
        System.out.println(findLength(new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7}));//3    3,2,1
    }


    /**
     * Runtime: 42 ms, faster than 79.83% of Java online submissions for Maximum Length of Repeated Subarray.
     * Memory Usage: 48.5 MB, less than 56.16% of Java online submissions for Maximum Length of Repeated Subarray.
     */
    public static int findLength(int[] A, int[] B) {
        int result = 0;
        int[][] dp = new int[A.length][B.length];
        for(int i=0; i<A.length; i++){
            if(A[i] == B[0]){
                dp[i][0] = 1;
            }
        }
        for(int j=1; j<B.length; j++){
            if(A[0] == B[j]){
                dp[0][j] = 1;
            }
        }
        for(int i=1; i<A.length; i++){
            for(int j=1; j<B.length; j++){
                if(A[i] == B[j]){
                    dp[i][j] = dp[i-1][j-1]+1;
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }
}
