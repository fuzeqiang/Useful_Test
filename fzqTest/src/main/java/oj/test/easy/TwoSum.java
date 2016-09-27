package oj.test.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given nums = [2, 7, 11, 15], target = 9,
 * <p/>
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {

    public static void main(String[] args) {
        TwoSum test = new TwoSum();
        int[] nums = {3, 2, 4};
        System.out.println(Arrays.toString(test.twoSum(nums, 6)));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int anNum = target - nums[i];
            if (numMap.containsKey(anNum)) {
                int anIndex = numMap.get(anNum);
                if (i != anIndex) {
                    return new int[] {i, anIndex};
                }
            }
        }

        return null;
    }
}
