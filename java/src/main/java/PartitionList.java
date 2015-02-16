import java.util.Arrays;

/**
 * @created: 2015/2/16
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problemset/algorithms/
 */
public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        if (head == null) return null;
        ListNode fakeLeft = new ListNode(0);
        ListNode fakeRight = new ListNode(0);
        ListNode iter = head;
        ListNode iterLeft = fakeLeft;
        ListNode iterRight = fakeRight;
        while (iter != null) {
            if (iter.val < x) {
                iterLeft.next = iter;
                iterLeft = iter;
            } else {
                iterRight.next = iter;
                iterRight = iter;
            }
            iter = iter.next;
        }
        iterLeft.next = null;
        iterRight.next = null;
        iterLeft.next = fakeRight.next;
        return fakeLeft.next;
    }

    public static void main(String args[]) {
        ListNode tmp = Utils.makeList(Arrays.asList(1, 4, 3, 2, 5, 2));
        PartitionList s = new PartitionList();
        tmp = s.partition(tmp, 3);
        Utils.printList(tmp);
    }
}
