import com.sun.javafx.tk.PlatformImage;

/**
 * @created: 2015/2/8
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/palindrome-number/
 */
public class PalindromeNumber {

    /**
     * 先计算出数字的长度，然后左右遍历判断是否为回文
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int num = x;
        int digit = 0;
        while (num != 0) {
            num /= 10;
            digit++;
        }
        int leftDigit = 0, rightDigit = digit - 1;
        while (leftDigit <= rightDigit) {
            int left = (int) (x / Math.pow(10, leftDigit) % 10);
            int right = (int) (x / Math.pow(10, rightDigit) % 10);
            if (left != right) return false;
            leftDigit++;
            rightDigit--;
        }
        return true;
    }

    public static void main(String args[]) {
        PalindromeNumber s = new PalindromeNumber();
        System.out.println(s.isPalindrome(121));
    }
}
