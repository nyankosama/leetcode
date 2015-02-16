/**
 * @created: 2015/2/16
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/word-search/
 */
public class WordSearch {

    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    /**
     * dfs即可
     * @param board
     * @param word
     * @return
     */
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)
                        && dfs(board, i, j, word.substring(1, word.length()), new boolean[n][m])) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int x, int y, String word, boolean[][] marked) {
        if (word.length() == 0) return true;
        int n = board.length;
        int m = board[0].length;
        marked[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int newX = x + directions[i][0];
            int newY = y + directions[i][1];
            if (newX >= 0 && newX < n && newY >= 0 && newY < m
                    && board[newX][newY] == word.charAt(0)
                    && !marked[newX][newY]
                    && dfs(board, newX, newY, word.substring(1, word.length()), marked))
                return true;
        }
        return false;
    }

    public static void main(String args[]) {
        WordSearch s = new WordSearch();
        char[][] words = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        System.out.println(s.exist(words, "ABCCED"));
        System.out.println(s.exist(words, "SEE"));
        System.out.println(s.exist(words, "ABCB"));
    }
}
