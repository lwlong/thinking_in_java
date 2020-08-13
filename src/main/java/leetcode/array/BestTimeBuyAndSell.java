package leetcode.array;

/**
 * Created by LWL on 2019/5/16.
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * 121. Best Time to Buy and Sell Stock
 * Easy
 *
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 *
 */
public class BestTimeBuyAndSell {
    public static void main(String[] args) {
//        int[] prices= {7,1,5,3,6,4};
        int[] prices= {7,6,4,3,1};
        BestTimeBuyAndSell bestTimeBuyAndSell = new BestTimeBuyAndSell();
        int result = bestTimeBuyAndSell.bestTime(prices);
        System.out.println(result);
    }

    public int bestTime(int[] prices) {
        int result = 0;
        if(prices.length <= 1){
            return 0;
        }else if(prices.length == 2){
            return (prices[1]>prices[0])?(prices[1]-prices[0]):0;
        }else{
            int sellPrice = prices[prices.length-1];
            result = (prices[prices.length-1]>prices[prices.length-2])?(prices[prices.length-1]-prices[prices.length-2]):0;
            for(int i=prices.length-3; i>=0; i--){
                sellPrice = max(sellPrice, prices[i+1]);
                if(prices[i]<sellPrice){
                    result = max(result, sellPrice-prices[i]);
                }
            }
        }
        return result;
    }

    public int max (int m, int n){
        return m > n ? m : n;
    }
}
