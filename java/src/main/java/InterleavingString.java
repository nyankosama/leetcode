/**
 * @created: 2015/2/17
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/interleaving-string/
 */
public class InterleavingString {

    /**
     * 动态规划，match[i][j]表示s1取前i个字符和s2取前j个字符能否匹配s3取前i+j个字符
     * @param s1
     * @param s2
     * @param s3
     * @return
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s3.length() != s1.length() + s2.length()) return false;
        boolean[][] match = new boolean[s1.length() + 1][s2.length() + 1];
        for (int i = 0; i <= s1.length(); i++) {
            if (s1.substring(0, i).equals(s3.substring(0, i))) {
                match[i][0] = true;
            }
        }
        for (int i = 0; i <= s2.length(); i++) {
            if (s2.substring(0, i).equals(s3.substring(0, i))) {
                match[0][i] = true;
            }
        }
        for (int i = 1; i <= s1.length(); i++) {
            for (int j = 1; j <= s2.length(); j++) {
                match[i][j] = match[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)
                        || match[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
            }
        }
        return match[s1.length()][s2.length()];
    }

    public static void main(String args[]) {
        InterleavingString s = new InterleavingString();
        System.out.println(s.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
        System.out.println(s.isInterleave("aabcc", "dbbca", "aadbbbaccc"));
    }
}
