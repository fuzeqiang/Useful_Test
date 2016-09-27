package oj.test.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given  an  arbitrary  ransom  note  string  and  another  string  containing  letters from  all  the  magazines,  write  a  function  that  will  return  true  if  the  ransom   note  can  be  constructed  from  the  magazines ;  otherwise,  it  will  return  false.
 * <br/>
 * Each  letter  in  the  magazine  string  can  only  be  used  once  in  your  ransom  note.
 * <p/>
 * Note:
 * You may assume that both strings contain only lowercase letters.
 * <p/>
 * canConstruct("a", "b") -> false<br/>
 * canConstruct("aa", "ab") -> false<br/>
 * canConstruct("aa", "aab") -> true
 */
public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();

        int length = magazine.length();
        for (int i = 0; i < length; i++) {
            char ch = magazine.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

        length = ransomNote.length();
        for (int i = 0; i < length; i++) {
            char ch = ransomNote.charAt(i);
            if (map.containsKey(ch)) {
                int count = map.get(ch);
                if (count > 0) {
                    map.put(ch, count - 1);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }

        return true;
    }

    //优化算法
    public boolean test(String ransomNote, String magazine) {
        int ransomLength = ransomNote.length();
        int magazineLength = magazine.length();

        if (ransomLength > magazineLength) {
            return false;
        } else if (ransomLength == magazineLength) {
            int re = 0;
            for (int i = 0; i < ransomLength; i++) {
                re = ransomNote.charAt(i) ^ magazine.charAt(i);
            }

            if (0 == re) {
                return true;
            }
            return false;
        } else {
            int[] arr = new int['z' + 1];
            for (int i = 0; i < magazineLength; i++) {
                if (i < ransomLength) {
                    char ch1 = ransomNote.charAt(i);
                    arr[ch1]--;
                }

                char ch2 = magazine.charAt(i);
                arr[ch2]++;
            }

            for (int i = 'a'; i <= 'z'; i++) {
                if (0 > arr[i]) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println('a' ^ 'a');
        int[] arr = new int['z'];
        System.out.println(arr['z']);
    }

}
