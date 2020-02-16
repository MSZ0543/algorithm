package algorithm.string;

import java.util.Arrays;

/**
 * @program: algorithm
 * @description: 有效的字母异位词
 * @author: szm
 * @create: 2020-01-18 09:59
 **/
public class Leetcode242 {

    public boolean isAnagram(String s, String t) {
        // 通过
        if(s.length() != t.length())
            return false;
        int[] map = new int[26];
        // 转成charArray操作速度更快
        char[] sChar = s.toCharArray();
        char[] tChar = t.toCharArray();
        for(int i = 0; i < s.length(); i ++) {
            // hash表
            map['z'- sChar[i]] ++;
            map['z'- tChar[i]] --;
        }
        Arrays.sort(map);
        return 0 == map[25] && map[25] == map[0];
    }

}
