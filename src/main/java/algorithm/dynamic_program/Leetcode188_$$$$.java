package algorithm.dynamic_program;

import org.junit.jupiter.api.Test;

/**
 * @program: algorithm
 * @description: 买卖股票的最佳时机 IV 你最多可以完成 k 笔交易。
 * @author: szm
 * @create: 2020-02-22 11:22
 **/
public class Leetcode188_$$$$ {

    @Test
    public void test() {
        System.out.println("----------start-----------");
        int[] input = {2,4,1};
        System.out.println(maxProfit(2, input));
    }

    // 未通过
    public int maxProfit(int k, int[] prices) {
        int length = prices.length;

        if(length < 2) return 0;
        int dp[][][] = new int[length][k][2];
        for(int i = 0; i < length; i ++) {
            for(int j = 1; j < k; j ++) {
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j - 1][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j - 1][0] - prices[i]);
            }
        }
        int profit = Integer.MIN_VALUE;
        for(int j = 0; j < k ; j ++) {
            profit = Math.max(profit, dp[length - 1][j][0]);
        }
        return profit;
    }
}
