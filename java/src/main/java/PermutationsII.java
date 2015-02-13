import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @created: 2015/2/13
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/permutations-ii/
 */
public class PermutationsII {

    /**
     * 如果这里用1的swap的话，就不能有效跳过相同元素了，因为顺序被swap打乱了
     * 这里使用dfs的marked数组来记录是否使用过某个元素
     * 如果相邻元素相同则跳过本次dfs
     * @param num
     * @return
     */
    public List<List<Integer>> permuteUnique(int[] num) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0) return ret;
        Arrays.sort(num);
        helper(num, new boolean[num.length], new ArrayList<Integer>(), ret);
        return ret;
    }

    private void helper(int[] num, boolean[] marked, List<Integer> seq, List<List<Integer>> ret) {
        if (seq.size() == num.length) {
            ret.add(new ArrayList<Integer>(seq));
            return;
        }
        for (int i = 0; i < num.length; i++) {
            if (i < num.length - 1 && num[i] == num[i + 1] && !marked[i + 1]) continue; //避免重复递归相同的元素
            if (!marked[i]) {
                marked[i] = true;
                seq.add(num[i]);
                helper(num, marked, seq, ret);
                seq.remove(seq.size() - 1);
                marked[i] = false;
            }

        }
    }

    public static void main(String args[]) {
        PermutationsII s = new PermutationsII();
        int[] num = {1, 1, 2, 2};
        for (List<Integer> integers : s.permuteUnique(num)) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
