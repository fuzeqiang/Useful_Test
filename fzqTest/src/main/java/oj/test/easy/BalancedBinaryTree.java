package oj.test.easy;

/**
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as a
 * binary tree in which the depth of the two subtrees of every
 * node never differ by more than 1.
 * <pre>
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * </pre>
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (null == root) {
            return true;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }


}
