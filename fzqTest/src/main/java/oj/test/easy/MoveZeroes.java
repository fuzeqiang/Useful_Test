package oj.test.easy;

import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * <br/>
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * <p/>
 * Note:<br/>
 * You must do this in-place without making a copy of the array.<br/>
 * Minimize the total number of operations.
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int zeroIndex = 0;

        for (int i = 0; i < length; i++) {
            if (0 != nums[i]) {
                int temp = nums[zeroIndex];
                nums[zeroIndex++] = nums[i];
                nums[i] = 0 == temp ? 0 : nums[i];
            }
        }
    }

    public static void main(String[] args) {
//        int[] arr = {2, 1};
////        int[] arr = {0, 1, 0, 3, 12};
//        System.out.println(Arrays.toString(arr));
//        new MoveZeroes().moveZeroes(arr);
//        System.out.println(Arrays.toString(arr));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(0x80000000);
        System.out.println(1 << 30);
    }

}
