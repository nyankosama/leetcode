import java.util.Stack;

/**
 * @created: 2015/2/11
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/longest-valid-parentheses/
 */
public class LongestValidParentheses {

    /**
     * 使用栈进行匹配
     * 注意当遇到')'要分情况讨论
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        if (s == null) return 0;
        s = s.trim();
        if (s.isEmpty()) return 0;
        int max = 0;
        int start = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char chr = s.charAt(i);
            if (chr == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                    if (stack.isEmpty()) {
                        max = Math.max(i - start + 1, max);
                    } else {
                        max = Math.max(i - stack.peek(), max);
                    }
                } else {
                    start = i + 1;
                }
            }
        }
        return max;
    }

    public static void main(String args[]) {
        LongestValidParentheses s = new LongestValidParentheses();
        System.out.println(s.longestValidParentheses(""));
    }
}
