package oj.test;

import java.util.Arrays;

/**
 * Given s = "hello", return "olleh".
 */
public class ReverseString {

    public String test(String s) {
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }

    public String reverseString(String s) {
        if ("".equals(s)) {
            return s;
        }

        char[] arr = s.toCharArray();
        int count = arr.length - 1;
        int half = count / 2;

        for (int i = half; i >= 0; i--) {
            char temp1 = arr[i];
            char temp2 = arr[count - i];
            arr[i] = temp2;
            arr[count - i] = temp1;
        }

        return new String(arr);
    }

    static int[] arr1 = {1, 2, 3, 4, 5};
    static int[] arr2 = {1, 2, 3, 4,};

    public void test(int[] arr) {
        int count = arr.length - 1;
        int half = count / 2;
        for (int i = half; i >= 0; i--) {
            int temp1 = arr[i];
            int temp2 = arr[count - i];
            arr[i] = temp2;
            arr[count - i] = temp1;
        }

        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        System.out.println(new ReverseString().reverseString(""));
//        new ReverseString().test(arr1);
//        new ReverseString().test(arr2);
    }
}
