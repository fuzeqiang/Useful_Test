package oj.test.easy;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * <br/>
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * <br/>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * <pre>
 * Example:
 * Given input array nums = [3,2,2,3], val = 3
 * Your function should return length = 2, with the first two elements of nums being 2.
 * </pre>
 */
public class RemoveElement {

    public int removeElement(int[] nums, int val) {
        int removeCount = 0;
        int length = nums.length;

        if (1 == length && val == nums[0]) {
            return 0;
        }

        for (int i = 0; i < length; i++) {
            if (length == i + removeCount) {
                break;
            }
            if (val == nums[i]) {
                int temp = nums[length - removeCount - 1];
                nums[length - removeCount - 1] = nums[i];
                nums[i] = temp;
                removeCount++;
                --i;
            }
        }
        return nums.length - removeCount;
    }

    public int test(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (val != nums[j]) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(new RemoveElement().removeElement(new int[]{3,  3}, 3));
    }

}
