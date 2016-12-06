package oj.test.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 * <pre>
 * For example, given the following binary tree:
 *           1
 *         /   \
 *        2     3
 *         \
 *          5
 * All root-to-leaf paths are:
 * ["1->2->5", "1->3"]
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * </pre>
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<TreeNode> stack = new ArrayList<TreeNode>();
        List<String> re = new ArrayList<String>();
        if (null != root) {
            binaryTreePaths(root, stack, re);
        }
        return re;
    }

    private void binaryTreePaths(TreeNode root, List<TreeNode> stack, List<String> re) {
        stack.add(root);
        TreeNode left = root.left;
        TreeNode right = root.right;

        if (null == left && null == right) {
            StringBuilder sb = new StringBuilder();
            int size = stack.size();
            for (int i = 0; i < size; i++) {
                if (0 == i) {
                    sb.append(stack.get(i).val);
                } else {
                    sb.append("->" + stack.get(i).val);
                }
            }
            re.add(sb.toString());

            stack.remove(stack.size() - 1);
            return;
        }

        if (null != left) {
            binaryTreePaths(left, stack, re);
        }
        if (null != right) {
            binaryTreePaths(right, stack, re);
        }

        stack.remove(stack.size() - 1);
    }
}
