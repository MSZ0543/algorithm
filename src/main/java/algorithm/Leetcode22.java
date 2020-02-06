package algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: javaStudy
 * @description:
 * @author: szm
 * @create: 2020-01-09 17:10
 **/
public class Leetcode22 {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        helper(0, 0, n, "", res);
        return res;
    }
    // 二叉树选择性去左子树还是右子树
    public static void helper(int leftAmount, int rightAmount, int n , String s, List<String> res) {
        if(leftAmount == n && rightAmount == n) {
            res.add(s);
        }
        if(leftAmount < n) {
            helper(leftAmount + 1, rightAmount, n, s + "(", res);
        }
        if(leftAmount > rightAmount && rightAmount < n) {
            helper(leftAmount, rightAmount + 1, n, s + ")", res);
        }
    }
}
