package algorithm;

import main.pojo.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: javaStudy
 * @description:
 * @author: szm
 * @create: 2019-12-28 21:42
 **/
public class Leetcode103 {


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(9);
        TreeNode n2 = new TreeNode(20);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(7);
        TreeNode n5 = new TreeNode(3);

        root.left = n1;
        root.right = n2;
        n2.left = n3;
        n2.right = n4;

        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> l = null;
        if(root == null) res.forEach(h->{
            System.out.print("[");
            h.forEach(i->System.out.print(i + ","));
            System.out.println("]");
        });
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.addLast(root);
        int level = 1;
        while(!queue.isEmpty()){
            l = new LinkedList<>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = queue.removeFirst();
                if(level % 2 == 1) {
                    l.addLast(cur.val);
                } else {
                    l.addFirst(cur.val);
                }
                if(cur.left != null) queue.addLast(cur.left);
                if(cur.right != null) queue.addLast(cur.right);
            }
            res.add(l);
            level ++;
        }
        res.forEach(h->{
            System.out.print("[");
            h.forEach(i->System.out.print(i + ","));
            System.out.println("]");
        });

    }
}
