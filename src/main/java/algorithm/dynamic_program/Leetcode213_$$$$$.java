package algorithm.dynamic_program;

/**
 * @program: algorithm
 * @description: 打家劫舍 II 房屋都围成一圈
 * @author: szm
 * @create: 2020-01-19 16:47
 **/
public class Leetcode213_$$$$$ {

    /*@Test
    public void test() {
        System.out.println("----------start-----------");
        int[] input = {1,2,1,1};
        System.out.println(rob(input));
    }

    public int rob(int[] nums) {
        // 通过
        int length = nums.length;
        if (length == 0) {
            return 0;
        }
        if(length == 1) {
            return nums[0];
        }

    }

    private int robForRange(int[] nums, int start, int end) {
        int[] dp = new int[nums.length + 2];
        for(int i = 2; i < length; i ++) {
            // 第i个房子不偷，第i个房子偷
            dp[i] = Math.max(dp[i-1], dp[i-2] + nums[i-1]);
        }
        return dp[length - 1];
    }*/
}
