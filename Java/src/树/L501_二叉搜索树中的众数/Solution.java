package 树.L501_二叉搜索树中的众数;

import Common.TreeNode;
import com.sun.deploy.util.ArrayUtil;
import com.sun.tools.javac.util.ArrayUtils;

import java.util.*;

/**
 * @author logan
 * @date 2020/9/24 9:44 上午
 */
public class Solution {

    HashMap<Integer,Integer> map = new HashMap<>();
    public int[] findMode(TreeNode root) {
        if (root == null) {
            return new int[]{};
        }
        helper(root);
        ArrayList<Integer> res = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if (map.get(key) > 1) {
                res.add(key);
            }
        }
        if (res.size() == 0) {
            for (Integer key : map.keySet()) {
                res.add(key);
            }
        }
        int[] ret = new int[res.size()];
        Iterator<Integer> iterator = res.iterator();
        for (int i = 0; i < ret.length; i++)
        {
            ret[i] = iterator.next().intValue();
        }
        return ret;
    }

    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        map.put(root.val, map.getOrDefault(root.val,0) + 1);
        helper(root.left);
        helper(root.right);
    }
}
