package 树.L257_二叉树的所有路径;

import Common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author logan
 * @date 2020/9/4 9:54 上午
 */
public class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> paths = new ArrayList<String>();
        dfs(root,"",paths);
        return paths;
    }

    private void dfs(TreeNode node, String path, ArrayList<String> paths) {
        if (node == null) {
            return;
        }
        StringBuffer sb = new StringBuffer(path);
        sb.append(Integer.toString(node.val));
        if(node.left == null && node.right == null) {
            // 当前为叶子节点
            paths.add(sb.toString());
        }else {
            sb.append("->");
            dfs(node.left,sb.toString(),paths);
            dfs(node.right,sb.toString(),paths);
        }
    }
}
