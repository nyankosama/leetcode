import java.util.ArrayList;

/**
 * @created: 2015/9/3
 * @author: nyankosama
 * @description: https://leetcode.com/problems/triangle/
 */
public class Triangle {

    //http://www.programcreek.com/2013/01/leetcode-triangle-java/
    //bottom-up dynamic programming
    public int minimumTotal(ArrayList<ArrayList<Integer>> triangle) {
        int[] total = new int[triangle.size()];
        int l = triangle.size() - 1;

        for (int i = 0; i < triangle.get(l).size(); i++) {
            total[i] = triangle.get(l).get(i);
        }

        // iterate from last second row
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i + 1).size() - 1; j++) {
                total[j] = triangle.get(i).get(j) + Math.min(total[j], total[j + 1]);
            }
        }

        return total[0];
    }
}
