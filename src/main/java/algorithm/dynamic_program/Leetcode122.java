package algorithm.dynamic_program;

/**
 * @program: algorithm
 * @description: 买卖股票的最佳时机 II 多次买卖一支股票,再次购买前出售掉之前的股票
 * @author: szm
 * @create: 2020-01-18 10:23
 **/
public class Leetcode122 {

    public int maxProfit(int[] prices) {
        // 通过
        if(prices.length < 2) return 0;
        // 最大利润
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i ++) {
            // 如果买入赚钱就叠加到maxProfit中
            maxProfit = Math.max(maxProfit, maxProfit + (prices[i] - prices[i - 1]));
        }
        return maxProfit;
    }
}
