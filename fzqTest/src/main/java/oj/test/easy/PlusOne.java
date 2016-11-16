package oj.test.easy;

/**
 * Given a non-negative number represented as an array of digits, plus one to the number.
 * <br/>
 * The digits are stored such that the most significant digit is at the head of the list.
 */
public class PlusOne {

    public int[] plusOne(int[] digits) {
        int carry = 1;
        int length = digits.length;

        for (int i = length - 1; i >= 0; i--) {
            int re = digits[i] + carry;
            if (re >= 10) {
                carry = 1;
                digits[i] = re - 10;
            } else {
                carry = 0;
                digits[i] = re;
            }
        }

        if (0 == carry) {
            return digits;
        } else {
            int[] re = new int[length + 1];
            re[0] = 1;
            for (int i = 0; i < length; i++) {
                re[i + 1] = digits[i];
            }
            return re;
        }
    }

    public static void main(String[] args) {
        new PlusOne().plusOne(new int[]{0});
    }

}
