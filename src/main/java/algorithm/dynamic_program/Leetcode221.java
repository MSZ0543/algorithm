package algorithm.dynamic_program;

import org.junit.jupiter.api.Test;

/**
 * @program: algorithm
 * @description: 最大正方形
 * @author: szm
 * @create: 2020-03-09 09:42
 **/
public class Leetcode221 {

    @Test
    public void test() {
        System.out.println("----------start-----------");
        char[][] input =
                {
                        {'1', '0', '1', '0', '0'},
                        {'1', '0', '1', '1', '1'},
                        {'1', '1', '1', '1', '1'},
                        {'1', '0', '0', '1', '0'}
                };
        System.out.println(maximalSquare(input));
    }


    public int maximalSquare(char[][] matrix) {
        int rowNum = matrix.length;
        if (rowNum < 1) return 0;
        int colNum = matrix[0].length;
        int[][] dp = new int[rowNum][colNum];
        for (int i = 0; i < rowNum; i++) {
            dp[i][0] = matrix[i][0] - '0';
        }
        for (int i = 0; i < colNum; i++) {
            dp[0][i] = matrix[0][i] - '0';
        }
        int res = 0;
        for (int row = 1; row < rowNum; row++) {
            for (int col = 1; col < colNum; col++) {
                if (matrix[row - 1][col - 1] == '1') {
                    dp[row][col] = Math.min(Math.min(dp[row][col - 1],
                            dp[row - 1][col]), dp[row - 1][col - 1]) + 1;;
                    res = Math.max(res, dp[row][col]);
                }
            }
        }
        return res * res;
    }
}
