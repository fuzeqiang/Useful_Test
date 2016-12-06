package oj.test.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
 * <br/>
 * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
 * <br/>
 * The order of output does not matter.
 * <pre>
 * Example 1:
 *  Input: s: "cbaebabacd" p: "abc"
 *  Output: [0, 6]
 *  Explanation:
 *  The substring with start index = 0 is "cba", which is an anagram of "abc".
 *  The substring with start index = 6 is "bac", which is an anagram of "abc".
 *
 * Example 2:
 *  Input: s: "abab" p: "ab"
 *  Output: [0, 1, 2]
 *  Explanation:
 *  The substring with start index = 0 is "ab", which is an anagram of "ab".
 *  The substring with start index = 1 is "ba", which is an anagram of "ab".
 *  The substring with start index = 2 is "ab", which is an anagram of "ab".
 * </pre>
 */
public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> re = new ArrayList<Integer>();
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        char[] sArr = s.toCharArray();
        char[] pArr = p.toCharArray();

        for (char ch : pArr) {
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        Map<Character, Integer> temp = new HashMap<Character, Integer>();
        temp.putAll(map);
        for (int i = 0; i < sArr.length; i++) {
            if (temp.containsKey(sArr[i])) {
                if (i + pArr.length > sArr.length) {
                    break;
                }

                temp.put(sArr[i], temp.get(sArr[i]) - 1);
                boolean isBreak = false;
                for (int j = 1; j < pArr.length; j++) {
                    if (temp.containsKey(sArr[i + j])) {
                        temp.put(sArr[i + j], temp.get(sArr[i + j]) - 1);
                    } else {
                        i = i + j;
                        temp = new HashMap<Character, Integer>();
                        temp.putAll(map);
                        isBreak = true;
                        break;
                    }
                }

                if (!isBreak) {
                    int sum = 0;
                    for (Map.Entry<Character, Integer> en : temp.entrySet()) {
                        if (en.getValue() < 0) {
                            sum = -1;
                            break;
                        }
                        sum += en.getValue();
                    }
                    if (0 == sum) {
                        re.add(i);
                    }
                    temp = new HashMap<Character, Integer>();
                    temp.putAll(map);
                }
            }
        }

        return re;
    }

    public static void main(String[] args) {
        System.out.println(new FindAllAnagramsInAString().findAnagrams("abab", "ab"));
    }
}
