package algorithm;

/**
 * @program: javaStudy
 * @description: 旋转图像
 * @author: szm
 * @create: 2020-01-11 17:38
 **/
public class Leetcode48 {

    public static void main(String[] args) {
        int[][] input = new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        rotate(input);
        printInput(input);
    }

    private static void printInput(int[][] input) {
        for (int i = 0; i < input.length; i++) {
            System.out.print("[");
            for (int j : input[i]) {
                System.out.print(j + ",");
            }
            System.out.println("]");
        }
    }

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < (n + 1) / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int tmp = matrix[i][j];
                printInput(matrix);
                System.out.println("one round start------------------");
                matrix[i][j] = matrix[n - j - 1][i];
                printInput(matrix);
                System.out.println("------------------");
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                printInput(matrix);
                System.out.println("------------------");
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                printInput(matrix);
                System.out.println("------------------");
                matrix[j][n - i - 1] = tmp;
                printInput(matrix);
                System.out.println("one round end ------------------");

            }
        }
    }
}
