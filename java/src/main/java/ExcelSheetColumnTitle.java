/**
 * @created: 2015/2/5
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/excel-sheet-column-title/
 */

/**
 * 十进制转二十六进制问题
 */
public class ExcelSheetColumnTitle {

    public String convertToTitle(int n) {
        if (n <= 0) return "";
        StringBuilder ret = new StringBuilder();
        while (n > 0) {
            ret.append((char) ('A' + (n - 1) % 26));
            n = (n - 1) / 26;
        }
        return ret.reverse().toString();
    }

    public static void main(String args[]) {
        ExcelSheetColumnTitle s = new ExcelSheetColumnTitle();
        System.out.println(s.convertToTitle(52));
    }
}
