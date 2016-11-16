package oj.test.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * <p/>
 * Example 1: Given s = "hello", return "holle".
 * <br/>
 * Example 2: Given s = "leetcode", return "leotcede".
 * <p/>
 * Note:The vowels does not include the letter "y".
 */
public class ReverseVowelsOfAString {


    public String reverseVowels(String s) {
        if (null == s) {
            return s;
        }
        int length = s.length();
        char[] arr = s.toCharArray();
        List<Character> tempChars = new ArrayList<Character>();
        List<Integer> tempIndex = new ArrayList<Integer>();

        for (int i = 0; i < length; i++) {
            char ch = arr[i];
            switch (ch) {
                case 'a' :
                    tempChars.add(ch);
                    tempIndex.add(i);
                    break;
                case 'e' :
                    tempChars.add(ch);
                    tempIndex.add(i);
                    break;
                case 'i' :
                    tempChars.add(ch);
                    tempIndex.add(i);
                    break;
                case 'o' :
                    tempChars.add(ch);
                    tempIndex.add(i);
                    break;
                case 'u' :
                    tempChars.add(ch);
                    tempIndex.add(i);
                    break;
                case 'A' :
                    tempChars.add(ch);
                    tempIndex.add(i);
                    break;
                case 'E' :
                    tempChars.add(ch);
                    tempIndex.add(i);
                    break;
                case 'I' :
                    tempChars.add(ch);
                    tempIndex.add(i);
                    break;
                case 'O' :
                    tempChars.add(ch);
                    tempIndex.add(i);
                    break;
                case 'U' :
                    tempChars.add(ch);
                    tempIndex.add(i);
                    break;
                default: break;
            }
        }

        length = tempChars.size();
        for (int i = 0; i < length; i++) {
            arr[tempIndex.get(length - 1 - i)] = tempChars.get(i);
        }

        return new String(arr);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseVowelsOfAString().reverseVowels("lacboe"));
    }

}
