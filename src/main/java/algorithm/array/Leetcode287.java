package algorithm.array;

/**
 * @program: javaStudy
 * @description: 寻找重复数
 * @author: szm
 * @create: 2020-01-08 18:47
 **/
public class Leetcode287 {

    public static void main(String[] args) {
        int[] input = new int[]{1, 3, 4, 2, 2};
        System.out.println(findDuplicate(input));
    }

    public static int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 1;
        while (nums[slow] != nums[fast]) {
            slow++;
            fast = nums[fast];
        }
        return nums[fast];
    }
}
//1,3,4,2,2