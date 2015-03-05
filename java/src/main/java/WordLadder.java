import java.util.LinkedList;
import java.util.Set;

/**
 * @created: 2015/3/5
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/word-ladder/
 */
public class WordLadder {

    /**
     * BFS
     * @param start
     * @param end
     * @param dict
     * @return
     */
    public int ladderLength(String start, String end, Set<String> dict) {
        if (dict.size() == 0)
            return 0;

        dict.add(end);

        LinkedList<String> wordQueue = new LinkedList<>();
        LinkedList<Integer> distanceQueue = new LinkedList<>();

        wordQueue.add(start);
        distanceQueue.add(1);

        //track the shortest path
        int result = Integer.MAX_VALUE;
        while (!wordQueue.isEmpty()) {
            String currWord = wordQueue.pop();
            Integer currDistance = distanceQueue.pop();

            if (currWord.equals(end)) {
                result = Math.min(result, currDistance);
            }

            for (int i = 0; i < currWord.length(); i++) {
                char[] currCharArr = currWord.toCharArray();
                for (char c = 'a'; c <= 'z'; c++) {
                    currCharArr[i] = c;

                    String newWord = new String(currCharArr);
                    if (dict.contains(newWord)) {
                        wordQueue.add(newWord);
                        distanceQueue.add(currDistance + 1);
                        dict.remove(newWord);
                    }
                }
            }
        }
        if (result < Integer.MAX_VALUE)
            return result;
        else
            return 0;
    }
}
