package oj.test.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom represent the minutes (0-59).
 * <br/>
 * Each LED represents a zero or one, with the least significant bit on the right.
 * <br/>
 * Given a non-negative integer n which represents the number of LEDs that are currently on, return all possible times the watch could represent.
 * <p/>
 * Example:
 * <br/>
 * Input: n = 1<br/>
 * Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 * <p/>
 * Note:<br/>
 * The order of output does not matter.<br/>
 * The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".<br/>
 * The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".<br/>
 */
public class BinaryWatch {

    public static final int[] HOURS_BINARY = {8, 4, 2, 1};
    public static final int[] MINITES_BINARY = {32, 16, 8, 4, 2, 1};
    public static final String[] HOURS = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};
    public static final String[] MINITES = {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09",
                                                                "10",  "11",  "12", "13",  "14",  "15", "16",  "17",  "18", "19",
                                                                "20", "21", "22", "23", "24", "25", "26", "27", "28", "29",
                                                                "30", "31", "32", "33", "34", "35", "36", "37", "38", "39",
                                                                "40", "41", "42", "43", "44", "45", "46", "47", "48", "49",
                                                                "50", "51", "52", "53", "54", "55", "56", "57", "58", "59"};


    public List<String> readBinaryWatch(int num) {
        List<String> re = new ArrayList<String>();
        if (0 == num) {
            re.add("0:00");
            return re;
        }

        if (num <= 8) {
            int maxHourLEDNum = num > 3 ? 3 : num;
            int maxMinuteLEDNum = num > 5 ? 5 : num;

            int hour;
            int minute;
            for (int i = 1; i <= num; i++) {
                hour = i;
                minute = num - i;
                if (hour <= maxHourLEDNum && minute <= maxMinuteLEDNum) {
                    //获取小时分钟的全部可能值，并进行全组合
                }
            }
        }

        return re;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int i = 3;
        while (i >= 1) {

        }
    }

    public void test(int[] nums, int n) {
        if (n == 0) {
            System.out.println();
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + ", ");

        }
    }

}
