package algorithm.bit_operation;

/**
 * @program: algorithm
 * @description: 位1的个数
 * @author: szm
 * @create: 2020-01-17 16:34
 **/
public class Leetcode191 {

    public int hammingWeight(int n) {
        // 通过
        // n &= n - 1 消除二进制
        int res = 0;
        while (n != 0) {
            n &= n - 1;
            res++;
        }
        return res;
    }

}
