package algorithm.array;

import java.util.Arrays;

/**
 * @program: algorithm
 * @description: 多数元素
 * @author: szm
 * @create: 2020-01-17 18:10
 **/
public class Leetcode169 {

    public int majorityElement(int[] nums) {
        // 通过
        // 将数组排序，取中间位置元素即为多数元素
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
