package oj.test.easy;

/**
 * Given an integer, write a function to determine if it is a power of three.
 * <p/>
 * Follow up: Could you do it without using any loop / recursion?
 */
public class PowerOfThree {

    public boolean isPowerOfThree(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 3 == 0) {
            n = n / 3;
        }

        return n == 1;
    }

    public static boolean test(int n) {
        if (n < 1) {
            return false;
        }
        return Integer.toString(n, 3).matches("10*");
    }

    public static void main(String[] args) {
        System.out.println(test(333));
    }
}
