/**
 * @created: 2015/2/15
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/rotate-list/
 */
public class RotateList {

    /**
     * 用walker-runner思想，注意n可能会大于链表长度，如果n大于长度这里先遍历一遍链表是跑不掉的
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        ListNode walker = head;
        ListNode runner = head;
        int index = 0;
        while (runner != null && index < n) {
            runner = runner.next;
            index++;
        }
        if (runner == null) {
            n %= index;
            runner = head;
            index = 0;
            while (runner != null && index < n) {
                runner = runner.next;
                index++;
            }
        }
        assert runner != null;
        while (runner.next != null) {
            walker = walker.next;
            runner = runner.next;
        }
        runner.next = head;
        ListNode newHead = walker.next;
        walker.next = null;
        return newHead;
    }
}
