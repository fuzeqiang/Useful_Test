package oj.test.easy;

import java.util.Arrays;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.<br/>
 * For example, Given input array nums = [1,1,2],
 * <br/>
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively. It doesn't matter what you leave beyond the new length.
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return 0;
        }
        int count = 0;
        int duplicateCheck = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (0 == i) {
                count++;
            } else {
                if (duplicateCheck != nums[i]) {
                    nums[count++] = nums[i];
                    duplicateCheck = nums[i];
                }
            }
        }

        return count;
    }

    public int test(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return 0;
        }
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[count] != nums[i]) {
                nums[++count] = nums[i];
            }
        }
        return count + 1;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 2};

        System.out.println(Arrays.toString(nums));
        System.out.println(new RemoveDuplicatesFromSortedArray().removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }

}
