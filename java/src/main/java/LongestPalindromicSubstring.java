/**
 * @created: 2015/2/8
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {

    /**
     * 以某个中心点展开搜索回文串，O(n^2)
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        String ppStr = preProcessing(s);
        int maxLen = Integer.MIN_VALUE, index = 0;
        for (int i = 0; i < ppStr.length(); i++) {
            int step = 1;
            while (i - step >= 0 && i + step < ppStr.length()) {
                if (ppStr.charAt(i - step) != ppStr.charAt(i + step)) break;
                step++;
            }
            if (maxLen < step) {
                maxLen = step;
                index = i;
            }
        }
        return s.substring((index - maxLen) / 2, (maxLen + index) / 2 - 1);
    }

    private String preProcessing(String s) {
        StringBuilder builder = new StringBuilder();
        builder.append("$");
        builder.append("#");
        for (char c : s.toCharArray()) {
            builder.append(c);
            builder.append("#");
        }
        builder.append("^");
        return builder.toString();
    }

    public static void main(String args[]) {
        LongestPalindromicSubstring s = new LongestPalindromicSubstring();
        System.out.println(s.longestPalindrome("12321"));
        System.out.println(s.longestPalindrome("abbac"));
        System.out.println(s.longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"));
    }
}
