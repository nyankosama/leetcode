/**
 * @created: 2015/3/5
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) return null;
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;
        TreeNode root = new TreeNode(preorder[preStart]);
        if (preStart == preEnd && inStart == inEnd) return root;
        int inRootIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) inRootIndex = i;
        }

        int numInLeft = inRootIndex - inStart;
        root.left = helper(preorder, preStart + 1, preStart + numInLeft, inorder, inStart, inRootIndex - 1);
        root.right = helper(preorder, preStart + numInLeft + 1, preEnd, inorder, inRootIndex + 1, inEnd);
        return root;
    }
}
