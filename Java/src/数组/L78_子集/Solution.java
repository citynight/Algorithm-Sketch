package 数组.L78_子集;

import java.util.ArrayList;
import java.util.List;

/**
 * @author logan
 * @date 2020/9/20 8:52 上午
 */
public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res,nums,new ArrayList<>(),0);
        return res;
    }
    private void dfs(List<List<Integer>> res,int[] nums,List<Integer> temp,int start) {
        if (start == nums.length) {
            res.add(new ArrayList<>(temp));
            return;
        }
        dfs(res, nums, temp, start + 1);
        temp.add(nums[start]);
        dfs(res, nums, temp, start + 1);
        temp.remove(temp.size() - 1);
    }
}
