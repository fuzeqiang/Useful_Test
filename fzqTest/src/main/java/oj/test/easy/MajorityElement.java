package oj.test.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of size n, find the majority element. The majority element is the element that appears more than "n/2" times.
 * <p/>
 * You may assume that the array is non-empty and the majority element always exist in the array.
 */
public class MajorityElement {

    public int majorityElement(int[] nums) {
        int length = nums.length;
        int majorityCount = length / 2 + 1;

        if (1 == length) {
            return nums[0];
        }

        Arrays.sort(nums);
        int majorityNum = nums[0];
        int count = 1;
        for (int i = 1; i < length; i++) {
            int temp = nums[i];
            if (majorityNum == temp) {
                count++;
                if (count >= majorityCount) {
                    break;
                }
            } else {
                majorityNum = temp;
                count = 1;
            }
        }

        return majorityNum;
    }

    public int test(int[] nums) {
        int length = nums.length;
        if (1 == length) {
            return nums[0];
        }

        int majorityCount = length / 2 + 1;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i = 0; i < length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                int temp = map.get(num) + 1;
                if (temp == majorityCount) {
                    return num;
                }
                map.put(num, temp);
            } else {
                map.put(num, 1);
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(new MajorityElement().test(nums));
    }

}
