package oj.test;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 */
public class SingleNumber {
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i] + 1));
            } else {
                map.put(nums[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> en : map.entrySet()) {
            if (1 == en.getValue()) {
                return en.getKey();
            }
        }

        return -1;
    }

    public int test(int[] nums) {
        int re = nums[0];
        for (int i = 1; i < nums.length; i++) {
            re = re ^ nums[i];
        }

        return re;
    }
}
