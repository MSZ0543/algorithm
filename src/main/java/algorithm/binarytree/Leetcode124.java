package algorithm.binarytree;

import pojo.TreeNode;

/**
 * @program: algorithm
 * @description: 二叉树中的最大路径和
 * @author: szm
 * @create: 2020-03-01 21:34
 **/
public class Leetcode124 {


    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        // 增益最少是0
        int left = Math.max(helper(root.left), 0);
        int right = Math.max(helper(root.right), 0);
        // 以当前节点的祖先节点为根节点的路径
        int oldPath = root.val + Math.max(left, right);
        // 以当前节点为根节点的路径
        int newPath = root.val + left + right;
        // 新路径和res取最大
        res = Math.max(newPath, res);
        // 递归思路还是要返回以当前节点父节点为根节点路经长度
        return oldPath;
    }
}
