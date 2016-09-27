package oj.test.easy;

/**
 * Invert a binary tree.
 * <p/>
 *           4
 *        /   \
 *      2     7
 *   / \   / \
 * 1   3 6   9
 * to
 *           4
 *        /   \
 *      7     2
 *    / \   / \
 *  9   6 3   1
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (null != root) {
            TreeNode left = root.left;
            TreeNode right = root.right;

            TreeNode temp = left;
            root.left = right;
            root.right = temp;

            invertTree(left);
            invertTree(right);
        }

        return root;
    }
}
