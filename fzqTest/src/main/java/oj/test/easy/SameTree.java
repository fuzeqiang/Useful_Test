package oj.test.easy;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * <br/>
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 */
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q) {
            return true;
        } else if (p == null || q == null) {
            return false;
        } else {
            return p.val == q.val ? (isSameTree(p.left, q.left) && isSameTree(p.right, q.right)) : false;
        }
    }

}
