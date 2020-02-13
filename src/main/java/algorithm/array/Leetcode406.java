package algorithm.array;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: algorithm
 * @description: 根据身高重建队列
 * @author: szm
 * @create: 2020-02-12 11:02
 **/
public class Leetcode406 {

    @Test
    public void test() {
        System.out.println("----------start-----------");
        int[][] input = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};

        Arrays.asList(reconstructQueue(input)).stream().forEach(s->System.out.println(s.toString()));
    }


    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // if the heights are equal, compare k-values
                return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
            }
        });

        List<int[]> output = new LinkedList<>();
        for (int[] p : people) {
            output.add(p[1], p);
        }

        int n = people.length;
        return output.toArray(new int[n][2]);
    }
}

