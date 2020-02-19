package algorithm.array;

/**
 * @program: algorithm
 * @description: 盛最多水的容器
 * @author: szm
 * @create: 2020-02-17 15:32
 **/
public class Leetcode11 {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int res = Integer.MIN_VALUE;
        // 指针向较长边方向靠拢
        while (l < r) {
            res = Math.max(res, (r - l) * Math.min(height[l], height[r]));
            if (height[r] > height[l]) {
                l++;
            } else {
                r--;
            }
        }
        return res;
    }
}
