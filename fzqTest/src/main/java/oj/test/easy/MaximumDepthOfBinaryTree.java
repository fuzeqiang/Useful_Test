package oj.test.easy;

/**
 * Given a binary tree, find its maximum depth.
 * <p/>
 * The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
public class MaximumDepthOfBinaryTree {

    int maxDepth = 0;
    int depth = 0;

    public int maxDepth(TreeNode root) {
        if(null == root) {
            return 0;
        }

        depth++;
        boolean isLNull = null == root.left;
        boolean isRNull = null == root.right;

        if (isLNull && isRNull) {
            if (depth > maxDepth) {
                maxDepth = depth;
            }
        }

        if (!isLNull) {
            maxDepth(root.left);
        }

        if (!isRNull) {
            maxDepth(root.right);
        }

        depth--;
        return maxDepth;
    }

}
