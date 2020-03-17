package algorithm.dynamic_program;

import org.junit.jupiter.api.Test;

/**
 * @program: algorithm
 * @description: 最长回文子串
 * @author: szm
 * @create: 2020-03-16 18:17
 **/
public class Leetcode5 {

    @Test
    public void test() {
        System.out.println("----------start-----------");
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }


    public String longestPalindrome(String s) {
        int n = s.length();
        String res = "";
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                //j - i 代表长度减去 1
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1]);
                if (dp[i][j] && j - i + 1 > res.length()) {
                    res = s.substring(i, j + 1);
                }
            }
        }
        return res;
    }

//    public String longestPalindrome(String s) {
        // if(s.length() < 2){return s;}
        // char[] sc = s.toCharArray();
        // int length = sc.length;
        // String res = s.substring(0,1);
        // boolean[][] dp = new boolean[length][length];
        // for (int r = 1; r < length; r++) {
        //     for (int l = 0; l < r; l++) {
        //         if(sc[l] == sc[r] && (r-1<=l+1 || dp[l+1][r-1])){
        //            dp[l][r] = true;
        //            if(r-l+1>res.length()){
        //             res = s.substring(l, r+1);
        //             }
        //         } else {
        //             dp[l][r] = false;
        //         }
        //     }
        // }
        // return res;
//    }
}
