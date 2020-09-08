package 数组.L77_组合;

import java.util.ArrayList;
import java.util.List;

/**
 * @author logan
 * @date 2020/9/8 9:59 上午
 */
public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        // 获取所有的数
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i+1;
        }

        // 结果
        List<List<Integer>> res = new ArrayList<>();
        helper(res,nums,new ArrayList<>(),0,k);
        return res;
    }

    private void helper(List<List<Integer>> res, int[] nums, ArrayList<Integer> temp, int index, int count) {
        // 如果数量为k结束
        if (count == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            helper(res,nums,temp,i + 1,count - 1);
            temp.remove(temp.size() - 1);
        }
    }
}
