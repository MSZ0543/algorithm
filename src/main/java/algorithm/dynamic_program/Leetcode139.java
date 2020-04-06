package algorithm.dynamic_program;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * @program: algorithm
 * @description: 单词拆分
 * @author: szm
 * @create: 2020-04-06 10:56
 **/
public class Leetcode139 {

    @Test
    public void test() {
        System.out.println("----------start-----------");
        String s = "leetcode";
        List<String> list = Lists.newArrayList(new String[]{"leet", "code"});
        System.out.println(wordBreak(s, list));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] dp = new boolean[length + 1];
        dp[0] = true;
        for (int i = 0; i < length + 1; i++) {
            for (String str : wordDict) {
                // 状态转移方程
                if (i - str.length() >= 0 && dp[i - str.length()] &&
                        str.equals(s.substring(i - str.length(), i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[length];
    }
}

