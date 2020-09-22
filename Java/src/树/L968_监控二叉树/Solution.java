package 树.L968_监控二叉树;

import Common.TreeNode;

/**
 * @author logan
 * @date 2020/9/22 9:56 上午
 */
class Solution {
    //0未被监控  1已被监控   2该节点安装监控器
    int res=0;
    public int minCameraCover(TreeNode root) {
        if(dfs(root)==0)res++;
        return res;
    }
    int dfs(TreeNode tn){
        if(tn==null)return 1;
        int left=dfs(tn.left);
        int right=dfs(tn.right);
        //左右子节点均已被监控，此时跳过
        if(left==1&&right==1)return 0;
        //2种情况，1、一个子节点安装监控，另一个已被监控  2、两个子节点均有监控  此时不需要安装监控器，且该节点已被监控
        if(left+right>=3)return 1;
        //其他情况均需要安装监控，不然会有节点监控不到
        res++;
        return 2;
    }
}
