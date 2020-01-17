package algorithm.binarytree;

import org.junit.jupiter.api.Test;
import pojo.TreeNode;

/**
 * @program: algorithm
 * @description: 翻转二叉树
 * @author: szm
 * @create: 2020-01-17 15:30
 **/
public class Leetcode226 {

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

        TreeNode treeNode = invertTree(root);


    }

    public TreeNode invertTree(TreeNode root) {
        // 通过
        if(root == null) return null;
        helper(root);
        return root;
    }

    private void helper(TreeNode root) {
        if(root == null) return;
        // 后序遍历
        helper(root.left);
        helper(root.right);
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
    }
}
