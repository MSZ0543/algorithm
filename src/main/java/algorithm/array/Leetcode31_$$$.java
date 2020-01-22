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
public class Leetcode31_$$$ {

    @Test
    public void test(){
        int[] input = {5, 1,1};
        nextPermutation(input);
        System.out.println(CommonUtil.toJsonString(input));
    }


    public void nextPermutation(int[] nums) {
        // 通过
        if(nums.length < 2) return;
        // 从数组末尾向前查找nums[index] < nums[index + 1]
        int length = nums.length;
        int index = length - 2;
        while(index >= 0 && nums[index] >= nums[index + 1]) {
            index --;
        }
        // 将nums[index] 和 右边子数组应存在位置交换
        if(index >= 0) {
            int rightIndex = length - 1;
            for(; nums[rightIndex] <= nums[index] && rightIndex >= 0; rightIndex --) ;
            swap(nums, index, rightIndex);
        }
        // 将index右边数字逆序
        int end = length - 1;
        index ++;
        while(index <= end) {
            swap(nums, index++, end--);
        }
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;

        //  ^ 交换存在局限性 当两个是相等时交换完必定有一个是0
        /*nums[a] ^= nums[b];
        nums[b] ^= nums[a];
        nums[a] ^= nums[b];*/
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
