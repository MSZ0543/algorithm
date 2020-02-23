package algorithm.greedy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @program: algorithm
 * @description: 任务调度器
 * @author: szm
 * @create: 2020-02-22 17:28
 **/
public class Leetcode627_$$$ {

    @Test
    public void test() {
//        System.out.println('----------start-----------');
        char[] input = new char[]{'A','A','A','A','A','A','B','C','D','E','F','G'};
        System.out.println(leastInterval(input, 2));
    }


    /**
     * 解题思路：
     * 1、将任务按类型分组，正好A-Z用一个int[26]保存任务类型个数
     * 2、对数组进行排序，优先排列个数（count）最大的任务，
     *      如题得到的时间至少为 retCount =（count-1）* (n+1) + 1 ==> A->X->X->A->X->X->A(X为其他任务或者待命)
     * 3、再排序下一个任务，如果下一个任务B个数和最大任务数一致，
     *      则retCount++ ==> A->B->X->A->B->X->A->B
     * 4、如果空位都插满之后还有任务，那就随便在这些间隔里面插入就可以，因为间隔长度肯定会大于n，在这种情况下就是任务的总数是最小所需时间
     *
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        int l = tasks.length;
        if(l < 2 || n < 1) return l;
        int[] map = new int[26];
        for(char c : tasks) {
            map[c - 'A'] ++;
        }
        Arrays.sort(map);
        int maxCount = map[25];
        int res = (maxCount - 1) * (n + 1) + 1;
        for(int i = 24; i >= 0 && map[i] == maxCount; i --) {
            res ++;
        }
        return Math.max(res, l);
    }
}
