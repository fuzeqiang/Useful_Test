package oj.test.easy;

/**
 * Given an integer, write a function to determine if it is a power of two.
 */
public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        if (n < 1) {
            return false;
        }

        while (n % 2 == 0) {
            n = n >> 1;
        }
        return n == 1;
    }

    public static boolean test(int n) {
        if (n < 1) {
            return false;
        }

        return 1073741824 % n == 0;
    }

    public static void main(String[] args) {
        System.out.println(test(3));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(1024 * 1024 * 1024);
    }

}
