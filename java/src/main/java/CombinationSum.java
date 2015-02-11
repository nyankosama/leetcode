import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @created: 2015/2/11
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/combination-sum/
 */
public class CombinationSum {

    /**
     * NP问题，先对数组进行排序然后使用递归进行枚举
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) return ret;
        helper(candidates, 0, target, new ArrayList<Integer>(), ret);
        return ret;
    }

    private void helper(int[] candidates, int start, int target, List<Integer> items, List<List<Integer>> ret) {
        if (target < 0) return;
        if (target == 0) {
            ret.add(new ArrayList<Integer>(items));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > 0 && candidates[i - 1] == candidates[i])
                continue;
            items.add(candidates[i]);
            helper(candidates, i, target - candidates[i], items, ret);
            items.remove(items.size() - 1);
        }
    }

    public static void main(String args[]) {
        int[] num = {8, 7, 4, 3};
        CombinationSum s = new CombinationSum();
        System.out.println(s.combinationSum(num, 11));
    }
}
