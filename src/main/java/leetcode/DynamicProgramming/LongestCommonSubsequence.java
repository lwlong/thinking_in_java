package leetcode.DynamicProgramming;

/**
 *  https://leetcode.com/problems/longest-common-subsequence/
 *  1143. Longest Common Subsequence
 *
 *  代码面试指南 P220 最长公共子序列问题
 *  注：子串就是需要连续，子序列不需要连续。
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde","ace"));//3  ace
        System.out.println(longestCommonSubsequence("abc","abc"));//3
        System.out.println(longestCommonSubsequence("abc","def"));//0
    }

    /**
     * Runtime: 14 ms, faster than 41.36% of Java online submissions for Longest Common Subsequence.
     * Memory Usage: 43.5 MB, less than 35.43% of Java online submissions for Longest Common Subsequence.
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        char[] chars1 = text1.toCharArray();
        char[] chars2 = text2.toCharArray();
        int[][] dp = new int[chars1.length][chars2.length];
        dp[0][0] = chars1[0] == chars2[0] ? 1 : 0;
        for(int i=1; i<chars1.length; i++){
            dp[i][0] = Math.max(dp[i-1][0], chars1[i] == chars2[0] ? 1 : 0);
        }
        for(int j=1; j<chars2.length; j++){
            dp[0][j] = Math.max(dp[0][j-1], chars1[0] == chars2[j] ? 1 : 0);
        }
        for(int i=1; i<chars1.length; i++){
            for(int j=1; j<chars2.length; j++){
                dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                if(chars1[i] == chars2[j]){
                    dp[i][j] = Math.max(dp[i][j], dp[i-1][j-1]+1);
                }
            }
        }
        return dp[chars1.length-1][chars2.length-1];
    }
}
