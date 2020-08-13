package leetcode.DynamicProgramming;

/**
 *  https://leetcode.com/problems/coin-change/
 *  322. Coin Change
 *  Medium
 *  给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。
 *
 *  代码面试指南 P189 换钱的最少货币数 dp[i][amount] i代表arr中的位置，最终结果dp[0][amount]
 */
public class CoinChange {

    public static void main(String[] args) {
        CoinChange c = new CoinChange();
        int[] coins = new int[]{1,2,5};
        int result = c.coinChange(coins,11);
        System.out.println(result);//3    11 = 5+5+1
    }

    /**
     * Runtime: 50 ms, faster than 10.63% of Java online submissions for Coin Change.
     * Memory Usage: 52 MB, less than 5.03% of Java online submissions for Coin Change.
     */
    public int coinChange(int[] coins, int amount) {

        if(coins==null || coins.length==0 || amount<0){
            return -1;
        }
        int[][] dp = new int[coins.length+1][amount+1];
        //设置最后一排的值，除dp[N][0]为0外，其他都是-1
        for(int j=1; j<=amount; j++){
            dp[coins.length][j] = -1;
        }

        for(int i=coins.length-1; i>=0; i--){//从低向上计算每一行
            for(int rest=0; rest<=amount; rest++){//每一行都是从左到右
                dp[i][rest] = -1;//初始先设置值无效

                if(dp[i+1][rest] != -1){ //下面的值如果有效，先设置成下面的值
                    dp[i][rest] = dp[i+1][rest];
                }

                //如果左边的位置不越界且有线
                if(rest-coins[i] >= 0 && dp[i][rest-coins[i]] != -1){
                    if(dp[i][rest] == -1){ //如果之前下面的值无效
                        dp[i][rest] = dp[i][rest-coins[i]] + 1;
                    }else{ //说明下面和左边的值都有效，取最小的
                        dp[i][rest] = Math.min(dp[i][rest], dp[i][rest-coins[i]]+1);
                    }
                }
            }
        }
        //print
        for(int i=0; i<=coins.length; i++){
            for(int rest=0; rest<=amount; rest++){//每一行都是从左到右
                System.out.print(dp[i][rest]+" ");
                if(dp[i][rest]>0){
                    System.out.print(" ");
                }

            }
            System.out.println();
        }
        return dp[0][amount];
    }
}
