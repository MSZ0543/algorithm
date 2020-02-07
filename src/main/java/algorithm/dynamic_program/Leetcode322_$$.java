package algorithm.dynamic_program;

import org.junit.jupiter.api.Test;

/**
 * @program: algorithm
 * @description: 零钱兑换
 * @author: szm
 * @create: 2020-02-07 09:29
 **/
public class Leetcode322_$$ {

    @Test
    public void test() {
        System.out.println("----------start-----------");
        int[] input = {186,419,83,408};
        System.out.println(coinChange(input, 6249));
    }

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            dp[i] = -1;
        }
        dp[0] = 0;
        // 外层循环总金额也就是1到14，内层循环面值也就是 { 1, 2, 5, 7, 10 }
        for (int i = 1; i <= amount; i++) {// 循环各个金额,找到dp[i]最优解
            for (int j = 0; j < coins.length; j++) {// 递推条件
                if (i - coins[j] >= 0 && dp[i - coins[j]] != -1) {
                    if (dp[i] == -1 || dp[i] > dp[i - coins[j]] + 1) {
                        dp[i] = dp[i - coins[j]] + 1;
                    }
                }
            }
        }
        return dp[amount];
    }

    // 贪心不过
    /*private int res = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0) {
            return -1;
        }
        Arrays.sort(coins);
        helper(coins, amount, 0, coins.length - 1, 0);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    public void helper(int[] coins, int amount, int val, int index, int num) {
        if(val == amount) {
            res = Math.min(res, num);
            return;
        }
        if(index < 0) return;
        int newVal = val + coins[index];
        if(newVal > amount) {
            newVal -= coins[index];
            index --;
            num --;
        }
        helper(coins, amount,  newVal, index, num + 1);
    }*/
}
