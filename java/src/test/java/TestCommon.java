import java.util.ArrayList;
import java.util.Arrays;

/**
 * @created: 2015/2/3
 * @author: nyankosama
 * @description:
 */
public class TestCommon {

    public static int indexOf(int h, int length) {
        return h & (length-1);
    }

    public static void main(String args[]) {
        int a[] = new int[5];
        ArrayList<Integer> list[] = new ArrayList[4];
        Arrays.fill(list, new ArrayList<Integer>());
        for (ArrayList<Integer> i : list) {
            System.out.println(i);
        }
    }
}
