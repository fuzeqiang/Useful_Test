package oj.test.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, find if the array contains any duplicates. <br/>
 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
 */
public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return false;
        }

        int length = nums.length;
        Map<Integer, Object> map = new HashMap<Integer, Object>();
        for (int i = 0; i < length; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            } else {
                map.put(nums[i], null);
            }
        }

        return false;
    }

    public static void main(String[] args) {
//        System.out.println(arr.length);
    }

}
