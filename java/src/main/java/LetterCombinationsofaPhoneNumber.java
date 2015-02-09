import java.util.ArrayList;
import java.util.List;

/**
 * @created: 2015/2/9
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationsofaPhoneNumber {

    /**
     * 递归
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        String trans[] = {"", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> set = new ArrayList<String>();
        StringBuilder seq = new StringBuilder();
        generate(trans, digits, 0, seq, set);
        return set;
    }

    private void generate(String trans[], String digits, int deep, StringBuilder result, List<String> set) {
        if (deep == digits.length()) {
            set.add(result.toString());
            return;
        }
        int currentDigit = digits.charAt(deep) - 48;
        for (int i = 0; i < trans[currentDigit].length(); i++) {
            result.append(trans[currentDigit].charAt(i));
            generate(trans, digits, deep + 1, result, set);
            result.deleteCharAt(result.length() - 1);
        }
    }

    public static void main(String args[]) {
        LetterCombinationsofaPhoneNumber s = new LetterCombinationsofaPhoneNumber();
        System.out.println(s.letterCombinations("23"));
    }
}
