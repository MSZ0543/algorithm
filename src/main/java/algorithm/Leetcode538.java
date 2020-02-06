package algorithm;

import main.pojo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: javaStudy
 * @description:
 * @author: szm
 * @create: 2020-01-14 17:43
 **/
public class Leetcode538 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(13);
//        TreeNode n3 = new TreeNode(15);
//        TreeNode n4 = new TreeNode(7);
//        TreeNode n5 = new TreeNode(3);

        root.left = n1;
        root.right = n2;
//        n2.left = n3;
//        n2.right = n4;
        convertBST(root);
        List<List<Integer>> lists = levelOrder(root);
        System.out.println(lists);
    }

    static int lastVal = 0;
    public static TreeNode convertBST(TreeNode root) {
        if(root == null) return null;
        helper(root);
        return root;
    }
    private static void helper(TreeNode root) {
        if(root == null) return;
        helper(root.right);
        root.val += lastVal;
        lastVal = root.val;
        helper(root.left);
    }

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
