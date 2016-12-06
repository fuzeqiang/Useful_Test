package oj.test.easy;

/**
 * You are given a binary tree in which each node contains an integer value.
 * <br/>
 * Find the number of paths that sum to a given value.
 * <br/>
 * The path does not need to start or end at the root or a leaf, but it must go downwards (traveling only from parent nodes to child nodes).
 * <br/>
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 * <p/>
 * Example: root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 * <br/>
 *                     10
 *                   /  \
 *                 5   -3
 *               / \     \
 *             3   2    11
 *           / \   \
 *         3  -2   1
 * <p/>
 * Return 3. The paths that sum to 8 are:
 * <br/>
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 * <p/>
 * Definition for a binary tree node.<br/>
 * public class TreeNode {<br/>
 *     int val;<br/>
 *     TreeNode left;<br/>
 *     TreeNode right;<br/>
 *     TreeNode(int x) { val = x; }<br/>
 * }
 */
public class PathSumIII {
    public int pathSum(TreeNode root, int sum) {

        return 0;
    }

    public int test(TreeNode parent, TreeNode node, int sum, int valSum) {
        if (null == node) {
            return 0;
        }
        valSum += node.val;
        if (sum == valSum) {

        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(1000000 * 1000);
    }
}
