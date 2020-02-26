package algorithm.dynamic_program;

import org.junit.jupiter.api.Test;

/**
 * @program: algorithm
 * @description: 分割等和子集(0 - 1背包问题)
 * @author: szm
 * @create: 2020-02-25 14:33
 **/
public class Leetcode416_$$$$ {

    @Test
    public void test() {
        System.out.println("----------start-----------");
        int[] input = {1, 5, 11, 5};
        System.out.println(canPartition(input));
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 == 1) {
            return false;
        }

        int target = sum / 2;
        int len = nums.length;

        boolean dp[][] = new boolean[len][target + 1];

        if (nums[0] <= target) {
            dp[0][nums[0]] = true;
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                if (nums[i] == j) {
                    dp[i][j] = true;
                    continue;
                }
                if (nums[i] < j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[len - 1][target];
    }

    /*
    * public boolean canPartition(int[] nums) {
        //转化为经典的01背包问题
        int sum = 0;
        for (int i : nums) {
            sum += i;
        }
        if (sum % 2 == 1)
            return false;
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        //建立dp数组，dp[i]表示能否找到和为i的数组元素集合
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                if (dp[i - num] == true)
                    dp[i] = true;
            }
        }
            return dp[target];
    }*/

}
