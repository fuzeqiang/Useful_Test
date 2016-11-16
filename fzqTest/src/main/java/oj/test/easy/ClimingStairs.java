package oj.test.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * <p/>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimingStairs {

    public int climbStairs(int n) {
        int[] ways = {0};
        test(n, ways);
        return ways[0];
    }

    //time exceeded
    public void test(int n, int[] ways) {
        if (n > 0) {
            test(n - 1, ways);
            if (n >= 2) {
                test(n - 2, ways);
            }
        } else {
            ways[0]++;
        }
    }

    public int test2(int n) {
        int minSteps = (1 == n % 2) ? (n / 2 + 1) : (n / 2);
        int ways = 0;

        int oneSteps;
        int twoSteps;
        for (int steps = n; steps >= minSteps; steps--) {
            twoSteps = n - steps;
            oneSteps = steps - twoSteps;

            if (oneSteps == n) {
                ways++;
            } else {
                int temp1 = 1;
                int temp2 = 1;
                int tempSteps = steps;
                for (int i = 1; i <= twoSteps; i++) {
                    temp1 *= tempSteps--;//n=24时会有溢出
                    temp2 *= i;
                }
                ways += (temp1 / temp2);
            }
        }

        return ways;
    }

    public static Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    public static int[] arr = new int[50];
    static {
        map.put(1, 1);
        map.put(2, 2);

        arr[1] = 1;
        arr[2] = 2;
    }

    //斐波那契数列0，空间换时间
    public int fibonacci0(int n) {
        if (0 == arr[n]) {
            int re = fibonacci0(n - 1) + fibonacci0(n - 2);
            arr[n] = re;
        }

        return arr[n];
    }

    //斐波那契数列1，空间换时间
    public int fibonacci(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }

        int re = fibonacci(n - 1) + fibonacci(n - 2);
        map.put(n, re);
        return re;
    }

    //斐波那契数列2，递归速度太慢
    public int fibonacci2(int n) {
        if (1 == n) {
            return 1;
        }
        if (2 == n) {
            return 2;
        }

        return fibonacci2(n - 1) + fibonacci2(n - 2);
    }

    public static void main(String[] args) {
        ClimingStairs test = new ClimingStairs();
        System.out.println(test.fibonacci2(45));
        for (int i = 1; i < 46; i++) {
            System.out.println(i + ". " + test.test2(i) + " --- " + test.fibonacci(i));
        }
//        System.out.println(new ClimingStairs().climbStairs(10));
    }

}
