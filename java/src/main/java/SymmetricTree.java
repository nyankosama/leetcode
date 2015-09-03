/**
 * @created: 2015/9/3
 * @author: nyankosama
 * @description: https://leetcode.com/problems/symmetric-tree/
 * 方案：http://www.programcreek.com/2014/03/leetcode-symmetric-tree-java/
 */
public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null)
            return true;
        return isSymmetric(root.left, root.right);
    }

    public boolean isSymmetric(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        } else if (r == null || l == null) {
            return false;
        }

        if (l.val != r.val)
            return false;

        if (!isSymmetric(l.left, r.right))
            return false;
        if (!isSymmetric(l.right, r.left))
            return false;

        return true;
    }
}
