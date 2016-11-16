package oj.test.easy;

/**
 * Related to question Excel Sheet Column Title
 * <br/>
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * <p/>
 * For example:<br/>
 * A -> 1<br/>
 * B -> 2<br/>
 * C -> 3<br/>
 * ...<br/>
 * Z -> 26<br/>
 * AA -> 27<br/>
 * AB -> 28
 */
public class ExcelSheetColumnNumber {

    public static final int[] NUMS = {  1,   2,  3,   4,   5,
                                                        6,  7,  8,   9,  10,
                                                        11, 12, 13, 14, 15,
                                                        16, 17, 18, 19, 20,
                                                        21, 22, 23, 24, 25,
                                                        26};

    public static final int[] DIGIT = new int[7];

    static {
        for (int i = 0; i < 7; i++) {
            DIGIT[i] = (int) Math.pow(26, i);
        }
    }

    public int titleToNumber(String s) {
        int length = s.length();
        int num = 0;

        for (int i = 0; i < length; i++) {
            num += (NUMS[s.charAt(i) - 'A'] * DIGIT[length - i - 1]);
        }

        return num;
    }

    public static void main(String[] args) {
//        System.out.println(new ExcelSheetColumnNumber().titleToNumber("ZZZZAA"));
        System.out.println(Math.pow(26, 7));
    }

}
