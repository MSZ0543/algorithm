package algorithm.array;

import cn.creditease.std.common.utils.utils.CommonUtil;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: algorithm
 * @description: 下一个排列
 * @author: szm
 * @create: 2020-01-20 17:55
 **/
public class Leetcode31_$$$$ {

    @Test
    public void test(){
        int[] input = {2,0,4,0,0,4,4,1,4};
        nextPermutation(input);
        System.out.println(CommonUtil.toJsonString(input));
    }


    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i + 1] <= nums[i]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    List<Integer> lastNums = new ArrayList<>();
    List<Integer> now = new ArrayList<>();

    /*public void nextPermutation(int[] nums) {
        // 未通过
        List<Integer> row = new ArrayList<>();
        int[] visited = new int[nums.length];
        int[] sortNums = nums.clone();
        Arrays.sort(sortNums);
        List<Integer> targetNums = Arrays.stream(nums).boxed().collect(Collectors.toList());
        helper(targetNums, sortNums, row, visited);
        if(now.size() == 0) {
            Arrays.sort(nums);
        } else {
            for(int i = 0; i < nums.length; i++) {
                nums[i] = now.get(i);
            }
        }
    }*/

    private void helper(List<Integer> targetNums, int[] sortNums, List<Integer> row, int[] visited) {


        if(row.size() == targetNums.size() && greater(row, targetNums)) {
            now.addAll(row);
        }
        for(int i = 0; i < sortNums.length; i++) {
            if(visited[i] == 1) {
                continue;
            }
            row.add(sortNums[i]);
            visited[i] = 1;
            helper(targetNums, sortNums, row, visited);
            if(row.size() == targetNums.size()) {
                lastNums.clear();
                lastNums.addAll(row);
            }
            row.remove(row.size() - 1);
            visited[i] = 0;
        }
    }

    private boolean greater(List<Integer> row, List<Integer> targetNums) {
        return Arrays.deepToString(row.toArray()).compareTo(Arrays.deepToString(targetNums.toArray())) > 0;
    }

}
