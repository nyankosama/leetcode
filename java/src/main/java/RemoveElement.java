import java.util.Arrays;

/**
 * @created: 2015/2/10
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/remove-element/
 */
public class RemoveElement {

    /**
     * 如果相等的话，就直接后面覆盖前面即可
     * 用two pointer
     * @param A
     * @param elem
     * @return
     */
    public int removeElement(int[] A, int elem) {
        int index = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] != elem)
                A[index++] = A[i];
        }
        return index;
    }

    public static void main(String args[]) {
        RemoveElement s = new RemoveElement();
        int tmp[] = {};
        System.out.println(s.removeElement(tmp, 1));
        for (int i : tmp) {
            System.out.print(i + " ");
        }
    }
}
