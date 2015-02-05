/**
 * @created: 2015/2/5
 * @author: nyankosama
 * @description:
 */
public class ExHeapSort {

    public static void sort(int[] a){
        int N = a.length;
        for (int k = (N - 1) / 2; k >= 0; k--) {
            sink(a, k, N - 1);
        }
        while (N > 0) {
            exch(a, 0, --N);
            sink(a, 0, N - 1);
        }
    }

    public static void sink(int[] a, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && a[j] < a[j + 1]) j++;
            if (a[k] >= a[j]) break;
            exch(a, k, j);
            k = j;
        }
    }

    public static void exch(int[] a, int k, int j) {
        int tmp = a[k];
        a[k] = a[j];
        a[j] = tmp;
    }
}
