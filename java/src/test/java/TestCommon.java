import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        List<Integer> list = new ArrayList<Integer>();
        list.addAll(Arrays.asList(1, 2, 3, 4));
    }
}
