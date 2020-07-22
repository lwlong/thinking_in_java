package leetcode.DynamicProgramming;

/**
 *  https://leetcode.com/problems/palindrome-partitioning-ii/
 *  132. Palindrome Partitioning II
 *  Hard
 *
 *  代码面试指南 P314 回文串最少分割数 dp
 *  dp[i]的含义是子串str[i...len-1]至少切割几次，才能把str[i...len-1]全部切成回文子串，dp[0]就是最后结果
 *  定义二位数组 boolean[][]p，如果p[i][j]值为true，说明字符串str[i...j]是回文串，否则不是
 */
public class PalindromePartitioningII {

    public static void main(String[] args) {
        System.out.println(minCut("aab"));//1   aa,b
        System.out.println(minCut("aba"));//0   aba
        System.out.println(minCut("acdcdcdad"));//2   a,cdcdc,dad
    }

    /**
     * Runtime: 15 ms, faster than 57.82% of Java online submissions for Palindrome Partitioning II.
     * Memory Usage: 41.3 MB, less than 28.01% of Java online submissions for Palindrome Partitioning II.
     */
    public static int minCut(String s) {
        System.out.print(s+ "    ");
        if(s==null ||s.equals("")){
            return 0;
        }
        char[] ss = s.toCharArray();
        int len = ss.length;
        int[] dp = new int[len+1];
        dp[len] = -1;
        boolean[][] p = new boolean[len][len];
        for(int i=len-1; i>=0; i--){
            dp[i] = Integer.MAX_VALUE;
            for(int j=i; j<len; j++){
                if( ss[i]==ss[j] && (j-i<2 || p[i+1][j-1]) ){
                   p[i][j] = true;
                   dp[i] = Math.min(dp[i], dp[j+1]+1);
                }
            }
        }

        return dp[0];
    }

}
