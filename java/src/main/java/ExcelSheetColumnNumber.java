/**
 * @created: 2015/2/5
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/excel-sheet-column-number/
 */

/**
 * 二十六进制数转十进制问题
 */
public class ExcelSheetColumnNumber {

    public int titleToNumber(String s) {
        int ret = 0;
        String reverse = new StringBuilder(s).reverse().toString();
        for (int i = 0; i < reverse.length(); i++) {
            ret = (int) ((reverse.charAt(i) - 'A' + 1) * Math.pow(26, i) + ret);
        }
        return ret;
    }

    public static void main(String args[]) {
        ExcelSheetColumnNumber s = new ExcelSheetColumnNumber();
        System.out.println(s.titleToNumber("A"));
        System.out.println(s.titleToNumber("AA"));
        System.out.println(s.titleToNumber("AB"));
    }
}
