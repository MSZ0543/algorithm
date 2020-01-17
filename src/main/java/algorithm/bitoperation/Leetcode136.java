package algorithm.bitoperation;

/**
 * @program: algorithm
 * @description: 只出现一次的数字
 * @author: szm
 * @create: 2020-01-17 16:30
 **/
public class Leetcode136 {
    public int singleNumber(int[] nums) {
        // 通过
        int res = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            // 异或运算，位相同为1，不同为0，成对出现最后为1
            res ^= nums[i];
        }
        return res;
    }
}
