package algorithm.array;

/**
 * @program: algorithm
 * @description: 除自身以外数组的乘积
 * @author: szm
 * @create: 2020-02-13 20:29
 **/
public class Leetcode238 {

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int l = 1;
        int r = 1;
        int[] res = new int[n];
        res[0] = 1;
        for(int i = 1; i < n; i ++) {
            res[i] = l * nums[i - 1];
            l = res[i];
        }
        for(int i = n - 2; i > -1; i --) {
            r = r * nums[i + 1];
            res[i] *= r;
        }
        return res;
    }
}
