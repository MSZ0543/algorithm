package algorithm.figure;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;

/**
 * @program: algorithm
 * @description: 课程表-图是否有拓扑序列  dfs还不会!!!
 * @author: szm
 * @create: 2020-02-22 09:41
 **/
public class Leetcode207_$$$$ {


    @Test
    public void test() {
        System.out.println("----------start-----------");
        int[][] input = {{1,0},{2,0}};
        System.out.println(canFinish(3, input));
    }


/*
* 算法流程：
统计课程安排图中每个节点的入度，生成 入度表 indegrees。
借助一个队列 queue，将所有入度为 00 的节点入队。
当 queue 非空时，依次将队首节点出队，在课程安排图中删除此节点 pre：
并不是真正从邻接表中删除此节点 pre，而是将此节点对应所有邻接节点 cur 的入度 -1−1，即 indegrees[cur] -= 1。
当入度 -1−1后邻接节点 cur 的入度为 00，说明 cur 所有的前驱节点已经被 “删除”，此时将 cur 入队。
在每次 pre 出队时，执行 numCourses--；
若整个课程安排图是有向无环图（即可以安排），则所有节点一定都入队并出队过，即完成拓扑排序。换个角度说，若课程安排图中存在环，一定有节点的入度始终不为 00。
因此，拓扑排序出队次数等于课程个数，返回 numCourses == 0 判断课程是否可以成功安排。
*/
    // bfs思路
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int length = prerequisites.length;
        if(length <2) return true;
        int[] rudu = new int[numCourses];
        for(int[] pre : prerequisites) {
            rudu[pre[0]] ++;
        }
        LinkedList<Integer> queue = new LinkedList<>();
        for(int i = 0; i < rudu.length; i++) {
            if(rudu[i] == 0) {
                queue.addLast(i);
            }
        }
        while(!queue.isEmpty()) {
            int nowNode = queue.removeFirst();
            numCourses --;
            for(int[] pre : prerequisites) {
                if(pre[1] == nowNode) {
                    if(-- rudu[pre[0]] == 0) {
                        queue.addLast(pre[0]);
                    }
                }
            }
        }
        return numCourses <= 0;
    }
}
