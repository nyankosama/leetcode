import java.util.*;

/**
 * @created: 2015/2/11
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/combination-sum-ii/
 */
public class CombinationSumII {

    /**
     * 解法同CombinationSum
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        if (candidates == null || candidates.length == 0) return ret;
        Arrays.sort(candidates);
        helper(candidates, 0, target, new ArrayList<Integer>(), set);
        ret.addAll(set);
        return ret;
    }

    private void helper(int[] candidates, int start, int target, List<Integer> items, Set<List<Integer>> ret) {
        if (target < 0) return;
        if (target == 0) {
            ret.add(new ArrayList<Integer>(items));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            items.add(candidates[i]);
            helper(candidates, i + 1, target - candidates[i], items, ret);
            items.remove(items.size() - 1);
        }
    }

    public static void main(String args[]) {
        int[] num = {10, 1, 2, 7, 6, 1, 5};
        CombinationSumII s = new CombinationSumII();
        System.out.println(s.combinationSum2(num, 8));
    }
}
