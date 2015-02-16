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
        String s = "1";
        System.out.println(s.substring(1, s.length()));
    }
}
