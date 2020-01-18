package algorithm.binarytree;

import org.junit.jupiter.api.Test;
import pojo.TreeNode;

/**
 * @program: algorithm
 * @description: 路径总和 III
 *               找出路径和等于给定数值的路径总数.
 *               路径不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 * @author: szm
 * @create: 2020-01-18 15:44
 **/
public class Leetcode437_$$$ {

    @Test
    public void test() {
        System.out.println("----------start-----------");
        TreeNode root = new TreeNode(10);
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(-3);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(11);
        TreeNode n6 = new TreeNode(3);
        TreeNode n7 = new TreeNode(-2);
        TreeNode n8 = new TreeNode(1);

        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.right = n8;

        System.out.println(pathSum(root, 10));


    }


    public int pathSum(TreeNode root, int sum) {
        if(root == null) return 0;
        int[] path = new int[1000];
        return helper(root, sum, path, 0);
    }

    private int helper(TreeNode root, int sum, int[] path, int endIndex) {
        // 通过but不熟悉
        if(root == null) return 0;
        // 先看本节点的情况 如果 root.val == sum 本身就是一条满足条件的路径
        int n = root.val == sum ? 1 : 0;
        // 避免root.val == sum情况被重复满足条件
        int tmp = root.val;
        for(int i = endIndex - 1; i >= 0; i --) {
            // 再看从根节点到本节点路径的情况，从后向前遍历path，如果和为sum，则以本节点结束的路径上满足条件路径数 + 1
            tmp += path[i];
            if(tmp == sum) {
                n ++;
            }
        }
        // 将本节点放入path
        path[endIndex] = root.val;
        // 返回 本节点条数 + 孩子节点条数
        return n + helper(root.left, sum, path, endIndex + 1) + helper(root.right, sum, path, endIndex + 1);
    }

}
