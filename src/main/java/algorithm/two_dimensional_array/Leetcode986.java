package algorithm.two_dimensional_array;

import java.util.ArrayList;

/**
 * @program: algorithm
 * @description: 区间列表的交集
 * @author: szm
 * @create: 2020-03-18 15:38
 **/
public class Leetcode986 {

    public int[][] intervalIntersection(int[][] A, int[][] B) {
        if(A.length == 0 || B.length == 0) {
            return new int[0][];
        }
        ArrayList<int[]> res = new ArrayList<>();
        int indexA = 0;
        int indexB = 0;
        while(indexA < A.length && indexB < B.length) {
            int start = Math.max(A[indexA][0], B[indexB][0]);
            int end = Math.min(A[indexA][1], B[indexB][1]);

            if(start <= end) {
                res.add(new int[]{start, end});
            }

            if(A[indexA][1] > B[indexB][1]) {
                indexB ++;
            } else {
                indexA ++;
            }
        }
        int[][] trueRes = res.toArray(new int[res.size()][2]);
        return trueRes;
    }
}
