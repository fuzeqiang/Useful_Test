package oj.test.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a roman numeral, convert it to an integer.
 * <p/>
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class Roman2Integer {

//    public static Map<Character, Integer> map = new HashMap();
    public static int[] arr = new int['Z'];

    static {
//        map.put('I', 1);
//        map.put('X', 10);
//        map.put('C', 100);
//        map.put('M', 1000);
//        map.put('V', 5);
//        map.put('L', 50);
//        map.put('D', 500);
        arr['I'] = 1;
        arr['X'] = 10;
        arr['C'] = 100;
        arr['M'] = 1000;
        arr['V'] = 5;
        arr['L'] = 50;
        arr['D'] = 500;
    }

    public int romanToInt(String s) {
        int length = s.length();
        int re = 0;

        int preInt = 0;
        for (int i = 0; i < length; i++) {
            int currentInt = arr[s.charAt(i)];
            if (preInt == 0 || preInt >= currentInt) {
                re += currentInt;
            } else {
                re = re - 2 * preInt + currentInt;
            }
            preInt = currentInt;
        }
        return re;
    }

}
