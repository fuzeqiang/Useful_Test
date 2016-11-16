package oj.test.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * <br/>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is <br/>
 * defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
 * <p/>
 *        _______6______    <br/>
 *            /                 \        <br/>
 *     __2__          ___8__   <br/>
 *    /      \             /      \     <br/>
 *  0      _4_         7       9    <br/>
 *         /  \                          <br/>
 *       3   5                          <br/>
 * <p/>
 * For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. <br/>
 * Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.
 * <p/>
 * Definition for a binary tree node.<br/>
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LowestCommonAncestorOfABinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode lowestAncestor = null;
        List<TreeNode> re1 = new ArrayList<TreeNode>();
        List<TreeNode> re2 = new ArrayList<TreeNode>();
        test(root, p, re1);
        test(root, q, re2);

        int length1 = re1.size();
        int length2 = re2.size();
        int i = 1;
        for ( ; i <= length1 && i <= length2; i++) {
            if (re1.get(length1 - i) != re2.get(length2 - i) && i != 1) {
                lowestAncestor = re1.get(length1 - i + 1);
                break;
            }
        }

        if (i == length1 + 1 || i == length2 + 1) {
            lowestAncestor = length1 > length2 ? re2.get(0) : re1.get(0);
        }

        return lowestAncestor;
    }

    public void test(TreeNode root, TreeNode p, List<TreeNode> re) {
        if (!re.isEmpty()) {
            return;
        }
        if (null != root) {
            if (p.val == root.val) {
                re.add(root);
                return;
            }

            TreeNode left = root.left;
            TreeNode right = root.right;

            test(left, p, re);
            test(right, p, re);

            if (!re.isEmpty()) {
                re.add(root);
            }
        }
    }

    public TreeNode test2(TreeNode root, TreeNode p, TreeNode q, List<TreeNode> stack, boolean[] isFound) {
        stack.add(root);

        if (p == root) {
            isFound[0] = true;
        }
        if (q == root) {
            isFound[1] = true;
        }

        stack.remove(stack.size() - 1);
        return null;
    }

    private void find(TreeNode root, TreeNode q) {
    }

    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);

//        node6.left = node2;
//        node6.right = node8;
//        node2.left = node0;
//        node2.right = node4;
//        node4.left = node3;
//        node4.right = node5;
//        node8.left = node7;
//        node8.right = node9;

        node5.left = node3;
        node5.right = node6;
        node3.left = node2;
        node3.right = node4;
        node2.left = node1;


        LowestCommonAncestorOfABinarySearchTree test = new LowestCommonAncestorOfABinarySearchTree();
        System.out.println(test.lowestCommonAncestor(node5, node1, node3).val);
    }

}
