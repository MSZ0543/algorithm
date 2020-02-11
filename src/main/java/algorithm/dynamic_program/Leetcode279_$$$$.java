package algorithm.dynamic_program;

import org.junit.jupiter.api.Test;

/**
 * @program: algorithm
 * @description: 完全平方数
 * @author: szm
 * @create: 2020-02-10 17:31
 **/
public class Leetcode279_$$$$ {


    @Test
    public void test() {
        System.out.println("----------start-----------");
        System.out.println(numSquares(13));
    }

    public int numSquares(int n) {
        // 不懂
        int[] dp = new int[n + 1]; // 默认初始化值都为0
        for (int i = 1; i <= n; i++) {
            dp[i] = i; // 最坏的情况就是每次+1
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1); // 动态转移方程
            }
        }
        return dp[n];
    }


    /*public int numSquares(int n) {
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i = 1; i * i <= n; i ++) {
            nums.add(i * i);
        }
        if(nums.contains(n)) return 1;
        return coinChange(nums.stream().mapToInt(Integer::valueOf).toArray(), n);
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
    }*/
}
