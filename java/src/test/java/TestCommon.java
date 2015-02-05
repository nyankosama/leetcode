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
        int digit = (int) (Math.log(26) / Math.log(26));
        System.out.println(digit);
    }
}
