import java.util.Arrays;

/**
 * @created: 2015/2/10
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/swap-nodes-in-pairs/
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
        ListNode fakePre = new ListNode(0);
        fakePre.next = new ListNode(0);
        fakePre.next.next = new ListNode(0);
        fakePre.next.next.next = head;
        ListNode pre = fakePre;
        ListNode first = fakePre.next;
        ListNode second = fakePre.next.next;
        ListNode fakeNode = second;
        while (second.next != null && second.next.next != null) {
            pre = pre.next.next;
            first = first.next.next;
            second = second.next.next;
            pre.next = second;
            first.next = second.next;
            second.next = first;
            ListNode tmp = first;
            first = second;
            second = tmp;
        }
        return fakeNode.next;
    }

    public static void main(String args[]) {
        SwapNodesInPairs s = new SwapNodesInPairs();
//        ListNode h1 = Utils.makeList(Arrays.asList(1, 2, 3, 4, 5));
        ListNode ret = s.swapPairs(null);
        Utils.printList(ret);
    }
}
