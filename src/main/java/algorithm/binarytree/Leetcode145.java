package algorithm.binarytree;

import pojo.TreeNode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @program: algorithm
 * @description: 二叉树的后序遍历
 * @author: szm
 * @create: 2020-03-14 16:35
 **/
public class Leetcode145 {


    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if(root == null) return res;
        helper(root, res);
        return res;
    }

    private void helper(TreeNode root, LinkedList res) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode now;
        while(!stack.isEmpty()) {
            now = stack.pop();
            res.addFirst(now.val);
            if(now.left != null) {
                stack.push(root.left);
            }
            if(now.right != null) {
                stack.push(root.right);
            }
        }
    }
}
