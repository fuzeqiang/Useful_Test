package oj.test.easy;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note: Your solution should be in logarithmic time complexity.
 */
public class FactorialTrailingZeroes {

    public int trailingZeroes(int n) {
        int count = 0;

        int temp = 5;
        int re = n / temp;
        while (0 < re) {
            count += re;
            temp *= 5;
            re = n / temp;
            if (temp == 1220703125) {
                count += re;
                break;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(new FactorialTrailingZeroes().trailingZeroes(1808548329));
//        System.out.println(Integer.MAX_VALUE);
//        System.out.println((int)Math.pow(5, 13));
    }

}
