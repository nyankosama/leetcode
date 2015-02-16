/**
 * @created: 2015/2/16
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/unique-binary-search-trees/
 */
public class UniqueBinarySearchTrees {

    /**
     * 动态规划
     * 观察规律可发现新添加一个节点后，原来的子树可以分别位于新节点的左下方和左上方
     * 然后子树还可以被拆分成更小的子树分别位于新节点的左下方和左上方，这时计算情况数把两个子树的个数相乘即可
     * @param n
     * @return
     */
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        if (n >= 1) dp[1] = 1;
        if (n >= 2) dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            int preSize = i - 1;
            for (int j = 0; j <= preSize; j++) {
                dp[i] += dp[preSize - j] * dp[j];
            }
        }
        return dp[n];
    }

    public static void main(String args[]) {
        UniqueBinarySearchTrees s = new UniqueBinarySearchTrees();
        System.out.println(s.numTrees(1));
        System.out.println(s.numTrees(2));
        System.out.println(s.numTrees(3));
    }
}
