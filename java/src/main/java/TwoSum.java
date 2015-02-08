import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * @created: 2015/2/8
 * @author: nyankosama
 * @description: https://oj.leetcode.com/problems/two-sum/
 */
public class TwoSum {

    /**
     * 思路：
     * 使用类似threeSum的two pointers的方法
     * 需要使用index数组来记录index
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        final int copy[] = new int[numbers.length];
        Integer index[] = new Integer[numbers.length];
        System.arraycopy(numbers, 0, copy, 0, numbers.length);
        for (int i = 0; i < index.length; i++) {
            index[i] = i;
        }
        Arrays.sort(index, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return new Integer(copy[o1]).compareTo(copy[o2]);
            }
        });
        int begin = 0;
        int end = numbers.length - 1;
        while (begin < end) {
            int sum = numbers[index[begin]] + numbers[index[end]];
            if (sum > target) end--;
            else if (sum < target) begin++;
            else {
                int ret[] = new int[]{index[begin] + 1, index[end] + 1};
                Arrays.sort(ret);
                return ret;
            }
        }
        return null;
    }

    /**
     * 利用hashMap巧妙记录位置
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum2(int[] numbers, int target) {
        HashMap<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        int ret[] = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            if (indexMap.containsKey(numbers[i])) {
                int index = indexMap.get(numbers[i]);
                ret[0] = index + 1;
                ret[1] = i + 1;
            } else {
                indexMap.put(target - numbers[i], i);
            }
        }
        return ret;
    }

    public static void main(String args[]) {
        TwoSum s = new TwoSum();
        int a[] = {-1,-2,-3,-4,-5};
        int ret[] = s.twoSum(a, -8);
        for (int i : ret) {
            System.out.println(i);
        }
    }
}
