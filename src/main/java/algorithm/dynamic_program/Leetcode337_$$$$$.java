package algorithm.dynamic_program;

import org.junit.jupiter.api.Test;
import pojo.TreeNode;

import javax.annotation.Resource;
import java.util.ArrayList;

/**
 * @program: algorithm
 * @description: 打家劫舍 III
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，
 * 我们称之为“根”。 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小
 * 偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果两个直接相连的房子在同一天晚上被打劫，
 * 房屋将自动报警。
 * 计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。
 * @author: szm
 * @create: 2020-01-19 14:44
 **/
public class Leetcode337_$$$$$ {

    @Resource
    private Leetcode198 leetcode198;



    @Test
    public void test() {
        System.out.println("----------start-----------");
        TreeNode root = new TreeNode(3);
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(1);
        TreeNode n4 = new TreeNode(3);
        TreeNode n5 = new TreeNode(1);
        TreeNode n6 = new TreeNode(3);
        TreeNode n7 = new TreeNode(-2);
        TreeNode n8 = new TreeNode(1);

        root.left = n1;
        root.right = n2;

        n1.right = n3;
        n2.right = n4;
        n3.left = n5;
//        n3.right = n7;
//        n4.right = n8;

        System.out.println(rob(root));


    }

    private boolean preOrder = false;

    public int rob(TreeNode root) {
        // 未通过
        ArrayList<Integer> list = new ArrayList<>();
        inOrderTraversal(root, list, root);
        return rob(list);
    }

    private void inOrderTraversal(TreeNode root, ArrayList<Integer> list, TreeNode rootRoot) {
        if (root == null) {
            return;
        }
        if (!preOrder) {
            inOrderTraversal(root.left, list, rootRoot);
            list.add(root.val);
            if(root == rootRoot) preOrder = true;
            inOrderTraversal(root.right, list, rootRoot);
        } else {
            list.add(root.val);
            inOrderTraversal(root.right, list, rootRoot);
            inOrderTraversal(root.right, list, rootRoot);
        }

    }

    private int rob(ArrayList<Integer> nums) {
        // 通过
        int length = nums.size();
        if (length == 0) {
            return 0;
        }
        int[] dp = new int[length + 1];
        dp[0] = 0;
        dp[1] = nums.get(0);
        for (int i = 2; i <= length; i++) {
            // 第i个房子不偷，第i个房子偷
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums.get(i - 1));
        }
        return dp[length];
    }
}
