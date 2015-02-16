import java.util.Arrays;

/**
 * @created: 2015/2/16
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list/
 */
public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode pre = head;
        ListNode iter = head.next;
        while (iter != null) {
            if (pre.val == iter.val) {
                iter = iter.next;
            } else {
                pre.next = iter;
                pre = iter;
                iter = iter.next;
            }
        }
        pre.next = iter;
        return head;
    }

    public static void main(String args[]) {
        RemoveDuplicatesFromSortedList s = new RemoveDuplicatesFromSortedList();
        ListNode head = Utils.makeList(Arrays.asList(1, 1, 2));
        Utils.printList(head);
        s.deleteDuplicates(head);
        Utils.printList(head);
        head = Utils.makeList(Arrays.asList(1, 1, 2, 3, 3));
        Utils.printList(head);
        s.deleteDuplicates(head);
        Utils.printList(head);
    }
}
