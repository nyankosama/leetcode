/**
 * @created: 2015/2/16
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 */
public class RemoveDuplicatesFromSortedListII {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        ListNode fake = new ListNode(0);
        fake.next = head;
        ListNode pre = fake;
        ListNode iter = head;
        while (iter != null) {
            while (iter.next != null && pre.next.val == iter.next.val) {
                iter = iter.next;
            }
            if (pre.next == iter) {
                pre = pre.next;
            } else {
                pre.next = iter.next;
            }
            iter = iter.next;
        }
        return fake.next;
    }
}
