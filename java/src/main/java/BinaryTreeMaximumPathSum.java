/**
 * @created: 2015/3/5
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class BinaryTreeMaximumPathSum {

    int max = Integer.MIN_VALUE;

    /**
     * 分别计算左子树和又子树，然后递归DFS
     * @param root
     * @return
     */
    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        max = root.val;
        findMax(root);
        return max;
    }

    public int findMax(TreeNode node) {
        if (node == null) return 0;

        int left = Math.max(findMax(node.left), 0);
        int right = Math.max(findMax(node.right), 0);

        max = Math.max(left + right + node.val, max);

        return node.val + Math.max(left, right);
    }
}
