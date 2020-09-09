package 数组.L39_组合总和;

import java.util.ArrayList;
import java.util.List;

/**
 * @author logan
 * @date 2020/9/9 7:42 下午
 */
public class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res,candidates,target,0,new ArrayList<>());
        return res;
    }

    private void dfs(List<List<Integer>> res,int[] candidates, int target, int start,List<Integer> temp) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }

        // 遍历每个数字
        for (int i = start; i < candidates.length; i++) {
            // 把数组放到临时数组中
            temp.add(candidates[i]);
            // 递归调用，目标为当前目标-当前的值，因为可以重复所以开始位置还是当前的开始位置
            dfs(res, candidates, target - candidates[i],i,temp);
            // 溯源
            temp.remove(temp.size() - 1);
        }
    }
}
