package algorithm.binarytree;

import org.junit.jupiter.api.Test;
import pojo.TreeNode;

/**
 * @program: algorithm
 * @description: 二叉树展开为链表
 * @author: szm
 * @create: 2020-01-20 15:11
 **/
public class Leetcode114_$ {

    @Test
    public void test() {
        System.out.println("----------start-----------");
        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(9);

        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.right = n5;

        flatten(root);
        while (root != null) {
            System.out.println(root.val);
            root = root.right;
        }

    }


    public void flatten(TreeNode root) {
        // 通过
        /*将左子树插入到右子树的地方
          将原来的右子树接到左子树的最右边节点
          考虑新的右子树的根节点，一直重复上边的过程，直到新的右子树为 null
          */
        TreeNode p = root;
        while (p != null) {
            TreeNode leftRight = p.left;
            if(leftRight == null) {
                p = p.right;

            } else {
                TreeNode right = p.right;
                while (leftRight != null && leftRight.right != null) {
                    leftRight = leftRight.right;
                }
                leftRight.right = right;
                p.right = p.left;
                p.left = null;
                p = p.right;
            }
        }
    }
}
