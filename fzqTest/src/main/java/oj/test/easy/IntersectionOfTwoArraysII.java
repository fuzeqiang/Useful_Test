package oj.test.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by fuzeqiang(100918) on 2016/10/10 0010.
 */
public class IntersectionOfTwoArraysII {

    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> re = new ArrayList<Integer>();
        for (int num : nums1) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (int num : nums2) {
            if (map.containsKey(num) && 0 < map.get(num)) {
                map.put(num, map.get(num) - 1);
                re.add(num);
            }
        }

        int[] arr = new int[re.size()];
        for (int i = 0; i < re.size(); i++) {
            arr[i] = re.get(i);
        }

        return arr;
    }

}
