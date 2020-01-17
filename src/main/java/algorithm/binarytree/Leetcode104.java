package algorithm.binarytree;

import org.junit.jupiter.api.Test;
import pojo.TreeNode;

/**
 * @program: algorithm
 * @description: 二叉树的最大深度
 * @author: szm
 * @create: 2020-01-17 15:53
 **/
public class Leetcode104 {

    @Test
    public void test() {
        System.out.println("----------start-----------");
        TreeNode root = new TreeNode(4);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(7);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(9);

        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;

        System.out.println(maxDepth(root));


    }

    public int maxDepth(TreeNode root) {
        // 通过
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
