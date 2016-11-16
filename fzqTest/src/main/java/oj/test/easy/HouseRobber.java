package oj.test.easy;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, <br/>
 * the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and <br/>
 * it will automatically contact the police if two adjacent houses were broken into on the same night.
 * <p/>
 * Given a list of non-negative integers representing the amount of money of each house, <br/>
 * determine the maximum amount of money you can rob tonight without alerting the police.
 */
public class HouseRobber {

    public int rob(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return 0;
        }

        if (1 == nums.length) {
            return nums[0];
        }

        int[] re = new int[1];
        rob(nums, re, 0, 0);
        rob(nums, re, 1, 0);

        return re[0];
    }

    //穷举法，性能差
    private void rob(int[] nums, int[] re, int index, int sum) {
        if (index >= nums.length) {
            return;
        }
        rob(nums, re, index + 1, sum);

        sum += nums[index];
        if (re[0] < sum) {
            re[0] = sum;
        }
        rob(nums, re, index + 2, sum);
    }


    public static void main(String[] args) {
//        int[] houses = {1, 2, 9, 11, 3};
//        System.out.println(new HouseRobber().rob(houses));
        String s = "123";
        String s1 = new String(new char[]{'1', '2'});
        String s2 = new String(new char[]{'1', '2'});
        System.out.println(s2.equals(s1));
        int code = s1.hashCode();
        System.out.println("s1 hash:" + code);
        System.out.println("s2 hash:" + s2.hashCode());
    }
}
