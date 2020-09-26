package 树.L113_路径总和_II;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author logan
 * @date 2020/9/26 11:44 上午
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res,root,sum,new ArrayList<>());
        return res;
    }

    private void helper(List<List<Integer>> res, TreeNode node, int target, List<Integer> temp) {
        if (node == null) {
            return;
        }
        boolean isLeaf = node.left == null && node.right == null;
        // 是叶子节点，并且满足目标
        if (node.val == target && isLeaf) {
            temp.add(node.val);
            res.add(new ArrayList<Integer>(temp));
            temp.remove(temp.size() - 1);
            return;
        }
        // 如果不是叶子节点
        if (!isLeaf) {
            // 判断左节点
            temp.add(node.val);
            helper(res,node.left,target - node.val,temp);
            // 判断右节点
            helper(res,node.right,target - node.val,temp);

            temp.remove(temp.size() - 1);
        }
    }
} 
