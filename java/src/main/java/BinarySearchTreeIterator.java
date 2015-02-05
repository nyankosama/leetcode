import java.util.Stack;

/**
 * @created: 2015/2/5
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/binary-search-tree-iterator/
 */

/**
 * 即完成一个非递归的中序迭代器
 */
public class BinarySearchTreeIterator {


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public class BSTIterator {
        private Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            TreeNode node = stack.pop();
            int ret = node.val;
            if (node.right != null) {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
            return ret;
        }
    }
}
