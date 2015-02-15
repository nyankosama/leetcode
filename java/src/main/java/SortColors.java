/**
 * @created: 2015/2/15
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/sort-colors/
 */
public class SortColors {

    /**
     * 大量重复元素排序
     * 使用三向快速排序
     * @param A
     */
    public void sortColors(int[] A) {
        quickSort3Way(A, 0, A.length - 1);
    }

    public void quickSort3Way(int[] a, int low, int high) {
        if (high - low + 1 <= 15) {
            insertSort(a, low, high);
            return;
        }
        int lt = low, i = low + 1, gt = high;
        int pivot = findMedium(a, low, (high - low) / 2, high);
        int v = a[pivot];
        exch(a, low, pivot);
        while (i <= gt) {
            if (a[i] < v) exch(a, lt++, i++);
            else if (a[i] > v) exch(a, i, gt--);
            else i++;
        }
        quickSort3Way(a, low, lt - 1);
        quickSort3Way(a, gt + 1, high);
    }

    private void exch(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private int findMedium(int[] a, int i, int j, int k) {
        int min = i;
        int max = i;
        if (a[j] < a[min])
            min = j;
        else
            max = j;
        if (a[k] < a[min])
            min = k;
        else if (a[k] > a[max])
            max = k;
        return i + j + k - min - max;
    }

    private void insertSort(int[] a, int low, int high) {
        for (int i = low; i <= high; i++) {
            int v = a[i];
            int j;
            for (j = i; j > low && v < a[j - 1]; j--) {
                a[j] = a[j - 1];
            }
            a[j] = v;
        }
    }

    public static void main(String args[]) {
        int[] a = {0, 0, 0, 1, 2, 0, 1, 2, 2, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 1, 1, 1, 1, 0};
        SortColors s = new SortColors();
        s.sortColors(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
