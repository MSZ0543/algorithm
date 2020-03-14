package algorithm.binarytree;

import org.junit.jupiter.api.Test;
import pojo.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static algorithm.binarytree.Leetcode102.levelOrder;

/**
 * @program: algorithm
 * @description: 二叉树的序列化与反序列化
 * @author: szm
 * @create: 2020-02-19 08:27
 **/
public class Leetcode297_$ {

    @Test
    public void test() {
        System.out.println("----------start-----------");
        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(2);
        TreeNode n2 = new TreeNode(4);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(6);
        TreeNode n6 = new TreeNode(9);

        root.left = n1;
        root.right = n2;

        n1.left = n3;
//        n1.right = n4;
//        n2.left = n5;
//        n2.right = n6;

        TreeNode treeNode = deserialize(serialize(root));;
        System.out.println(levelOrder(root));

    }


    // DFS(前序遍历)就完事了


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        ArrayList<String> list = new ArrayList<>();
        serializeHelper(root, list);
        return String.join(",", list);
    }

    private void serializeHelper(TreeNode root, ArrayList<String> str) {
        if(root == null) {
            str.add("null");
            return;
        }
        str.add(String.valueOf(root.val));
        serializeHelper(root.left, str);
        serializeHelper(root.right, str);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        List<String> nodes = new LinkedList<>(Arrays.asList(data.split(",")));
        return deserializeHelper(nodes);
    }

    public TreeNode deserializeHelper(List<String> l) {
        // Recursive deserialization.
        // 删除遍历过的，不需要维护索引比较保险
        // 不需要指定list size边界校验，肯定对得上
        String s = l.get(0);
        if (s.equals("null")) {
            l.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(s));
        l.remove(0);
        root.left = deserializeHelper(l);
        root.right = deserializeHelper(l);

        return root;
    }
}
