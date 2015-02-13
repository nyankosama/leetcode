/**
 * @created: 2015/2/13
 * @author: nyankosama
 * @description:
 */
public class RotateImage {

    /**
     * 先转置，再每一行reverse
     * 见：http://blog.csdn.net/kenden23/article/details/17200067
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix[i].length; j++) {
                swap(matrix, i, j, j, i);
            }
            reverse(matrix[i], 0, matrix[i].length);
        }
    }

    private void swap(int[][] arr, int i1, int j1, int i2, int j2) {
        int tmp = arr[i1][j1];
        arr[i1][j1] = arr[i2][j2];
        arr[i2][j2] = tmp;
    }

    private void swap(int[] arr, int i, int j) {
        if (i == j) return;
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private void reverse(int[] arr, int begin, int end) {
        int i = begin, j = end - 1;
        while (i < j) {
            swap(arr, i, j);
            i++;
            j--;
        }
    }

    public static void main(String args[]) {
        RotateImage s = new RotateImage();
        int[][] m = {{11, 12, 13}, {21, 22, 23}, {31, 32, 33}};
        for (int[] ints : m) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        s.rotate(m);
        for (int[] ints : m) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}
