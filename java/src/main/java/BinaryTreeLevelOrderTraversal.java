import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @created: 2015/3/5
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/binary-tree-level-order-traversal/
 */
public class BinaryTreeLevelOrderTraversal {

    /**
     * BFS即可，注意需要统计每一层的节点个数，以便输出
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int curNum = 0;
        int lastNum = 1;
        ArrayList<Integer> list = new ArrayList<>();
        while(!queue.isEmpty())
        {
            TreeNode cur = queue.poll();
            lastNum--;
            list.add(cur.val);
            if(cur.left!=null)
            {
                queue.add(cur.left);
                curNum ++;
            }
            if(cur.right!=null)
            {
                queue.add(cur.right);
                curNum++;
            }
            if(lastNum==0)
            {
                lastNum = curNum;
                curNum = 0;
                res.add(list);
                list = new ArrayList<>();
            }
        }
        return res;
    }
}
