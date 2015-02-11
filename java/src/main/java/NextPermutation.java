import java.util.Arrays;

/**
 * @created: 2015/2/11
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/next-permutation/
 */
public class NextPermutation {

    /**
     * 按照题意，从后到前扫描数组，首先找到第一个不是降序的元素
     * 然后从其后面的元素中选择一个比它大的最小的元素与其交换
     * 然后在对后面的元素进行升序排列即可
     * @param num
     */
    public void nextPermutation(int[] num) {
        if (num.length == 0 || num.length == 1) return;
        int index = -1;
        for (int i = num.length - 1; i > 0; i--) {
            if (num[i - 1] < num[i]) {
                index = i - 1;
                break;
            }
        }
        if (index == -1) {
            Arrays.sort(num);
            return;
        }
        int minLargerIndex = index + 1;
        for (int i = index + 1; i < num.length; i++) {
            if (num[i] > num[index] && num[i] < num[minLargerIndex])
                minLargerIndex = i;
        }
        int tmp = num[minLargerIndex];
        num[minLargerIndex] = num[index];
        num[index] = tmp;
        Arrays.sort(num, index + 1, num.length);
    }

    public static void main(String args[]) {
        int num[] = {1, 3, 4, 2};
        NextPermutation s = new NextPermutation();
        s.nextPermutation(num);
        for (int i : num) {
            System.out.print(i + " ");
        }
    }
}
