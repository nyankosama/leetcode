/**
 * @created: 2015/3/5
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/validate-binary-search-tree/
 */
public class ValidateBinarySearchTree {
    /**
     * 1. 直接递归
     * 2. 中序遍历如果有序，则一定为二叉搜索树
     */

    /**
     * 直接递归即可
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }

    public boolean isValidBST(TreeNode p, double min, double max){
        if(p==null)
            return true;

        if(p.val <= min || p.val >= max)
            return false;

        return isValidBST(p.left, min, p.val) && isValidBST(p.right, p.val, max);
    }
}
