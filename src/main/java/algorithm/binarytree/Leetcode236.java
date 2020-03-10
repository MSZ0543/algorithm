package algorithm.binarytree;

import pojo.TreeNode;

/**
 * @program: algorithm
 * @description: 二叉树的最近公共祖先
 * @author: szm
 * @create: 2020-03-10 09:59
 **/
public class Leetcode236 {

    private TreeNode ans;

    private int recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {
        if(currentNode == null){
            return 0;
        }

        int left = recurseTree(currentNode.left, p, q);
        int right = recurseTree(currentNode.right, p, q);
        int mid = currentNode.val == p.val || currentNode.val == q.val ? 1 : 0;

        if(mid + left + right >= 2){
            ans = currentNode;
        }
        return left + mid + right;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Traverse the tree
        recurseTree(root, p, q);
        return ans;
    }
}
