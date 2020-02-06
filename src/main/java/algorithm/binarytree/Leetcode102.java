package algorithm.binarytree;

import pojo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: algorithm
 * @description: 二叉树层次遍历
 * @author: szm
 * @create: 2020-02-06 09:50
 **/

public class Leetcode102 {

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> l = null;
        if(root == null) return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int level = 1;
        while(!queue.isEmpty()){
            l = new LinkedList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.removeFirst();
                l.addLast(cur.val);
                if(cur.left != null) queue.addLast(cur.left);
                if(cur.right != null) queue.addLast(cur.right);
            }
            res.add(l);
        }
        return res;
    }
}
