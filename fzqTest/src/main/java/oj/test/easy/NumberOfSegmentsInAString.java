package oj.test.easy;

import java.util.Arrays;

/**
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
 * Please note that the string does not contain any non-printable characters.
 * <pre>
 * Example:
 * Input: "Hello, my name is John"
 * Output: 5
 * <pre/>
 */
public class NumberOfSegmentsInAString {
    public int countSegments(String s) {
        if (null == s || s.isEmpty()) {
            return 0;
        }

//        String[] arr = s.split(" [1,]");
//        System.out.println(Arrays.toString(arr));
//        return arr.length;
        s = s.trim();
        int re = 0;
        int length = s.length();
        for (int i = 0; i < length; i++) {
            if (i < length - 1) {
                if (' ' == s.charAt(i) && ' ' != s.charAt(i + 1)) {
                    re++;
                }
            } else {
                if (' ' != s.charAt(i)) {
                    re++;
                }
            }
        }
        return re;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOfSegmentsInAString().countSegments("  a, b,  c  "));
    }
}
