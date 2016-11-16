package oj.test.easy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * <p/>
 * For example: Given binary tree [3,9,20,null,null,15,7],
 *           3
 *         / \
 *       9  20
 *          /  \
 *        15   7
 * return its level order traversal as:<br/>
 * [<br/>
 * [3],<br/>
 * [9,20],<br/>
 * [15,7]<br/>
 * ]
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> re = new ArrayList<List<Integer>>();
        levelOrder(root, re, 0);
        return re;
    }

    //深度搜索
    private void levelOrder(TreeNode root, List<List<Integer>> re, int deep) {
        if (null == root) {
            return;
        }
        if (deep >= re.size()) {
            re.add(new ArrayList<Integer>());
        }
        re.get(deep).add(root.val);
        levelOrder(root.left, re, deep + 1);
        levelOrder(root.right, re, deep + 1);
    }

    public List<List<Integer>> test(TreeNode root) {
        List<List<Integer>> re = new ArrayList<List<Integer>>();
        if (null == root) {
            return re;
        }

        List<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        test(list, re);

        int length = re.size();
        for (int i = 0; i < length / 2; i++) {
            List<Integer> temp = re.get(i);
            re.set(i, re.get(length - 1 - i));
            re.set(length - 1 - i, temp);
        }

        return re;
    }

    //广度搜索
    private void test(List<TreeNode> list, List<List<Integer>> re) {
        if (null == list || 0 == list.size()) {
            return;
        }

        List<TreeNode> children = new ArrayList<TreeNode>();
        List<Integer> arr = new ArrayList<Integer>();
        re.add(arr);

        for (TreeNode node : list) {
            arr.add(node.val);
            if (null != node.left) {
                children.add(node.left);
            }
            if (null != node.right) {
                children.add(node.right);
            }
        }

        test(children, re);
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

        List<List<Integer>> re = new BinaryTreeLevelOrderTraversal().test(n3);
        for (List<Integer> list : re) {
            System.out.println(list);
        }
    }
}
