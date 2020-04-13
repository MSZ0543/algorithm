package algorithm.string;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: algorithm
 * @description: 分割回文串
 * @author: szm
 * @create: 2020-04-09 10:51
 **/
public class Leetcode131 {

    @Test
    public void test() {
        System.out.println("----------start-----------");
        String input = "aab";
        List<List<String>> lists = partition(input);
        System.out.println(lists);
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if(s.length() == 0) {
            return res;
        }
        LinkedList<String> row = new LinkedList<>();
        help(s, row, res, 0);
        return res;
    }

    private void help(String s, LinkedList<String> row,
                      List<List<String>> res, int start) {
        if(start == s.length()) {
            res.add(new ArrayList<>(row));
            return;
        }
        for(int end = start; end < s.length(); end ++) {
            String tmp = s.substring(start, end + 1);
            if(!tmp.equals(new StringBuilder(tmp).reverse().toString())) {
                continue;
            }
            row.addLast(tmp);
            help(s, row, res, end + 1);
            row.removeLast();
        }
    }
}
