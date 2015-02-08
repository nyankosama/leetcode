import java.util.HashMap;
import java.util.Map;

/**
 * @created: 2015/2/8
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubWithoutRepeatingChr {

    /**
     * 通过start和savePoint来避免进行重复的扫描
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        if (s.trim().isEmpty()) return 0;
        s = s.trim();
        int maxLen = Integer.MIN_VALUE;
        int start = 0;
        int savePoint = 0;
        Map<Character, Integer> indexMap = new HashMap<Character, Integer>();
        while (start < s.length()) {
            boolean match = false;
            for (int i = savePoint; i < s.length(); i++) {
                char chr = s.charAt(i);
                if (indexMap.containsKey(chr) && indexMap.get(chr) >= start) {
                    maxLen = Math.max(maxLen, i - start);
                    start = indexMap.get(chr) + 1;
                    savePoint = i + 1;
                    indexMap.put(chr, i);
                    match = true;
                    break;
                } else {
                    indexMap.put(chr, i);
                }
            }
            if (!match) {
                maxLen = Math.max(maxLen, s.length() - start);
                return maxLen;
            }
        }
        return maxLen;
    }

    public static void main(String args[]) {
        LongestSubWithoutRepeatingChr s = new LongestSubWithoutRepeatingChr();
        System.out.println(s.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(s.lengthOfLongestSubstring("bbbbb"));
        System.out.println(s.lengthOfLongestSubstring(""));
    }
}
