package 树.L111_二叉树的最小深度;

import Common.TreeNode;

class Solution {
    public int minDepth(TreeNode root) {
        // 如果是空节点返回0
        if (root == null) {
            return 0;
        }

        // 如果都为空返回1，如果有一个不为空说明该节点不是最近的叶子节点需要找该节点的子节点
        if (root.left == null || root.right == null) {
            return 1 + Math.max(minDepth(root.left), minDepth(root.right));
        }

        // 如果左右都有则返回最小的
        return 1 + Math.min(minDepth(root.left),minDepth(root.right));
    }
}