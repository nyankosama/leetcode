/**
 * @created: 2015/3/5
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/validate-binary-search-tree/
 */
public class ValidateBinarySearchTree {

    /**
     * 直接Brute force
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSubTreeLessThan(root.left, root.val) && isSubTreeGreaterThan(root.right, root.val) && isValidBST(root.left) && isValidBST(root.right);
    }

    public boolean isSubTreeLessThan(TreeNode node, int val) {
        if (node == null) {
            return true;
        }
        return node.val < val && isSubTreeLessThan(node.left, val) && isSubTreeLessThan(node.right, val);
    }

    public boolean isSubTreeGreaterThan(TreeNode node, int val) {
        if (node == null) {
            return true;
        }
        return node.val > val && isSubTreeGreaterThan(node.left, val) && isSubTreeGreaterThan(node.right, val);
    }

    public static int previous = Integer.MIN_VALUE;

    /**
     * 中序遍历如果有序，则一定为BST
     * @param root
     * @return
     */
    public boolean isValidBST2(TreeNode root) {
        if(root == null)
            return true;
        //the left sub tree
        if(!isValidBST(root.left))
            return false;
        //the current node
        if(root.val <= previous)
            return false;
        previous = root.val;
        //the right subtree
        return isValidBST(root.right);
    }
}
