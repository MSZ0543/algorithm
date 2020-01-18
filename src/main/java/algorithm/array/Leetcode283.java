package algorithm.array;

/**
 * @program: algorithm
 * @description: 移动零
 * @author: szm
 * @create: 2020-01-18 09:53
 **/
public class Leetcode283 {

    public void moveZeroes(int[] nums) {
        // 通过
        int index = 0;
        // 先把不为0的元素挪到数组前面
        for (int i : nums) {
            if (i != 0) {
                nums[index++] = i;
            }
        }
        // 之后的置为0
        while (index < nums.length) {
            nums[index++] = 0;
        }
    }
}
