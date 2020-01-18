package algorithm.binarytree;

import pojo.TreeNode;

/**
 * @program: algorithm
 * @description: 把二叉搜索树转换为累加树
 * @author: szm
 * @create: 2020-01-18 10:12
 **/
public class Leetcode538 {

    // 全局变量
    private Integer value = 0;

    public TreeNode convertBST(TreeNode root) {
        // 通过
        if (root == null) return root;
        helper(root);
        return root;
    }

    private void helper(TreeNode root) {
        // 后序遍历 + 叠加全局变量
        if (root == null) return;
        helper(root.right);
        root.val += value;
        value = root.val;
        helper(root.left);
    }

}
