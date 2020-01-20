package algorithm.dynamic_program;

import org.junit.jupiter.api.Test;

/**
 * @program: algorithm
 * @description: 打家劫舍
 *                 给定一个代表每个房屋存放金额的非负整数数组，计算你在不触动警报装置的情况下，能够偷窃到的最高金额。
 *                 如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * @author: szm
 * @create: 2020-01-19 11:29
 **/
public class Leetcode198 {

    @Test
    public void test() {
        System.out.println("----------start-----------");
        int[] input = {1,2,3,1};
        System.out.println(rob(input));
    }


    int rob(int[] nums) {
        int n = nums.length;
        // 用常量代替dp[]
        int dp_1 = 0, dp_2 = 0, dp_i = 0;
        for (int i = 0; i < n; i ++) {
            dp_i = Math.max(dp_1, nums[i] + dp_2);
            dp_2 = dp_1;
            dp_1 = dp_i;
        }
        return dp_i;
    }


    /*int rob(int[] nums) {
        int n = nums.length;
        // dp[i] = x 表示：
        // 从第 i 间房子开始抢劫，最多能抢到的钱为 x
        // base case: dp[n] = 0
        // n + 2 是为了 将 从第一天开始抢还是第二天开始抢两种情况都包含
        int[] dp = new int[n + 2];
        for (int i = 2; i < n + 2; i ++) {
            dp[i] = Math.max(dp[i - 1], nums[i - 2] + dp[i - 2]);
        }
        return dp[n + 1];
    }*/

    /*public int rob(int[] nums) {
        // 通过
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        int[] dp = new int[length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i = 2; i <= length; i ++) {
            // 第i个房子不偷，第i个房子偷
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }
        return dp[length];
    }*/

}
