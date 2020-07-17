package leetcode.DynamicProgramming;

import java.util.Arrays;

/**
 *  https://leetcode.com/problems/longest-valid-parentheses/
 *  32. Longest Valid Parentheses
 *  Hard
 *
 *  代码面试指南 P290 括号字符串的最长有效长度
 *  dp[i] 指str[0-i]中必须以str[i]结尾的最长的有效括号长度
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        System.out.println(longestValidParentheses("(()"));//2    dp=[0, 0, 2]
        System.out.println(longestValidParentheses(")()())"));//4    dp=[0, 0, 2, 0, 4, 0]
        System.out.println(longestValidParentheses("(()())"));//6    dp=[0, 0, 2, 0, 4, 6]
    }

    /**
     * Runtime: 1 ms, faster than 100.00% of Java online submissions for Longest Valid Parentheses.
     * Memory Usage: 39.8 MB, less than 26.56% of Java online submissions for Longest Valid Parentheses.
     */
    public static int longestValidParentheses(String s) {
        if(s==null || s.equals("")){
            return 0;
        }
        char[] ss = s.toCharArray();
        int[] dp = new int[ss.length]; //dp[0]=0
        int pre = 0;
        int res = 0;
        for(int i=1; i<ss.length; i++){
            if(ss[i]==')'){  //ss[i]==( 肯定不存在以当前结尾的有效字符串
                pre = i-dp[i-1]-1;
                if(pre>=0 && ss[pre]=='('){
                    dp[i] = dp[i-1] + 2 +(pre > 0 ? dp[pre-1] : 0);
                }
            }
            res = Math.max(res, dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return res;
    }
}
