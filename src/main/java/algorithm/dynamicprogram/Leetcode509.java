package algorithm.dynamicprogram;

import org.junit.jupiter.api.Test;

/**
 * @program: algorithm
 * @description: 斐波那契数
 * @author: szm
 * @create: 2020-01-17 16:18
 **/
public class Leetcode509 {

    @Test
    public void test() {
        System.out.println("----------start-----------");

    }

    public int fib(int N) {
        // 通过
        if (N == 0) return 0;
        if (N == 1) return 1;
        // 递归方式
//        return fib(N - 1) + fib(N - 2);
        // 非递归动态规划 == 爬楼梯
        int[] dp = new int[N];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i < N; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[N - 1];
    }
}
