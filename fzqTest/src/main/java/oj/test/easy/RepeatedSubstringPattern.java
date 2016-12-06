package oj.test.easy;

/**
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.
 * You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 * <pre>
 * Example 1:
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 *
 * Example 2:
 * Input: "aba"
 * Output: False
 *
 * Example 3:
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 * <pre/>
 */
public class RepeatedSubstringPattern {
    public boolean repeatedSubstringPattern(String str) {
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (0 == (length % (i + 1))) {
                String sub = str.substring(0, i + 1);
                boolean repeated = true;

                for (int j = 1; j < length / (i + 1); j++) {
                    String nextSub = str.substring(j * (i + 1), (j + 1) * (i + 1));
                    if (!sub.equals(nextSub)) {
                        repeated = false;
                        break;
                    }
                }
                if (repeated) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean test(String str) {
        int length = str.length();

        for (int i = 0; i < length / 2; i++) {
            if (0 == (length % (i + 1)) ) {
                char[] arr = str.substring(0, i + 1).toCharArray();
                boolean isBreak = false;

                for (int j = 1; j < length / (i + 1); j++) {
                    for (int k = 0; k < arr.length; k++) {
                        if (arr[k] != str.charAt(j * (i + 1) + k)) {
                            isBreak = true;
                            break;
                        }
                    }
                    if (isBreak) {
                        break;
                    }
                }

                if (!isBreak) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(new RepeatedSubstringPattern().test("abdab"));
    }
}
