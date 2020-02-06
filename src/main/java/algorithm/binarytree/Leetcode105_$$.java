package algorithm.binarytree;

import org.junit.jupiter.api.Test;
import pojo.TreeNode;

import java.util.HashMap;

/**
 * @program: algorithm
 * @description: 从前序与中序遍历序列构造二叉树
 * @author: szm
 * @create: 2020-02-06 09:15
 **/
public class Leetcode105_$$ {


    @Test
    public void test() {
        System.out.println("----------start-----------");
        int[] preorderInput = new int[]{3,9,20,15,7};
        int[] inorderInput = new int[]{9,3,15,20,7};
        TreeNode treeNode = buildTree(preorderInput, inorderInput);
        System.out.println(Leetcode102.levelOrder(treeNode));
    }

    private int[] preorder;
    private int[] inorder;
    HashMap<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        this.inorder = inorder;
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return helper(0, preorder.length, 0, inorder.length);
    }

    private TreeNode helper(int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft == preRight) {
            return null;
        }
        int nowVal = preorder[preLeft];
        TreeNode root = new TreeNode(nowVal);
        int inOrderIndex = map.get(nowVal);
        int inIndexToInLeft = inOrderIndex - inLeft;
        root.left = helper(preLeft + 1, preLeft + inIndexToInLeft + 1, inLeft, inOrderIndex);
        root.right = helper(preLeft + inIndexToInLeft + 1, preRight, inOrderIndex + 1, inRight);
        return root;
    }
}
