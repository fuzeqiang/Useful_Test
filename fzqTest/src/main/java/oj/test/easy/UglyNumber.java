package oj.test.easy;

/**
 * Write a program to check whether a given number is an ugly number.
 * <p/>
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
 * <p/>
 * Note that 1 is typically treated as an ugly number.
 */
public class UglyNumber {

    public boolean test1(int num) {
        if (0 >= num) {
            return false;
        }

        boolean isDivisibleBy5 = 0 == num % 5;
        boolean isDivisibleBy3 = 0 == num % 3;
        boolean isDivisibleBy2 = 0 == num % 2;
        while (isDivisibleBy5 || isDivisibleBy3 || isDivisibleBy2) {
            num = isDivisibleBy5 ? num / 5 : num;
            num = isDivisibleBy3 ? num / 3 : num;
            num = isDivisibleBy2 ? num / 2 : num;
            isDivisibleBy5 = 0 == num % 5;
            isDivisibleBy3 = 0 == num % 3;
            isDivisibleBy2 = 0 == num % 2;
        }
        return 1 == num;
    }

    public boolean isUgly(int num) {
        while (0 == num % 2) {
            num >>= 1;
        }
        while (0 == num % 3) {
            num /= 3;
        }
        while (0 == num % 5) {
            num /= 5;
        }

        return 1 == num;
    }

    public static void main(String[] args) {
        System.out.println(new UglyNumber().test1(6));
    }

}
