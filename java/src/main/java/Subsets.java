import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @created: 2015/2/16
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/subsets/
 */
public class Subsets {

    public List<List<Integer>> subsets(int[] S) {
        Arrays.sort(S);
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for (int i = 0; i <= S.length; i++) {
            helper(S, 0, i, new ArrayList<Integer>(), ret);
        }
        return ret;
    }

    private void helper(int[] S, int start, int k, List<Integer> seq, List<List<Integer>> ret) {
        if (k == 0) {
            ret.add(new ArrayList<Integer>(seq));
            return;
        }
        for (int i = start; i < S.length; i++) {
            seq.add(S[i]);
            helper(S, i + 1, k - 1, seq, ret);
            seq.remove(seq.size() - 1);
        }
    }

    public static void main(String args[]) {
        Subsets s = new Subsets();
        int[] tmp = {1, 2, 3};
        for (List<Integer> integers : s.subsets(tmp)) {
            for (Integer integer : integers) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }
}
