/**
 * @created: 2015/2/11
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/count-and-say/
 */
public class CountAndSay {

    /**
     * 顺序便利数个数
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        String ret = String.valueOf(1);
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < n - 1; i++) {
            int count = 1;
            for (int j = 0; j < ret.length() - 1; j++) {
                if (ret.charAt(j) != ret.charAt(j + 1)) {
                    b.append(count).append(ret.charAt(j));
                    count = 1;
                } else {
                    count++;
                }
            }
            b.append(count).append(ret.charAt(ret.length() - 1));
            ret = b.toString();
            b = new StringBuilder();
        }
        return ret;
    }

    public static void main(String args[]) {
        CountAndSay s = new CountAndSay();
        System.out.println(s.countAndSay(2));
    }
}
