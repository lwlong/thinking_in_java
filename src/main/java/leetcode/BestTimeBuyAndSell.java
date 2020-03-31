package leetcode;

/**
 * Created by LWL on 2019/5/16.
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
