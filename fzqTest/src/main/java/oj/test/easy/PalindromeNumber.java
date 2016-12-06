package oj.test.easy;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (0 > x) {
            return false;
        }
        if (10 > x) {
            return true;
        }

        int temp = x;
        int re = x % 10;
        x /= 10;
        while (10 <= x) {
            re = re * 10 + (x % 10);
            x /= 10;
        }
        re = re * 10 + x;
        System.out.println(re);
        return temp == re;
    }


    public static void main(String[] args) {
        int x = 1001;
        System.out.println(new PalindromeNumber().isPalindrome(x));
    }
}
