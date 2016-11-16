package oj.test.easy;

import java.util.*;

/**
 * Given two arrays, write a function to compute their intersection.
 * <p/>
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * <p/>
 * Note:<br/>
 * Each element in the result must be unique.<br/>
 * The result can be in any order.
 */
public class IntersectionOfTwoArrays {

    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Object> map = new HashMap<Integer, Object>();
        Object obj = null;

        for (int num : nums1) {
            map.put(num, obj);
        }

        List<Integer> list = new ArrayList<Integer>();
        for (int num : nums2) {
            if (map.containsKey(num)) {
                list.add(num);
                map.remove(num);
            }
        }

        int size = list.size();
        int[] re = new int[size];
        for (int i = 0; i < size; i++) {
            re[i] = list.get(i);
        }
        return re;
    }

    public int[] test(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<Integer>();
        for (int num1 : nums1) {
            for (int num2 : nums2) {
                if (0 == (num1 ^ num2)) {
                    set.add(num1);
                    break;
                }
            }
        }

        int count = 0;
        int[] re = new int[set.size()];
        for (int num : set) {
            re[count++] = num;
        }

        return re;
    }

}
