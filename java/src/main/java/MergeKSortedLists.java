import java.util.*;

/**
 * @created: 2015/2/10
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/merge-k-sorted-lists/
 */
public class MergeKSortedLists {

    /**
     * 使用TreeMap来存储一个树结构，每次从k个当前1节点O(logk)的复杂度找出最小节点，然后merge
     * @param lists
     * @return
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        ListNode fakeNode = new ListNode(0);
        ListNode p = fakeNode;

        int count = 0;
        TreeMap<Integer, List<ListNode>> valueNodeMap = new TreeMap<Integer, List<ListNode>>();
        for (ListNode iter : lists) {
            if (iter != null) {
                addTreeMap(valueNodeMap, iter.val, iter);
                count++;
            }
        }

        while (count > 1) {
            int minKey = valueNodeMap.firstKey();
            List<ListNode> nodes = valueNodeMap.get(minKey);
            ListNode minIter = nodes.get(0);
            p.next = minIter;
            minIter = minIter.next;
            nodes.remove(0);
            if (nodes.size() == 0) valueNodeMap.remove(minKey);

            if (minIter != null) {
                addTreeMap(valueNodeMap, minIter.val, minIter);
            } else {
                count--;
            }
            p = p.next;
        }
        if (count == 1) {
            p.next = valueNodeMap.firstEntry().getValue().get(0);
        }
        return fakeNode.next;
    }

    private void addTreeMap(TreeMap<Integer, List<ListNode>> map, int val, ListNode node) {
        if (map.containsKey(val)) {
            List<ListNode> tmp = map.get(val);
            tmp.add(node);
            map.put(val, tmp);
        } else {
            List<ListNode> tmp = new LinkedList<ListNode>();
            tmp.add(node);
            map.put(val, tmp);
        }
    }

    public static void main(String args[]) {
        List<ListNode> list = new ArrayList<ListNode>();
        MergeKSortedLists s = new MergeKSortedLists();
        ListNode head1 = Utils.makeList(Arrays.asList(1, 5));
        ListNode head2 = Utils.makeList(Arrays.asList(2, 6));
        ListNode head3 = Utils.makeList(Arrays.asList(3, 7));
        ListNode ret = s.mergeKLists(Arrays.asList(head1, head2, head3));
        Utils.printList(ret);
    }
}
