import java.util.*;

/**
 * @created: 2015/2/10
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/4sum/
 */
public class FourSum {

    /**
     * 可以在2sum的基础上解决这个问题，同样用hashMap来存储，做一个O(n^2)的预处理
     * 思路详见：http://www.cnblogs.com/tenosdoit/p/3649607.html
     *
     * @param num
     * @param target
     * @return
     */
    public List<List<Integer>> fourSum(int[] num, int target) {
        Arrays.sort(num);
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Set<List<Integer>> set = new HashSet<List<Integer>>();
        if (num.length < 4) return ret;
        Map<Integer, List<Pair<Integer, Integer>>> preMap = new HashMap<Integer, List<Pair<Integer, Integer>>>();
        for (int i = 0; i < num.length - 1; i++) {
            for (int j = i + 1; j < num.length; j++) {
                int sum = num[i] + num[j];
                if (preMap.containsKey(sum)) {
                    List<Pair<Integer, Integer>> tmp = preMap.get(sum);
                    tmp.add(new Pair<Integer, Integer>(i, j));
                    preMap.put(sum, tmp);
                } else {
                    List<Pair<Integer, Integer>> tmp = new ArrayList<Pair<Integer, Integer>>();
                    tmp.add(new Pair<Integer, Integer>(i, j));
                    preMap.put(sum, tmp);
                }
            }
        }

        for (int i = 0; i < num.length - 1; i++) {
            for (int j = i + 1; j < num.length; j++) {
                int sum = num[i] + num[j];
                if (preMap.containsKey(target - sum)) {
                    List<Pair<Integer, Integer>> tmp = preMap.get(target - sum);
                    for (Pair<Integer, Integer> pair : tmp) {
                        if (pair.first != i && pair.first != j
                                && pair.second != i && pair.second != j) {
                            List<Integer> seq = new ArrayList<Integer>();
                            seq.addAll(Arrays.asList(num[i], num[j], num[pair.first], num[pair.second]));
                            Collections.sort(seq);
                            set.add(seq);
                        }
                    }
                }
            }
        }

        ret.addAll(set);
        return ret;
    }

    private class Pair<T1, T2> {
        T1 first;
        T2 second;

        private Pair(T1 first, T2 second) {
            this.first = first;
            this.second = second;
        }
    }

    public static void main(String args[]) {
        FourSum s = new FourSum();
        int num[] = {1, 0, -1, 0, -2, 2};
        List<List<Integer>> ret = s.fourSum(num, 0);
        for (List<Integer> nums : ret) {
            System.out.println("");
            for (Integer n : nums) {
                System.out.print(n + " ");
            }
        }
    }
}

