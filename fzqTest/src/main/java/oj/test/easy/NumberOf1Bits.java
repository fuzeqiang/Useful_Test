package oj.test.easy;

/**
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
 * <p/>
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 */
public class NumberOf1Bits {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        String numStr = Integer.toBinaryString(n);

        int count = 0;
        for (char ch : numStr.toCharArray()) {
            if ('1' == ch) {
                count++;
            }
        }
        return count;
    }

    public static int test(int n) {
        int bit = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) != 0) {
                bit++;
            }
            n = n << 1;
        }
        return bit;
    }
    public static void main(String[] args) {
        //2147483648  4294967295
        System.out.println(Integer.MIN_VALUE);
        System.out.println(test(1));
    }
}
