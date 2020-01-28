package algorithm.figure;

import org.junit.jupiter.api.Test;

/**
 * @program: algorithm
 * @description: 单词搜索
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母不允许被重复使用。
 * @author: szm
 * @create: 2020-01-22 15:40
 **/
public class Leetcode79 {

    @Test
    public void test() {
        System.out.println("----------start-----------");
        char[][] board = {
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(exist(board, "SEE"));
    }

    int indexOfWord = 0;

    public boolean exist(char[][] board, String word) {
        if (board.length == 0 && word.length() > 0) return false;
        int[][] visited = new int[board.length][board[0].length];
        int[] i = new int[]{0};
        int[] j = new int[]{0};
        helper(board, word, visited, i, j);
        return indexOfWord == word.length() - 1;
    }

    private boolean helper(char[][] board, String word, int[][] visited, int[] i, int[] j) {

        if (indexOfWord == word.length() - 1) return true;
        if (visited[i[0]][j[0]] == 1 || board[i[0]][j[0]] != word.charAt(indexOfWord)) {
            return false;
        }
        if (board[i[0]][j[0]] == word.charAt(indexOfWord)) {
            indexOfWord++;
        }
        visited[i[0]][j[0]] = 1;
        if (i[0] > 0) {
            i[0]--;
            if (!helper(board, word, visited, i, j)) {
                i[0]++;
            } else {
                return true;
            }
        }
        if (i[0] < board.length - 1) {
            i[0]++;
            if (!helper(board, word, visited, i, j)) {
                i[0]--;
            } else {
                return true;
            }
        }
        if (j[0] > 0) {
            j[0]--;
            if (!helper(board, word, visited, i, j)) {
                j[0]++;
            } else {
                return true;
            }
        }
        if (j[0] < board[0].length - 1) {
            j[0]++;
            if (!helper(board, word, visited, i, j)) {
                j[0]--;
            } else {
                return true;
            }
        }
        indexOfWord--;
        return false;
    }
}
