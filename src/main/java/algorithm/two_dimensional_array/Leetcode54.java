package algorithm.two_dimensional_array;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: algorithm
 * @description: 螺旋矩阵
 * @author: szm
 * @create: 2020-02-06 10:53
 **/
public class Leetcode54 {

    public static void main(String[] args) {

        int[][] input = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        List<Integer> integers = spiralOrder(input);
        integers.forEach(i -> System.out.println(i + " "));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        int m = matrix.length;
        int n = matrix[0].length;
        if (matrix == null || m == 0) {
            return res;
        }
        int l = 0;
        int r = n - 1;
        int f = 0;
        int d = m - 1;
        while (l <= r && f <= d) {
            for (int j = l; j <= r; j++) res.add(matrix[f][j]);
            for (int k = f + 1; k <= d; k++) res.add(matrix[k][r]);
            if (l < r && f < d) {
                for (int o = r - 1; o > l; o--) res.add(matrix[d][o]);
                for (int t = d; t > f; t--) res.add(matrix[t][l]);
            }
            l++;
            r--;
            f++;
            d--;
        }
        return res;
    }
}
