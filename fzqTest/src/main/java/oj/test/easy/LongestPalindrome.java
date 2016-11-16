package oj.test.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.
 * <br/>
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * <p/>
 * Note: Assume the length of given string will not exceed 1,010.
 * <p/>
 * Example: <br/>
 * Input: "abccccdd"
 * <br/>
 * Output: 7
 * <p/>
 * Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        int length = s.length();
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        for (int i = 0; i < length; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        int re = 0;
        boolean hasSingle = false;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            if (count > 0) {
                if (1 == count % 2) {
                    hasSingle = true;
                    re += (count - 1);
                } else {
                    re += count;
                }
            }
        }

        if (hasSingle) {
            re++;
        }

        return re;
    }

    public int test(String s) {
        int length = s.length();
        int[] arr = new int['z' + 1];

        for (int i = 0; i < length; i++) {
            arr[s.charAt(i)]++;
        }

        int re = 0;
        boolean hasSingle = false;
        for (int count : arr) {
            if (count > 0) {
                if (1 == count % 2) {
                    hasSingle = true;
                    re += (count - 1);
                } else {
                    re += count;
                }
            }
        }
        if (hasSingle) {
            re++;
        }

        return re;
    }

    public static void main(String[] args) {
        System.out.println(new LongestPalindrome().longestPalindrome("abccccdd"));
        System.out.println(new LongestPalindrome().test("abccccdd"));

    }

}
