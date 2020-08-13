package leetcode.DynamicProgramming;

/**
 *  https://leetcode.com/problems/minimum-path-sum/
 *  64. Minimum Path Sum
 *  Medium
 *
 *  动态规划 代码面试指南 P185 矩阵的最小路径和 两种方法 额外空间复杂度O(M*N) 压缩空间法
 */
public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        int result = minPathSum1(grid);
        System.out.println(result);

    }

    /**
     *  Runtime: 2 ms, faster than 88.23% of Java online submissions for Minimum Path Sum.
     *  Memory Usage: 42.6 MB, less than 23.78% of Java online submissions for Minimum Path Sum.
     */
    public static int minPathSum(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0]==null || grid[0].length==0){
            return -1;
        }
        int more = Math.max(grid.length, grid[0].length);
        int less = Math.min(grid.length, grid[0].length);
        boolean rowmore = more==grid.length; //行数是不是大的那个值

        int[] dp = new int[less]; //申请最小的辅助数组
        dp[0] = grid[0][0];
        for(int i=1; i<less; i++){ //先算出第一行或第一列
            dp[i] = dp[i-1] + (rowmore ? grid[0][i] : grid[i][0]);
        }
        for(int i=1; i<more; i++){ //循环更新more
            dp[0] = dp[0] + (rowmore ? grid[i][0] : grid[0][i]); //先更新dp[0]
            for(int j=1; j<less; j++){
                dp[j] = Math.min(dp[j-1], dp[j]) + (rowmore ? grid[i][j] : grid[j][i]);
            }

        }
        return dp[less-1];
    }

    /**
     *  Runtime: 2 ms, faster than 88.23% of Java online submissions for Minimum Path Sum.
     *  Memory Usage: 42.1 MB, less than 67.97% of Java online submissions for Minimum Path Sum.
     */
    public static int minPathSum1(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0]==null || grid[0].length==0){
            return -1;
        }
        int row = grid.length;
        int col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        //先生成第一列
        for(int i=1; i<row; i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        //先生成第一行
        for(int j=1; j<col; j++){
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        for(int i=1; i<row; i++){
            for(int j=1; j<col; j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[row-1][col-1];
    }
}
