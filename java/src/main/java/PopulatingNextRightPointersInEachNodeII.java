/**
 * @created: 2015/3/5
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 */
public class PopulatingNextRightPointersInEachNodeII {

    public void connect(TreeLinkNode root) {
        if (root == null) return;
        //root直接左连右
        if (root.left != null)
                root.left.next = root.right == null ? getRightMostNext(root.next) : root.right;
        //处理两个子树的边界连接
        if (root.right != null)
            root.right.next = getRightMostNext(root.next);
        connect(root.left);
        connect(root.right);
    }

    public TreeLinkNode getRightMostNext(TreeLinkNode node) {
        while (node != null) {
            if (node.left != null)
                return node.left;
            else if (node.right != null)
                return node.right;
            node = node.next;
        }
        return null;
    }
}
