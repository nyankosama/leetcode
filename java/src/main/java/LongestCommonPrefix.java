/**
 * @created: 2015/2/9
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/longest-common-prefix/
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {
        int minLen = Integer.MAX_VALUE;
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }
        if (minLen == 0) return "";
        for (int i = 0; i < minLen; i++) {
            char pre = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != pre) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0].substring(0, minLen);
    }

    public static void main(String args[]) {
        LongestCommonPrefix s = new LongestCommonPrefix();
        String strs[] = {"123", "12", "1234"};
        System.out.println(s.longestCommonPrefix(strs));
    }
}
