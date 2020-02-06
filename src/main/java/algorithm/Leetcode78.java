package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: javaStudy
 * @description:
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
        for(int i = 0; i < end; i ++) {
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j < nums.length; j ++) {
                if((((1<<j)&i) != 0)) {
                    row.add(nums[j]);
                }
            }
            res.add(row);
        }
        return res;
    }
}
