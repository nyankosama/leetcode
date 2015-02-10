import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @created: 2015/2/10
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/generate-parentheses/
 */
public class GenerateParentheses {

    /**
     * 递归
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<String>();
        if (n <= 0) return ret;
        generate(new Stack<Character>(), n, n, new StringBuilder(), ret);
        return ret;
    }

    private void generate(Stack<Character> stack, int leftN, int rightN, StringBuilder seq, List<String> ret) {
        if (rightN == 0) {
            ret.add(seq.toString());
            return;
        }
        if (leftN != 0) {
            seq.append('(');
            stack.push('(');
            generate(stack, leftN - 1, rightN, seq, ret);
            seq.deleteCharAt(seq.length() - 1);
            stack.pop();
            if (!stack.isEmpty() && stack.peek() == '(') {
                seq.append(')');
                stack.pop();
                generate(stack, leftN, rightN - 1, seq, ret);
                seq.deleteCharAt(seq.length() - 1);
                stack.push('(');
            }
        } else {
            stack.pop();
            seq.append(')');
            generate(stack, leftN, rightN - 1, seq, ret);
            stack.push('(');
            seq.deleteCharAt(seq.length() - 1);
        }
    }

    public static void main(String args[]) {
        GenerateParentheses s = new GenerateParentheses();
        for (String str : s.generateParenthesis(2)) {
            System.out.println(str);
        }
    }
}
