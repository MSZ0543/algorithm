package algorithm.array;

import org.junit.jupiter.api.Test;

/**
 * @program: algorithm
 * @description: 颜色分类-荷兰国旗问题
 * @author: szm
 * @create: 2020-02-17 16:08
 **/
public class Leetcode75 {

    @Test
    public void test() {
        System.out.println("----------start-----------");
        int[] input = {1,2,0};
        sortColors(input);
        for (int i : input) {
            System.out.println(i);
        }
    }


    public void sortColors(int[] nums) {
        int index0 = 0;
        int index2 = nums.length - 1;
        int curIndex = 0;
        while (curIndex <= index2) {
            if (nums[curIndex] == 0) {
                swap(nums, index0++, curIndex++);
            } else if (nums[curIndex] == 2) {
                swap(nums, index2--, curIndex);
            } else {
                curIndex++;
            }
        }
    }

    private void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }
}
