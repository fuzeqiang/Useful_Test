package oj.test.easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * <p/>
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:<br/>
 * <pre>
 *               1
 *             /  \
 *            2    2
 *           / \  / \
 *          3  4 4   3
 * </pre>
 * But the following [1,2,2,null,3,null,3] is not:
 * <pre>
 *         1
 *        / \
 *       2   2
 *        \   \
 *         3   3
 *</pre>
 * Definition for a binary tree node.
 * <pre>
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * </pre>
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        List<List<TreeNode>> list = new ArrayList<List<TreeNode>>();
        getNodeByDeep(root, 0, list);
        for (List<TreeNode> tns : list) {
            int length = tns.size();
            for (int i = 0; i < length / 2; i++) {
                TreeNode tni = tns.get(i);
                TreeNode tnl = tns.get(length - i - 1);
                if ((null != tni && null == tnl) || (null == tni && null != tnl) ||
                        (tni != null && tnl != null && tni.val != tnl.val)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void getNodeByDeep(TreeNode root, int deep, List<List<TreeNode>> list) {
        if (deep >= list.size()) {
            list.add(new ArrayList<TreeNode>());
        }
        if (null == root) {
            list.get(deep).add(root);
            return;
        }
        list.get(deep).add(root);
        getNodeByDeep(root.left, deep + 1, list);
        getNodeByDeep(root.right, deep + 1, list);
    }

    public boolean test(TreeNode root) {
        return isMirror(root, root);
    }

    private boolean isMirror(TreeNode root, TreeNode root1) {
        if (null == root && root == root1) {
            return true;
        }
        if ((null != root && null == root1) || (null == root && null != root1) || (root.val != root1.val)) {
            return false;
        }
        return isMirror(root.left, root1.right) && isMirror(root.right, root1.left);
    }

    public static void main(String[] args) throws Exception{
        TreeNode n1 = new TreeNode(1);
        TreeNode n21 = new TreeNode(2);
        TreeNode n22 = new TreeNode(2);
        TreeNode n31 = new TreeNode(3);
        TreeNode n32 = new TreeNode(3);
        TreeNode n41 = new TreeNode(4);
        TreeNode n42 = new TreeNode(4);
//        n1.left = n21;
//        n1.right = n22;
//        n21.left = n31;
//        n21.right = n41;
//        n22.left = n42;
//        n22.right = n32;

        n1.left = n21;
        n1.right = n22;
        n21.right = n31;
        n22.right = n32;

        List<List<TreeNode>> list = new ArrayList<List<TreeNode>>();
        SymmetricTree test = new SymmetricTree();
//        test.getNodeByDeep(n1, 0, list);
        System.out.println(test.test(n1));
//        for (List<TreeNode> tn : list) {
//            for (TreeNode n : tn) {
//                if (null == n) {
//                    System.out.print(n + ", ");
//                } else {
//                    System.out.print(n.val + ", ");
//                }
//            }
//            System.out.println();
//        }
    }
}
