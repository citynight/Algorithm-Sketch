package 树.L226_翻转二叉树;

import Common.TreeNode;

/**
 * @author logan
 * @date 2020/9/16 9:56 上午
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}
