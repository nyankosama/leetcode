import java.util.ArrayList;
import java.util.List;

/**
 * @created: 2015/2/16
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/combinations/
 */
public class Combinations {

    /**
     * 递归DFS
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        helper(n, 1, k, new ArrayList<Integer>(), ret);
        return ret;
    }

    private void helper(int n, int start, int k, List<Integer> seq, List<List<Integer>> ret) {
        if (k == 0) {
            ret.add(new ArrayList<Integer>(seq));
            return;
        }
        for (int i = start; i <= n; i++) {
            seq.add(i);
            helper(n, i + 1, k - 1, seq, ret);
            seq.remove(seq.size() - 1);
        }
    }

    public static void main(String args[]) {
        Combinations s = new Combinations();
        for (List<Integer> integers : s.combine(4, 3)) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
