import java.util.List;

/**
 * @created:    2015/2/3
 * @author:     i@nyankosama.com
 *
 * @description:
 */
public class Utils {

    public static ListNode makeList(List<Integer> nodes) {
        ListNode pre = new ListNode(0);
        ListNode iter = pre;
        for (Integer node : nodes) {
            iter.next = new ListNode(node);
            iter = iter.next;
        }
        return pre.next;
    }

    public static void printList(ListNode head) {
        ListNode iter = head;
        while (iter != null) {
            System.out.print(iter.val + "->");
            iter = iter.next;
        }
        System.out.print("Nal");
        System.out.println();
    }
}
