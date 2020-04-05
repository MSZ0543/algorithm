package algorithm.array;

/**
 * @program: algorithm
 * @description: 在排序数组中查找元素的第一个和最后一个位置
 * @author: szm
 * @create: 2020-04-05 19:15
 **/
public class Leetcode34 {

    int minIndex;
    int maxIndex;

    public int[] searchRange(int[] nums, int target) {
        int l = nums.length;
        this.minIndex = l - 1;
        this.maxIndex = 0;
        if (l < 1) {
            return new int[]{-1, -1};
        }
        if (findIndex(nums, 0, l - 1, target) != -1) {
            return new int[]{minIndex, maxIndex};
        }
        return new int[]{-1, -1};
    }

    private int findIndex(int[] nums, int l, int r, int target) {

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target == nums[mid]) {
                // 记录并且递归
                minIndex = Math.min(minIndex, mid);
                maxIndex = Math.max(maxIndex, mid);
                findIndex(nums, l, mid - 1, target);
                findIndex(nums, mid + 1, r, target);
                return mid;
            } else if (target > nums[mid]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
