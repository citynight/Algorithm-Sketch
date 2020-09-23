package 树.L617_合并二叉树;

import Common.TreeNode;

/**
 * @author logan
 * @date 2020/9/23 10:11 上午
 */
public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) {
            return null;
        }

        int temp = 0;
        if(t1 != null) {
            temp += t1.val;
        }
        if(t2 != null) {
            temp += t2.val;
        }
        TreeNode treeNode = new TreeNode(temp);
        treeNode.left = mergeTrees(t1 == null ? null : t1.left,t2 == null ? null : t2.left);
        treeNode.right = mergeTrees(t1 == null ? null : t1.right,t2 == null ? null : t2.right);
        return treeNode;
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(1);
        left.left = new TreeNode(3);
        left.right = new TreeNode(2);
        left.left.left = new TreeNode(5);

        TreeNode right = new TreeNode(2);
        right.left = new TreeNode(1);
        right.right = new TreeNode(3);
        right.left.right = new TreeNode(4);
        right.right.right = new TreeNode(7);

        Solution solution = new Solution();
        TreeNode val = solution.mergeTrees(left,right);
        System.out.println(val.toString());
    }
}
