package oj.test.contest.warm_up;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * <p/>
 * Examples: <br/>
 * s = "leetcode", return 0.<br/>
 * s = "loveleetcode", return 2.
 * <p/>
 * Note: You may assume the string contain only lowercase letters.
 */
public class FirstUniqueCharacterInAString {

    public int firstUniqChar(String s) {
        int length = s.length();
        boolean[] isRepeat = new boolean[length];

        for (int i = 0; i < length; i++) {
            if (isRepeat[i]) {
                continue;
            }

            for (int j = 0; j < length; j++) {
                if (j == i) {
                    continue;
                }

                if (0 == (s.charAt(i) ^ s.charAt(j)) ) {
                    isRepeat[j] = true;
                    isRepeat[i] = true;
                    break;
                }
            }
            if ((!isRepeat[i])) {
                return i;
            }
        }

        return -1;
    }

    public int test(String s) {
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

        for (int i = 0; i < length; i++) {
            if (1 == map.get(s.charAt(i))) {
                return i;
            }
        }

        return -1;
    }

    public int test2(String s) {
        int length = s.length();
        int[] countOfChar = new int['z' + 1];

        for (int i = 0; i < length; i++) {
            countOfChar[s.charAt(i)]++;
        }

        for (int i = 0; i < length; i++) {
            if (1 == countOfChar[s.charAt(i)]) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new FirstUniqueCharacterInAString().test2("loveleetcode"));
        System.out.println('z' - 'a');
    }

}
