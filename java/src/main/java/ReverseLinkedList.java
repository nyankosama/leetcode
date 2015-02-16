import java.util.Arrays;

/**
 * @created: 2015/2/16
 * @author: nyankosama
 * @description: reverse a linked list with on-pass and in-place method
 */
public class ReverseLinkedList {

    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode fakeNode = new ListNode(0);
        fakeNode.next = head;
        ListNode pre = fakeNode;
        ListNode iter = head;
        ListNode tmp;
        while (iter != null) {
            tmp = iter;
            iter = iter.next;
            tmp.next = pre;
            pre = tmp;
        }
        fakeNode.next.next = null;
        return pre;
    }

    public static void main(String args[]) {
        ListNode tmp = Utils.makeList(Arrays.asList(1, 2, 3, 4, 5));
        ReverseLinkedList s = new ReverseLinkedList();
        tmp = s.reverseList(tmp);
        Utils.printList(tmp);
    }
}
