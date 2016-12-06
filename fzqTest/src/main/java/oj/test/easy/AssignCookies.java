package oj.test.easy;

import java.util.*;

/**
 * Assume you are an awesome parent and want to give your children some cookies.
 * But, you should give each child at most one cookie.
 * Each child i has a greed factor gi, which is the minimum size of a cookie that the child will be content with; and each cookie j has a size sj.
 * If sj >= gi, we can assign the cookie j to the child i, and the child i will be content.
 * Your goal is to maximize the number of your content children and output the maximum number.
 * <p/>
 * Note:
 * You may assume the greed factor is always positive.
 * You cannot assign more than one cookie to one child.
 * <pre>
 * Example 1:
 *  Input: [1,2,3], [1,1]
 *  Output: 1
 *  Explanation: You have 3 children and 2 cookies. The greed factors of 3 children are 1, 2, 3.
 *                  And even though you have 2 cookies, since their size is both 1, you could only make the child whose greed factor is 1 content.
 *                  You need to output 1.
 *
 * Example 2:
 *  Input: [1,2], [1,2,3]
 *  Output: 2
 *  Explanation: You have 2 children and 3 cookies. The greed factors of 2 children are 1, 2.
 *              You have 3 cookies and their sizes are big enough to gratify all of the children,
 *              You need to output 2.
 * <pre/>
 */
public class AssignCookies {

    //当s或者g中数很大，且相差很大时，性能很差
    public int findContentChildren(int[] g, int[] s) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int greedFactor : g) {
            if (map.containsKey(greedFactor)) {
                map.put(greedFactor, map.get(greedFactor) + 1);
            } else {
                map.put(greedFactor, 1);
            }
        }

        int re = 0;
        for (int cookie : s) {
            while (cookie > 0 && !map.containsKey(cookie)) {
                cookie--;
            }
            if (cookie > 0) {
                int gNum = map.get(cookie);
                if (gNum > 1) {
                    map.put(cookie, gNum - 1);
                } else {
                    map.remove(cookie);
                }
                re++;
            }
        }

        return re;
    }

    //优化算法，主要耗时在数组排序上
    public int test(int[] g , int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int re = 0;
        int j = g.length - 1;
        for (int i = s.length - 1; i >= 0 && j >=0; ) {
            if (s[i] >= g[j]) {
                re++;
                i--;
            }
            j--;
        }

        return re;
    }

    public static void main(String[] args) {
        int[] g = {1, 3, 2};
        int[] s = {1, 2};
        System.out.println(new AssignCookies().test(s, g));
    }
}
