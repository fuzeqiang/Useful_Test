package oj.test.easy;

import java.util.Arrays;

/**
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * <p/>
 * For example,<br/>
 * s = "anagram", t = "nagaram", return true.<br/>
 * s = "rat", t = "car", return false.
 * <p/>
 * Note:
 * You may assume the string contains only lowercase alphabets.
 */
public class ValidAnagram {

    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        int length = s.length();

        if (s == t || length != t.length()) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            arr[s.charAt(i) - 'a']++;
            arr[t.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (0 < arr[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidAnagram().isAnagram("ab", "ba"));
    }

}
