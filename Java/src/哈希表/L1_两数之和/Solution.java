package 哈希表.L1_两数之和;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : logan
 * create at:  2020-08-17  10:27
 * 一遍hash  O(n)
 * 思路：
 *      查找遍历过的数据中是否存在当前元素所对应的目标元素，如果存在说明找到了对应的解，直接返回
 */
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if ( map.containsKey(target - nums[i]) ) {
                return new int[]{map.get(target-nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}