package algorithm.array;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: algorithm
 * @description: 子集 II
 * 给定一个可能包含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * @author: szm
 * @create: 2020-01-21 15:04
 **/
public class Leetcode90_$$ {

    @Test
    public void test() {
        System.out.println("----------start-----------");
        int[] input = {1, 2, 3, 4, 5, 6, 7, 8, 10, 0};
        List<List<Integer>> lists = subsetsWithDup(input);
        System.out.println(lists);
    }


    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 通过
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        // 排序，为剪枝去重坐准备
        Arrays.sort(nums);
        // 使用start将回溯遍历剪枝
        helper(nums, res, row, 0);
        return res;
    }

    private void helper(int[] nums, List<List<Integer>> res, List<Integer> row, int start) {

        res.add(new ArrayList<>(row));

        for (int i = start; i < nums.length; i++) {
            // 相同数字剪枝
            if (i > start && nums[i] == nums[i - 1]) continue;
            row.add(nums[i]);
            helper(nums, res, row, i + 1);
            row.remove(row.indexOf(nums[i]));
        }
    }
}
