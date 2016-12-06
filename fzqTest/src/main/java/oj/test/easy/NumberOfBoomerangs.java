package oj.test.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given n points in the plane that are all pairwise distinct,
 * a "boomerang" is a tuple of points (i, j, k) such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
 * Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are all in the range [-10000, 10000] (inclusive).
 * <pre>
 * Example:
 * Input: [[0,0],[1,0],[2,0]]
 * Output: 2
 * Explanation:The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 * </pre>
 */
public class NumberOfBoomerangs {

    public int numberOfBoomerangs(int[][] points) {
        int length = points.length;
        if (3 > length) {
            return 0;
        }

        int re = 0;
        Map<Integer, Integer> map;
        for (int i = 0; i < length; i++) {
            map = new HashMap<Integer, Integer>();
            int[] p1 = points[i];

            for (int j = 0; j < length; j++) {
                int[] p2 = points[j];
                int temp = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
                if (map.containsKey(temp)) {
                    map.put(temp, map.get(temp) + 1);
                } else {
                    map.put(temp, 1);
                }
            }

            for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                int value = entry.getValue();
                if (1 < value) {
                    re += (value * (value - 1));
                }
            }
        }

        return re;
    }

    public static void main(String[] args) {
        int[][] points = {
                {0, 0},
                {1, 0},
                {2, 0}
        };
        System.out.println(new NumberOfBoomerangs().numberOfBoomerangs(points));
    }

}
