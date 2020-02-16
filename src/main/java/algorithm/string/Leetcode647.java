package algorithm.string;

/**
 * @program: javaStudy
 * @description: 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 * @author: szm
 * @create: 2020-01-09 18:23
 **/
public class Leetcode647 {

    public static void main(String[] args) {
        System.out.println(countSubstrings("aaa"));
    }

    public static int countSubstrings(String s) {
        int res = 0;
        for (int start = 0; start < s.length(); start++) {
            for (int end = start; end < s.length(); end++) {
                if (isHuiWen(s, start, end)) {
                    res++;
                }
            }
        }
        return res;
    }

    private static boolean isHuiWen(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
