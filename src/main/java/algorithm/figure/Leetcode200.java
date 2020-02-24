package algorithm.figure;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

/**
 * @program: algorithm
 * @description: 岛屿的数量
 * @author: szm
 * @create: 2020-02-24 20:14
 **/
public class Leetcode200 {

    @Test
    public void test() {
        System.out.println("----------start-----------");
        char[][] input = new char[][]{
                {'1','1','1'},
                {'0','1','0'},
                {'1','1','1'}
        };
        System.out.println(numIslands(input));
    }

    int m = 0;
    int n = 0;
    public int numIslands(char[][] grid) {

        m = grid.length;
        if (m < 1) {
            return 0;
        }
        n = grid[0].length;
        // 搜索岛屿开头时记录已经遍历的格子个数
        int res = 0;
        for(int y = 0; y < m; y++) {
            for (int x = 0; x < n; x++) {
                // 从头找没走过的岛屿边界
               if(grid[y][x] == '1') {
                   bfs(y * n + x, grid);
                   res++;
               }
            }
        }
        return res;
    }

    private void bfs(Integer no, char[][] grid) {
        LinkedList<Integer> queue = new LinkedList<>();
        queue.addLast(no);
        while(!queue.isEmpty()) {
            Integer node = queue.removeFirst();
            int ny = node / n;
            int nx = node % n;
            if(grid[ny][nx] == '2') {
                continue;
            }
            grid[ny][nx] = '2';
            if(ny + 1 < m && grid[ny + 1][nx] == '1') {
                queue.addLast((ny + 1) * n + nx);
            }
            if(ny - 1 >= 0 && grid[ny - 1][nx] == '1') {
                queue.addLast((ny - 1) * n + nx);
            }
            if(nx + 1 < n && grid[ny][nx + 1] == '1') {
                queue.addLast(ny * n + nx + 1);
            }
            if(nx - 1 >= 0 && grid[ny][nx - 1] == '1') {
                queue.addLast(ny * n + nx - 1);
            }
        }
    }
}
