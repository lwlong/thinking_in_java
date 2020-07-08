package leetcode.DynamicProgramming;

/**
 *  https://leetcode.com/problems/unique-paths/
 *  62. Unique Paths
 *  一个机器人位于一个 m x n 网格的左上角
 *  机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *  问总共有多少条不同的路径？
 *  代码面试指南 P192 类似 机器人达到指定位置方法数 无后效性 经典题型 二维表dp
 *
 *  m=3，n=2
 *  1 1
 *  1 2
 *  1 3
 */
public class UniquePaths {
    public static void main(String[] args) {
        UniquePaths u = new UniquePaths();
//        int result = u.uniquePaths(3,2);//3
        int result = u.uniquePaths(7,3);//28
        System.out.println(result);
    }

    /**
     * Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Paths.
     * Memory Usage: 38 MB, less than 12.57% of Java online submissions for Unique Paths.
     */
    public int uniquePaths(int m, int n) {
        if(m<1 || n<1){
            return -1;
        }
        if(m>n){
            return uniquePaths(n,m);
        }
        int[]dp = new int[m];//申请最小的辅助数组 less
        dp[0] = 1;
        for(int j=0 ; j<m; j++){//less
            dp[j] = 1;
        }
        for(int i=1; i<n; i++){//more
            for(int j=1; j<m; j++){//less
                dp[j] = dp[j-1] + dp[j];
            }
        }
        return dp[m-1];

    }

    /**
     * Runtime: 1 ms, faster than 21.61% of Java online submissions for Unique Paths.
     * Memory Usage: 38 MB, less than 12.81% of Java online submissions for Unique Paths.
     */
    public int uniquePaths1(int m, int n) {
        if(m<1 || n<1){
            return -1;
        }
        int[][]dp = new int[m][n];
        dp[0][0] = 1;
        for(int i=0 ; i<m; i++){
            dp[i][0] = 1;
        }
        for(int j=0; j<n; j++){
            dp[0][j] = 1;
        }
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];

    }
}
