import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @created: 2015/2/5
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/largest-number/
 */

/**
 * 思路：
 * 直接进行排序，排序规则为对于两个备选数字字符串，如果a cont b > b cont a，则a.compareTo(b) > 0
 * 然后直接按照reverse顺序输出即可
 */
public class LargestNumber {

    public String largestNumber(int[] num) {
        if (num == null || num.length == 0) return "";
        ArrayList<String> strList = new ArrayList<String>();
        for (Integer i : num) {
            strList.add(String.valueOf(i));
        }
        Collections.sort(strList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if ((o1 + o2).compareTo(o2 + o1) > 0) return 1;
                else return -1;
            }
        });
        Collections.reverse(strList);
        if (strList.get(0).equals("0")) return "0";
        StringBuilder ret = new StringBuilder();
        for (String str : strList) {
            ret.append(str);
        }
        return ret.toString();
    }

    public static void main(String args[]) {
        LargestNumber s = new LargestNumber();
        int[] tmp = {3, 30, 34, 5, 9};
        System.out.println(s.largestNumber(tmp));
    }
}
