package algorithm;

/**
 * @program: javaStudy
 * @description:
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
