package oj.test.easy;

/**
 * Find the sum of all left leaves in a given binary tree.
 * <p/>
 * Example:
 * <p/>
 *          3
 *        / \
 *     9  20
 *        /  \
 *      15   7
 * <p/>
 * There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24.
 */
public class SumOfLeftLeaves {

    public int sumOfLeftLeaves(TreeNode root) {
        if (null == root) {
            return 0;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        if (null != left && null == left.left && null == left.right) {
            return left.val + sumOfLeftLeaves(right);
        }

        return sumOfLeftLeaves(left) + sumOfLeftLeaves(right);
    }

    public static void main(String[] args) {
        TreeNode n3 = new TreeNode(3);
        TreeNode n9 = new TreeNode(9);
        TreeNode n20 = new TreeNode(20);
        TreeNode n15 = new TreeNode(15);
        TreeNode n7 = new TreeNode(7);
        n3.left = n9;
        n3.right = n20;
        n20.left = n15;
        n20.right = n7;

        System.out.println(new SumOfLeftLeaves().sumOfLeftLeaves(n3));
    }

}
