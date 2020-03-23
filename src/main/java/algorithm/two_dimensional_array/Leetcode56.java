package algorithm.two_dimensional_array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @program: algorithm
 * @description: 合并区间
 * @author: szm
 * @create: 2020-03-19 10:47
 **/
public class Leetcode56 {

    @Test
    public void test() {
        System.out.println("----------start-----------");
        int[][] board = {{1,3},{2,6},{8,10},{15,18}};
        int[][] merge = merge(board);
        for (int[] i:
             merge) {
            System.out.print("[");
            for (int j:
                 i) {
                System.out.print(j + ",");
            }
            System.out.println("]");
        }
    }


    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> res = new LinkedList<>();
        if (intervals == null || intervals.length == 0) {
            return res.toArray(new int[0][]);
        }

        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);

        for (int i = 0; i < intervals.length; i++) {
            if (res.isEmpty() || res.getLast()[1] < intervals[i][0]) {
                res.add(intervals[i]);
            } else {
                res.getLast()[1] = Math.max(res.getLast()[1], intervals[i][1]);
            }
        }

        //为什么放0，0长度？可以看下源码就知道了
        return res.toArray(new int[0][0]);
    }
}
