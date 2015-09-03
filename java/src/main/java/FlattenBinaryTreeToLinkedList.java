import java.util.Stack;

/**
 * @created: 2015/9/3
 * @author: nyankosama
 * @description: https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
 */
public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = root;

        while (p != null && !stack.empty()) {
            if (p.right != null) {
                stack.push(p.right);
            }

            if (p.left != null) {
                p.right = p.left;
                p.left = null
            } else if (!stack.empty()) {
                TreeNode tmp = stack.pop();
                p.right = tmp;
            }

            p = p.right;
        }
    }
}
