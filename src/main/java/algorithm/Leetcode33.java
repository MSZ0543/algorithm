package algorithm;

/**
 * @program: javaStudy
 * @description:
 * @author: szm
 * @create: 2019-12-29 09:32
 **/
public class Leetcode33 {
    public static void main(String[] args) {
        int[] nums = {1,3};
        System.out.println(search(nums, 3));
    }

    public static int search(int[] nums, int target) {

        int l = 0, r = nums.length - 1, res = 0, mid = 0, num = 0;
        while (l <= r) {
            mid = l + (r - l) / 2;
            num = nums[mid];
            if ((nums[0] > nums[mid]) == (nums[0] > target)) {
                num = nums[mid];
            } else {
                num = nums[0] > target ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            if (target > num) {
                l = mid + 1;
            } else if (target < num) {
                r = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;


//        int lo = 0, hi = nums.length - 1;
//        while (lo <= hi) {
//            int mid = lo + (hi - lo) / 2;
//            int num = nums[mid];
//            //nums [ mid ] 和 target 在同一段
//            if ((nums[mid] < nums[0]) == (target < nums[0])) {
//                num = nums[mid];
//                //nums [ mid ] 和 target 不在同一段，同时还要考虑下变成 -inf 还是 inf。
//            } else {
//                num = target < nums[0] ? Integer.MIN_VALUE : Integer.MAX_VALUE;
//            }
//
//            if (num < target)
//                lo = mid + 1;
//            else if (num > target)
//                hi = mid - 1;
//            else
//                return mid;
//        }
//        return -1;
    }
}
