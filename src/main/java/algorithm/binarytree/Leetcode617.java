package algorithm.binarytree;

import org.junit.jupiter.api.Test;
import pojo.TreeNode;


/**
 * @program: algorithm
 * @description: 合并二叉树
 * @author: szm
 * @create: 2020-01-17 15:12
 **/
public class Leetcode617 {
    @Test
    public void test() {
        System.out.println("----------start-----------");

    }

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // 通过
        if(t1 == null || t2 == null) {
            // 两者有空
            return t1 != null ? t1 : t2 != null ? t2 : null;
        }
        // 两只都不为空
        t1.val += t2.val;
        t1.left = mergeTrees(t1.left, t2.left);
        t1.right = mergeTrees(t1.right, t2.right);
        return t1;
    }
}
