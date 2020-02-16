package algorithm.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: javaStudy
 * @description: 子集
 * 给定一组不含重复元素的整数数组 nums，返回该数组所有可能的子集（幂集）。
 * 说明：解集不能包含重复的子集。
 * @author: szm
 * @create: 2020-01-09 16:20
 **/
public class Leetcode78 {

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1, 2, 3}));
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int end = 1 << nums.length;
        for (int i = 0; i < end; i++) {
            List<Integer> row = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if ((((1 << j) & i) != 0)) {
                    row.add(nums[j]);
                }
            }
            res.add(row);
        }
        return res;
    }
}
