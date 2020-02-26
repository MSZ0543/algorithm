package algorithm.array;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @program: algorithm
 * @description: 和为K的子数组 你需要找到该数组中和为 k 的连续的子数组的个数。
 * @author: szm
 * @create: 2020-02-26 20:43
 **/
public class Leetcode560 {

    @Test
    public void test() {
        int[] input = new int[]{1,1,1};
        System.out.println(subarraySum(input, 2));
    }


    public int subarraySum(int[] nums, int k) {
        int length = nums.length;
        // 使用map记录结束index为 i-1 之前累加和sum和出现次数
        HashMap<Integer, Integer> map = new HashMap();
//        int[] dp = new int[length + 1];
        map.put(0, 1);
//        dp[0] = 0;
        int sum = 0;
        int res = 0;
        for(int i = 0; i < length; i ++){
            sum += nums[i];
            if(map.containsKey(sum - k)) {
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
