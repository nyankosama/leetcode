/**
 * @created: 2015/3/5
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/populating-next-right-pointers-in-each-node/
 */
public class PopulatingNextRightPointersInEachNode {

    /**
     * 直接DPS
     * 利用已经连好的next连接来搭桥处理两个子树的边界next连接
     * @param root
     */
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        //root直接左连右
        if (root.left != null)
            root.left.next = root.right;
        //处理两个子树的边界连接
        if (root.right != null && root.next != null)
            root.right.next = root.next.left;
        connect(root.left);
        connect(root.right);
    }
}
