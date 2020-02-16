package algorithm.string;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: algorithm
 * @description: 字母异位词分组
 * @author: szm
 * @create: 2020-01-18 10:36
 **/
public class Leetcode49 {

    @Test
    public void test() {
        System.out.println("----------start-----------");
        String[] input = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> lists = groupAnagrams(input);
        System.out.println(lists);
    }


    public List<List<String>> groupAnagrams(String[] strs) {
        // 通过 hash表 + 字符串排序
        List<List<String>> res = new LinkedList<>();
        if (strs.length < 1) return res;
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String helper = helper(strs[i]);
            if (!map.containsKey(helper)) {
                List<String> list = new LinkedList<>();
                list.add(strs[i]);
                map.put(helper, list);
            } else {
                map.get(helper).add(strs[i]);
            }
        }
        res.addAll(map.values());
        return res;
    }

    private String helper(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return String.valueOf(chars);
    }

}
