package algorithm.array;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: algorithm
 * @description: 电话号码的字母组合
 * @author: szm
 * @create: 2020-01-18 11:57
 **/
public class Leetcode17 {

    private String letterMap[] = {
            " ",    //0
            "",     //1
            "abc",  //2
            "def",  //3
            "ghi",  //4
            "jkl",  //5
            "mno",  //6
            "pqrs", //7
            "tuv",  //8
            "wxyz"  //9
    };

    @Test
    public void test() {
        System.out.println("----------start-----------");

        System.out.println(letterCombinations("23"));

    }


    public List<String> letterCombinations(String digits) {
        // 通过
        List<String> res = new LinkedList<>();
        if (digits.length() == 0) return res;
        char[] chars = digits.toCharArray();
        // index 表示第N个位置上的字母选择
        helper(res, new StringBuffer(), 0, chars);
        return res;
    }

    private void helper(List<String> res, StringBuffer str, int index, char[] chars) {
        if (index == chars.length) {
            res.add(str.toString());
            return;
        }
        // 这块得到键位英文字符串需要特殊处理
        String mapValue = letterMap[chars[index] - '0'];
        for (int i = 0; i < mapValue.length(); i++) {
            str.append(mapValue.charAt(i));
            helper(res, str, index + 1, chars);
            str.deleteCharAt(str.length() - 1);
        }
    }


}
