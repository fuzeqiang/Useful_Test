package oj.test.easy;

/**
 * Given an integer, write an algorithm to convert it to hexadecimal. For negative integer, two’s complement method is used.
 * <p/>
 * Note:
 * <br/>
 * 1. All letters in hexadecimal (a-f) must be in lowercase.<br/>
 * 2. The hexadecimal string must not contain extra leading 0s. <br/>
 *     &nbsp;&nbsp;&nbsp;&nbsp; If the number is zero, it is represented by a single zero character '0'; <br/>
 *     &nbsp;&nbsp;&nbsp;&nbsp; otherwise, the first character in the hexadecimal string will not be the zero character.<br/>
 * 3. The given number is guaranteed to fit within the range of a 32-bit signed integer.<br/>
 * 4.You must not use any method provided by the library which converts/formats the number to hex directly.<br/>
 * <p/>
 * Example 1:
 * <br/>
 * Input: 26 <br/>
 * Output: "1a"
 * <p/>
 * Example 2:
 * <br/>
 * Input: -1
 * <br/>
 * Output: "ffffffff"
 */
public class ConvertANumber2Hexadecimal {

    public static final String[] HEX_NUM = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};

    public static String toHex(int num) {
        String re = "";
        while (16 <= num) {
            int remainder = num % 16;
            num = num >> 4;
            re = HEX_NUM[remainder] + re;
        }
        re = HEX_NUM[num] + re;

        return re;
    }

    public static void main(String[] args) {
        System.out.println(toHex(Integer.MAX_VALUE));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MAX_VALUE + 1);
    }

}
