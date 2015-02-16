import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @created: 2015/2/16
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/binary-tree-inorder-traversal/
 */
public class BinaryTreeInorderTraversal {

    /**
     * 简单的递归解法
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        helper(root, ret);
        return ret;
    }

    public void helper(TreeNode node, List<Integer> ret) {
        if (node == null) return;
        helper(node.left, ret);
        ret.add(node.val);
        helper(node.right, ret);
    }

    /**
     * 非递归，使用stack来保存遍历顺序
     * @param root
     * @return
     */
    public List<Integer> inorderTravelsalNonRecursive(TreeNode root) {
        List<Integer> ret = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode iter = root;
        pushLeft(stack, iter);
        while (!stack.isEmpty()) {
            iter = stack.pop();
            ret.add(iter.val);
            iter = iter.right;
            pushLeft(stack, iter);
        }
        return ret;
    }

    private void pushLeft(Stack<TreeNode> stack, TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    public static void main(String args[]) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.right = node1;
        node1.left = node2;
        BinaryTreeInorderTraversal s = new BinaryTreeInorderTraversal();
        for (Integer integer : s.inorderTravelsalNonRecursive(root)) {
            System.out.print(integer + " ");
        }
    }
}
