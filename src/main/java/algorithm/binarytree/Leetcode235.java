package algorithm.binarytree;

import org.junit.jupiter.api.Test;
import pojo.TreeNode;

/**
 * @program: algorithm
 * @description: 二叉搜索树的最近公共祖先
 * @author: szm
 * @create: 2020-01-17 16:50
 **/
public class Leetcode235 {
    @Test
    public void test() {
        System.out.println("----------start-----------");
        TreeNode root = new TreeNode(6);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(8);
        TreeNode n3 = new TreeNode(0);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(7);
        TreeNode n6 = new TreeNode(9);
        TreeNode n7 = new TreeNode(3);
        TreeNode n8 = new TreeNode(5);

        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;
        n4.left = n7;
        n4.right = n8;

        System.out.println(lowestCommonAncestor(root, n3, n8).val);


    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 通过
        if (root == p || root == q) return root;
        if (root == null) return null;
        // 利用搜索书特性进行剪枝
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            return left != null && right != null ? root : left != null ? left : right != null ? right : null;
        }

//        if(root == p || root == q) return root;
//        if(root == null) return null;
//        TreeNode left = lowestCommonAncestor(root.left, p, q);
//        TreeNode right = lowestCommonAncestor(root.right, p, q);
//        return left != null && right != null ? root : left != null ? left : right != null ? right : null;
    }


}
