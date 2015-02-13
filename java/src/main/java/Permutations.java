import java.util.ArrayList;
import java.util.List;

/**
 * @created: 2015/2/13
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/permutations/
 */
public class Permutations {

    /**
     * 典型带回退的递归，dfs
     * @param num
     * @return
     */
    public List<List<Integer>> permute(int[] num) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (num == null || num.length == 0) return ret;
        helper(num, 0, new ArrayList<Integer>(), ret);
        return ret;
    }

    private void helper(int[] num, int deep, List<Integer> seq, List<List<Integer>> ret) {
        if (deep == num.length) {
            ret.add(new ArrayList<Integer>(seq));
            return;
        }
        for (int i = deep; i < num.length; i++) {
            swap(num, deep, i);
            seq.add(num[deep]);
            helper(num, deep + 1, seq, ret);
            seq.remove(seq.size() - 1);
            swap(num, deep, i);
        }
    }

    private void swap(int[] arr, int i, int j) {
        if (i == j) return;
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void main(String args[]) {
        Permutations s = new Permutations();
        int[] num = {1, 2, 3};
        for (List<Integer> integers : s.permute(num)) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
