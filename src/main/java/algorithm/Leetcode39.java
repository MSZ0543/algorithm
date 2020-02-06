package algorithm;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @program: javaStudy
 * @description:
 * @author: szm
 * @create: 2020-01-14 18:50
 **/
public class Leetcode39 {
    public static void main(String[] args) {
        int[] input = {2,3,5};
        System.out.println(combinationSum(input, 8));
    }


    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> res = new HashSet<>();
        if(candidates.length ==0) {
            return res.stream().collect(Collectors.toList());
        }
        List<Integer> row = new ArrayList<>();
        Arrays.sort(candidates);
        helper(res, row, candidates, target, 0);
        return res.stream().collect(Collectors.toList());
    }

    private static void helper(Set<List<Integer>> res, List<Integer> row,
                        int[] candidates, int target, int sum) {
        if(sum == target) {
            Collections.sort(row);
            res.add(new ArrayList<>(row));
            return;
        }
        if(sum > target) {
            return;
        }
        for(int i = 0; i < candidates.length; i++) {
            if(row.size() > 1 && candidates[i] < row.get(row.size() - 1)) return;
            row.add(candidates[i]);
            sum += candidates[i];
            helper(res, row, candidates, target, sum);
            row.remove(row.lastIndexOf(candidates[i]));
            sum -= candidates[i];
        }
    }
}
