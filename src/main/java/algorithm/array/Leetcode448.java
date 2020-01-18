package algorithm.array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: algorithm
 * @description: 找到所有数组中消失的数字
 * @author: szm
 * @create: 2020-01-18 15:13
 **/
public class Leetcode448 {

    @Test
    public void test() {
        System.out.println("----------start-----------");

    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        // 通过 O(N) 但是不如 使用hashMap 快
        // 使用hash表遍历两边肯定能做，但是因为元素为 1-N 所以 nums[i] 排序后应该放的位置为 Math.abs(nums[i]) - 1
        List<Integer> res = new ArrayList<>();
        if (nums.length == 0) return res;
        for (int i = 0; i < nums.length; i++) {
            int rightIndex = (nums[i] > 0 ? nums[i] : -nums[i]) - 1;
            // 因为 1<= nums[i] <= N 将存在数的正确位置元素变成负数作为标示
            if (nums[rightIndex] > 0) {
                nums[rightIndex] *= -1;
            }
        }
        // 不为负数的即 i 不存在 开头是1
        for (int i = 1; i <= nums.length; i++) {
            if (nums[i - 1] > 0) {
                res.add(i);
            }
        }
        return res;
    }
}
