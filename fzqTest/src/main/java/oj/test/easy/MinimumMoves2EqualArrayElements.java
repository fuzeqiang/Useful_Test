package oj.test.easy;

/**
 * Given a non-empty integer array of size n, find the minimum number of moves required to make all array elements equal, where a move is incrementing n - 1 elements by 1.
 * <p/>
 * Example:<br/>
 * Input: [1,2,3]
 * <br/>
 * Output: 3
 * <p/>
 * Explanation: Only three moves are needed (remember each move increments two elements):
 * <br/>
 * [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 */
public class MinimumMoves2EqualArrayElements {
    public int minMoves(int[] nums) {
//        int moves = 0;
        int minNum = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (num < minNum) {
                minNum = num;
            }
            sum += num;
        }
//        for (int num : nums) {
//            moves += num - minNum;
//        }
//        return moves;
        return sum - minNum * nums.length;
    }
}
