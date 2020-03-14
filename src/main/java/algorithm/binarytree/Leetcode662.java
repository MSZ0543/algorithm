package algorithm.binarytree;

import org.junit.jupiter.api.Test;
import pojo.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: algorithm
 * @description: 二叉树最大宽度
 * @author: szm
 * @create: 2020-03-14 09:52
 **/
public class Leetcode662 {

    @Test
    public void test() {
        System.out.println("----------start-----------");

        TreeNode root = new TreeNode(1);
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(5);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(9);
        TreeNode n6 = new TreeNode(9);

        root.left = n1;
        root.right = n2;
        n1.left = n3;
        n1.right = n4;
        n2.left = n5;
        n2.right = n6;

        System.out.println(widthOfBinaryTree(root));

    }


    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> list = new LinkedList<>();
        queue.offer(root);
        int res = 1;
        list.add(1);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                TreeNode now = queue.poll();
                int index = list.removeFirst();
                if (now.left != null) {
                    queue.offer(now.left);
                    list.add(index * 2);
                }
                if (now.right != null) {
                    queue.offer(now.right);
                    list.add(index * 2 + 1);
                }
            }
            if (list.size() > 1) {
                res = Math.max(res, list.getLast() - list.getFirst() + 1);
            }
        }
        return res;
    }
}
