package 数组.L216_组合总和III;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author logan
 * @date 2020/9/11 9:43 上午
 */
public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(n,k,1,new ArrayList<>(),res);
        return res;
    }

    private void dfs( int target, int count, int start,List<Integer> temp,List<List<Integer>> res) {
        if (count == 0 && target == 0) {
            res.add(new ArrayList<>(temp));
            return;
        }
        for (int i = start; i <= 9; i++) {
            temp.add(i);
            dfs(target - i,count - 1,i+1,temp,res);
            temp.remove(temp.size() - 1);
        }
    }
}
