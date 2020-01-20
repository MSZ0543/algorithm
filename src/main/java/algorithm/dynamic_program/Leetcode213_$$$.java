package algorithm.dynamic_program;

import org.junit.jupiter.api.Test;

/**
 * @program: algorithm
 * @description: 打家劫舍 II 房屋都围成一圈
 * @author: szm
 * @create: 2020-01-19 16:47
 **/
public class Leetcode213_$$$ {

    @Test
    public void test() {
        System.out.println("----------start-----------");
        int[] input = {1,2,3,1};
        System.out.println(rob(input));
    }

    int rob(int[] nums) {
        // 前置入参判断
        if(nums.length < 1) return 0;
        if(nums.length == 1) return nums[0];
        // 偷头不偷尾，偷尾不偷头，两者取最大
        return Math.max(robForRange(nums, 0, nums.length - 2),
                robForRange(nums, 1, nums.length - 1));
    }

    public int robForRange(int[] nums, int start, int end) {
        int n = nums.length;
        // 用常量代替dp[]
        int dp_1 = 0, dp_2 = 0, dp_i = 0;
        for (int i = start; i <= end; i ++) {
            dp_i = Math.max(dp_1, nums[i] + dp_2);
            dp_2 = dp_1;
            dp_1 = dp_i;
        }
        return dp_i;
    }

}
