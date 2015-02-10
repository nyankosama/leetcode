import java.util.Arrays;

/**
 * @created: 2015/2/10
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/remove-nth-node-from-end-of-list/
 */
public class RemoveNthNodeFromEndofList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode iter = head;
        ListNode pre = null;
        int count = 0;
        while (iter != null) {
            if (count == n)
                pre = head;
            else if (count > n)
                pre = pre.next;
            iter = iter.next;
            count++;
        }
        if (n > count) {
            return null;
        } else if (n == count) {
            return head.next;
        } else {
            pre.next = pre.next.next;
        }
        return head;
    }

    public static void main(String args[]) {
        RemoveNthNodeFromEndofList s = new RemoveNthNodeFromEndofList();
        ListNode h1 = Utils.makeList(Arrays.asList(1, 2, 3, 4, 5));
        Utils.printList(h1);
        ListNode tmp = s.removeNthFromEnd(h1, 2);
        Utils.printList(tmp);
        ListNode h2 = Utils.makeList(Arrays.asList(1, 2, 3, 4, 5));
        Utils.printList(h2);
        tmp = s.removeNthFromEnd(h2, 5);
        Utils.printList(tmp);
    }
}
