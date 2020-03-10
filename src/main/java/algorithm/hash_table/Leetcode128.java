package algorithm.hash_table;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: algorithm
 * @description: 最长连续序列
 * @author: szm
 * @create: 2020-03-04 19:53
 **/
public class Leetcode128 {

    @Test
    public void test() {
        System.out.println("----------start-----------");
        int[] input = {0, -1};
        int i = longestConsecutive(input);
        System.out.println(i);
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        int res = 1;
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            set.add(i);
        }
        for (int i : nums) {
            // 确定自己是一段中最小的
            if (!set.contains(i - 1)) {
                int sum = 0;
                int now = i;
                for (; ; ) {
                    // 从set中找寻下一个
                    if (set.contains(now)) {
                        sum++;
                        now++;
                    } else {
                        // 选最大值
                        res = Math.max(res, sum);
                        break;
                    }
                }
            }
        }
        return res;
    }
}
