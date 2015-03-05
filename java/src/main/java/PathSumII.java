import java.util.ArrayList;
import java.util.List;

/**
 * @created: 2015/3/5
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/path-sum-ii/
 */
public class PathSumII {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) return ret;
        helper(root, sum, new ArrayList<Integer>(), ret);
        return ret;
    }

    private void helper(TreeNode root, int sum, List<Integer> seq, List<List<Integer>> ret) {
        if (root == null) return;
        if (root.left == null && root.right == null && root.val == sum) {
            seq.add(root.val);
            ret.add(new ArrayList<>(seq));
            seq.remove(seq.size() - 1);
            return;
        }
        seq.add(root.val);
        helper(root.left, sum - root.val, seq, ret);
        helper(root.right, sum - root.val, seq, ret);
        seq.remove(seq.size() - 1);
    }
}
