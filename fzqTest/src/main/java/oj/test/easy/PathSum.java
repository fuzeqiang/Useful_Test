package oj.test.easy;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.
 * <p/>
 * For example: Given the below binary tree and sum = 22,<br/>
 *                5
 *              /  \
 *            4    8
 *          /     / \
 *       11    13   4
 *     /  \           \
 *   7    2            1
 * <br/>
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.<br/>
 * Definition for a binary tree node.<br/>
 * public class TreeNode {<br/>
 *     int val;<br/>
 *     TreeNode left;<br/>
 *     TreeNode right;<br/>
 *     TreeNode(int x) { val = x; }<br/>
 * }
 */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (null == root) {
            return false;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        if (null == left && null == right) {
            return 0 == sum - root.val;
        }

        return hasPathSum(left, sum - root.val) || hasPathSum(right, sum - root.val);
    }

    public static void main(String[] args) {
        TreeNode n5 = new TreeNode(5);
        TreeNode n4 = new TreeNode(4);
        TreeNode n8 = new TreeNode(8);
        TreeNode n11 = new TreeNode(11);
        TreeNode n13 = new TreeNode(13);
        TreeNode n4a = new TreeNode(4);
        TreeNode n7 = new TreeNode(7);
        TreeNode n2 = new TreeNode(2);
        TreeNode n1 = new TreeNode(1);

        n5.left = n4;
        n5.right = n8;

        n4.left = n11;

        n8.left = n13;
        n8.right = n4a;

        n11.left = n7;
        n11.right = n2;

        n4a.right = n1;
        System.out.println(new PathSum().hasPathSum(n5, 22));
    }
}
