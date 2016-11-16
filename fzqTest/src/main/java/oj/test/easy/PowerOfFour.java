package oj.test.easy;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 * <p/>
 * Example:
 * Given num = 16, return true. Given num = 5, return false.
 * <p/>
 * Follow up: Could you solve it without loops/recursion?
 */
public class PowerOfFour {

    public static final int[] arr = {1, 4, 16, 64, 256, 1024, 4096, 16384, 65536, 262144, 1048576, 4194304, 16777216, 67108864, 268435456, 1073741824};

    public boolean isPowerOfFour(int num) {
        for (int i : arr) {
            if (i == num) {
                return true;
            }
        }
        return false;
    }

    public boolean test(int num) {
        String bNum = Integer.toBinaryString(num);
        return bNum.matches("^10*$") && 1 == bNum.length() % 2;
    }

    public static void main(String[] args) {
        int num = 4;
        for (int i = 0; i < 15; i++) {
            num *= 4;
            System.out.println(num);
        }
        DataInputStream d;
        BufferedInputStream bufferedInputStream;
        FileInputStream f;
    }

}
